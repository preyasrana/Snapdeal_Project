package StepDefinition;

import java.util.List;

import Pages.Cart_page;
import io.cucumber.java.en.Then;

public class Cart_Steps {

	Cart_page cartpage = new Cart_page();
	List<String> Cart_listproduct;
	String Actual_message;
	String Expected_Message;

	@Then("user click on proceed to checkout")
	public void user_click_on_proceed_to_checkout() throws InterruptedException {

		cartpage.btn_proceedcheckout();
		
	}

	@Then("user click on View cart")
	public void user_click_on_View_cart() throws InterruptedException {

		cartpage.btn_viewcart();
		Cart_listproduct = cartpage.get_cartproduct_list();
		System.out.println(Cart_listproduct);
		cartpage.btn_popup_close();

	}

}
