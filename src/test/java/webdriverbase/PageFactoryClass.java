package webdriverbase;

import java.io.File;
import com.fcip.constants.FCIPConstants;
import com.fcip.pages.BasePage;

public class PageFactoryClass {
	static BasePage page = null;
	String pageName = null;

	public BasePage initializePage(String pageName) throws Exception {
		this.pageName = pageName;
		pageName = getAllSpacesRemoved(pageName);
		File file = new File(FCIPConstants.PAGES_REPO);
		System.out.println(FCIPConstants.PAGES_REPO);

		if (file.isDirectory()) {
			String list[] = file.list();

			/*
			 * for (String string : list) { System.out.println(string);
			 * 
			 * }
			 */
			for (int i = 0; i < list.length; i++) {
				System.out.println(list[i]);
				String fileName = list[i];
				fileName = fileName.substring(0, fileName.lastIndexOf("."));
				System.out.println(fileName);
				if (fileName.equalsIgnoreCase(pageName)) {
					System.out.println("Page Name - " + pageName + " is instanciated ");
					Class c = Class.forName("com.fcip.pages." + pageName);

					// Explicit type Casting is used below because newInstanceMethod returns Object type
					page = (BasePage) c.newInstance();
					System.out.println("page - " + page);
				}
			}

		}
		
		
		return page;
	}

	public String getAllSpacesRemoved(String pagename) {
		String page = pagename.replaceAll("\\s", "");
		return page;
	}
}
