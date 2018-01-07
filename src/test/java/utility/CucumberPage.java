package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;

public class CucumberPage extends CTRBasePage {
	public CucumberPage(WebDriver driver) {
		super(driver);
	}

	public void uploadDocument(DataTable dt) throws IOException, InterruptedException {
		LinkedHashMap<Integer, LinkedHashMap<String, String>> mData = getTableDataMasterMap(dt);
		uploadDocument(mData);
	}

	public void setText(DataTable dt) throws InterruptedException {
		LinkedHashMap<Integer, LinkedHashMap<String, String>> mData = getTableDataMasterMap(dt);
		setText(mData);
	}

	public void captureValue(DataTable dt) throws InterruptedException {

		LinkedHashMap<Integer, LinkedHashMap<String, String>> mData = getTableDataMasterMap(dt);
		captureValue(mData);
	}

	public void clickLink(DataTable dt) throws InterruptedException {

		LinkedHashMap<Integer, LinkedHashMap<String, String>> mData = getTableDataMasterMap(dt);
		clickLink(mData);
	}

	public void verifyText(DataTable dt) throws InterruptedException {

		LinkedHashMap<Integer, LinkedHashMap<String, String>> mData = getTableDataMasterMap(dt);
		verifyText(mData);
	}

	public void verifyTitle(DataTable dt) throws InterruptedException {

		LinkedHashMap<Integer, LinkedHashMap<String, String>> mData = getTableDataMasterMap(dt);
		verifyTitle(mData);
	}

	public void highlightElement(DataTable dt) throws InterruptedException {

		getTableDataMasterMapp(dt);
	//	highlightElement(mData);
	}

	public void verifyTable(String id, DataTable dt) throws InterruptedException {
		LinkedHashMap<Integer, LinkedHashMap<String, String>> mData = getTableDataMasterMap(dt);
		verifyTable(id, mData);
	}

	public void handleDataDynamically(DataTable dt) throws InterruptedException {

		LinkedHashMap<Integer, LinkedHashMap<String, String>> mData = getTableDataMasterMap(dt);
		handleDataDynamically(mData);

	}

	public void handleDataDynamically(LinkedHashMap<Integer, LinkedHashMap<String, String>> mData)
			throws InterruptedException {

		String logicalName = null;
		String value = null;
		Iterator<Map.Entry<Integer, LinkedHashMap<String, String>>> entries = mData.entrySet().iterator();
		String rows = null, tableIdentifier = null;
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

				if (mapvalue.getKey().contains("TableIdentifier")) {
					tableIdentifier = mapvalue.getValue();
					System.out.println("TI - " + tableIdentifier);
				}
				if (mapvalue.getKey().contains("Rows")) {
					rows = mapvalue.getValue();
					System.out.println("Rows- " + rows);
				}

			}

		}

		handleDataDynamically(tableIdentifier, rows);

	}

	private void handleDataDynamically(String tableIdentifier, String rows) {
		String row[] = rows.split(",");
		System.out.println(row.length);

		// System.out.println(tableIdentifier+" "+rows);
		String tableXpath = getTableXpath(tableIdentifier);
		System.out.println("tableXpath -" + tableXpath);

		List<WebElement> totalData = driver.findElements(By.xpath(tableXpath));
		// Operation to be performed on the required rows

		for (int i = 0; i < row.length; i++) {
			if (totalData.size() >= Integer.parseInt(row[i])) {
				System.out.println("Performing operation on row number - " + Integer.parseInt(row[i]));
				totalData.get(Integer.parseInt(row[i])).click();

			} else {
				System.out.println(
						"Row number - " + Integer.parseInt(row[i]) + "entered from feature file is not correct");
			}

		}

	}

	public static String getTableXpath(String tableIdentifier)

	{
		String tableXpath = null;
		System.out.println("id -" + tableIdentifier);
		switch (tableIdentifier) {
		case "a":
			tableXpath = "Give ur xpath here";
			return tableXpath;
		case "b":
			tableXpath = "Give ur xpath";
			return tableXpath;
		default:
			break;
		}
		return tableXpath;

	}

}
