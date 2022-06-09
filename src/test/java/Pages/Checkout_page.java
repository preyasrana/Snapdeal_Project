package Pages;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import Utility.testbase;
import static org.testng.Assert.assertEquals;
import java.util.List;

public class Checkout_page extends testbase {

	// Cart Summary
	@FindBy(xpath = "//div[@id='cart-summary']//div[@class='cart-heading']")
	WebElement txt_Summary_cartitems_total;

	@FindBy(xpath = "//div[@id='cart-summary']//div[@class='cs-items-list']//div[@class='cs-item-name']")
	List<WebElement> list_Summary_items_total;

	@FindBy(xpath = "//div[@class='make-payment-row']//span[contains(text(),'Total')]//following-sibling::span")
	WebElement txt_Summary_price_total;

	@FindBy(xpath = "//div[@class='make-payment-row']//span[contains(text(),'Delivery Charges:')]//following-sibling::span")
	WebElement txt_Summary_delivery_charges;

	@FindBy(xpath = "//div[@class='make-payment-row total-pay show-border']//span[contains(text(),'You Pay:')]//following-sibling::span")
	WebElement txt_Summary_youpay;

	// Delivery Address

	@FindBy(xpath = "//div[@id='address-form']//input[@name='zip']")
	WebElement txt_zip;

	@FindBy(xpath = "//div[@id='address-form']//input[@name='fullName']")
	WebElement txt_fullname;

	@FindBy(xpath = "//div[@id='address-form']//textarea[@id='address']")
	WebElement txt_address;

	@FindBy(xpath = "//div[@id='address-form']//input[@id='nearestLandmark']")
	WebElement txt_landmark;

	@FindBy(xpath = "//div[@id='address-form']//input[@id='mobile']")
	WebElement txt_mobno;

	@FindBy(xpath = "//div[@id='address-form']//input[@id='alternateMobile']")
	WebElement txt_altmobno;

	@FindBy(xpath = "//div[@class='row address-type-checkbox']//input[@id='home-mobile']//following-sibling::span[1]")
	WebElement rdo_home_mobile;

	@FindBy(xpath = "//button[@id='delivery-modes-continue']//span[contains(text(),'SAVE AND CONTINUE')]")
	WebElement btn_save_continue;

	// Review Order

	@FindBy(xpath = "//div[@id='reviews-data']//div[@class='review-sub col-xs-5']//span[@class='highlight-price']")
	List<WebElement> list_checkout_productprice;

	@FindBy(xpath = "//div[@id='reviews-data']//div[@class='review-qty col-xs-3 pad-3px-top']//div")
	List<WebElement> list_checkout_productqty;

	List<Double> listprice;

	@FindBy(xpath = "//div[@id='reviews-payment']//div[@id='reviews-payment-details']//span[@class='total-amt pull-right']")
	WebElement get_review_totalpay;

	@FindBy(xpath = "//div[@class='make-payment-button']//button[@id='make-payment'][contains(text(),'PROCEED TO PAYMENT')]")
	WebElement btn_proceed_to_payment;

	@FindBy(xpath = "//div[@id='payment-nav-id']//span[contains(text(),'Cash On Delivery')]")
	WebElement lnk_cash_on_delivery;

	@FindBy(xpath = "//div[@id='make-payment-button']")
	WebElement btn_Pay_cash_on_delivery;

	@FindBy(xpath = "//div[@id='checkout-reviews']//div[@class='reviews-wrapper']")
	WebElement lbl_checkout_revieworder;

	@FindBy(xpath = "//div[@id='address-details']//span[contains(text(),'Change')]")
	WebElement lnk_Change_Deliveryaddress;

	@FindBy(xpath = "//div[@class='add-address no-display']//button[contains(text(),'ADD NEW ADDRESS')]")
	WebElement btn_add_new_address;

	// Review Module
	@FindBy(xpath = "//div[@class='review-cart-items clearfix']//div[@class='styledSelect sd-icon-expand-arrow customized']")
	List<WebElement> get_review_product_qty;
	
	


	

	public Checkout_page() {

		PageFactory.initElements(driver, this);

	}

	public boolean change_deliveryaddress() {

		return ElementIsVisible(lnk_Change_Deliveryaddress, 05);

	}

