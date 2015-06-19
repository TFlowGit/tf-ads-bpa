package com.techflow.openfda.drugs;

import java.io.IOException;
import com.techflow.openfda.OpenFdaGateway;

public class FindDrugImpl extends BaseUseCase<FindDrugRequest, FindDrugResponse> implements FindDrug
{
	private final OpenFdaGateway mockFdaGateway;

	public FindDrugImpl(OpenFdaGateway mockFdaGateway) {
		this.mockFdaGateway = mockFdaGateway;
	}

	@Override
	public void execute()
	{
		DrugLabel drug = null;
		try {
			drug = mockFdaGateway.getLabel(request.getName());
		} catch (final IOException e) {
			e.printStackTrace();
		}
		if (drug == null) {
			response.setNotFound(true);
			return;
		}

		response.setActive(drug.getActive());
		response.setAskDoctor(drug.getAskDoctor());
		response.setDoNotUse(drug.getDoNotUse());
		response.setDosage(drug.getDosage());
		response.setInactive(drug.getInactive());
		response.setIndicationsAndUsage(drug.getIndicationsAndUsage());
		response.setName(drug.getName());
		response.setPurpose(drug.getPurpose());
		response.setStopUse(drug.getStopUse());
		response.setWarnings(drug.getWarnings());
	}
}
