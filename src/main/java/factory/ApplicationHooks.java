package factory;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import Utility.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.asserts.IAssert; 

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private static WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	

	@Before()
	public void launchBrowser() {

		configReader = new ConfigReader();
		prop = configReader.init_prop();

		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);

	}

	@After()
	public void quitBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

	}

	@AfterStep
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {

			// take screenshot:
			try {
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcePath, "image/png", screenshotName);
			}

			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	



}
