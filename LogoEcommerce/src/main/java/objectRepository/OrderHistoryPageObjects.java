package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPageObjects {
	WebDriver driverObject;

	public OrderHistoryPageObjects(WebDriver driverObject) {
		this.driverObject = driverObject;
		PageFactory.initElements(driverObject, this);
	}

	@FindBy(xpath = "//div[@class='info-order box']/p[2]/span")
	WebElement paymentMethod;

	public WebElement sendObjectPaymentMethod() {
		return paymentMethod;
	}

	@FindBy(xpath = "//div[@id='order-detail-content']/table/tbody/tr/td[1]")
	public List<WebElement> productReferenceIDList;

	public List<WebElement> sendObjectProductReferenceIDList() {
		return productReferenceIDList;
	}

	@FindBy(xpath = "//div[@id='order-detail-content']/table/tbody/tr/td[2]")
	public List<WebElement> productDetails;

	public List<WebElement> sendObjectProductDetails() {
		return productDetails;
	}

	@FindBy(xpath = "//div[@id='order-detail-content']/table/tfoot/tr[2]/td[2]/span")
	WebElement totalPrice;

	public WebElement sendObjectTotalPrice() {
		return totalPrice;
	}

	@FindBy(xpath = "//div[@id='order-detail-content']/table/tfoot/tr[4]/td[2]/span")
	WebElement totalPriceIncludingShipping;

	public WebElement sendObjectTotalPriceIncludingShipping() {
		return totalPriceIncludingShipping;
	}

	@FindBy(xpath = "//table[@id='order-list']/tbody/tr[1]/td[7]/a[2]")
	WebElement firstReorderLink;

	public WebElement sendObjectFirstReorderLink() {
		return firstReorderLink;
	}

	@FindBy(xpath = "//table[@id='order-list']/tbody/tr[1]/td[7]/a[2]")
	WebElement firstOrderRefrenceID;

	public WebElement sendObjectFirstOrderRefrenceID() {
		return firstOrderRefrenceID;
	}

	@FindBy(xpath = "//table[@id='order-list']/tbody/tr[1]/td[3]/span")
	WebElement firstOrderPrice;

	public WebElement sendObjectFirstOrderPrice() {
		return firstOrderPrice;
	}

	@FindBy(xpath = "//table[@id='order-list']/tbody/tr[1]/td[4]")
	WebElement orderPaymentMethod;

	public WebElement sendObjectOrderPaymentMethod() {
		return orderPaymentMethod;
	}
}
