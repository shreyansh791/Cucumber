import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

public class getsteps {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\Selenium\\workspace\\Cucumber\\src\\test\\java\\com\\fcip\\steps\\FCIPSteps.java");
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String s = br.readLine();
		List<String> list = new ArrayList<String>();
		while (s != null)

		{

			if (s.contains("@Then") || s.contains("@Given") || s.contains("@When") || s.contains("@And")) {
				int a = s.indexOf("^");
				int b = s.indexOf("$");
				System.out.println(s.substring(a + 1, b));
				list.add(s.substring(a + 1, b));
			}

			s = br.readLine();

		}
		writeExcel(list);

	}

	private static void writeExcel(List<String> list) {
		XSSFSheet sheet = null;
		XSSFWorkbook workbook = null;

		int rowNumber = 0;

		File file = new File("E:\\TestData.xlsx");
		try {

			workbook = SingleObject.getSingleInstanceOfWorkBook();
			sheet = workbook.createSheet("TestData");

			for (int k = 0; k < list.size(); k++) {
				Row row = sheet.createRow(k);
				row.createCell(0).setCellValue(list.get(k));

			}

			FileOutputStream outputstream = new FileOutputStream(file);
			workbook.write(outputstream);
			outputstream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		System.out.println("Successfully Written Data!");
	}

}

class SingleObject {
	private static XSSFWorkbook instance = new XSSFWorkbook();

	private SingleObject() {
	}

	public static XSSFWorkbook getSingleInstanceOfWorkBook() {
		return instance;
	}

}