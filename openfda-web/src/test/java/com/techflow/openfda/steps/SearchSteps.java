package com.techflow.openfda.steps;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	public SearchSteps(Pages pages)
	{
		super(pages);
	}

	@Step("When the user searches for {0}")
	public void searchesFor(String drug)
	{
		onSearchPage().searchFor(drug);
	}

	@Step("Then the label info is displayed for {0}")
	public void shouldSeeLabelFor(String drugName, WebDriver driver)
	{
		DrugPage drugPage = onDrugPage();
		Actions actions = new Actions(driver);
		
		
		WebElement btnMore;
		WebElement btnClose;

		// Insure all elememts are visible.
	    ((JavascriptExecutor)driver).executeScript("window.resizeTo(1024, 4096);");
	    try {
	    	Thread.sleep(1000);
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	 
		// ############ ACTIVEINGREDIENT #############
		try {
			btnMore = driver.findElement(By.id("btn-more-active"));
			actions.moveToElement(btnMore);
			Thread.sleep(2000);
			actions.click();
			actions.perform();
			assertThat(drugPage.getActiveIngredient(),
					is("Active ingredient (in each tablet) Aspirin 81 mg (NSAID)* *nonsteroidal anti- inflammatory drug"));
			btnClose = driver.findElement(By.id("btn-close-active"));
			actions.click();
			actions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ############ INACTIVEINGREDIENT #############
		try {
			btnMore = driver.findElement(By.id("btn-more-inactive"));
			actions.moveToElement(btnMore);
			Thread.sleep(2000);
			actions.click();
			actions.perform();
			assertThat(drugPage.getInactiveIngredient(),
					 //is("Inactive ingredients *acetylated monoglycerides, *anhydrous lactose, *carnauba wax, colloidal silicon dioxide,*corn starch, *croscarmellose sodium, D&amp;;C Yellow #10 Aluminum Lake, FD&amp;C Yellow #6 Aluminum Lake, hypromellose, *hypromellose phthalate, *iron oxide Yellow (iron oxide ochre), methacrylic acid copolymer, microcrystalline cellulose, *mineral oil, *polyethylene glycol (PEG)-400, *polysorbate 80, povidone, pregelatinized starch, *propylene glycol, *simethicone, silicon dioxide, sodium bicarbonate, sodium hydroxide, sodium lauryl sulfate, starch, stearic acid, talc, titanium dioxide, triacetin, and triethyl citrate. *May also contain."));
					startsWith("Inactive ingredients *acetylated monoglycerides, *anhydrous lactose, *carnauba wax, colloidal silicon dioxide,"));
			btnClose = driver.findElement(By.id("btn-close-inactive"));
			actions.click();
			actions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done getInactiveIngredient");

		// ############ getDosage #############
		try {
			btnMore = driver.findElement(By.id("btn-more-dosage"));
			actions.moveToElement(btnMore);
			Thread.sleep(2000);
			actions.click();
			actions.perform();
			assertThat(
					drugPage.getDosage(),
					is("Directions do not exceed recommended dosage drink a full glass of water with each dose adults and children 12 years of age and over: take 4 to 8 tablets every 4 hours not to exceed 48 tablets in 24 hours, unless directed by a doctor children under 12 years of age: consult a doctor"));
			btnClose = driver.findElement(By.id("btn-close-dosage"));
			actions.click();
			actions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done getDosage");

		// ############ askDoctor #############
		try {
			btnMore = driver.findElement(By.id("btn-more-askDoctor"));
			actions.moveToElement(btnMore);
			Thread.sleep(2000);
			actions.click();
			actions.perform();
			assertThat(
					drugPage.getAskDoctor(),
					startsWith("Ask a doctor before use if stomach bleeding warning applies to you you have a history of stomach problems,"));
			btnClose = driver.findElement(By.id("btn-close-askDoctor"));
			actions.click();
			actions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done getAskDoctor");

		// ############ doNotUse #############
		try {
			btnMore = driver.findElement(By.id("btn-more-doNotUse"));
			actions.moveToElement(btnMore);
			Thread.sleep(2000);
			actions.click();
			actions.perform();
			assertThat(drugPage.getDoNotUse(),
					is("Do not use if you have ever had an allergic reaction to any other pain reliever/fever reducer"));
			btnClose = driver.findElement(By.id("btn-close-doNotUse"));
			actions.click();
			actions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ############ getIndicationsAndUsage #############
		try {
			btnMore = driver.findElement(By.id("btn-more-indicationsAndUsage"));
			actions.moveToElement(btnMore);
			Thread.sleep(2000);
			actions.click();
			actions.perform();
			assertThat(
					drugPage.getIndicationsAndUsage(),
					is("Uses temporarily relieves minor aches and pains other therapy as recommended by your doctor. Because of its delayed action, this product will not provide fast relief of headaches, fever, or other symptoms needing immediate relief."));
			btnClose = driver.findElement(By.id("btn-close-indicationsAndUsage"));
			actions.click();
			actions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ############ StopUse #############
		try {
			btnMore = driver.findElement(By.id("btn-more-stopUse"));
			actions.moveToElement(btnMore);
			Thread.sleep(2000);
			actions.click();
			actions.perform();
			assertThat(
					drugPage.getStopUse(),
					startsWith("Stop use and ask a doctor if you experience any of the following signs of stomach bleeding:"));
			btnClose = driver.findElement(By.id("btn-close-stopUse"));
			actions.click();
			actions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ############ Warnings #############
		try {
			btnMore = driver.findElement(By.id("btn-more-warnings"));
			actions.moveToElement(btnMore);
			Thread.sleep(2000);
			actions.click();
			actions.perform();
			// Serenity error on long string, so work around is use startsWith with less character compare
			assertThat(drugPage.getWarnings(),
					startsWith("Warnings Reye’s syndrome: Children and teenagers who have or are recovering from chicken pox or flu-like symptoms should not use this product."));
			btnClose = driver.findElement(By.id("btn-close-warnings"));
			actions.click();
			actions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		
		// ############ labeling-askDoctorOrPharmacist #############
		try {
			btnMore = driver.findElement(By.id("btn-more-askDoctorOrPharmacist"));
			actions.moveToElement(btnMore);
			Thread.sleep(2000);
			actions.click();
			actions.perform();
			// Serenity error on long string, so work around is use startsWith with less character compare
			assertThat(drugPage.askDoctorOrPharmacist(),
					startsWith("Ask a doctor or pharmacist before use if you are taking a prescription drug for: anticoagulation (thinning of the blood) gout diabetes arthritis"));

			btnClose = driver.findElement(By.id("btn-close-askDoctorOrPharmacist"));
			actions.click();
			actions.perform();
		} catch (Exception e) {
					e.printStackTrace();
		}
		
		// ############ labeling-genericName-label #############
		try {
			btnMore = driver.findElement(By.id("btn-more-genericName"));
			actions.moveToElement(btnMore);
			Thread.sleep(2000);
			actions.click();
			actions.perform();
			assertThat(drugPage.getGenericName(), is("ASPIRIN"));

			btnClose = driver.findElement(By.id("btn-close-genericName"));
			actions.click();
			actions.perform();
		} catch (Exception e) {
					e.printStackTrace();
		}
		
		
		

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
