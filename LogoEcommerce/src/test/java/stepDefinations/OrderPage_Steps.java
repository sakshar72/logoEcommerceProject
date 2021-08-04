package stepDefinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import objectRepository.DressesPLPPageObjects;
import objectRepository.HomePageObjects;
import objectRepository.MyAccountPageObjects;
import objectRepository.OrderHistoryPageObjects;
import objectRepository.OrderPageObjects;
import resources.UtilityFunctions;

public class OrderPage_Steps extends UtilityFunctions {
	TestContext testContext;
	HomePageObjects homePageObject;
	SoftAssert softAssertObj;
	Properties propertiesObj;
	Actions actionObject;
	DressesPLPPageObjects DressesPLPPageObject;
	OrderPageObjects OrderPageObject;
	ArrayList<String> productPrice = new ArrayList<String>();
	ArrayList<String> productName = new ArrayList<String>();
	ArrayList<String> paymentMethodType = new ArrayList<String>();
	ArrayList<String> skuId = new ArrayList<String>();
	ArrayList<String> colorAndSize = new ArrayList<String>();
	float calculatedPrice = 0;
	WebDriverWait waitObject;
	MyAccountPageObjects MyAccountPageObject;
	int count;
	HashMap<String, String> hash_map = new HashMap<String, String>();
	OrderHistoryPageObjects OrderHistoryPageObject;

	public OrderPage_Steps(TestContext context) throws IOException {
		testContext = context;
		DressesPLPPageObject = testContext.getPageObjectManager().getDressesPLPPage();
		MyAccountPageObject = testContext.getPageObjectManager().getMyAccountPage();
		OrderHistoryPageObject = testContext.getPageObjectManager().getOrderHistoryPage();
		OrderPageObject = testContext.getPageObjectManager().getOrderPage();
		homePageObject = context.getPageObjectManager().getHomePage();
		softAssertObj = softAssertObject();
		propertiesObj = propertiesFileLoad();
		actionObject = actionObject(driverObject);
		waitObject = explicitWait();
	}

	@Then("^verify the product details and cost$")
	public void verify_the_product_details_and_cost() throws Throwable {
		productPrice.add(testContext.scenarioContext.getContext(Context.product_Price1).toString().substring(1));
		productPrice.add(testContext.scenarioContext.getContext(Context.product_Price2).toString().substring(1));
		productName.add(testContext.scenarioContext.getContext(Context.product_Name1).toString());
		productName.add(testContext.scenarioContext.getContext(Context.product_Name2).toString());
		System.out.println("Array list of product price " + productPrice);
		System.out.println("Array list of product price " + productName);
		for (int i = 0; i < productPrice.size(); i++) {
			System.out.println("Product price line 48 " + productPrice.get(i));
			System.out.println("Product name line 49 " + productName.get(i));
			System.out.println("Cart product name " + OrderPageObject.cartProductName.get(i).getText());
			System.out.println("Cart product price " + OrderPageObject.cartProductPrice.get(i).getText().substring(1));
			softAssertObj.assertEquals(OrderPageObject.cartProductPrice.get(i).getText().substring(1),
					productPrice.get(i), "Product Price Did not matched");
			softAssertObj.assertEquals(OrderPageObject.cartProductName.get(i).getText(), productName.get(i),
					"Product name Did not matched");
			softAssertObj.assertAll();
			calculatedPrice = calculatedPrice + Float.parseFloat(productPrice.get(i).toString());
			testContext.scenarioContext.setContext(Context.product_TotalPrice, calculatedPrice);
			testContext.scenarioContext.setContext(Context.product_TotalPriceWithShiiping,
					OrderPageObject.sendObjectTotalPriceIncludingShipping().getText().substring(1));
		}

	}

