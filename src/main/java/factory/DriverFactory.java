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
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("chrome_headless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");			
		    driver = new ChromeDriver(chromeOptions);
		}
		else if (browserName.equals("firefox_headless")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless");			
			driver = new FirefoxDriver(firefoxOptions);
		}
		
		driver.manage().timeouts().pageLoadTimeout(testbase.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testbase.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	


}
