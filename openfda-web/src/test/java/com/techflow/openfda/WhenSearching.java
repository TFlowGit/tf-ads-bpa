package com.techflow.openfda;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.techflow.openfda.steps.SearchSteps;
// Note: please save imports for later use:
// import java.io.IOException;
// import java.util.concurrent.TimeUnit;
// import org.apache.commons.httpclient.Credentials;
// import org.apache.commons.httpclient.Header;
// import org.apache.commons.httpclient.HttpClient;
// import org.apache.commons.httpclient.HttpException;
// import org.apache.commons.httpclient.HttpMethod;
// import org.apache.commons.httpclient.UsernamePasswordCredentials;
// import org.apache.commons.httpclient.auth.AuthScope;
// import org.apache.commons.httpclient.methods.GetMethod;

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

		// Note: please save commented lines for later debug/devel use.
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		user.shouldSeeLabelFor("aspirin");
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	/**
	 * Pause before checking if driver completed.
	 */
	@After
	public void Ending()
	{
		try {
			Thread.sleep(1000);
			driver.close();
			Thread.sleep(3000);
		} catch (Exception b) {
			b.getMessage();
		}
	}
}
