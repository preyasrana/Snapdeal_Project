package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.testbase;

public class Cart_page extends testbase {

	List<String> Cart_listproduct;

	@FindBy(xpath = "//a[@class='btn marR5'][contains(text(),'Proceed To Checkout')]")
	WebElement btn_proceed_checkout;

	@FindBy(xpath = "//div[@class='cart-container']")
	WebElement cart_popup;

	@FindBy(xpath = "//div[@class='btn btn-theme-secondary open-cart'][contains(text(),'View Cart')]")
	WebElement btn_view_cart;

	@FindBy(xpath = "//div[@class='cart-heading clearfix']//span[@class='icon-font-grey-size24 close-popup-icon']")
	WebElement cart_popup_close;

	@FindBy(xpath = "//div[@class='cart-items-list clearfix']//li")
	List<WebElement> list_shopping_cartproduct;

	@FindBy(xpath = "//div[@class='cart-items-list clearfix']//li//a[@class='item-name']")
	List<WebElement> list_shopping_crt_productname;

	@FindBy(xpath = "//div[@class='cart-items-list clearfix']//li//span[@class='item-price']")
	List<WebElement> list_shopping_crt_productprice;

	@FindBy(xpath = "//div[@class='cart-items-list clearfix']//li//div[@class='col-xs-4 cart-item-quantity ']//option[@selected='selected']")
	List<WebElement> list_shopping_crt_productqty;

	@FindBy(xpath = "//div[@class='cart-items-list clearfix']//li//div[@class='col-xs-4 cart-item-details']//span")
	List<WebElement> list_shopping_crt_productsubtotal;

	public Cart_page() {

		PageFactory.initElements(driver, this);

	}

	public void btn_proceedcheckout() {
		isClickable(btn_proceed_checkout);
	}

	public void btn_viewcart() {
		isClickable(btn_view_cart);
	}

	public void btn_popup_close() {
		isClickable(cart_popup_close);
	}

	public List<String> get_cartproduct_list() throws InterruptedException {

		return get_Text(list_shopping_crt_productname);
	}

	public void cart_popup() {
		isdisplay(cart_popup);
	}

}
