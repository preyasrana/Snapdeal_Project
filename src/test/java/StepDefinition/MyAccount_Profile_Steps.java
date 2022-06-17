package StepDefinition;

import org.testng.Assert;

import Pages.MyAccount_Profile_page;
import io.cucumber.java.en.Then;

public class MyAccount_Profile_Steps {
	
	MyAccount_Profile_page myaccount_profile = new MyAccount_Profile_page();
	String Actual_message;
	String Expected_Message;
	
	@Then("user click on changepassword link")
	public void user_click_on_changepassword_link() throws InterruptedException {

		myaccount_profile.lnk_changepassword();

	}
	
	@Then("Verify Page Should be Redirect on changepassword page")
	public void Verify_Page_Should_be_Redirect_on_changepassword_page() throws InterruptedException {

		Actual_message = myaccount_profile.Myaccount_changepassword_title();

		Expected_Message = "Snapdeal.com - Reset Your Password";
		Assert.assertEquals(Expected_Message, Actual_message);

	}
	
	
	@Then("user click on submit button & Verify Error message")
	public void user_click_on_submit_button_Verify_Error_message() throws InterruptedException {

		myaccount_profile.clear_newpassword();
		myaccount_profile.btn_changepassword_submit();
		
		Expected_Message = "New password cannot be empty";
		Assert.assertEquals(Expected_Message, myaccount_profile.validation_msg_changepassword());
		
	}
	


}
