package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.testbase;

public class Email_page extends testbase {

	@FindBy(xpath = "//form[@id='aso_search_form_anchor']//input[@name='q'][@placeholder='Search mail']")
	WebElement gmail_search;

	@FindBy(xpath = "(//table//tbody//tr[@role='row'][1])[2]")
	List<WebElement> list_emailmail;
	
	@FindBy(xpath = "//td[contains(text(),'You need to pay')]//following::td[1]")
	WebElement email_Youneed_to_pay;


	public Email_page() {

		PageFactory.initElements(driver, this);
	}

	public void clickonSearch_bar() {
		isClickable(gmail_search);
	}
	
	public String email_Youpay_price_total() {
		return getText(email_Youneed_to_pay);
	}
	

	public void enter_gmail_searchname(String Searchname) {

		sendKeys(gmail_search, Searchname);
	}
	
	public void email_list() throws InterruptedException {

		int mailsize = list_emailmail.size();
		System.out.println("mailsize -->" + list_emailmail);

		if (list_emailmail.size() != 0) {
			for (int i = 0; i < mailsize; i++) {

				
				isClickable(list_emailmail.get(i));
				break;
			}
		} else {
			System.out.println("List Of mail not appear");
		}

	}
	
	

}
