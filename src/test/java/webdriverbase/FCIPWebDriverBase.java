package webdriverbase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.fcip.constants.FCIPConstants;

import dataProvider.TestConfiguration;

// SingleTon Design Pattern  only 1 instance of Webdriver across the framework

public class FCIPWebDriverBase {

	static WebDriver driver = null;

	private FCIPWebDriverBase() {

	}

	private static WebDriver createInstance() throws IOException {
		Logger logger = Logger.getLogger(FCIPWebDriverBase.class);

		PropertyConfigurator.configure(FCIPConstants.log4jPath);

		String browserName = new TestConfiguration().getBrowserName();
		if (driver == null) {
			if (browserName.equalsIgnoreCase("chrome")) {
				// logger.info("browser FCIPWebDriverBase : " + browserName);
				// System.out.println("browser FCIPWebDriverBase :
				// "+browserName);
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + File.separator + "browser_exe/chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("ff")) {
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("ie")) {
				System.out.println("b - " + browserName);
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + File.separator + "browser_exe/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				// driver = new FirefoxDriver();

				System.out.println("Done.");
			}
		}
		return driver;

	}
	/*
	 * public static void main(String[] args) throws IOException {
	 * createInstance(); }
	 */

	public static WebDriver getCurrentDriver() throws IOException {
		WebDriver driver = createInstance();
		return driver;
	}

	public static void getCurrentURL() {
		System.out.println("Inside getCurrentURL ");
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String url = TestConfiguration.getCurrentURL();
		if (!url.equals("") && url != null) {
			driver.navigate().to(url);
		} else {
			System.out.println("Could not get current url!");
		}

	}

	public static void closeBrowser() {

		System.out.println("Closing All browsers!");
		driver.quit();
		driver = null;
	}

	public static void takeScreenshot() {

	}
	/*
	 * public static void main(String[] args) throws IOException { // WebDriver
	 * driver= FCIPWebDriverBase.getCurrentDriver();
	 * FCIPWebDriverBase.getCurrentDriver();
	 * //System.out.println("driver"+driver); }
	 */

}