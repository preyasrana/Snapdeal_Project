package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.testbase;

public class Productlist_page extends testbase {

	@FindBy(xpath = "//div[@id='products']//div[@class='product-tuple-image ']//a")
	List<WebElement> list_product;

	@FindBy(xpath = "//div[@id='products']//div[@class='product-tuple-description ']//a/p")
	List<WebElement> list_product_name;

	@FindBy(xpath = "//div[@id='see-more-products']")
	WebElement see_more_product;

	@FindBy(xpath = "//div[@class='sd-loader-see-more']")
	WebElement see_more_product_loader;

	// Sorting Product option

	@FindBy(xpath = "//div[@class='sorting-sec animBounce']")
	WebElement drp_sort_by_product;

	@FindBy(xpath = "//div[@class='sorting-sec animBounce']//i")
	WebElement drp_sort_by_product_arrow;

	@FindBy(xpath = "//div[@class='sorting-sec animBounce']//ul//li")
	List<WebElement> list_Sortoption;

	@FindBy(xpath = "//div[@class='sorting-sec animBounce']//div[@class='sort-selected']")
	WebElement get_sort_by_productname;

	@FindBy(xpath = "//div[@id='products']//section")
	WebElement product_section;

	List<String> listproduct;

	public Productlist_page() {

		PageFactory.initElements(driver, this);

	}

	public void getlist_allProduct() throws InterruptedException {

		
	
		int listCount = 0;

		int maxcount = 1000;
		int firstPageSize = list_product.size();

		while (maxcount > listCount) {

			int Productitems = list_product.size();

			if (Productitems > maxcount) {
				maxcount = Productitems + firstPageSize; // 20 is scroll size + 1s
			}

			System.out.println("ListCount ==>" + listCount);
			System.out.println("Productsize ==>" + Productitems);
			System.out.println("MaxCount ==>" + maxcount);

			if (list_product.size() != 0) {

				String size = list_product.get(listCount).toString();
				// String productname = list_product_name.get(listCount).getText().toString();
				// System.out.println(productname);
				if (listCount == list_product.size() - 2) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();",
							list_product.get(listCount));
					Thread.sleep(7000);

					ElementIs_inVisible(list_product.get(listCount), 10);

					System.out.println("==> Updated list_product size: " + list_product.size());
				}

				if (listCount == Productitems - 1) {

					Thread.sleep(2000);
					if (isdisplay(see_more_product)) {
						isClickable(see_more_product);
						Thread.sleep(4000);
						ElementIs_inVisible(list_product.get(listCount), 10);
					} else {
						break;
					}
				}

				listCount++;
			}

		}
	
	}

	public void Sorting_Productlist() throws InterruptedException {

		getMultipleTextwithclick(list_Sortoption, "Price Low To High");

	}

	public String gettext_Sortby() {
		return getText(get_sort_by_productname);
	}

	public void click_on_sorting_by() {
		isClickable_javascript(drp_sort_by_product_arrow);
	}

	public void product_list() throws InterruptedException {

		int Productsize = list_product.size();
		System.out.println("Productsize -->" + Productsize);

		// fluentwait();
		Thread.sleep(5000);
		if (list_product.size() != 0) {
			for (int i = 0; i < Productsize; i++) {

				isClickable(list_product.get(i));
				break;
			}
		} else {
			System.out.println("List Of Product not appear");
		}

	}

	public List<String> getall_product_list() throws InterruptedException {

		// locateElement(list_product_name);

		/*
		 * int Productsize = list_product_name.size();
		 * 
		 * System.out.println("List size :: " + Productsize); List<String> values = new
		 * ArrayList<>();
		 * 
		 * 
		 * if (list_product_name.size() != 0) { for (int i = 0; i < Productsize; i++) {
		 * 
		 * 
		 * values.add(list_product_name.get(i).getText()); } } else {
		 * System.out.println("List Of Product not appear"); }
		 */

		listproduct = lazyloader_get_Text(list_product_name);

		System.out.println(listproduct);
		return listproduct;

	}

	public void switch_newwindow() throws InterruptedException {

		switchToLatestWindow();
	}

	public void switch_parentwindow() throws InterruptedException {

		switchToPartentWindow();
	}

}
