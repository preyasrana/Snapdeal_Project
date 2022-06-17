package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.testbase;

public class MyAccount_Profile_page extends testbase {

	@FindBy(xpath = "//a[@id='dotAccountChangePassword']")
	WebElement lnk_changepassword;

	@FindBy(xpath = "//form[@id='resetPassword']//button[contains(text(),'SUBMIT')]")
	WebElement btn_changepassword_submit;

	@FindBy(xpath = "//input[@name='newPassword']")
	WebElement txt_newpassword;

	@FindBy(xpath = "//label[@id='newPassword-error']")
	WebElement validation_msg_password;
	
	@FindBy(xpath = "//div[@class='sidebarin otp-screen']//input[@class='otpValueCode']")
	WebElement txt_otpValueCode;
	
	

	public MyAccount_Profile_page() {

		PageFactory.initElements(driver, this);

	}

	public void lnk_changepassword() {

		isClickable(lnk_changepassword);

	}

	public String Myaccount_changepassword_title() {
		return driver.getTitle();
	}

	public void clear_newpassword() {

		clearValue(txt_newpassword);

	}
	
	public void btn_changepassword_submit() {

		isClickable(btn_changepassword_submit);

	}

	public String validation_msg_changepassword() {
		return getText(validation_msg_password);
	}
	
	public void enter_newpassword(String pwd) {
		sendKeys(txt_newpassword, pwd);
	}
	
	public boolean popup_otpbox() {

		return isdisplay(txt_otpValueCode);

	}

}
