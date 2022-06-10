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

}
