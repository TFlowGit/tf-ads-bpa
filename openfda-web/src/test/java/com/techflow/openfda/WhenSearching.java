package com.techflow.openfda;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.techflow.openfda.steps.SearchSteps;

@RunWith(SerenityRunner.class)
public class WhenSearching
{
	@Managed(driver = "firefox")
	public WebDriver driver;

	@ManagedPages(defaultUrl = "http://localhost:8080/index.html")
	public Pages pages;

	@Steps
	public SearchSteps user;

	@Test
	public void shouldCalculatePointsBasedOnDistance()
	{
		user.searchesFor("aspirin");
		user.shouldSeeLabelFor("aspirin");
	}
}
