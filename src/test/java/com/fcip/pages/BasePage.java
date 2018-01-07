package com.fcip.pages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fcip.constants.FCIPConstants;
import com.google.common.base.Function;

import org.openqa.selenium.support.ui.Wait;

import cucumber.api.DataTable;
import utility.CucumberPage;
import webdriverbase.FCIPWebDriverBase;

public class BasePage extends CucumberPage {
	static WebDriver driver = null;

	public BasePage() throws IOException {
		super(driver = FCIPWebDriverBase.getCurrentDriver());

		this.driver = driver;
	}

	// mouseHoverToElement
	public void mouseHoverToElement(DataTable dt) {
		LinkedHashMap<Integer, LinkedHashMap<String, String>> mData = getTableDataMasterMap(dt);
		mouseHoverToElement(mData);
	}

	public void mouseHoverToElement(LinkedHashMap<Integer, LinkedHashMap<String, String>> mData) {
		System.out.println("Inside mouseHoverToElement method in Base Page Class! ");
		String logicalName = null;
		Iterator<Map.Entry<Integer, LinkedHashMap<String, String>>> entries = mData.entrySet().iterator();

		while (entries.hasNext()) {
			Map.Entry<Integer, LinkedHashMap<String, String>> mapVal = entries.next();
			LinkedHashMap<String, String> mapEntries = mapVal.getValue();
			Iterator<Map.Entry<String, String>> m = mapEntries.entrySet().iterator();

			while (m.hasNext()) {
				Map.Entry<String, String> mapvalue = m.next();
				// System.out.println("before if " +mapvalue);
				if (mapvalue.getKey().contains("LogicalName")) {
					logicalName = mapvalue.getValue();
					System.out.println("logicalName - " + logicalName);
				} else {
					System.out.println("scn - " + mapvalue.getValue());
				}

			}
			mouseHoverToElement(logicalName);

		}
	}

	private void mouseHoverToElement(String logicalName) {
		System.out.println("inside private method");
		System.out.println(logicalName);
		WebElement element = getObject(logicalName);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		actions.release();

	}

	public void click(DataTable dt) {
		LinkedHashMap<Integer, LinkedHashMap<String, String>> mData = getTableDataMasterMap(dt);
		click(mData);
	}

	public void click(LinkedHashMap<Integer, LinkedHashMap<String, String>> mData) {

		String logicalName = null;
		Iterator<Map.Entry<Integer, LinkedHashMap<String, String>>> entries = mData.entrySet().iterator();

		while (entries.hasNext()) {
			Map.Entry<Integer, LinkedHashMap<String, String>> mapVal = entries.next();
			LinkedHashMap<String, String> mapEntries = mapVal.getValue();
			Iterator<Map.Entry<String, String>> m = mapEntries.entrySet().iterator();

			while (m.hasNext()) {
				Map.Entry<String, String> mapvalue = m.next();
				// System.out.println("before if " +mapvalue);
				if (mapvalue.getKey().contains("LogicalName")) {
					logicalName = mapvalue.getValue();
					System.out.println("logicalName - " + logicalName);
				}

			}
			click(logicalName);

		}
	}

	private void click(String logicalName) {

		WebElement element = getObject(logicalName);
		element.click();

	}

	public void switchToChildWindow(int numberOfWindow) {
		int i = 0;
		Set<String> s = driver.getWindowHandles();
		System.out.println("size : " + s.size());
		if (s.size() == numberOfWindow) {
			Iterator<String> it = s.iterator();
			while (it.hasNext()) {
				i++;
				String window = it.next();
				if (i == numberOfWindow) {
					driver.switchTo().window(window);
					break;
				}
			}
		}

	}

	public void waitForNumberOfWindows(int numberOfWindow) {
		new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver arg0) {
				return driver.getWindowHandles().size() == numberOfWindow;
			}
		});
	}

	public void switchToParentWindow(int numberOfWindow) {
		int i = 0;
		Set<String> s = driver.getWindowHandles();
		if (s.size() == numberOfWindow) {
			Iterator<String> it = s.iterator();
			while (it.hasNext()) {
				i++;
				String window = it.next();
				if (i == numberOfWindow) {
					driver.switchTo().window(window);
				}

			}

		}
	}

	/*
	 * Java Lambda Expression Syntax
	 * 
	 * (argument-list) -> {body} Java lambda expression is consisted of three
	 * components.
	 * 
	 * 1) Argument-list: It can be empty or non-empty as well.
	 * 
	 * 2) Arrow-token: It is used to link arguments-list and body of expression.
	 * 
	 * 3) Body: It contains expressions and statements for lambda expression.
	 */
	public void isPageLoaded() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		new WebDriverWait(driver, 60).until((ExpectedCondition<Boolean>) driver -> {

			String status = js.executeScript("return document.readyState").toString();
			System.out.println("Page Load Status - " + status);
			return js.executeScript("return document.readyState").equals("complete");
		});

	}

	/*
	 * public void isPageLoaded() {
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) driver; new
	 * WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>() {
	 * 
	 * @Override public Boolean apply(WebDriver arg0) {
	 * 
	 * String status = js.executeScript("return document.readyState"
	 * ).toString(); System.out.println("Page Load Status - " + status); return
	 * js.executeScript("return document.readyState").equals("complete"); } });
	 * }
	 */

	/*
	 * public static void isPageLoaded() { Wait<WebDriver> wait = new
	 * FluentWait<WebDriver>(driver).withMessage(
	 * "Page is not loaded in given Timeout") .withTimeout(60,
	 * TimeUnit.SECONDS).pollingEvery(1, TimeUnit.NANOSECONDS)
	 * .ignoring(NoSuchElementException.class); wait.until(new
	 * Function<WebDriver, Boolean>() {
	 * 
	 * @Override public Boolean apply(WebDriver arg0) { JavascriptExecutor js =
	 * (JavascriptExecutor) driver; String s = js.executeScript(
	 * "return document.readyState").toString(); System.out.println(
	 * "Ready State ---> " + s); return js.executeScript(
	 * "return document.readyState").equals("complete"); }
	 * 
	 * });
	 * 
	 * }
	 */

	public void getDate(String formatter) {
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		DateFormat df = new SimpleDateFormat(formatter);
		String date = df.format(d);
		System.out.println(date);
	}

	public void convertDateToCalender() {
		
	}

	public static void resetAndWriteCaptureData() throws IOException {
		
		File newFile = new File(FCIPConstants.FCIP_REPO + File.separator + "capture.properties");
		if(newFile.exists())
		{
			newFile.delete();
		}
		File file = new File(FCIPConstants.FCIP_REPO);
		
		file.mkdirs();
		newFile.createNewFile();
		try {
			Properties properties = new Properties();

			for (Map.Entry<String, String> entry : capturedData.entrySet()) {
				properties.put(entry.getKey(), entry.getValue());
			}

			properties.store(new FileOutputStream(newFile), null);

		} catch (Exception e) {
		}
		
	}

		
}