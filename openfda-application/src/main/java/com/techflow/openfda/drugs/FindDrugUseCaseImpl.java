package com.techflow.openfda.drugs;

import java.util.HashMap;
import java.util.Map;
import com.techflow.openfda.GatewayException;
import com.techflow.openfda.drug.client.OpenFdaGateway;
import com.techflow.openfda.drug.usecase.BaseUseCase;
import com.techflow.openfda.drug.usecase.FindDrugRequest;
import com.techflow.openfda.drug.usecase.FindDrugResponse;
import com.techflow.openfda.drug.usecase.FindDrugUseCase;

public class FindDrugUseCaseImpl extends BaseUseCase<FindDrugRequest, FindDrugResponse> implements FindDrugUseCase
{
	private final OpenFdaGateway openFdaGateway;

	public FindDrugUseCaseImpl(OpenFdaGateway mockFdaGateway) {
		this.openFdaGateway = mockFdaGateway;
	}

	@Override
	public void execute() throws GatewayException
	{
		final DrugLabel drug = openFdaGateway.getLabel(request.getName());

		if (drug == null) {
			response.setNotFound(true);
			return;
		}

		response.setBrandName(drug.getBrandName());
		response.setGenericName(drug.getGenericName());
		response.setActive(drug.getActive());
		response.setAskDoctor(drug.getAskDoctor());
		response.setAskDoctorOrPharmacist(drug.getAskDoctorOrPharmacist());
		response.setDoNotUse(drug.getDoNotUse());
		response.setDosage(drug.getDosage());
		response.setInactive(drug.getInactive());
		response.setIndicationsAndUsage(drug.getIndicationsAndUsage());
		response.setPurpose(drug.getPurpose());
		response.setStopUse(drug.getStopUse());
		response.setWarnings(drug.getWarnings());
		response.setAdverseReactions(drug.getAdverseReactions());
		response.setManufacturerName(drug.getManufacturerName());

		final Map<String, Integer> drugEffects = new HashMap<String, Integer>();
		for (final Seriousness seriousness : Seriousness.values()) {
			final String productNdc = drug.getProductNdc();
			final String key = seriousness.key();
			final DrugEvent events = openFdaGateway.getEvents(productNdc, seriousness);
			final int count = events.getCount();

			drugEffects.put(key, count);
		}

		response.setEvents(drugEffects);
	}
}