	@Then("^verify the total product cost$")
	public void verify_the_total_product_cost() throws Throwable {
		System.out.println("Printed price "
				+ Float.parseFloat(OrderPageObject.sendObjectTotalProductPrice().getText().toString().substring(1)));
		if (calculatedPrice != Float
				.parseFloat(OrderPageObject.sendObjectTotalProductPrice().getText().toString().substring(1))) {
			Assert.fail("Calcualted value and printed value is not same ");
		}
	}

	@Then("^click on proceed to chekout$")
	public void click_on_proceed_to_chekout() throws Throwable {
		OrderPageObject.sendObjectProceedToCheckoutSummaryPage().click();
		Thread.sleep(4000L);
		waitObject.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='processAddress']")))
				.click();
		Thread.sleep(4000L);
		OrderPageObject.sendObjectTermsConditionCheckbox().click();
		waitObject.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='processCarrier']")))
				.click();

	}

	@Then("^verfiy the total payment$")
	public void verfiy_the_total_payment() throws Throwable {
		softAssertObj.assertEquals(testContext.scenarioContext.getContext(Context.product_TotalPrice).toString(),
				OrderPageObject.sendObjectTotalPrice().getText().substring(1), "Total Price is a mismatch");
		softAssertObj.assertAll();
	}

	@Then("^select the payment option$")
	public void select_the_payment_option() throws Throwable {
		for (int i = 0; i < OrderPageObject.skuIdList.size(); i++) {
			System.out.println("Color and size " + OrderPageObject.colorAndSizeList.get(i).getText());
			System.out.println("skuID " + OrderPageObject.skuIdList.get(i).getText());
			colorAndSize.add(OrderPageObject.colorAndSizeList.get(i).getText());
			skuId.add(OrderPageObject.skuIdList.get(i).getText());
		}
		OrderPageObject.sendObjectPayByBankWire().click();
	}

	@Then("^select the verify the payment amount$")
	public void select_the_verify_the_payment_amount() throws Throwable {
		softAssertObj.assertEquals(
				testContext.scenarioContext.getContext(Context.product_TotalPriceWithShiiping).toString(),
				OrderPageObject.sendObjectTotalPriceonPaymentPage().getText().substring(1),
				"Price not matching on Payment Page");
		softAssertObj.assertAll();
	}

	@Then("^click on confirm order button$")
	public void click_on_confirm_order_button() throws Throwable {
		OrderPageObject.sendObjectConfirmOrderBtn().click();
	}

	@Then("^Verify the order$")
	public void verify_the_order() throws Throwable {
		testContext.scenarioContext.setContext(Context.orderDetails,
				OrderPageObject.sendObjectOrderDetails().getText());
		MyAccountPageObject.sendObjectCustomerLoggedInName().click();
		MyAccountPageObject.sendObjectOrderHistoryLink().click();
	}

	@Then("^verify the order reference ID$")
	public void verify_the_order_reference_id() throws Throwable {
		System.out.println("Color and size list " + colorAndSize);
		Thread.sleep(2000L);
		for (int i = 0; i < OrderPageObject.paymentTypeList.size(); i++) {
			hash_map.put(OrderPageObject.listOrderReferenceID.get(i).getText(),
					OrderPageObject.paymentTypeList.get(i).getText());
		}
		Set<Map.Entry<String, String>> entries = hash_map.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			System.out.print("key: " + entry.getKey());
			System.out.println(", Value: " + entry.getValue());
		}
		OrderPageObject.sendObjectOrderDetailsLink().click();
		for (Map.Entry<String, String> entry : entries) {
			if (entry.getKey() == OrderPageObject.sendObjectFirstOrderID().getText()) {
				softAssertObj.assertEquals(entry.getValue(), OrderHistoryPageObject.sendObjectPaymentMethod().getText(),
						"Order Refernce id not available ");
				softAssertObj.assertAll();
				break;
			}
		}

		for (int i = 0; i < OrderHistoryPageObject.productReferenceIDList.size(); i++) {
			System.out.println("Size " + OrderHistoryPageObject.productReferenceIDList.size());
			System.out.println(
					"Order hisotry page sku id " + OrderHistoryPageObject.productReferenceIDList.get(i).getText());
			System.out.println("Sku id array " + skuId.get(i));
			System.out.println("order hisoty " + OrderHistoryPageObject.productDetails.get(i).getText());
			System.out.println("Color and size array list " + colorAndSize.get(i));
			softAssertObj.assertEquals("SKU : " + OrderHistoryPageObject.productReferenceIDList.get(i).getText(),
					skuId.get(i), "Sku id does not match");
			softAssertObj.assertTrue(
					OrderHistoryPageObject.productDetails.get(i).getText().contains(colorAndSize.get(i)),
					"Prodcut details not matching");
			softAssertObj.assertAll();
		}
		softAssertObj.assertEquals(
				OrderHistoryPageObject.sendObjectTotalPriceIncludingShipping().getText().substring(1),
				testContext.scenarioContext.getContext(Context.product_TotalPriceWithShiiping).toString(),
				"Shipping totoal price does nto match ");
		softAssertObj.assertEquals(OrderHistoryPageObject.sendObjectTotalPrice().getText().substring(1),
				testContext.scenarioContext.getContext(Context.product_TotalPrice).toString(),
				"totoal price does nto match ");
		softAssertObj.assertAll();
	}

	@Then("^click on reorder link$")
	public void click_on_reorder_link() throws Throwable {
		OrderHistoryPageObject.sendObjectFirstReorderLink().click();
	}

	@Then("^capture the order refrence id, price and payment method$")
	public void capture_the_order_refrence_id_price_and_payment_method() throws Throwable {
		testContext.scenarioContext.setContext(Context.product_TotalPrice,
				OrderHistoryPageObject.sendObjectFirstOrderPrice().getText());
		testContext.scenarioContext.setContext(Context.order_RefrenceID,
				OrderHistoryPageObject.sendObjectFirstOrderRefrenceID().getText());
		testContext.scenarioContext.setContext(Context.paymentMethodType,
				OrderHistoryPageObject.sendObjectOrderPaymentMethod().getText());
		System.out.println(
				"Total Price " + testContext.scenarioContext.getContext(Context.product_TotalPrice).toString());
		System.out
				.println("Order Ref ID " + testContext.scenarioContext.getContext(Context.order_RefrenceID).toString());
		System.out.println(
				"Payment Mehtod " + testContext.scenarioContext.getContext(Context.paymentMethodType).toString());
	}

	@Then("^change the quantity value$")
	public void change_the_quantity_value() throws Throwable {
		OrderPageObject.sendObjectFirstProductQuantityBtn().click();
	}

	@Then("^verify whether quantity increased and price of product changed$")
	public void verify_whether_quantity_increased_and_price_of_product_changed() throws Throwable {
		float firstProductPrice = Float
				.parseFloat(OrderPageObject.sendObjectFirstProductTotalPrice().getText().substring(1));
		System.out.println("Value attribute " + OrderPageObject.sendObjectFirstProductQuantity().getAttribute("value"));
		float unitPrice = Float.parseFloat(OrderPageObject.sendObjectUnitPrice().getText().substring(1));
		System.out.println("First product Price " + firstProductPrice + " " + "Unit Price " + unitPrice);
		System.out.println("Remainder " + firstProductPrice % unitPrice);
		System.out.println("Divisor  " + firstProductPrice / unitPrice);
		softAssertObj.assertEquals(firstProductPrice % unitPrice, 0.00, "Quantity is not the multiple");
		softAssertObj.assertEquals(OrderPageObject.sendObjectFirstProductQuantity().getAttribute("value"),
				firstProductPrice / unitPrice, "Quantitty is not equal");
		softAssertObj.assertAll();
		float priceIncludingShipping = Float
				.parseFloat(OrderPageObject.sendObjectTotalPriceIncludingShipping().getText().substring(1));
		float updatedPrice = priceIncludingShipping
				+ Float.parseFloat(OrderPageObject.sendObjectUnitPrice().getText().substring(1));

	}

}
