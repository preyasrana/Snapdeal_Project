package StepDefinition;

import org.testng.Assert;

import Pages.Home_page;
import Pages.Productdetail_page;
import Pages.Productlist_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Productdetail_Steps {

	Productdetail_page productdetail = new Productdetail_page();
	Productlist_page productdata = new Productlist_page();

	String Actual_message;
	String Expected_Message;

	@Then("user add to cart product")
	public void user_add_to_cart_product() throws InterruptedException {

		productdetail.btn_click_addtocart();

	}

}
