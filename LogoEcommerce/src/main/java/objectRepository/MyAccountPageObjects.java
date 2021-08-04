package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageObjects {
	WebDriver driverObject;

	public MyAccountPageObjects(WebDriver driverObject) {
		this.driverObject = driverObject;
		PageFactory.initElements(driverObject, this);
	}

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement createAccountEmailAddressInputField;

	public WebElement sendObjectCreateAccountEmailAddressInputField() {
		return createAccountEmailAddressInputField;
	}

	@FindBy(xpath = "//button[@id='SubmitCreate']")
	WebElement createAccountBtn;

	public WebElement sendObjectCreateAccountBtn() {
		return createAccountBtn;
	}

	@FindBy(xpath = "//div[@id='create_account_error']/ol/li")
	WebElement createAccountErrorMessage;

	public WebElement sendObjectCreateAccountErrorMessage() {
		return createAccountErrorMessage;
	}

	@FindBy(xpath = "//div[@id='uniform-id_gender1']")
	WebElement genderRadiBtnMale;

	public WebElement sendObjectGenderRadiBtnMale() {
		return genderRadiBtnMale;
	}

	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement firstNameInputField;

	public WebElement sendObjectFirstNameInputField() {
		return firstNameInputField;
	}

	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement lastNameInputField;

	public WebElement sendObjectLastNameInputField() {
		return lastNameInputField;
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailInputField;

	public WebElement sendObjectEmailInputField() {
		return emailInputField;
	}

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement passwordInputField;

	public WebElement sendObjectPasswordInputField() {
		return passwordInputField;
	}

	@FindBy(xpath = "//select[@id='days']")
	WebElement dateInputField;

	public WebElement sendObjectDateInputField() {
		return dateInputField;
	}

	@FindBy(xpath = "//select[@id='months']")
	WebElement monthInputField;

	public WebElement sendObjectMonthInputField() {
		return monthInputField;
	}

	@FindBy(xpath = "//select[@id='years']")
	WebElement yearsInputField;

	public WebElement sendObjectYearsInputField() {
		return yearsInputField;
	}

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstNameAddressInputField;

	public WebElement sendObjectFirstNameAddressInputField() {
		return firstNameAddressInputField;
	}

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastNameAddressInputField;

	public WebElement sendObjectLastNameAddressInputField() {
		return lastNameAddressInputField;
	}

	@FindBy(xpath = "//input[@id='company']")
	WebElement companyInputField;

	public WebElement sendObjectCompanyInputField() {
		return companyInputField;
	}

	@FindBy(xpath = "//input[@id='city']")
	WebElement cityInputField;

	public WebElement sendObjectCityInputField() {
		return cityInputField;
	}

	@FindBy(xpath = "//input[@id='address1']")
	WebElement addressInputField;

	public WebElement sendObjectAddressInputField() {
		return addressInputField;
	}

	@FindBy(xpath = "//select[@id='id_state']")
	WebElement stateInputField;

	public WebElement sendObjectStateInputField() {
		return stateInputField;
	}

	@FindBy(xpath = "//select[@id='id_country']")
	WebElement countryInputField;

	public WebElement sendObjectCountryInputField() {
		return countryInputField;
	}

	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement mobileInputField;

	public WebElement sendObjectMobileInputField() {
		return mobileInputField;
	}

	@FindBy(xpath = "//input[@id='postcode']")
	WebElement pincodeInputField;

	public WebElement sendObjectPincodeInputField() {
		return pincodeInputField;
	}

	@FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
	WebElement invalidEntryError;

	public WebElement sendObjectInvalidEntryError() {
		return invalidEntryError;
	}

	@FindBy(xpath = "//button[@id='submitAccount']")
	WebElement registerBtn;

	public WebElement sendObjectRegisterBtn() {
		return registerBtn;
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement loginEmailInputField;

	public WebElement sendObjectLoginEmailInputField() {
		return loginEmailInputField;
	}

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement signInBtn;

	public WebElement sendObjectSignInBtn() {
		return signInBtn;
	}

	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement customerLoggedInName;

	public WebElement sendObjectCustomerLoggedInName() {
		return customerLoggedInName;
	}

	@FindBy(xpath = "//li[@class='lnk_wishlist']")
	WebElement wishlistLink;

	public WebElement sendObjectWishlistLink() {
		return wishlistLink;
	}

	@FindBy(xpath = "//a[@title='Orders']")
	WebElement orderHistoryLink;

	public WebElement sendObjectOrderHistoryLink() {
		return orderHistoryLink;
	}
}
