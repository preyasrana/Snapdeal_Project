package StepDefinition;

import Pages.Login_page;
import Pages.Productlist_page;
import io.cucumber.java.en.Then;

public class Login_Steps {

	Login_page login = new Login_page();
	Productlist_page productdata = new Productlist_page();
	String Actual_message;
	String Expected_Message;

	@Then("user click on login via gmail option")
	public void user_click_on_login_via_gmail_option() throws InterruptedException {

		login.btn_logingoogle();
	}

	@Then("user login via gmail")
	public void user_login_via_gmail() throws InterruptedException {

		login.switchToLatestWindow();
		//login.switchTo_multiWindow();
		
		login.enter_gmail_email(login.configreader.init_prop().getProperty("gmail_email"));
		login.btn_gmail_emailnext();
		login.enter_gmail_pwd(login.configreader.init_prop().getProperty("gmail_pwd"));
		login.btn_gmail_pwdnext();
	
		login.switchToNextTab();
				
	}

}
