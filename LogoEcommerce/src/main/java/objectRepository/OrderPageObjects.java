package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPageObjects {
	WebDriver driverObject;

	public OrderPageObjects(WebDriver driverObject) {
		this.driverObject = driverObject;
		PageFactory.initElements(driverObject, this);
	}

	@FindBy(xpath = "//table[@id='cart_summary']/tbody/tr/td[2]/p")
	public List<WebElement> cartProductName;

	public List<WebElement> sendObjectProductName() {
		return cartProductName;
	}

	@FindBy(xpath = "//table[@id='cart_summary']/tbody/tr/td[6]/span")
	public List<WebElement> cartProductPrice;

	public List<WebElement> sendObjectProductPrice() {
		return cartProductPrice;
	}

	@FindBy(xpath = "//td[@id='total_product']")
	WebElement totalProductPrice;

	public WebElement sendObjectTotalProductPrice() {
		return totalProductPrice;
	}

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']/a[1]")
	WebElement proceedToCheckoutSummaryPage;

	public WebElement sendObjectProceedToCheckoutSummaryPage() {
		return proceedToCheckoutSummaryPage;
	}

	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement proceedToCheckoutAddress;

	public WebElement sendObjectProceedToCheckoutAddress() {
		return proceedToCheckoutAddress;
	}

	@FindBy(xpath = "//input[@id='cgv']")
	WebElement termsConditionCheckbox;

	public WebElement sendObjectTermsConditionCheckbox() {
		return termsConditionCheckbox;
	}

	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement proceedToCheckoutShipping;

	public WebElement sendObjectProceedToCheckoutShipping() {
		return proceedToCheckoutShipping;
	}

	@FindBy(xpath = "//td[@id='total_product']")
	WebElement totalPrice;

	public WebElement sendObjectTotalPrice() {
		return totalPrice;
	}

	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByBankWire;

	public WebElement sendObjectPayByBankWire() {
		return payByBankWire;
	}

	@FindBy(xpath = "//span[@id='total_price']")
	WebElement totalPriceIncludingShipping;

	public WebElement sendObjectTotalPriceIncludingShipping() {
		return totalPriceIncludingShipping;
	}

	@FindBy(xpath = "//span[@id='amount']")
	WebElement totalPriceonPaymentPage;

	public WebElement sendObjectTotalPriceonPaymentPage() {
		return totalPriceonPaymentPage;
	}

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement confirmOrderBtn;

	public WebElement sendObjectConfirmOrderBtn() {
		return confirmOrderBtn;
	}

	@FindBy(xpath = "//table[@id='order-list']/tbody/tr[1]/td[7]/a[1]")
	WebElement orderDetailsLink;

	public WebElement sendObjectOrderDetailsLink() {
		return orderDetailsLink;
	}

	@FindBy(xpath = "//div[@class='box']")
	WebElement orderDetails;

	public WebElement sendObjectOrderDetails() {
		return orderDetails;
	}

	@FindBy(xpath = "//table[@id='order-list']/tbody/tr/td[1]/a")
	public List<WebElement> listOrderReferenceID;

	public List<WebElement> sendObjectListOrderReferenceID() {
		return listOrderReferenceID;
	}

	@FindBy(xpath = "//table[@id='order-list']/tbody/tr/td[4]")
	public List<WebElement> paymentTypeList;

	public List<WebElement> sendObjectPaymentTypeList() {
		return paymentTypeList;
	}

	@FindBy(xpath = "//table[@id='cart_summary']/tbody/tr/td[2]/small[1]")
	public List<WebElement> skuIdList;

	public List<WebElement> sendObjectSkuIdList() {
		return skuIdList;
	}

	@FindBy(xpath = "//table[@id='cart_summary']/tbody/tr/td[2]/small[2]/a")
	public List<WebElement> colorAndSizeList;

	public List<WebElement> sendObjectColorAndSizeList() {
		return colorAndSizeList;
	}

	@FindBy(xpath = "//table[@id='order-list']/tbody/tr[1]/td[1]/a")
	WebElement firstOrderID;

	public WebElement sendObjectFirstOrderID() {
		return firstOrderID;
	}

	@FindBy(xpath = "//table[@id='cart_summary']/tbody/tr[1]/td[5]/div/a[2]")
	WebElement firstProductQuantityBtn;

	public WebElement sendObjectFirstProductQuantityBtn() {
		return firstProductQuantityBtn;
	}
	
	@FindBy(xpath = "//table[@id='cart_summary']/tbody/tr[1]/td[6]/span")
	WebElement firstProductTotalPrice;

	public WebElement sendObjectFirstProductTotalPrice() {
		return firstProductTotalPrice;
	}
	
	@FindBy(xpath = "//table[@id='cart_summary']/tbody/tr[1]/td[5]/input[1]")
	WebElement firstProductQuantity;

	public WebElement sendObjectFirstProductQuantity() {
		return firstProductQuantity;
	}
	
	@FindBy(xpath = "//table[@id='cart_summary']/tbody/tr[1]/td[4]/span/span[1]")
	WebElement unitPrice;

	public WebElement sendObjectUnitPrice() {
		return unitPrice;
	}
}
