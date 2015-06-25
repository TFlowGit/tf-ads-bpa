package com.techflow.openfda.drugs;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import java.util.List;
import org.junit.Test;
import com.techflow.openfda.drug.usecase.AutocompleteRequest;
import com.techflow.openfda.drug.usecase.AutocompleteResponse;

public class AutocompleteUseCaseImplTest
{
	@Test
	public void shouldFindAspirin() throws Exception
	{
		final AutocompleteUseCaseImpl useCase = new AutocompleteUseCaseImpl(new MockDrugRepository());

		useCase.setRequest(new AutocompleteRequest() {

			@Override
			public String getDrug()
			{
				return "asp";
			}

		});
		;
		final AutocompleteResponseImplementation response = new AutocompleteResponseImplementation();
		useCase.setResponse(response);
		useCase.execute();

		assertThat(response.getResults(), contains("aspirin"));
	}

	@Test
	public void shouldFindTylenol() throws Exception
	{
		final AutocompleteUseCaseImpl useCase = new AutocompleteUseCaseImpl(new MockDrugRepository());

		useCase.setRequest(new AutocompleteRequest() {

			@Override
			public String getDrug()
			{
				return "TY";
			}

		});
		;
		final AutocompleteResponseImplementation response = new AutocompleteResponseImplementation();
		useCase.setResponse(response);
		useCase.execute();

		assertThat(response.getResults(), containsInAnyOrder("tylenol", "tylenol pm"));
	}

	private final class AutocompleteResponseImplementation implements AutocompleteResponse
	{
		private List<String> results;

		@Override
		public void setResults(List<String> results)
		{
			this.results = results;
		}

		public List<String> getResults()
		{
			return results;
		}
	}
}
