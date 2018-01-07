import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JSVerification {
	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public static void main(String[] args) throws AWTException {
		driver = new FirefoxDriver();
		// baseUrl = "https://www.google.com";
		// baseUrl = "http://Qeworks.com";
		baseUrl = "https://github.com/login";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("login_field")).sendKeys("ddas");
		driver.findElement(By.id("password")).sendKeys("ddas");
		driver.findElement(By.cssSelector("input[value='Sign in']")).click();
		// driver.findElement(By.id("errorTryAgain")).click();
		// System.out.println(driver.findElement(By.id("gb_70")).getText());
		// Robot robot=new Robot();
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println(driver.findElement(By.id("js-flash-container")).getText());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("using js");

		// String s=js.executeScript("return
		// document.getElementById('js-flash-container').textContent").toString();
		String s = (String) js.executeScript("return arguments[0].textContent",
				driver.findElement(By.id("js-flash-container")));
		System.out.println(s.trim());
		System.out.println("done");

	}
}
