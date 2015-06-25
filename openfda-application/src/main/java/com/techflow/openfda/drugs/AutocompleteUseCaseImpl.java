package com.techflow.openfda.drugs;

import com.techflow.openfda.drug.client.DrugRepository;
import com.techflow.openfda.drug.usecase.AutocompleteRequest;
import com.techflow.openfda.drug.usecase.AutocompleteResponse;
import com.techflow.openfda.drug.usecase.AutocompleteUseCase;
import com.techflow.openfda.drug.usecase.BaseUseCase;

public class AutocompleteUseCaseImpl extends BaseUseCase<AutocompleteRequest, AutocompleteResponse> implements AutocompleteUseCase
{
	private final DrugRepository drugRepository;

	public AutocompleteUseCaseImpl(DrugRepository drugRepository) {
		this.drugRepository = drugRepository;
	}

	@Override
	public void execute() throws Exception
	{
		response.setResults(drugRepository.startsWith(request.getDrug()));
	}
}
