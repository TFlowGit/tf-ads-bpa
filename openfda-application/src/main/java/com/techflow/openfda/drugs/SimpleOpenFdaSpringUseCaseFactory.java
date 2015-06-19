package com.techflow.openfda.drugs;

import com.techflow.openfda.OpenFdaGateway;

public class SimpleOpenFdaSpringUseCaseFactory implements OpenFdaUseCaseFactory
{
	private final OpenFdaGateway fdaGateway;

	public SimpleOpenFdaSpringUseCaseFactory(OpenFdaGateway fdaGateway) {
		this.fdaGateway = fdaGateway;
	}

	@Override
	public FindDrugImpl newFindDrugUseCase()
	{
		return new FindDrugImpl(fdaGateway);
	}
}
