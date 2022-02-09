package com.Selenium.Utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleCheckBoxes {

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* this method is used to select all checkboxes or few from lists */
	
	public static void selectMultipleCheckboxes(WebDriver driver, List<WebElement> checkboxes, String... values) {
		if (!values[0].equalsIgnoreCase("all")) {
			for (WebElement checkbox : checkboxes) {
				String checkboxName = checkbox.getAttribute("id");
				/*
				 * this loop is used to check 'checkboxName' value with multiple user values, i.e option
				 * 1 is going to compare with all the values that user wants to select, and it
				 * repeats for all options available in checkboxes list
				 */
				for (String value : values) {
					if (checkboxName.equalsIgnoreCase(value)) {
						checkbox.click();
						break;
					}
				}
			}
		} else {
			try {
				for (WebElement checkbox : checkboxes) {
					checkbox.click();
				}
			} catch (Exception e) {

			}
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/*
	 * using this for loop to select last 'n' checkboxes, 'n' is last n no. of checkboxes
	 */
	public static void selectMultipleCheckboxesFromLast(List<WebElement> checkboxes, int n) {
		for (int i = checkboxes.size() - n; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * using this for loop to select first 'n' checkboxes, 'n' is first n no. of checkboxes
	 */
	public static void selectMultipleCheckboxesFromFirst(List<WebElement> checkboxes, int n) {
		for (int i = 0; i < checkboxes.size(); i++) {
			if(i<n) {
			checkboxes.get(i).click();
			}
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
