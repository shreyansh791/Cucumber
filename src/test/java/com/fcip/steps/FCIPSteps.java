package com.fcip.steps;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.exec.util.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.fcip.pages.BasePage;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.difflib.StringUtills;
import webdriverbase.FCIPWebDriverBase;
import webdriverbase.PageFactoryClass;

public class FCIPSteps {
	PageFactoryClass pf = new PageFactoryClass();
	BasePage page = null;
	boolean isHookExecutable = true;
	int numberOfWindow = 1;
	WebDriver driver = null;

	@Before
	public void abc(Scenario s) throws IOException {
		if (isHookExecutable) {

			driver = FCIPWebDriverBase.getCurrentDriver();
			FCIPWebDriverBase.getCurrentURL();
		}

	}

	@After
	public void abc1(Scenario s) throws WebDriverException, IOException, InterruptedException {
		if (s.isFailed()) {
			System.out.println(s.getName() + "scenario failed");

			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			s.embed(screenshot, "image/png"); // stick it in the report
			s.write("url: " + driver.getCurrentUrl());
			s.write("name :" + s.getName());
			// take the screenshot of the entire home page and save it to a png
			// file
			// Screenshot screenshot = new AShot().shootingStrategy(new
			// ViewportPastingStrategy(1000)).takeScreenshot(driver);
			// ImageIO.write(screenshot.getImage(), "PNG", new
			// File("D:\\home.png"));

		} else {
			try {
				/*
				 * This program demonstrates how to capture a screenshot (full
				 * screen) as an image which will be saved into a file.
				 */
				Robot robot = new Robot();
				String format = "jpg";
				String fileName = "FullScreenshot." + format;

				Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
				// ImageIO.write(screenFullImage, format, new File(fileName));

				System.out.println("A full screenshot saved!");

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(screenFullImage, "png", baos);
				baos.flush();
				byte[] imageInByte = baos.toByteArray();
				baos.close();
				s.embed(imageInByte, "image/png"); // stick it in the report
				s.write("url: " + driver.getCurrentUrl());
				s.write("name :" + s.getName());

			} catch (AWTException | IOException ex) {
				System.err.println(ex);
			}
		}
		// page.resetAndWriteCaptureData();
		FCIPWebDriverBase.closeBrowser();
		BasePage.resetAndWriteCaptureData();

	}

	@When("^I am on Login Page$")
	public void i_am_on_Login_Page() throws Throwable {

	}

	@Given("^(.*) is on \"([^\"]*)\"$")
	public void a_is_on(String arg1, String arg2) throws Throwable {
		page = pf.initializePage(arg2);
	}

	@Given("^user mousehover to element$")
	public void user_mousehover_to_element(DataTable dt) throws Throwable {
		page.mouseHoverToElement(dt);
	}

	@Given("^user selects item$")
	public void user_select_item(DataTable dt) throws Throwable {

		page.click(dt);
	}

	@Given("^user enters data in textbox$")
	public void user_enters_data_in_textbox(DataTable dt) throws Throwable {

		page.setText(dt);

	}

	@Given("^user switch to childwindow$")
	public void user_switch_to_childwindow() throws Throwable {
		numberOfWindow = numberOfWindow + 1;
		System.out.println("numberOfWindow - " + numberOfWindow);
		page.waitForNumberOfWindows(numberOfWindow);
		page.switchToChildWindow(numberOfWindow);
	}

	@Given("^user switch to parentwindow$")
	public void user_switch_to_parentwindow() throws Throwable {
		numberOfWindow = numberOfWindow - 1;
		System.out.println("numberOfWindow - " + numberOfWindow);
		page.switchToParentWindow(numberOfWindow);
	}

	@Given("^user loads page$")
	public void user_loads_page(String s) throws Throwable {
		System.out.println("Doc String from feature file is - " + s);
		/*
		 * ExpectedCondition<Boolean> pageLoad = new
		 * ExpectedCondition<Boolean>() { public Boolean apply(WebDriver driver)
		 * { return ((JavascriptExecutor) driver).executeScript(
		 * "return document.readyState").equals("complete"); } }; WebDriverWait
		 * wait = new WebDriverWait(driver, 30); wait.until(pageLoad);
		 */
		page.isPageLoaded();
	}

	@Given("^user upload the document$")
	public void user_upload_the_document(DataTable dt) throws Throwable {
		page.uploadDocument(dt);

	}

	@When("^user captures the value$")
	public void user_captures_the_value(DataTable dt) throws Throwable {

		page.captureValue(dt);

	}

	@Given("^clicks on link text$")
	public void clicks_on_link_text(DataTable dt) throws Throwable {
		page.clickLink(dt);
	}

	@Given("^user verify the text$")
	public void user_verify_the_text(DataTable dt) throws Throwable {
		page.verifyText(dt);
	}

	@Given("^user clicks on back button$")
	public void userClicksBackButton() throws Throwable {
		driver.navigate().back();
	}

	@Then("^user verifies the title$")
	public void user_verifies_the_title(DataTable dt) throws Throwable {
		page.verifyTitle(dt);
	}

	@Then("^user highlights the element$")
	public void highlightElement(DataTable dt) throws Throwable {
		page.highlightElement(dt);
	}

	@Then("^user verifies details in the table with \"([^\"]*)\"$")
	public void user_verifies_details_in_the_table_with(String id, DataTable dt) throws Throwable {
		page.verifyTable(id, dt);
	}

	@When("^user handles the data dynamically$")
	public void user_handles_the_data_dynamically(DataTable dt) throws Throwable {
		page.handleDataDynamically(dt);
	}

	@When("^user checks the rerun$")
	public void user_checks_re_run() throws Throwable {
		Assert.assertTrue(true);
	}

	@When("^user checks the rerunn$")
	public void user_checks_re_runn() throws Throwable {
		Assert.assertTrue(false);
	}

}