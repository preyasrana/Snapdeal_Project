package StepDefinition;

import java.text.ParseException;
import java.util.List;

import org.testng.Assert;

import Pages.Checkout_page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class Checkout_Steps {

	Checkout_page checkoutpg = new Checkout_page();

	String Actual_message;
	String Expected_Message;

	@Then("user has add delivery address")
	public void user_has_add_delivery_address() throws InterruptedException {

		if (checkoutpg.change_deliveryaddress()) {
			
			checkoutpg.click_changeaddress();
			checkoutpg.btn_addnew_address();
			checkoutpg.enter_pincode(checkoutpg.configreader.init_prop().getProperty("zip_code"));
			checkoutpg.enter_fullname();
			checkoutpg.enter_address();
			checkoutpg.enter_landmark();

			checkoutpg.enter_mobno(checkoutpg.configreader.init_prop().getProperty("mob_no"));
			checkoutpg.enter_altmobno(checkoutpg.configreader.init_prop().getProperty("mob_no"));
			checkoutpg.rdo_address_type();

			checkoutpg.btn_save_continue();
		}else {
			
			checkoutpg.enter_pincode(checkoutpg.configreader.init_prop().getProperty("zip_code"));
			checkoutpg.enter_fullname();
			checkoutpg.enter_address();
			checkoutpg.enter_landmark();

			checkoutpg.enter_mobno(checkoutpg.configreader.init_prop().getProperty("mob_no"));
			checkoutpg.enter_altmobno(checkoutpg.configreader.init_prop().getProperty("mob_no"));
			checkoutpg.rdo_address_type();

			checkoutpg.btn_save_continue();
			
		}
		
		Thread.sleep(5000);

	}

	@Then("user has review order")
	public void user_has_review_order() throws InterruptedException, ParseException {

		
		
		// Verify Order Total Prices
	   // Assert.assertEquals(checkoutpg.Verify_Review_product_prices(), checkoutpg.review_totalpayprice());

	   // Assert.assertEquals(checkoutpg.Summary_totalItems(), checkoutpg.Summary_product_Items());
	   // checkoutpg.Verify_Review_product_qty();
		
		
		checkoutpg.qtyselect();
		
		checkoutpg.btn_proceedpayment();
	}

	@Then("user has make payment as COD")
	public void user_has_make_payment_as_COD() throws InterruptedException {

		checkoutpg.lnk_cashon_delivery();
		// checkoutpg.btn_paycashon_delivery();

	}

}
