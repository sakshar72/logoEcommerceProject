package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import enums.Context;
import objectRepository.DressesPLPPageObjects;
import objectRepository.HomePageObjects;
import resources.UtilityFunctions;

public class DressesPLPPage_Steps extends UtilityFunctions {
	TestContext testContext;
	HomePageObjects homePageObject;
	SoftAssert softAssertObj;
	Properties propertiesObj;
	Actions actionObject;
	DressesPLPPageObjects DressesPLPPageObject;

	public DressesPLPPage_Steps(TestContext context) throws IOException {
		testContext = context;
		DressesPLPPageObject = testContext.getPageObjectManager().getDressesPLPPage();
		homePageObject = context.getPageObjectManager().getHomePage();
		softAssertObj = softAssertObject();
		propertiesObj = propertiesFileLoad();
		actionObject = actionObject(driverObject);
	}

	@Then("^filter on summer dress link$")
	public void filter_on_casual_dress_link() throws Throwable {
		DressesPLPPageObject.sendObjectSummerDressLink().click();
	}

	@Then("^select the dress$")
	public void select_the_dress() throws Throwable {
		System.out.println("Dress PLP Page first dress name " + DressesPLPPageObject.sendObjectNameOfDress().getText());
		System.out
				.println("Dress PLP Page first dress Price " + DressesPLPPageObject.sendObjectPriceOfDress().getText());
		testContext.scenarioContext.setContext(Context.product_Name1,
				DressesPLPPageObject.sendObjectNameOfDress().getText());
		testContext.scenarioContext.setContext(Context.product_Price1,
				DressesPLPPageObject.sendObjectPriceOfDress().getText());
		actionObject.moveToElement(DressesPLPPageObject.sendObjectfirstSummerDress())
				.click(DressesPLPPageObject.sendObjectfirstSummerDressAddToCartBtn()).build().perform();
		DressesPLPPageObject.sendObjectWriteAReviewLink().click();
		actionObject.click(DressesPLPPageObject.sendObjectTitleReview())
				.sendKeys(propertiesObj.getProperty("titleReview")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertiesObj.getProperty("comment")).build().perform();
		DressesPLPPageObject.sendObjectSendBtn().click();
		try {
			System.out.print("Inside try block");
			DressesPLPPageObject.sendObjectReviewError().isDisplayed();
			Assert.fail("Comment not saved");
		} catch (Exception e) {
			System.out.print("Inside Catch block");
			WebDriverWait wait = new WebDriverWait(driverObject, 10);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[@class='fancybox-skin']/div/div/p[2]/button"))).click();
		}
	}

	@Then("^click on continue shopping button$")
	public void click_on_checkout_button() throws Throwable {
		Thread.sleep(3000L);
		DressesPLPPageObject.sendObjectAddToCartBtn().click();
		Thread.sleep(3000L);
		DressesPLPPageObject.sendObjectContinueShoppingBtn().click();
	}

	@Then("^click on summer dress link on PDP page$")
	public void click_on_summer_dress_link_on_pdp_page() throws Throwable {
		DressesPLPPageObject.sendObjectSummerDressLinkOnPDP().click();
	}

	@Then("^select the second dress$")
	public void select_the_second_dress() throws Throwable {
		actionObject.moveToElement(DressesPLPPageObject.sendObjectfirstSummerDress())
				.click(DressesPLPPageObject.sendObjectSecondSummerDress()).build().perform();
	}

	@And("^Capture the dress price$")
	public void capture_the_dress_price() throws Throwable {
		System.out.println("Dress PLP Page second dress PRice "
				+ DressesPLPPageObject.sendObjectPriceOfSecondSummerDress().getText());
		System.out.println(
				"Dress PLP Page second dress name " + DressesPLPPageObject.sendObjectSecondDressName().getText());
		testContext.scenarioContext.setContext(Context.product_Price2,
				DressesPLPPageObject.sendObjectPriceOfSecondSummerDress().getText());
		testContext.scenarioContext.setContext(Context.product_Name2,
				DressesPLPPageObject.sendObjectSecondDressName().getText());
	}

	@Then("^add to cart button$")
	public void add_to_cart_button() throws Throwable {
		Thread.sleep(3000L);
		DressesPLPPageObject.sendObjectAddToCartBtn().click();
	}

	@Then("^click on proceed to checkout$")
	public void click_on_proceed_to_checkout() throws Throwable {
		Thread.sleep(2000L);
		DressesPLPPageObject.sendObjectProceedToCheckoutBtn().click();
	}

}
