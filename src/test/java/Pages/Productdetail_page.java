package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.testbase;

public class Productdetail_page extends testbase {

	@FindBy(id = "add-cart-button-id")
	WebElement btn_addtocart;
	
	

	public Productdetail_page() {

		PageFactory.initElements(driver, this);

	}

	public void btn_click_addtocart() {
		isClickable(btn_addtocart);
	}
	

}
