package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPLPPageObjects {
	WebDriver driverObject;

	public DressesPLPPageObjects(WebDriver driverObject) {
		this.driverObject = driverObject;
		PageFactory.initElements(driverObject, this);
	}

	@FindBy(xpath = "//div[@id='categories_block_left']/div/ul/li[3]")
	WebElement summerDressLink;

	public WebElement sendObjectSummerDressLink() {
		return summerDressLink;
	}

	@FindBy(xpath = "//div[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span[1]")
	WebElement priceOfDress;

	public WebElement sendObjectPriceOfDress() {
		return priceOfDress;
	}

	@FindBy(xpath = "//div[@id='center_column']/ul/li[1]/div/div[2]/h5/a")
	WebElement nameOfDress;

	public WebElement sendObjectNameOfDress() {
		return nameOfDress;
	}

	@FindBy(xpath = "//div[@class='pb-center-column col-xs-12 col-sm-4']/h1")
	WebElement secondDressName;

	public WebElement sendObjectSecondDressName() {
		return secondDressName;
	}

	@FindBy(xpath = "//div[@id='center_column']/ul/li[1]/div/div[2]/h5/a")
	WebElement firstSummerDress;

	public WebElement sendObjectfirstSummerDress() {
		return firstSummerDress;
	}

	@FindBy(xpath = "//div[@id='center_column']/ul/li[1]/div/div[2]/h5/a")
	WebElement firstSummerDressAddToCartBtn;

	public WebElement sendObjectfirstSummerDressAddToCartBtn() {
		return firstSummerDressAddToCartBtn;
	}

	@FindBy(xpath = "//p[@id='add_to_cart']/button")
	WebElement addToCartBtn;

	public WebElement sendObjectAddToCartBtn() {
		return addToCartBtn;
	}

	@FindBy(xpath = "//div[@id='product_comments_block_extra']/ul/li/a")
	WebElement writeAReviewLink;

	public WebElement sendObjectWriteAReviewLink() {
		return writeAReviewLink;
	}

	@FindBy(xpath = "//input[@id='comment_title']")
	WebElement titleReview;

	public WebElement sendObjectTitleReview() {
		return titleReview;
	}

	@FindBy(xpath = "//button[@id='submitNewMessage']")
	WebElement sendBtn;

	public WebElement sendObjectSendBtn() {
		return sendBtn;
	}

	@FindBy(xpath = "//div[@class='fancybox-skin']/div/div/p[2]/button")
	WebElement okBtn;

	public WebElement sendObjectOkBtn() {
		return okBtn;
	}

	@FindBy(xpath = "//div[@id='new_comment_form_error']/ul/li")
	WebElement reviewError;

	public WebElement sendObjectReviewError() {
		return reviewError;
	}

	@FindBy(xpath = "//div[@class='button-container']/span")
	WebElement continueShoppingBtn;

	public WebElement sendObjectContinueShoppingBtn() {
		return continueShoppingBtn;
	}

	@FindBy(xpath = "//div[@id='columns']/div[1]/a[4]")
	WebElement summerDressLinkOnPDP;

	public WebElement sendObjectSummerDressLinkOnPDP() {
		return summerDressLinkOnPDP;
	}

	@FindBy(xpath = "//div[@id='center_column']/ul/li[2]/div/div[2]/h5/a")
	WebElement secondSummerDress;

	public WebElement sendObjectSecondSummerDress() {
		return secondSummerDress;
	}

	@FindBy(xpath = "//span[@id='our_price_display']")
	WebElement priceOfSecondSummerDress;

	public WebElement sendObjectPriceOfSecondSummerDress() {
		return priceOfSecondSummerDress;
	}

	@FindBy(xpath = "//div[@class='button-container']/a")
	WebElement proceedToCheckoutBtn;

	public WebElement sendObjectProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}

	@FindBy(xpath = "//h1")
	WebElement wishlistProductHeading;

	public WebElement sendObjectWishlistProductHeading() {
		return wishlistProductHeading;
	}

	@FindBy(xpath = "//span[@id='our_price_display']")
	WebElement wishlistProductPrice;

	public WebElement sendObjectWishlistProductPrice() {
		return wishlistProductPrice;
	}

}
