package com.OrangeHRM.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_Objects {
	
	WebDriver driver;
	
	public  LoginPage_Objects(WebDriver driver) {
		 this.driver = driver;
	}

	By userName = By.xpath("//input[@id='txtUsername']");
	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	By password = By.xpath("//input[@id='txtPassword']");
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	By loginBtn = By.xpath("//input[@id='btnLogin']");
	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}
}
