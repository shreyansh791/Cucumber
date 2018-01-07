import java.io.File;

public final class FileHandling {
	public static void main(String[] args) {
		System.out.println(1);
		File file = new File(System.getProperty("user.dir") + File.separator + "src\\test\\java\\com\\fcip\\pages");
		System.out.println(System.getProperty("user.dir") + File.separator + "src\\test\\java\\com\\fcip\\pages");
		if (file.isDirectory()) {
			System.out.println(file.isFile() + "   " + file.isDirectory());
			String list[] = file.list();

			/*
			 * for (String string : list) { System.out.println(string);
			 * 
			 * }
			 */
			for (int i = 0; i < list.length; i++) {
				String fileName = list[i];
				fileName = fileName.substring(0, fileName.lastIndexOf("."));
				System.out.println(fileName);

			}
		}
	}
}
