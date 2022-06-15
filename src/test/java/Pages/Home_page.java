package Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.zxing.NotFoundException;

import Utility.testbase;

public class Home_page extends testbase {

	@FindBy(xpath = "//div[@class='col-xs-14 search-box-wrapper']//input")
	WebElement txt_search;

	@FindBy(xpath = "//button[@class='searchformButton col-xs-4 rippleGrey']")
	WebElement btn_search;

	@FindBy(xpath = "//div[@class='nav-bottom-barcode ']")
	WebElement snapdeal_barcode;

	@FindBy(xpath = "//div[@class='nav-bottom-barcode ']//div[@class='bar-code-image barCodImg']")
	WebElement scan_snapdeal_barcode;

	// without Logged in for Signin Option
	@FindBy(xpath = "//div[@class='myAccountTab accountHeaderClass col-xs-13 reset-padding']")
	WebElement lbl_signin;

	@FindBy(xpath = "//div[@class='accountInfoNonLoggedIn']//a[contains(text(),'login')]")
	WebElement btn_login;

	@FindBy(xpath = "//div[@class='accountInfoNonLoggedIn']//span[contains(text(),'Register')]")
	WebElement lnk_register;

	@FindBy(xpath = "//div[@class='dropdownAccountNonLoggedIn']//div//a[contains(text(),'Your Account')]")
	WebElement lnk_your_account;

	@FindBy(xpath = "//div[@class='dropdownAccountNonLoggedIn']//div//a[contains(text(),'Your Orders')]")
	WebElement lnk_your_Orders;

	@FindBy(xpath = "//div[@class='dropdownAccountNonLoggedIn']//div//a[contains(text(),'Shortlist')]")
	WebElement lnk_shortlist;

	// With login options
	@FindBy(xpath = "//li[@class='accountInfoNonLoggedIn logoutNew']//a[contains(text(),'Logout')]")
	WebElement btn_logout;

	@FindBy(xpath = "//li[@class='accountInfoNonLoggedIn logoutNew']//parent::ul/li//a[contains(text(),'Orders')]")
	WebElement lnk_orders;

	public Home_page() {

		PageFactory.initElements(driver, this);

	}

	public void Page_url(String url) {
		driver.get(url);
	}

	public String Homepage_title() {
		return driver.getTitle();
	}

	public void clickonSearch_bar() {
		isClickable(txt_search);
	}

	public String barcode_snapdeal() throws InterruptedException, NotFoundException, IOException {
		isElementPresent(snapdeal_barcode);

		String qrCodeFile = scan_snapdeal_barcode.getCssValue("background-image");
		String QRurl = getStringBetween(qrCodeFile, ch);

		return QRcode(getStringBetween(qrCodeFile, ch));

	}

	public void clear_Search() {
		clearValue(txt_search);
	}

	public void enter_productname(String productname) {

		sendKeys(txt_search, productname);
	}

	public void clickon_search() {
		isClickable(btn_search);
	}

	public void clickon_loginbutton() {
		moveToElement(lbl_signin);
		isClickable(btn_login);
	}

	public void verifyuser_login() {
		moveToElement(lbl_signin);

	}

	public boolean display_user_login() {
		return isdisplay(btn_logout);
	}

	public void clickon_withlogin_Orderlink() {
		isClickable(lnk_orders);
	}

}
