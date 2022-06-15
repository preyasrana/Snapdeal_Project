package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import Utility.testbase;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Login_page extends testbase {

	@FindBy(id = "gplogin")
	WebElement btn_gplogin;
	
	@FindBy(xpath = "//div[@class='login-register-common']//div[@class='social-button gmLogin rfloat col-xs-11'][@id='googleUserLogin']")
	WebElement btn_home_gplogin;
	
	@FindBy(id = "loginIframe")
	WebElement iframe_login;
	
	

	@FindBy(xpath = "//input[@type='email']")
	WebElement txt_gp_email;

	@FindBy(xpath = "//button[@type='button']//span[contains(text(),'Next')]")
	WebElement btn_gp_loginnext;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_gp_pwd;

	@FindBy(xpath = "//div[@id='passwordNext']//span[contains(text(),'Next')]")
	WebElement btn_gp_pwdnext;

	@FindBy(id = "mobile-number")
	WebElement txt_mobilenumber;

	@FindBy(id = "w_password")
	WebElement txt_password;

	@FindBy(id = "register-done")
	WebElement btn_register_continue;


	public Login_page() {

		PageFactory.initElements(driver, this);

	}

	public void btn_logingoogle() {
		isClickable(btn_gplogin);
	}

	public void enter_gmail_email(String email) {
		sendKeys(txt_gp_email, email);
	}

	public void enter_acc_mobno(String mobno) {
		sendKeys(txt_mobilenumber, mobno);
	}

	public void enter_password(String pwd) {
		sendKeys(txt_password, pwd);
	}

	public void btn_gmail_emailnext() {
		isClickable(btn_gp_loginnext);
	}

	public void enter_gmail_pwd(String password) {
		sendKeys(txt_gp_pwd, password);
	}

	public void btn_gmail_pwdnext() {
		isClickable(btn_gp_loginnext);
	}

	public void btn_register_continue() {
		isClickable(btn_register_continue);
	}

	public void btn_home_gplogin() {
		isClickable_javascript(btn_home_gplogin);
	}

	public void iframe_home_login() {
		switchToFrame(iframe_login);
	}
	
	public void back_iframe_home_login() {
		switchToparent();
	}
	

}
