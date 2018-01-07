package com.fcip.pages;

import java.io.IOException;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
	public HomePage() throws IOException {
		System.out.println("inside home page");
	//	addObject("gmail", By.linkText("Gmail"));
		addObject("googleTextBox", By.id("lst-ib"));
		addObject("Email", By.id("email"));
		addObject("flip", By.name("q"));
		addObject("child", By.name("My Window Name"));
		addObject("yo", By.xpath("//input[@value='Close this window']"));
		addObject("upload", By.name("upload"));
		// addObject("visitHere", By.cssSelector("a:contains('here')]"));
		addObject("visitHere", By.xpath("//a[text()='here']"));
		addObject("guru99bank", By.cssSelector(".barone"));
		addObject("enterEmail", By.name("emailid"));
		addObject("submitButton", By.name("btnLogin"));
		addObject("userID", By.xpath("//td[text()[contains(.,'User ID')]]/following-sibling::td[1]"));
		addObject("password", By.xpath("//td[text()[contains(.,'Password')]]/following-sibling::td[1]"));
		addObject("userid_homepage", By.name("uid"));
		addObject("pass_homepage", By.name("password"));

	}
}
