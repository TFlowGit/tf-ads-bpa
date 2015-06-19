package com.techflow.openfda.steps;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import com.techflow.openfda.pages.DrugPage;
import com.techflow.openfda.pages.SearchPage;

/**
 *
 *
 */
@SuppressWarnings("serial")
public class SearchSteps extends ScenarioSteps
{
	public SearchSteps(Pages pages) {
		super(pages);
	}

	@Step("When the user searches for {0}")
	public void searchesFor(String drug)
	{
		onSearchPage().searchFor(drug);
	}

	@Step("Then the label info is displayed for {0}")
	public void shouldSeeLabelFor(String drugName)
	{
		final DrugPage drugPage = onDrugPage();

		assertThat(drugPage.getActiveIngredient(), is("test"));
	}

	private SearchPage onSearchPage()
	{
		final Pages pages = getPages();
		return pages.get(SearchPage.class);
	}

	private DrugPage onDrugPage()
	{
		final Pages pages = getPages();
		return pages.get(DrugPage.class);
	}
}
