package com.techflow.openfda.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://localhost:8080/index.html")
public class DrugPage extends PageObject
{
	@FindBy(id = "labeling-active-label")
	WebElement activeIngredient;

	@FindBy(id = "labeling-inactive-label")
	WebElement inactiveIngredient;

	@FindBy(id = "labeling-dosage-label")
	WebElement dosage;

	@FindBy(id = "labeling-askDoctor-label")
	WebElement askDoctor;

	@FindBy(id = "labeling-doNotUse-label")
	WebElement doNotUse;

	@FindBy(id = "labeling-stopUse-label")
	WebElement stopUse;

	@FindBy(id = "labeling-warnings-label")
	WebElement warnings;

	@FindBy(id = "labeling-indicationsAndUsage-label")
	WebElement indicationsAndUsage;

	public String getActiveIngredient()
	{
		return activeIngredient.getText();
	}

	public String getDosage()
	{
		return dosage.getText();
	}

	public String getInactiveIngredient()
	{
		return inactiveIngredient.getText();
	}

	public String getAskDoctor()
	{
		return askDoctor.getText();
	}

	public String getDoNotUse()
	{
		return doNotUse.getText();
	}

	public String getStopUse()
	{
		return stopUse.getText();
	}

	public String getWarnings()
	{
		return warnings.getText();
	}

	public String getIndicationsAndUsage()
	{
		return indicationsAndUsage.getText();
	}
}
