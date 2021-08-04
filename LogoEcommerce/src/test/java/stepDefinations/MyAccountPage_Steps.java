package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import objectRepository.HomePageObjects;
import objectRepository.MyAccountPageObjects;
import resources.UtilityFunctions;

public class MyAccountPage_Steps extends UtilityFunctions {
	TestContext context;
	MyAccountPageObjects myAccountPageObject;
	HomePageObjects homePageObject;
	SoftAssert softAssertObj;
	Properties propertiesObj;
	Actions actionObject;
	Select selectObject;

	public MyAccountPage_Steps(TestContext context) throws IOException {
		myAccountPageObject = context.getPageObjectManager().getMyAccountPage();
		homePageObject = context.getPageObjectManager().getHomePage();
		softAssertObj = softAssertObject();
		propertiesObj = propertiesFileLoad();
		actionObject = actionObject(driverObject);

	}

	@Then("^User Enter the email address$")
	public void user_enter_the_email_address() throws Throwable {
		actionObject.click(myAccountPageObject.sendObjectCreateAccountEmailAddressInputField())
				.sendKeys(propertiesObj.getProperty("Email")).build().perform();

	}

	@Then("^Click on create account$")
	public void click_on_create_account() throws Throwable {
		myAccountPageObject.sendObjectCreateAccountBtn().click();
	}

	@Then("^Verify the email address$")
	public void verify_the_email_address() throws Throwable {
		try {
			myAccountPageObject.sendObjectCreateAccountErrorMessage().isDisplayed();
			Assert.fail(
					"Invalid Email address OR An account using this email address has already been registered. Please enter a valid password or request a new one. ");
		} catch (Exception e) {
			System.out.println("Account Created Successfully !!!");
		}
	}

	@Then("^User Enter the details$")
	public void user_enter_the_details() throws Throwable {
		myAccountPageObject.sendObjectGenderRadiBtnMale().click();
		actionObject.click(myAccountPageObject.sendObjectFirstNameInputField())
				.sendKeys(propertiesObj.getProperty("firstName")).sendKeys(Keys.TAB).build().perform();
		;
		actionObject.sendKeys(propertiesObj.getProperty("lastName")).sendKeys(Keys.TAB).build().perform();
		;
		System.out.println("Email ID Value" + myAccountPageObject.sendObjectEmailInputField().getAttribute("value"));
		softAssertObj.assertEquals(myAccountPageObject.sendObjectEmailInputField().getAttribute("value"),
				propertiesObj.getProperty("Email"), "Email Address are not matching");
		actionObject.click(myAccountPageObject.sendObjectPasswordInputField())
				.sendKeys(propertiesObj.getProperty("password")).sendKeys(Keys.TAB).build().perform();
		selectObject = selectObject(myAccountPageObject.sendObjectDateInputField());
		selectObject.selectByIndex(12);
		selectObject = selectObject(myAccountPageObject.sendObjectMonthInputField());
		selectObject.selectByIndex(5);
		selectObject = selectObject(myAccountPageObject.sendObjectYearsInputField());
		selectObject.selectByIndex(25);
		actionObject.click(myAccountPageObject.sendObjectFirstNameAddressInputField())
				.sendKeys(propertiesObj.getProperty("firstName")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertiesObj.getProperty("lastName")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertiesObj.getProperty("company")).sendKeys(Keys.TAB).build().perform();
		;
		actionObject.sendKeys(propertiesObj.getProperty("Address")).build().perform();
		;
		actionObject.click(myAccountPageObject.sendObjectCityInputField()).sendKeys(propertiesObj.getProperty("City"))
				.build().perform();
		selectObject = selectObject(myAccountPageObject.sendObjectStateInputField());
		selectObject.selectByIndex(10);
		actionObject.click(myAccountPageObject.sendObjectPincodeInputField())
				.sendKeys(propertiesObj.getProperty("ZipCode")).build().perform();
		actionObject.click(myAccountPageObject.sendObjectMobileInputField())
				.sendKeys(propertiesObj.getProperty("MobilePhone")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertiesObj.getProperty("AliasName")).build().perform();
		softAssertObj.assertAll();

	}

	@Then("^Click on register button$")
	public void click_on_register_button() throws Throwable {
		myAccountPageObject.sendObjectRegisterBtn().click();
	}

	@Then("^Verify the user details$")
	public void verify_the_user_details() throws Throwable {
		try {
			myAccountPageObject.sendObjectInvalidEntryError().isDisplayed();
			Assert.fail("Account Not created");
		} catch (Exception e) {
			System.out.println("User created !!!");
		}
	}

	@Then("^User Enter the Login credentials$")
	public void user_enter_the_login_credentials() throws Throwable {
		actionObject.click(myAccountPageObject.sendObjectLoginEmailInputField())
				.sendKeys(propertiesObj.getProperty("Email")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertiesObj.getProperty("password")).sendKeys(Keys.TAB).build().perform();

	}

	@Then("^Click on SignIn Button$")
	public void click_on_signin_button() throws Throwable {
		myAccountPageObject.sendObjectSignInBtn().click();
	}

	@Then("^Verfiy the details$")
	public void verfiy_the_details() throws Throwable {
		String userName = propertiesObj.getProperty("firstName") +" "+ propertiesObj.getProperty("lastName");
		try {
			myAccountPageObject.sendObjectInvalidEntryError().isDisplayed();
			Assert.fail("Invalid Email or Password or Fields are Mandatory");

		} catch (Exception e) {
			System.out.println("Customer Name " + myAccountPageObject.sendObjectCustomerLoggedInName().getText());
			softAssertObj.assertEquals(myAccountPageObject.sendObjectCustomerLoggedInName().getText(), userName,
					"Different Customer Profile");
			softAssertObj.assertAll();
		}

	}
	
    @Then("^click on user profile$")
    public void click_on_user_profile() throws Throwable {
    	myAccountPageObject.sendObjectCustomerLoggedInName().click();
    }

    @Then("^click on my wishlist$")
    public void click_on_my_wishlist() throws Throwable {
    	Thread.sleep(5000L);
    	myAccountPageObject.sendObjectWishlistLink().click();
    }
    
    @Then("^click on order history link$")
    public void click_on_order_history_link() throws Throwable {
    	myAccountPageObject.sendObjectOrderHistoryLink().click();
    }
    
    
}
