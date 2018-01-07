import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableDataValidation {

	private static WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	public static void main(String[] args) {
		// Get number of rows In table.
		ArrayList<String> list = new ArrayList<String>();

		driver = new FirefoxDriver();
		baseUrl = "https://www.w3schools.com/html/html_tables.asp";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to(baseUrl);
		String tableID = "customers";
		
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
				list.add(colElement.getText());
				columnIndex = columnIndex + 1;
			}
			rowIndex = rowIndex + 1;
		}
	}

	public static String getTableXpath(String id)

	{
		String tableXpath = "//*[@id='" + id + "']/tbody/tr[2]";
		return tableXpath;
	}
}