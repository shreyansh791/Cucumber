package utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fcip.constants.FCIPConstants;

import cucumber.api.DataTable;

public class CTRBasePage {
	// HashMap<String, String> capturedData =null;
	static WebDriver driver = null;
	HashMap<String, By> objRepo = new HashMap<String, By>();
	protected static HashMap<String, String> capturedData = new HashMap<String, String>();

	public CTRBasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void addObject(String logicalName, By by) {
		objRepo.put(logicalName, by);
	}

	public WebElement getObject(String logicalName) {
		WebElement webelement = null;
		By by = objRepo.get(logicalName);
		if (by != null) {

			webelement = driver.findElement(by);
		} else {
			System.out.println(logicalName + "logical name is not present in page class, please check");
		}
		return webelement;
	}

	public void setText(LinkedHashMap<Integer, LinkedHashMap<String, String>> mData) throws InterruptedException {

		String logicalName = null;
		String value = null;
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
				if (mapvalue.getKey().contains("Value")) {
					value = mapvalue.getValue();
					if (value.contains("$")) {
						try {
							value = capturedData.get(value);
							System.out.println("value from hashmap - " + value);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				}

			}
			setText(logicalName, value);

		}
	}

	public String getText(String logicalName) {
		String text = getObject(logicalName).getText();
		return text;
	}

	public void setText(String logicalName, String value) throws InterruptedException {

		System.out.println(logicalName + "  " + value);
		WebElement element = getObject(logicalName);
		element.clear();

		element.sendKeys(value);
	}

