package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;


import base.ReusableFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.Homepage;

public class UIStepdefinitions extends ReusableFunctions {

	public WebDriver driver = Hooks.driver;
	public Homepage pom = new  Homepage(driver);
	
	@Given("User is already on {string} site")
	public void user_is_already_on_site(String url) {
		assertEquals(getUrl(driver) , url);
	}

	@When("User clicks search item button")
	public void user_clicks_search_item_button() {
		pom.clickSearchIcon();
	}

	@When("User enters {string} as search string")
	public void user_enters_as_search_string(String text) {
		pom.enterSearchBox(text);
		pom.clickSearch();
	}

	@Then("Validate if the site is showing {string}.")
	public void validate_if_the_site_is_showing(String string) {
		assertTrue(pom.checkString(string));
	}

	@Then("Validate if the site is error message as {string}.")
	public void validate_if_the_site_is_showing_error(String string) {
		assertTrue(pom.checkErrorMessage(string));
	}
}
