package com.techflow.openfda.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://localhost:8080/index.html")
public class DrugPage extends PageObject
{
	@FindBy(id = "term")
	WebElement activeIngredient;

	public String getActiveIngredient()
	{
		return activeIngredient.getText();
	}
}
