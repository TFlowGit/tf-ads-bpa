package com.techflow.openfda.drugs;

import com.techflow.openfda.FdaGateway;

public class FindDrugImpl extends AbstractUseCase<FindDrugRequest, FindDrugResponse> implements FindDrug
{
	private final FdaGateway mockFdaGateway;

	public FindDrugImpl(FdaGateway mockFdaGateway) {
		this.mockFdaGateway = mockFdaGateway;
	}

	@Override
	public void execute()
	{
		final Drug drug = mockFdaGateway.findDrug(request.getName());
		if (drug == null) {
			response.setNotFound(true);
			return;
		}

		response.setActive(drug.getActive());
		response.setAdverseReactions(drug.getAdverseReactions());
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
