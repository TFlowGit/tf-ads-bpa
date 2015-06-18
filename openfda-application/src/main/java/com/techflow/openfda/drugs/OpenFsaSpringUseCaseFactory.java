package com.techflow.openfda.drugs;

import com.techflow.openfda.FdaGateway;

public class OpenFsaSpringUseCaseFactory implements OpenFdaUseCaseFactory
{
	private final FdaGateway fdaGateway;

	public OpenFsaSpringUseCaseFactory(FdaGateway fdaGateway) {
		this.fdaGateway = fdaGateway;
	}

	@Override
	public FindDrugImpl newFindDrugUseCase()
	{
		return new FindDrugImpl(fdaGateway);
	}
}
