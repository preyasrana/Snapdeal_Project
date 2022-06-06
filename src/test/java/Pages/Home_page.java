package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.testbase;

public class Home_page extends testbase {
	
	@FindBy(xpath = "//div[@class='col-xs-14 search-box-wrapper']//input")
	WebElement txt_search;
	
	@FindBy(xpath = "//button[@class='searchformButton col-xs-4 rippleGrey']")
	WebElement btn_search;
	

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
