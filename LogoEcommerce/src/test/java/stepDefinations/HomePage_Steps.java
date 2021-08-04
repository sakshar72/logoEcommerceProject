package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import objectRepository.HomePageObjects;
//import objectRepository.LoginPageObjects;
import resources.UtilityFunctions;

public class HomePage_Steps extends UtilityFunctions {
	TestContext context;
//	LoginPageObjects loginPageObject;
	HomePageObjects homePageObject;
	SoftAssert softAssertObj;
	Properties propertiesObj;
	Actions actionObject;

	public HomePage_Steps(TestContext context) throws IOException {
//		loginPageObject = context.getPageObjectManager().getLoginPage();
		homePageObject = context.getPageObjectManager().getHomePage();
		softAssertObj = softAssertObject();
		propertiesObj = propertiesFileLoad();
		actionObject = actionObject(driverObject);
	}

	@Given("^Open the home page URL$")
	public void open_the_home_page_url() throws Throwable {
		driverObject.get(propertiesObj.getProperty("homePageURL"));
		driverObject.manage().window().maximize();
	}

	@Then("^Click on Sign In button$")
	public void click_on_sign_in_button() throws Throwable {
		homePageObject.sendObjectSignInBtn().click();
	}

	@Then("^click on dresses link in nav bar$")
	public void click_on_dresses_link_in_nav_bar() throws Throwable {
		homePageObject.sendObjectDressesNavLink().click();
	}
}
