package com.techflow.openfda.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://localhost:8080/index.html")
public class DrugPage extends PageObject
{

	@FindBy(id = "labeling-indicationsAndUsage-modal")
	WebElement indicationsAndUsage;

	@FindBy(id = "labeling-brandName-modal")
	WebElement brandName;

	@FindBy(id = "labeling-genericName-modal")
	WebElement genericName;

	@FindBy(id = "labeling-purpose-modal")
	WebElement purpose;

	@FindBy(id = "labeling-active-modal")
	WebElement activeIngredient;

	@FindBy(id = "labeling-inactive-modal")
	WebElement inactiveIngredient;

	@FindBy(id = "labeling-warnings-modal")
	WebElement warnings;

	@FindBy(id = "labeling-doNotUse-modal")
	WebElement doNotUse;

	@FindBy(id = "labeling-askDoctor-modal")
	WebElement askDoctor;

	@FindBy(id = "labeling-askDoctorOrPharmacist-modal")
	WebElement askDoctorOrPharmacist;

	@FindBy(id = "labeling-dosage-modal")
	WebElement dosage;

	@FindBy(id = "labeling-stopUse-modal")
	WebElement stopUse;

	@FindBy(id = "labeling-found-modal")
	WebElement found;

	@FindBy(id = "labeling-adverseReactions-modal")
	WebElement adverseReactions;

	@FindBy(id = "labeling-manfacturerName-modal")
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