	public boolean click_changeaddress() {

		return isClickable(lnk_Change_Deliveryaddress);
	}

	public boolean btn_addnew_address() {

		return isClickable(btn_add_new_address);
	}

	public String cartitems_total() {
		return getText(txt_Summary_cartitems_total);
	}

	public String price_total() {
		return getText(txt_Summary_price_total);
	}

	public String delivery_charges() {
		return getText(txt_Summary_delivery_charges);
	}

	public String youpay() {
		return getText(txt_Summary_youpay);
	}

	public void enter_pincode(String zipcode) {
		sendKeys(txt_zip, zipcode);
	}

	public void enter_fullname() {
		sendKeys(txt_fullname, faker_getname());
	}

	public void enter_address() {
		sendKeys(txt_address, faker_getaddress());
	}

	public void enter_landmark() {
		sendKeys(txt_landmark, faker_getlandmark());
	}

	public void enter_mobno(String mobno) {
		sendKeys(txt_mobno, mobno);
	}

	public void enter_altmobno(String altmobno) {
		sendKeys(txt_altmobno, altmobno);
	}

	public void rdo_address_type() {
		isClickable_javascript(rdo_home_mobile);
	}

	public void btn_save_continue() {
		isClickable(btn_save_continue);
	}

	public double Verify_Review_product_prices() throws InterruptedException {

		waitForWebElementIsVisible(lbl_checkout_revieworder, 30);

		int Product_pricesize = list_checkout_productprice.size();
		System.out.println("list_checkout_productprice -->" + Product_pricesize);
		double total_pricesum = 0;

		for (WebElement productprice : list_checkout_productprice) {

			// System.out.println(productprice.getText().replaceAll("[Rs. ,]", ""));

			double getprice = Double.parseDouble(productprice.getText().replaceAll("[Rs. ,]", ""));
			total_pricesum = total_pricesum + getprice;

		}
		// System.out.println(total_pricesum);
		return total_pricesum;

	}

	public void qtyselect() throws InterruptedException {

		int review_Product_items = get_review_product_qty.size();
		System.out.println("list_review Product items -->" + review_Product_items);

		
		for (int i = 0; i < review_Product_items; i++) {

			String id = get_review_product_qty.get(i).getAttribute("id");
			System.out.print("is value is --->" + id);
			WebElement ele = get_review_product_qty.get(i);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", ele);
			Thread.sleep(3000);
			ele.click();
			
			WebElement ele1 = createWebElement("//ul[@class='options'][@data-cs='"+id+"']/li[1]", 20);
			
			ele1.click();

			Thread.sleep(3000);

		}

	}

	public int Verify_Review_product_qty() throws InterruptedException {

		int totalProduct_qty = list_checkout_productqty.size();
		System.out.println("list_checkout_productqty -->" + totalProduct_qty);
		int total_productqty = 0;

		for (WebElement productqty : list_checkout_productqty) {

			System.out.println(productqty.getText());
			int getqty = Integer.parseInt(productqty.getText());
			total_productqty = total_productqty + getqty;

		}
		System.out.println(total_productqty);
		return total_productqty;
	}

	public int Summary_product_Items() throws InterruptedException {

		int summaryProduct_items = list_Summary_items_total.size();
		return summaryProduct_items;

	}

	public int Summary_totalItems() {

		String summary_items = txt_Summary_cartitems_total.getText().replaceAll("([a-z,A-Z, ,()])", "");
		int summary_totalitems = Integer.parseInt(summary_items);
		System.out.println(summary_totalitems);

		return summary_totalitems;
	}

	public double review_totalpayprice() {

		waitForWebElementIsVisible(lbl_checkout_revieworder, 30);
		String review_strtotalpay = get_review_totalpay.getText().replaceAll("[Rs. ,]", "");
		double review_dbtotalprice = Double.parseDouble(review_strtotalpay);
		System.out.println(review_dbtotalprice);

		return review_dbtotalprice;

	}

	public void btn_proceedpayment() {
		isClickable(btn_proceed_to_payment);
	}

	public void lnk_cashon_delivery() {
		isClickable(lnk_cash_on_delivery);
	}

	public void btn_paycashon_delivery() {
		isClickable(btn_Pay_cash_on_delivery);
	}

}