	public void uploadDocument(LinkedHashMap<Integer, LinkedHashMap<String, String>> mData)
			throws IOException, InterruptedException {

		String logicalName = null;
		String value = null;
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
				} else if (mapvalue.getKey().contains("Value")) {
					value = mapvalue.getValue();
				} else {
					System.out.println("scn - " + mapvalue.getValue());
				}

			}
			uploadDocument(logicalName, value);

		}
	}

	private void uploadDocument(String logicalName, String value) throws IOException, InterruptedException {

		// String path=System.getProperty("user.dir")+File.separator+;
		WebElement element = getObject(logicalName);
		element.click();
		// Thread.sleep(5000);
		Runtime.getRuntime().exec(FCIPConstants.upload 
				+ File.separator + value);

	}

	public void clickLink(LinkedHashMap<Integer, LinkedHashMap<String, String>> mData) throws InterruptedException {

		String logicalName = null;
		String value = null;
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
				if (mapvalue.getKey().contains("Value")) {
					value = mapvalue.getValue();
					System.out.println("value - " + value);
				}

			}
			clickLink(logicalName);

		}
	}

	private void clickLink(String name) {
		try {
			getObject(name).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyText(LinkedHashMap<Integer, LinkedHashMap<String, String>> mData) throws InterruptedException {

		String logicalName = null;
		String value = null;
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
				if (mapvalue.getKey().contains("Value")) {
					value = mapvalue.getValue();
					System.out.println("value - " + value);
				}

			}
			verifyText(logicalName, value);

		}
	}

	private void verifyText(String name, String value) {
		try {
			String expected = getObject(name).getText();
			// Assert.assertTrue("failing...", 2==2);
			Assert.assertTrue(value + "- from feature is not matched with UI-  " + expected, expected.equals(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void captureValue(LinkedHashMap<Integer, LinkedHashMap<String, String>> mData) throws InterruptedException {

		String logicalName = null;
		String value = null;
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
					// System.out.println("logicalName - " + logicalName);
				}
				if (mapvalue.getKey().contains("Value")) {
					value = mapvalue.getValue();
					// System.out.println("value - " + value);
				}

			}
			captureValue(logicalName, value);

		}
	}

	private void captureValue(String logicalName, String value) {
		// value as key and logical name as value
		String val = getObject(logicalName).getText();
		System.out.println("Captured value - " + val);
		capturedData.put(value, val);
	}

	public void verifyTitle(LinkedHashMap<Integer, LinkedHashMap<String, String>> mData) throws InterruptedException {

		String logicalName = null;
		String value = null;
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
				}

				if (mapvalue.getKey().contains("Value")) {
					value = mapvalue.getValue();
					// System.out.println("value - " + value);
				}

			}
			verifyTitle(logicalName, value);

		}
	}

	private void verifyTitle(String logicalName, String value) {
		if (logicalName.equals("PageTitle")) {
			waitforTitleDisplayed(value);
		} else {
			System.out.println("Please correct logicalname in your feature file.\n  it should be PageTitle ");
			Assert.fail();
		}
	}

	public void waitforTitleDisplayed(String value) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleContains(value));

		} catch (TimeoutException e) {
			Assert.assertTrue("Title - " + value + " is not matched with UI " + driver.getTitle(),
					value.equals(driver.getTitle()));
		}

	}

	public void highlightElement(LinkedHashMap<Integer, LinkedHashMap<String, String>> mData)
			throws InterruptedException {
		String logicalName = null;
		String value = null;
		Iterator<Map.Entry<Integer, LinkedHashMap<String, String>>> it = mData.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, LinkedHashMap<String, String>> mapValue = it.next();
			LinkedHashMap<String, String> m = mapValue.getValue();
			Iterator<Map.Entry<String, String>> entry = m.entrySet().iterator();
			while (entry.hasNext()) {
				Map.Entry<String, String> entryData = entry.next();
				if (entryData.getKey().contains("LogicalName")) {
					logicalName = entryData.getValue();
					System.out.println("Logical Name -" + logicalName);
				}
				if (entryData.getKey().contains("Value")) {
					value = entryData.getValue();
					System.out.println("Value -" + value);
				}

			}
			highlightElement(logicalName);

		}
	}

	private void highlightElement(String name) {
		try {
			System.out.println("name -" + name);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement element = getObject(name);
			// Execute javascript

			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');",
					element);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				System.out.println(e.getMessage());
			}

			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

			/*
			 * js.executeScript("arguments[0].style.border='4px groove green'"
			 * ,element ); Thread.sleep(1000);
			 * js.executeScript("arguments[0].style.border=''", element);
			 */
			js = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyTable(String id, LinkedHashMap<Integer, LinkedHashMap<String, String>> mData)
			throws InterruptedException {
		ArrayList<String> list = new ArrayList<String>();
		String logicalName = null;
		String value = null;
		Iterator<Map.Entry<Integer, LinkedHashMap<String, String>>> entries = mData.entrySet().iterator();

		while (entries.hasNext()) {
			Map.Entry<Integer, LinkedHashMap<String, String>> mapVal = entries.next();
			LinkedHashMap<String, String> mapEntries = mapVal.getValue();
			Iterator<Map.Entry<String, String>> m = mapEntries.entrySet().iterator();

			while (m.hasNext()) {
				Map.Entry<String, String> mapvalue = m.next();
				// System.out.println("before if " +mapvalue);
				/*
				 * if (mapvalue.getKey().contains("ID")) { logicalName =
				 * mapvalue.getValue(); System.out.println("logicalName "+
				 * logicalName); }
				 */

				if (mapvalue.getKey().contains("Value")) {
					value = mapvalue.getValue();
					// System.out.println("value - " + value);
				}

			}

			list.add(value);
		}
		System.out.println("final : " + id);

		verifyTable(list, id);

	}

	private void verifyTable(ArrayList<String> listfromFeatureFile, String tableID) {

		ArrayList<String> valuefromUI = new ArrayList<String>();

		// tableID = "customers";

		String TableXpath = getTableXpath(tableID);

		WebElement Webtable = driver.findElement(By.id(tableID));

		List<WebElement> TotalRowCount = Webtable.findElements(By.xpath(TableXpath));

		System.out.println("No. of Rows in the WebTable: " + TotalRowCount.size());

		// Now we will Iterate the Table and print the Values
		int rowIndex = 1;
		for (WebElement rowElement : TotalRowCount) {
			System.out.println("Row - " + rowIndex);
			List<WebElement> TotalColumnCount = rowElement.findElements(By.xpath("td"));
			int columnIndex = 1;
			for (WebElement colElement : TotalColumnCount) {
				System.out.println(" Column - " + columnIndex + " Data from UI - " + colElement.getText());
				valuefromUI.add(colElement.getText());
				columnIndex = columnIndex + 1;
			}
			rowIndex = rowIndex + 1;
		}
		System.out.println("Value from UI - " + valuefromUI);
		System.out.println("Value from Feature File - " + listfromFeatureFile);
		for (int i = 0; i < listfromFeatureFile.size(); i++) {
			if (listfromFeatureFile.get(i).equals(valuefromUI.get(i))) {
				// Assert.assertTrue("Value from UI "+valuefromUI.get(i)+" is
				// not matched with Feature File"+listfromFeatureFile.get(i),
				// false);
				// System.out.println("Value from UI "+valuefromUI.get(i)
				// +"\n"+"Value from Feature File "+listfromFeatureFile.get(i)
				// );
			} else {
				Assert.assertTrue("Value from UI - " + valuefromUI.get(i)
						+ " is not matched with value from Feature File - " + listfromFeatureFile.get(i), false);
			}
		}
	}

	public static String getTableXpath(String id)

	{
		System.out.println("id -" + id);
		String tableXpath = "//*[@id='" + id + "']/tbody/tr[2]";
		return tableXpath;
	}

	public static LinkedHashMap<Integer, LinkedHashMap<String, String>> getTableDataMasterMap(DataTable dt) {
		int counter = 0;
		int i = 0;
		String logicalName = null;
		String value = null;
		List<Map<String, String>> listmap = dt.asMaps(String.class, String.class);
		System.out.println("Size - " + listmap.size());
		LinkedHashMap<Integer, LinkedHashMap<String, String>> masterMap = new LinkedHashMap();
		for (Map<String, String> list : listmap) {
			LinkedHashMap<String, String> map = new LinkedHashMap();
			Iterator<Map.Entry<String, String>> reference = list.entrySet().iterator();

			while (reference.hasNext()) {
				i++;
				Map.Entry<String, String> mapValue = reference.next();
				if (mapValue.getKey().contains("LogicalName")) {
					logicalName = mapValue.getValue();
					// System.out.println("LogicalName - "+logicalName);

				}
				if (mapValue.getKey().contains("Value")) {
					value = mapValue.getValue();
					// System.out.println("Value - "+value);

				}
				if (mapValue.getKey().contains("ScreenName")) {
					String sn = mapValue.getValue();
					// System.out.println("ScreenName - "+sn);

				}
				/*
				 * else { String screenName = mapValue.getValue();
				 * System.out.println("screenName - " + screenName); }
				 */
				// System.out.println("i - "+ i+" "+mapValue.getKey()+ " :
				// "+mapValue.getValue());
				map.put(mapValue.getKey(), mapValue.getValue());

			}
			counter = counter + 1;
			masterMap.put(counter, map);
		}
		// System.out.println("counter size: " + counter);
		return masterMap;

	}

	public void getTableDataMasterMapp(DataTable dt) {
		int counter = 0;
		int i = 0;
		String logicalName = null;
		String value = null;
		// In Case of dt.asMap method
		/*
		 * We convert DataTable asMap where Map holds keys as the first column
		 * of this table and second column is representing the value of this Map
		 * so key value pair looks like : userName=password,
		 * TestUser1=TestPassword1, TestUser2=TestPassword2
		 * asMap method can only be used when there are only 2 columns.
		 */
		Map<String, String> maps = dt.asMap(String.class, String.class);
		Iterator<Map.Entry<String, String>> it = maps.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> mapValue = it.next();
			System.out.println(mapValue.getKey() + " :: " + mapValue.getValue());
		}
		
		// return null;

	}

}
