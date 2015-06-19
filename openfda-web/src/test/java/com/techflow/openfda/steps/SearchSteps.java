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

		// todo: andrew add comparisons
		assertThat(drugPage.getActiveIngredient(), is("Active ingredients Each 5X (HPUS) Purpose ..."));
		assertThat(drugPage.getInactiveIngredient(), is("Inactive ingredients 27% alcohol..."));
		assertThat(
				drugPage.getDosage(),
				is("Directions do not exceed recommended dosage drink a full glass of water with each dose adults and children 12 years of age and over: take 4 to 8 tablets every 4 hours not to exceed 48 tablets in 24 hours, unless directed by a doctor children under 12 years of age: consult a doctor"));
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
