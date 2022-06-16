package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import Utility.testbase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public WebDriver init_driver(String browserName) {

		if (browserName.equals("chrome")) {
			// WebDriverManager.chromedriver().setup();

			System.out.print("browser started !!");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/Download/chromedriver");
			// System.setProperty("webdriver.chrome.verboseLogging", "true");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("chrome_headless")) {
			WebDriverManager.chromedriver().setup();
			final ChromeOptions chromeOptions = new ChromeOptions();
			// chromeOptions.setBinary("/usr/bin/google-chrome-stable");

			// chromeOptions.setHeadless(true);

			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--single-process", "--no-sandbox", "--disable-dev-shm-usage");

			// System.setProperty("webdriver.chrome.verboseLogging", "true");//
			// chromeOptions.add_experimental_option("prefs",
			// {"profile.managed_default_content_settings.images": 2})

			// chromeOptions.addArguments("--no-sandbox");
			// chromeOptions.addArguments("--disable-setuid-sandbox");

			// chromeOptions.addArguments("--remote-debugging-port=9222");

			chromeOptions.addArguments("--disable-dev-shm-using");
			// chromeOptions.addArguments("--disable-extensions");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("start-maximized");
			// chromeOptions.addArguments("disable-infobars");
			// chromeOptions.addArguments("user-data-dir=.\cookies\\test");

			driver = new ChromeDriver(chromeOptions);

		} else if (browserName.equals("firefox_headless")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless");
			driver = new FirefoxDriver(firefoxOptions);
		}

		driver.manage().timeouts().pageLoadTimeout(testbase.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testbase.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		return driver;
	}

}
