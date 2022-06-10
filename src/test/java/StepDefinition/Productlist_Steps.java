package StepDefinition;

import java.util.List;

import org.testng.Assert;

import Pages.Home_page;
import Pages.Productlist_page;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Productlist_Steps {

	Productlist_page productdata = new Productlist_page();
	String Actual_message;
	String Expected_Message;

	List<String> listproduct;

	@Then("user can click on product")
	public void user_can_click_on_product() throws InterruptedException {

		productdata.click_on_sorting_by();
		productdata.Sorting_Productlist();
		Assert.assertEquals(productdata.gettext_Sortby(), "Price Low To High");
		productdata.product_list();

	}
	
	@Then("user gets list of product")
	public void user_gets_list_of_product() throws InterruptedException {

		productdata.click_on_sorting_by();
		productdata.Sorting_Productlist();
		Assert.assertEquals(productdata.gettext_Sortby(), "Price Low To High");
		
		productdata.getlist_allProduct();
		
		
		
		
		
	}

	@Then("user click on product")
	public void user_click_on_product() throws InterruptedException {

		listproduct = productdata.getall_product_list();
		System.out.println(listproduct);
	}

	@Then("user switch on new window")
	public void user_switch_on_new_window() throws InterruptedException {

		// productdata.switch_newwindow();

		productdata.switchToNextTab();

	}

	@Then("user switch back to parent window")
	public void user_switch_back_to_parent_window() throws InterruptedException {

		// productdata.switch_parentwindow();
		productdata.closeTabAndReturn();

	}

}
