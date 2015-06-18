package com.techflow.openfda.drugs;

public class OpenFsaSpringUseCaseFactory implements OpenFdaUseCaseFactory
{
	@Override
	public FindDrugImpl newFindDrugUseCase()
	{
		return new FindDrugImpl();
	}
}
