package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListObjects {
	WebDriver driverObject;

	public WishListObjects(WebDriver driverObject) {
		this.driverObject = driverObject;
		PageFactory.initElements(driverObject, this);
	}

	@FindBy(xpath = "//input[@id='name']")
	WebElement wishListNameInputField;

	public WebElement sendObjectWishListNameInputField() {
		return wishListNameInputField;
	}

	@FindBy(xpath = "//button[@id='submitWishlist']")
	WebElement saveWishlistButton;

	public WebElement sendObjectSaveWishlistButton() {
		return saveWishlistButton;
	}

	@FindBy(xpath = "//div[@id='best-sellers_block_right']/div/ul/li[3]/div/h5/a")
	WebElement productToAddToWishlist;

	public WebElement sendObjectproductToAddToWishlist() {
		return productToAddToWishlist;
	}

	@FindBy(xpath = "//a[@id='wishlist_button']")
	WebElement AddToWishlistBtn;

	public WebElement sendObjectAddToWishlistBtn() {
		return AddToWishlistBtn;
	}

	@FindBy(xpath = "//a[@title='Close']")
	WebElement AddToWishlistCloseBtn;

	public WebElement sendObjectAddToWishlistCloseBtn() {
		return AddToWishlistCloseBtn;
	}

	@FindBy(xpath = "//div[@id='block-history']/table/tbody/tr/td[1]/a")
	WebElement createdWishlistNameLink;

	public WebElement sendObjectCreatedWishlistNameLink() {
		return createdWishlistNameLink;
	}

	@FindBy(xpath = "//div[@id='block-history']/table/tbody/tr/td[2]")
	WebElement quantityValue;

	public WebElement sendObjectQuantityValue() {
		return quantityValue;
	}

	@FindBy(xpath = "//a[@id='showSendWishlist']")
	WebElement sendWishlistBtn;

	public WebElement sendObjectSendWishlistBtn() {
		return sendWishlistBtn;
	}

	@FindBy(xpath = "//input[@id='email1']")
	WebElement emailInputField;

	public WebElement sendObjectEmailInputField() {
		return emailInputField;
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendButton;

	public WebElement sendObjectSendButton() {
		return sendButton;
	}

	@FindBy(xpath = "//ul[@class='row wlp_bought_list']/li/div/div[2]/div/div[1]/p[1]/input")
	public List<WebElement> quantityInsideWishlistLink;

	public List<WebElement> sendObjectQuantityInsideWishlistLink() {
		return quantityInsideWishlistLink;
	}
}
