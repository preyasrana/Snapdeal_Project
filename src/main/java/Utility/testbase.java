package Utility;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import java.io.IOException;
import java.net.URL;
import factory.DriverFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.IOException;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import java.awt.image.BufferedImage;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class testbase extends DriverFactory {

	public String Expected_Message;
	public String Actual_message;
	public Properties prop = new Properties();
	public ConfigReader configreader = new ConfigReader();

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	protected static Character ch = '"';

	public Faker faker = new Faker();

	// waitForWebElementIsClickable
	public void waitForWebElementIsClickable(WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));

	}

	public static String QRcode(String qrurl) throws NotFoundException, IOException {

		URL url = new URL(qrurl);
		// Pass the URL class object to store the file as image
		BufferedImage bufferedimage = ImageIO.read(url);
		// Process the image
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		// To Capture details of QR code
		com.google.zxing.Result result = new MultiFormatReader().decode(binaryBitmap);
		System.out.println(result.getText());

		return result.getText();
	}

	public static String getStringBetween(String input, Character ch) {
		int firstIndex = input.indexOf(ch) + 1;
		int lastIndex = input.lastIndexOf(ch);
		return input.substring(firstIndex, lastIndex);
	}

	public void fluentwait() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5));
	}

	// waitForWebElementIsVisible
	public void waitForWebElementIsVisible(List<WebElement> element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf((WebElement) element));
	}

	public void waitForWebElementIsVisible(WebElement webElement, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(webElement));

	}

	public boolean ElementIsVisible(WebElement webElement, int time) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOf(webElement));
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	public boolean ElementIs_inVisible(WebElement webElement, int time) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.invisibilityOf(webElement));
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	public static WebElement createWebElement(String elementText, int time) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementText)));
			element = driver.findElement(By.xpath(elementText));
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e);
		}
		return element;
	}

	// isdisplay
	public boolean isdisplay(WebElement element) {

		ElementIsVisible(element, 20);
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	// Faker Lib
	public String faker_getzipcode() {
		return faker.address().zipCode();
	}

	public String faker_getname() {
		return faker.name().fullName();
	}

	public String faker_getaddress() {
		return faker.address().fullAddress();
	}

	public String faker_getlandmark() {
		return faker.address().streetName();
	}

	public void resize(WebElement elementToResize, int xOffset, int yOffset) {
		try {
			if (elementToResize.isDisplayed()) {
				Actions action = new Actions(driver);
				action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
			} else {
				System.out.println("Element was not displayed to drag");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println(
					"Element with " + elementToResize + "is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to resize" + elementToResize + " - " + e.getStackTrace());
		}
	}

	/*
	 * public void dragAndDrop(WebElement from, WebElement to) {
	 * 
	 * Actions action = new Actions(driver); Action dragDrop =
	 * action.dragAndDrop(from, to).build(); dragDrop.perform(); }
	 */

	public void ClickHold(WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).build().perform();
		// you need to release the control from the test
		// actions.MoveToElement(element).Release();
	}

	public void dragAndDrop(WebElement from, WebElement to) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", from, to);
	}

	// isElementPresent
	public boolean isElementPresent(WebElement element) throws InterruptedException {
		try {

			waitForWebElementIsVisible(element, 20);
			if (element.isDisplayed())
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
			Thread.sleep(3000);
			System.out.println("Element presend on screen ***********" + element);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Element not present on screen **************" + element);
			return false;
		}
	}

	// isClickable
	public boolean isClickable(WebElement element) {

		ElementIsVisible(element, 30);

		try {
			// JavascriptExecutor executor = (JavascriptExecutor) driver;
			// executor.executeScript("arguments[0].click();", element);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
			Thread.sleep(3000);
			element.click();
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	public static void doubleClick(WebElement webElement) {
		Actions action = new Actions(driver);
		action.doubleClick(webElement).perform();
	}

	public boolean isClickable_javascript(WebElement element) {

		System.out.println(driver);
		ElementIsVisible(element, 30);

		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
				System.out.println("file downloaded are equal");
				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}

	public boolean isClickable(List<WebElement> element) {
		boolean value = false;

		System.out.println(driver);

		try {

			((WebElement) element).click();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return value;
	}

	// switchToFrame
	public void switchToFrame(WebElement nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToparent() {
		try {
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// switchToLatestWindow
	public static String parentWindow;

	public void switchToLatestWindow() throws InterruptedException {

		parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if ((!windowHandle.equals(parentWindow))) {

				driver.switchTo().window(windowHandle);
			}
		}

	}

	public void switchToPartentWindow() {

		// driver.close();
		try {

			driver.switchTo().window(parentWindow);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	String childwindow;

	public void switchTo_multiWindow() throws InterruptedException {

		Set<String> all_Windows = driver.getWindowHandles();
		int count_final = all_Windows.size();
		System.out.println("Now Total Windows : " + count_final);

		String child1_window = driver.getWindowHandle();
		parentWindow = driver.getWindowHandle();
		System.out.println("Child 1 Window ID is : " + child1_window);

		for (String child_2 : all_Windows)
			if (!parentWindow.equals(child_2) || !child1_window.equals(child_2))
				driver.switchTo().window(child_2);

		String child2_window = driver.getWindowHandle();
		System.out.println("Child 2 Window ID is : " + child2_window);
	}

	public void switchToNextTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
	}

	public void closeAndSwitchToNextTab() {
		driver.close();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
	}

	public void switchToPreviousTab() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}

	public void switchTo_multiTab(int i) {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(i));
	}

	public void closeTabAndReturn() {
		driver.close();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
	}

	public void switchToPreviousTabAndClose() {
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		driver.close();
	}

	// refreshPage method
	public void refreshPage() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// browser back method
	public void browserback() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// navigate method
	public void navigateurl(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// First Selected dropdown value/text
	public String firstSelectedOption(WebElement element) {
		String value = null;
		try {
			Select sel = new Select(element);
			value = sel.getFirstSelectedOption().getText();

			// Print the Currently selected value
			System.out.println("firstSelectedOption  ::" + value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}

	// getText
	public String getText(WebElement element) {
		String value = null;
		try {
			waitForWebElementIsVisible(element, 30);
			// scrollToElement(element);
			value = element.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String getAttribute(WebElement element, String elevalue) {
		String value = null;
		try {

			// scrollToElement(element);
			value = element.getAttribute(elevalue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public List<String> getMultipleAttribute(List<WebElement> element, String text, String expectedvalue) {
		System.out.println("List size :: " + element.size());
		List<String> values = new ArrayList<>();

		try {
			List<WebElement> webElements = element;
			for (WebElement webElement : webElements) {
				// values.add(webElement.getText());
				String value = webElement.getAttribute(text);
				String element_gettext = webElement.getText();
				// System.out.println(value);
				// System.out.println(expectedvalue);
				if (value.contains(expectedvalue)) {

					System.out.println("value matched");
					System.out.println(element_gettext);
					values.add(element_gettext);
					isClickable(webElement);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(values);
		return values;
	}

	public List<String> getMultipleAttribute_value(List<WebElement> element, String text) {
		System.out.println("List size :: " + element.size());
		List<String> values = new ArrayList<>();

		try {
			List<WebElement> webElements = element;
			for (WebElement webElement : webElements) {
				// values.add(webElement.getText());
				String value = webElement.getAttribute(text);
				// String element_gettext = webElement.getText();

				values.add(value);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(values);
		return values;
	}

	// moveToElement
	public void moveToElement(WebElement element) {

		waitForWebElementIsVisible(element, 30);
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// validateImage
	public boolean validateImage(WebElement element) {
		WebElement imageElement = element;
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imageElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != 200) {

				System.out.println("Image is invalid");
				return false;
			} else {
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println("Image is Valid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// List value get
	public List<WebElement> list_values(List<WebElement> element) {

		try {
			System.out.println("List of values :: " + element.size());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return element;
	}

	public static void selectByValue(WebElement element, String value) {
		Select selectElement = new Select(element);
		selectElement.selectByValue(value);
	}

	public static void selectByText(WebElement element, String text) {
		Select selectElement = new Select(element);
		selectElement.selectByVisibleText(text);
	}

	// list of values
	public List<String> getMultipleTextwithclick(List<WebElement> element, String text) throws InterruptedException {
		System.out.println("List size :: " + element.size());

		List<String> values = new ArrayList<>();
		try {
			List<WebElement> webElements = element;
			for (WebElement webElement : webElements) {
				values.add(webElement.getText());

				if (text.equals(webElement.getText())) {

					isClickable(webElement);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(values);
		return values;
	}

	// list of values
	public List<String> get_Text(List<WebElement> element) {

		System.out.println("List size :: " + element.size());
		List<String> values = new ArrayList<>();
		try {
			List<WebElement> webElements = element;
			for (WebElement webElement : webElements) {

				values.add(webElement.getText());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(values);
		return values;
	}

	// list of values
	public List<String> lazyloader_get_Text(List<WebElement> element) {

		System.out.println("List size :: " + element.size());
		List<String> values = new ArrayList<>();
		try {
			List<WebElement> webElements = element;
			for (WebElement webElement : webElements) {

				moveToElement(webElement);
				values.add(webElement.getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(values);
		return values;
	}

	public List<String> getMultipleText(List<WebElement> element) {
		System.out.println("List size :: " + element.size());
		List<String> values = new ArrayList<>();
		try {
			List<WebElement> webElements = element;
			for (WebElement webElement : webElements) {

				Actions actions = new Actions(driver);
				actions.keyDown(Keys.LEFT_CONTROL).click(webElement).keyUp(Keys.LEFT_CONTROL).build().perform();

				values.add(webElement.getText());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(values);
		return values;
	}

	public static void selectValue(String locator, String text) {

		// WebElement lang = locator;
		WebElement lang = driver.findElement(By.xpath(locator));
		List<WebElement> list = lang.findElements((By.xpath(locator)));
		for (WebElement opt : list) {
			String value = opt.getText();
			if (value.equalsIgnoreCase(text)) {
				System.out.println("Value clicked =" + value);
				opt.click();
			}
		}
	}

	// List validateImage
	public List<WebElement> Validate_image(List<WebElement> element) {

		try {
			System.out.println("List of images :: " + element.size());

			for (WebElement imgele : element) {

				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(imgele.getAttribute("src"));
				// System.out.println("request is :::" + request);
				HttpResponse response = client.execute(request);

				if (response.getStatusLine().getStatusCode() != 200) {
					System.out.println("Image is invalid   ::" + response.getStatusLine().getStatusCode() + ":URL:"
							+ imgele.getAttribute("src"));
				} else {

					System.out.println("Image is Valid   ::" + response.getStatusLine().getStatusCode() + ":URL:"
							+ imgele.getAttribute("src"));
				}

				/*
				 * String data = imgele.getAttribute("src"); System.out.println("data is  >> " +
				 * data); String extension;
				 * 
				 * switch (data) { case "data:image/svg+xml;base64": extension = "svg";
				 * 
				 * String[] strings = data.split(","); // convert base64 string to binary data
				 * byte[] newdata = DatatypeConverter.parseBase64Binary(strings[1]); String path
				 * = "C:\\Users\\Ene\\Desktop\\test_image." + extension; File file = new
				 * File(path); try (OutputStream outputStream = new BufferedOutputStream(new
				 * FileOutputStream(file))) { outputStream.write(newdata); } catch (IOException
				 * e) { e.printStackTrace(); }
				 * 
				 * if (response.getStatusLine().getStatusCode() != 200) {
				 * System.out.println("Image is invalid   ::" +
				 * response.getStatusLine().getStatusCode() + ":URL:" +
				 * imgele.getAttribute("src")); } else {
				 * 
				 * System.out.println("Image is Valid   ::" +
				 * response.getStatusLine().getStatusCode() + ":URL:" +
				 * imgele.getAttribute("src")); }
				 * 
				 * break;
				 * 
				 * default:
				 * 
				 * if (response.getStatusLine().getStatusCode() != 200) {
				 * System.out.println("Image is invalid   ::" +
				 * response.getStatusLine().getStatusCode() + ":URL:" +
				 * imgele.getAttribute("src")); } else {
				 * 
				 * System.out.println("Image is Valid   ::" +
				 * response.getStatusLine().getStatusCode() + ":URL:" +
				 * imgele.getAttribute("src")); }
				 * 
				 * break;
				 * 
				 * }
				 */

				/*
				 * String base64String =imgele.getAttribute("src"); String[] strings =
				 * base64String.split(","); HttpResponse response = client.execute(request);
				 * String extension;
				 * 
				 * switch (strings[0]) {
				 * 
				 * case "data:image/jpeg;base64": extension = "jpeg"; break;
				 * 
				 * case "data:image/svg+xml;base64": extension = "svg"; break;
				 * 
				 * case "data:image/png;base64": extension = "png"; break; default://should
				 * write cases for more images types extension = "png"; break; }
				 * 
				 * //convert base64 string to binary data byte[] data =
				 * DatatypeConverter.parseBase64Binary(strings[1]); String path =
				 * "C:\\Users\\Ene\\Desktop\\test_image." + extension; File file = new
				 * File(path); try (OutputStream outputStream = new BufferedOutputStream(new
				 * FileOutputStream(file))) { outputStream.write(data); } catch (IOException e)
				 * { e.printStackTrace(); }
				 */

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	// Sendkeys
	public void sendKeys(WebElement element, String value) {
		try {
			waitForWebElementIsVisible(element, 30);
			// scrollToElement(element);
			WebElement webelement = element;
			clearValue(webelement);
			element.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
			implicitWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// implicitWait
	private final int waitTime = 30;

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	// scrollToElement
	/*
	 * public void scrollToElement(WebElement element) { try { WebElement webelement
	 * = element; ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);", webelement); }
	 * catch (Exception e) { e.printStackTrace(); } }
	 */

	public static void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scroll_page(float to, float from) {
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		jse6.executeScript("window.scrollBy(" + to + "," + from + ")", "");
	}

	public void locateElement(List<WebElement> elementLocator) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Initial element count
		int elementCount = elementLocator.size();

		while (true) {
			// javascriptexecutor to scroll the page
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			// Check if the last fetch element count is same as new count,
			// It is's same then we already have fetch all the elements on the page.
			if (elementLocator.size() == elementCount)
				break;

			// fetch the lattest elements count
			elementCount = elementLocator.size();
		}
	}

	// clearValue
	public void clearValue(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = '';", element);
			implicitWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// List validateURL
	public List<WebElement> Validate_URL(List<WebElement> element) {

		try {

			System.out.println("List of Url is" + element.size());

			for (WebElement url : element) {

				// System.out.println(links);

				HttpClient client = HttpClientBuilder.create().build();

				HttpGet request = new HttpGet(url.getAttribute("href"));
				HttpResponse response = client.execute(request);

				if (response.getStatusLine().getStatusCode() != 200) {
					System.out.println("URL is invalid   ::" + response.getStatusLine().getStatusCode() + ":URL:"
							+ url.getAttribute("href"));

				} else {

					System.out.println("URL is Valid   ::" + response.getStatusLine().getStatusCode() + ":URL:"
							+ url.getAttribute("href"));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// getemailString
	protected String getemailString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();

		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void uploadFile(String fileLocation) {
		try {
			// Setting clipboard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			System.out.println("Failed uploading document");
			exp.printStackTrace();
		}
	}

	public static void enter_key() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	private String chars = "abcdefghijklmnopqrstuvwxyz";
	private String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String NUMS = "1234567890";
	private String SPEC = "@#$%^&+=";
	private Random rnd = new Random();

	private String getTwoFrom(String src) {
		int index1 = (int) (rnd.nextFloat() * src.length()), index2 = (int) (rnd.nextFloat() * src.length());
		return "" + src.charAt(index1) + src.charAt(index2);
	}

	// CreatePassword for Random
	public String createPassword() {
		return getTwoFrom(chars) + getTwoFrom(CHARS) + getTwoFrom(NUMS) + getTwoFrom(SPEC);
	}

	public static String getCurrentDay() {
		// Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Date Int: " + todayInt + "\n");

		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Date Str: " + todayStr + "\n");

		return todayStr;
	}

	// Get The Current Day plus days. You can change this method based on your
	// needs.
	public static String getCurrentDayPlus(int days) {
		LocalDate currentDate = LocalDate.now();

		int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
		return Integer.toString(dayOfWeekPlus);
	}

	// Click to given day
	public static void clickGivenDay(List<WebElement> elementList, String day) {
		// DatePicker is a table. Thus we can navigate to each cell
		// and if a cell matches with the current date then we will click it.
		/*
		 * /**Functional JAVA version of this method.
		 */

		/*
		 * elementList.stream() .filter(element -> element.getText().contains(day))
		 * .findFirst() .ifPresent(WebElement::click);
		 */
		/** Non-functional JAVA version of this method. */
		for (WebElement cell : elementList) {
			String cellText = cell.getText();
			if (cellText.contains(day)) {
				cell.click();
				break;
			}
		}
	}

	// Video Player Methods

}
