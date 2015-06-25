package com.techflow.openfda.drugs;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import java.util.List;
import org.junit.Test;
import com.techflow.openfda.drug.usecase.ProvideSearchSuggestionsRequest;
import com.techflow.openfda.drug.usecase.ProvideSearchSuggestionsResponse;

public class ProvideSearchSuggestionsUseCaseImplTest
{
	@Test
	public void shouldFindAspirin() throws Exception
	{
		final ProvideSearchSuggestionsUseCaseImpl useCase = new ProvideSearchSuggestionsUseCaseImpl(new MockDrugRepository());

		useCase.setRequest(new ProvideSearchSuggestionsRequest() {

			@Override
			public String getDrug()
			{
				return "asp";
			}

		});
		;
		final SuggestionsResponseSpy response = new SuggestionsResponseSpy();
		useCase.setResponse(response);
		useCase.execute();

		assertThat(response.getResults(), contains("aspirin"));
	}

	@Test
	public void shouldFindTylenol() throws Exception
	{
		final ProvideSearchSuggestionsUseCaseImpl useCase = new ProvideSearchSuggestionsUseCaseImpl(new MockDrugRepository());

		useCase.setRequest(new ProvideSearchSuggestionsRequest() {

			@Override
			public String getDrug()
			{
				return "TY";
			}

		});
		;
		final SuggestionsResponseSpy response = new SuggestionsResponseSpy();
		useCase.setResponse(response);
		useCase.execute();

		assertThat(response.getResults(), containsInAnyOrder("tylenol", "tylenol pm"));
	}

	private final class SuggestionsResponseSpy implements ProvideSearchSuggestionsResponse
	{
		private List<String> results;

		@Override
		public void setSuggestions(List<String> results)
		{
			this.results = results;
		}

		public List<String> getResults()
		{
			return results;
		}
	}
}
