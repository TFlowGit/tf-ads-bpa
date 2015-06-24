package com.techflow.openfda.drugs;

import com.techflow.openfda.drug.client.OpenFdaGateway;
import com.techflow.openfda.drug.usecase.ListDrugEventsUseCase;
import com.techflow.openfda.drug.usecase.OpenFdaUseCaseFactory;

public class SimpleOpenFdaSpringUseCaseFactory implements OpenFdaUseCaseFactory
{
	private final OpenFdaGateway openFdaGateway;

	public SimpleOpenFdaSpringUseCaseFactory(OpenFdaGateway openFdaGateway) {
		this.openFdaGateway = openFdaGateway;
	}

	@Override
	public FindDrugUseCaseImpl newFindDrugUseCase()
	{
		return new FindDrugUseCaseImpl(openFdaGateway);
	}

	@Override
	public ListDrugEventsUseCase newListDrugEventsUseCase()
	{
		return new ListDrugEventsUseCaseImpl(openFdaGateway);
	}
}
