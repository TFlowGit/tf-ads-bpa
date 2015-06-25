package com.techflow.openfda.drugs;

import com.techflow.openfda.drug.client.DrugRepository;
import com.techflow.openfda.drug.usecase.ProvideSearchSuggestionsRequest;
import com.techflow.openfda.drug.usecase.ProvideSearchSuggestionsResponse;
import com.techflow.openfda.drug.usecase.ProvideSearchSuggestionsUseCase;
import com.techflow.openfda.drug.usecase.BaseUseCase;

public class ProvideSearchSuggestionsUseCaseImpl extends BaseUseCase<ProvideSearchSuggestionsRequest, ProvideSearchSuggestionsResponse> implements ProvideSearchSuggestionsUseCase
{
	private final DrugRepository drugRepository;

	public ProvideSearchSuggestionsUseCaseImpl(DrugRepository drugRepository) {
		this.drugRepository = drugRepository;
	}

	@Override
	public void execute() throws Exception
	{
		response.setSuggestions(drugRepository.startsWith(request.getDrug()));
	}
}
