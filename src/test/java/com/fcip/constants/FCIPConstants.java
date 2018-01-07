package com.fcip.constants;

import java.io.File;

public interface FCIPConstants {
	public static String browserexe = System.getProperty("user.dir") + File.separator+"browser_exe";
	
	public static String upload = System.getProperty("user.dir") + File.separator+"uploadDocuments";
	
	public static String log4jPath = System.getProperty("user.dir") + File.separator+"properties"+File.separator+"log4j.properties";
	
	public static String FCIP_REPO = System.getProperty("user.dir") + File.separator+"FCIP_Repo";
	
	public static String PAGES_REPO = System.getProperty("user.dir") + File.separator+"src\\test\\java\\com\\fcip\\pages";
			
			/*public static void main(String[] args) {
				
				System.out.println(System.getProperty("user.dir"));
				
			}*/
}
