package StepDefinition;

import org.testng.Assert;

import Pages.MyAccount_Profile_page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
	
	@Then("user enter {string} & Verify {string}")
	public void user_has_enter_invalid_newpassword_in_search_box(String invalidnewpassword,String error_message) throws InterruptedException {

		myaccount_profile.enter_newpassword(invalidnewpassword);
		
		myaccount_profile.btn_changepassword_submit();
		
		System.out.println(error_message);
		System.out.println(myaccount_profile.validation_msg_changepassword());
		Assert.assertEquals(error_message, myaccount_profile.validation_msg_changepassword());
	}
	
	@Then("user enter {string} & click on submit button")
	public void user_has_enter_valid_new_password_in_search_box(String validnewpassword) throws InterruptedException {
		
		myaccount_profile.enter_newpassword(validnewpassword);
		//myaccount_profile.btn_changepassword_submit();

	}
	
	@Then("otp popup display & user enter otp")
	public void otp_popup_display_user_enter_otp() {
		
		myaccount_profile.popup_otpbox();
		
	}
	

}
