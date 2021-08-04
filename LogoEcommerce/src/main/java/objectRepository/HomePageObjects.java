package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	WebDriver driverObject;

	public HomePageObjects(WebDriver driverObject) {
		this.driverObject = driverObject;
		PageFactory.initElements(driverObject, this);
	}

	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	WebElement signInBtn;

	public WebElement sendObjectSignInBtn() {
		return signInBtn;
	}

	@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]")
	WebElement dressesNavLink;

	public WebElement sendObjectDressesNavLink() {
		return dressesNavLink;
	}

}
