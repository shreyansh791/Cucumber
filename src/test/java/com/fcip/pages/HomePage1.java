package com.fcip.pages;

import java.io.IOException;

import org.openqa.selenium.By;

public class HomePage1 extends BasePage {
	public HomePage1() throws Exception{
	
	addObject("gmail", By.linkText("Gmail"));
}

}