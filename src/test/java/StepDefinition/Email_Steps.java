package StepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.Assert;

import Pages.Checkout_page;
import Pages.Email_page;
import Pages.Login_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Email_Steps {

	Email_page emailpage = new Email_page();
	Login_page login = new Login_page();
	Checkout_page checkoutpg = new Checkout_page();
	String Actual_message;
	String Expected_Message;

	@When("gmail through login and verify email")
	public void gmail_through_login_and_verify_email() throws AWTException, InterruptedException  {

		emailpage.clickonSearch_bar();
		emailpage.enter_gmail_searchname(emailpage.configreader.init_prop().getProperty("gmail_search"));
		emailpage.enter_key();
		emailpage.email_list();
		
	    double getprice = Double.parseDouble(emailpage.email_Youpay_price_total());
	    System.out.println(getprice);
		Assert.assertEquals(getprice, checkoutpg.review_totalpayprice());
	    //Assert.assertEquals(getprice, 135.0);
	    
	}

	@Given("user login through gmail")
	public void user_login_through_gmail() throws InterruptedException {
		
		emailpage.navigateurl(emailpage.configreader.init_prop().getProperty("gmailurl"));
		login.enter_gmail_email(login.configreader.init_prop().getProperty("gmail_email"));
		login.btn_gmail_emailnext();
	
		login.enter_gmail_pwd(login.configreader.init_prop().getProperty("gmail_pwd"));
		login.btn_gmail_pwdnext();
	

	}

}
