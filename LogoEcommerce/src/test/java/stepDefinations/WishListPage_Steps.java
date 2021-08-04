package stepDefinations;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import objectRepository.DressesPLPPageObjects;
import objectRepository.HomePageObjects;
import objectRepository.MyAccountPageObjects;
import objectRepository.WishListObjects;
import resources.UtilityFunctions;

public class WishListPage_Steps extends UtilityFunctions {
	TestContext testContext;
	HomePageObjects homePageObject;
	SoftAssert softAssertObj;
	Properties propertiesObj;
	Actions actionObject;
	WishListObjects WishListObject;
	DressesPLPPageObjects DressesPLPPageObject;
	MyAccountPageObjects MyAccountPageObject;

	public WishListPage_Steps(TestContext context) throws IOException {
		testContext = context;
		WishListObject = context.getPageObjectManager().getWishlistPage();
		MyAccountPageObject = context.getPageObjectManager().getMyAccountPage();
		DressesPLPPageObject = context.getPageObjectManager().getDressesPLPPage();
		homePageObject = context.getPageObjectManager().getHomePage();
		softAssertObj = softAssertObject();
		propertiesObj = propertiesFileLoad();
		actionObject = actionObject(driverObject);
	}

	@Then("^Add a name for your wishlist$")
	public void add_a_name_for_your_wishlist() throws Throwable {
		actionObject.click(WishListObject.sendObjectWishListNameInputField())
				.sendKeys(propertiesObj.getProperty("wishListName")).build().perform();
	}

	@Then("^click on save wishlist button$")
	public void click_on_sign_in_button() throws Throwable {
		WishListObject.sendObjectSaveWishlistButton().click();
	}

	@Then("^select the product to add to wishlist$")
	public void select_the_product_to_add_to_wishlist() throws Throwable {
		System.out.println("Inside this step");
		Thread.sleep(4000L);
		homePageObject.sendObjectDressesNavLink().click();
		DressesPLPPageObject.sendObjectSecondSummerDress().click();
		Thread.sleep(4000L);
		testContext.scenarioContext.setContext(Context.wishlistProductName,
				DressesPLPPageObject.sendObjectWishlistProductHeading().getText());
		testContext.scenarioContext.setContext(Context.wishlistProductPrice,
				DressesPLPPageObject.sendObjectWishlistProductPrice().getText());

	}

	@Then("^click on Add to Wishlist button$")
	public void click_on_add_to_wishlist_button() throws Throwable {
		WishListObject.sendObjectAddToWishlistBtn().click();
		Thread.sleep(4000L);
		WishListObject.sendObjectAddToWishlistCloseBtn().click();
		System.out.println("First product name " + testContext.scenarioContext.getContext(Context.wishlistProductName));
		System.out
				.println("First product Price " + testContext.scenarioContext.getContext(Context.wishlistProductPrice));
	}

	@Then("^click on dresses nav link$")
	public void click_on_dresses_nav_link() throws Throwable {
		homePageObject.sendObjectDressesNavLink().click();
	}

	@Then("^select the dress to be added to wishlist$")
	public void select_the_dress_to_be_added_to_wishlist() throws Throwable {
		Thread.sleep(5000L);
		DressesPLPPageObject.sendObjectfirstSummerDress().click();
	}

	@Then("^add the dress to wishlist$")
	public void add_the_dress_to_wishlist() throws Throwable {
		testContext.scenarioContext.setContext(Context.wishlistSecondProductName,
				DressesPLPPageObject.sendObjectWishlistProductHeading().getText());
		testContext.scenarioContext.setContext(Context.wishlistSecondProductPrice,
				DressesPLPPageObject.sendObjectWishlistProductPrice().getText());
		System.out.println(
				"Second product name " + testContext.scenarioContext.getContext(Context.wishlistSecondProductName));
		System.out.println(
				"Second product Price " + testContext.scenarioContext.getContext(Context.wishlistSecondProductPrice));
	}

	@Then("^click on name profile$")
	public void click_on_name_profile() throws Throwable {
		MyAccountPageObject.sendObjectCustomerLoggedInName().click();
	}

	@Then("^click on wishlist button$")
	public void click_on_wishlist_button() throws Throwable {
		MyAccountPageObject.sendObjectWishlistLink().click();
	}

	@Then("^click on created wishlist$")
	public void click_on_created_wishlist() throws Throwable {
		WishListObject.sendObjectCreatedWishlistNameLink().click();
	}

	@Then("^verify the quantity of products added in wishlist$")
	public void verify_the_quantity_of_products_added_in_wishlist() throws Throwable {
		int count = 0;
		for (int i = 0; i < WishListObject.quantityInsideWishlistLink.size(); i++) {
			System.out.println(
					"Value of index " + i + WishListObject.quantityInsideWishlistLink.get(i).getAttribute("value"));
			count = count + Integer.parseInt(WishListObject.quantityInsideWishlistLink.get(i).getAttribute("value"));
		}
		System.out.println("value of count " + count);
		softAssertObj.assertEquals(Integer.parseInt(WishListObject.sendObjectQuantityValue().getText()), count,
				"Value are not same");
		softAssertObj.assertAll();
	}

	@Then("^click on send wishlist button$")
	public void click_on_send_wishlist_button() throws Throwable {
		WishListObject.sendObjectSendWishlistBtn().click();
	}

	@Then("^add the email address to share the wishlist$")
	public void add_the_email_address_to_share_the_wishlist() throws Throwable {
		actionObject.click(WishListObject.sendObjectEmailInputField()).sendKeys(propertiesObj.getProperty("Email"));

	}

	@Then("^click on send button$")
	public void click_on_send_button() throws Throwable {
		WishListObject.sendObjectSendButton().click();
	}

}
