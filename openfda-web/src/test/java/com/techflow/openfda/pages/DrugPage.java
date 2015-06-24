package com.techflow.openfda.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://localhost:8080/index.html")
public class DrugPage extends PageObject
{

	@FindBy(id = "labeling-indicationsAndUsage-label")
	WebElement indicationsAndUsage;

	@FindBy(id = "labeling-brandName-label")
	WebElement brandName;

	@FindBy(id = "labeling-genericName-label")
	WebElement genericName;

	@FindBy(id = "labeling-purpose-label")
	WebElement purpose;

	@FindBy(id = "labeling-active-label")
	WebElement activeIngredient;

	@FindBy(id = "labeling-inactive-label")
	WebElement inactiveIngredient;

	@FindBy(id = "labeling-warnings-label")
	WebElement warnings;

	@FindBy(id = "labeling-doNotUse-label")
	WebElement doNotUse;

	@FindBy(id = "labeling-askDoctor-label")
	WebElement askDoctor;

	@FindBy(id = "labeling-askDoctorOrPharmacist-label")
	WebElement askDoctorOrPharmacist;

	@FindBy(id = "labeling-dosage-label")
	WebElement dosage;

	@FindBy(id = "labeling-stopUse-label")
	WebElement stopUse;

	@FindBy(id = "labeling-found-label")
	WebElement found;

	@FindBy(id = "labeling-adverseReactions-label")
	WebElement adverseReactions;

	@FindBy(id = "labeling-manfacturerName-label")
	WebElement manufacturerName;

	public String getIndicationsAndUsage()
	{
		return indicationsAndUsage.getText();
	}

	public String getBrandName()
	{
		return brandName.getText();
	}

	public String getGenericName()
	{
		return genericName.getText();
	}

	public String getPurpose()
	{
		return purpose.getText();

	}

	public String getActiveIngredient()
	{
		return activeIngredient.getText();
	}

	public String getInactiveIngredient()
	{
		return inactiveIngredient.getText();
	}

	public String getWarnings()
	{
		return warnings.getText();
	}

	public String getDoNotUse()
	{
		return doNotUse.getText();
	}

	public String getAskDoctor()
	{
		return askDoctor.getText();
	}

	public String askDoctorOrPharmacist()
	{
		return askDoctorOrPharmacist.getText();
	}

	public String getDosage()
	{
		return dosage.getText();
	}

	public String getStopUse()
	{
		return stopUse.getText();
	}

	public String getFound()
	{
		return found.getText();
	}

	public String getAdverseReactions()
	{
		return adverseReactions.getText();
	}

	public String getManufacturerName()
	{
		return manufacturerName.getText();
	}
}
