package PageObjectManagers;

import org.openqa.selenium.WebDriver;

import objectRepository.DressesPLPPageObjects;
import objectRepository.HomePageObjects;
import objectRepository.MyAccountPageObjects;
import objectRepository.OrderHistoryPageObjects;
import objectRepository.OrderPageObjects;
import objectRepository.WishListObjects;

public class PageObjectManager {
	WebDriver driver;
	MyAccountPageObjects myAccountPageObject;
	HomePageObjects homePageObject;
	WishListObjects WishListObject;
	DressesPLPPageObjects DressesPLPPageObject;
	OrderPageObjects OrderPageObject;
	OrderHistoryPageObjects OrderHistoryPageObject;
	

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public HomePageObjects getHomePage() {

		return (homePageObject == null) ? homePageObject = new HomePageObjects(driver) : homePageObject;

	}

	public MyAccountPageObjects getMyAccountPage() {

		return (myAccountPageObject == null) ? myAccountPageObject = new MyAccountPageObjects(driver)
				: myAccountPageObject;

	}

	public WishListObjects getWishlistPage() {

		return (WishListObject == null) ? WishListObject = new WishListObjects(driver) : WishListObject;

	}

	public DressesPLPPageObjects getDressesPLPPage() {

		return (DressesPLPPageObject == null) ? DressesPLPPageObject = new DressesPLPPageObjects(driver)
				: DressesPLPPageObject;

	}

	public OrderPageObjects getOrderPage() {

		return (OrderPageObject == null) ? OrderPageObject = new OrderPageObjects(driver) : OrderPageObject;

	}

	public OrderHistoryPageObjects getOrderHistoryPage() {

		return (OrderHistoryPageObject == null) ? OrderHistoryPageObject = new OrderHistoryPageObjects(driver)
				: OrderHistoryPageObject;

	}
}
