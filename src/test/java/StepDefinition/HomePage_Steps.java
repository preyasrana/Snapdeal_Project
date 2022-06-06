package StepDefinition;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.Home_page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage_Steps {

	Home_page homepage = new Home_page();
	String Actual_message;
	String Expected_Message;

	SoftAssert soft = new SoftAssert();

	@Given("user is on Home Page and verify page title")
	public void Verify_home_page_title() throws InterruptedException {

		System.out.println("Inside Steps - user is on Home Page and verify page title");

		homepage.Page_url(homepage.configreader.init_prop().getProperty("url"));

		Actual_message = homepage.Homepage_title();

		Expected_Message = "Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items";
		Assert.assertEquals(Expected_Message, Actual_message);

	}

	@When("user click on search box")
	public void user_click_on_search_box() throws InterruptedException {

		System.out.println("Inside Steps - user click on search box");
		homepage.clickonSearch_bar();

	}

	@When("user has enter {string} in search box")
	public void user_has_enter_product_name_in_search_box(String Search_product) throws InterruptedException {

		System.out.println("Inside Steps - user has enter product name in search box");

		homepage.enter_productname(Search_product);

	}

	@Then("user has click on search button")
	public void click_on_search_button() {

		homepage.clickon_search();

	}

}
