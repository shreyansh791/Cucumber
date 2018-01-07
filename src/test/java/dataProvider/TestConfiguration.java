package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfiguration {
	static Properties p = null;

	public TestConfiguration() throws IOException {
		p = new Properties();
		File file = new File(System.getProperty("user.dir") + File.separator + "configuration.properties");
		FileInputStream in = new FileInputStream(file);
		// To Print properties FileName
		System.out.println(file.getName());
		p.load(in);
	}

	public static String getBrowserName() {
		String browser = p.getProperty("browser");
		System.out.println("browser TestConfiguration " + browser);
		return browser;
	}

	public static String getCurrentURL() {
		String url = p.getProperty("url");
		return url;
	}
	/*
	 * public static void main(String[] args) throws IOException { new
	 * TestConfiguration().getBrowserName(); }
	 */

	// Below is just to check the functionality of this class
	public static void main(String[] args) throws IOException {
		new TestConfiguration();
	}
}
