package com.techflow.openfda.drugs;

import org.springframework.stereotype.Component;

@Component
public class OpenFsaSpringUseCaseFactory implements OpenFdaUseCaseFactory
{
	@Override
	public FindDrug newFindDrugUseCase()
	{
		return new FindDrug();
	}
}
