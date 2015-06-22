package com.techflow.openfda.drugs;

import com.techflow.openfda.drug.client.OpenFdaGateway;
import com.techflow.openfda.drug.usecase.OpenFdaUseCaseFactory;

public class SimpleOpenFdaSpringUseCaseFactory implements OpenFdaUseCaseFactory
{
	private final OpenFdaGateway fdaGateway;

	public SimpleOpenFdaSpringUseCaseFactory(OpenFdaGateway fdaGateway) {
		this.fdaGateway = fdaGateway;
	}

	@Override
	public FindDrugUseCaseImpl newFindDrugUseCase()
	{
		return new FindDrugUseCaseImpl(fdaGateway);
	}
}
