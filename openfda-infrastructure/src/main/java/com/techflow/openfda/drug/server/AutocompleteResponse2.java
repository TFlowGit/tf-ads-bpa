package com.techflow.openfda.drug.server;

import java.util.List;
import com.techflow.openfda.drug.usecase.AutocompleteResponse;

public class AutocompleteResponse2 implements AutocompleteResponse
{
	private List<String> suggestions;

	public List<String> getSuggestions()
	{
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions)
	{
		this.suggestions = suggestions;
	}

	@Override
	public void setResults(List<String> results)
	{
		this.suggestions = results;
	}
}
