package com.Selenium.Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandling {
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	//Auto Suggestive dropdown
	//in xpath reach 'li > span' to get all suggestive option
	public static void selectOptionFromAutoSuggestiveDropdown(List<WebElement> suggestiveOptions, String RequiredValue) {
		for(WebElement option : suggestiveOptions) {
			if(option.getText().contains(RequiredValue)) {
				option.click();
				break;
			}
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//To check drop down options are sorted or not
	public static boolean isDropdowOptionsSorted(WebElement element) {
		Select drpSelect = new Select(element); // select object for drop down element
		List<WebElement> options = drpSelect.getOptions(); // getting all the options from list
		ArrayList<String> originalList = new ArrayList(); //creating one arraylist called original list
		ArrayList<String>  tempList = new ArrayList(); //creating one arraylist called tempList list
		for(WebElement option : options) {
			originalList.add(option.getText()); //collecting text of all option in original list
			tempList.add(option.getText()); ////collecting text of all option in tempList list
		}
		Collections.sort(tempList);
		System.out.println(originalList);
		System.out.println(tempList);
		if(originalList.equals(tempList)) {
			return true;
		}else {
			return false;
		}		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*If drop down has Select tag, then this method will work*/
	public static void selectOptionFromDropdown(WebElement element, String value) {
		Select dropdown = new Select(element);
		List<WebElement> options = dropdown.getOptions();
		for (WebElement option : options) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * bootstrap dropdown, which has div, button and ul/li tags
	 * 'options' are the webelements of all the values in dropdown, and value is option want to select
	 */
	public static void selectOptionFromDropdown(List<WebElement> options, String value) {
		for (WebElement option : options) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * jQuery multi choices drop downs generic method
	 * 'choices' are the webelements of all the choices option available in drop down
	 * 'values' that wants to select, it can be one or multiple, if want to select all option, give values='All'
	 *  ... represent it can take single as well as multiple values
	 */
	public static void selectChoiceOptionFromDropdown(WebDriver driver, List<WebElement> choices, String... values) {
		if (!values[0].equalsIgnoreCase("all")) {
			for (WebElement choice : choices) {
				String text = choice.getText();
				/*
				 * this loop is used to check 'text' value with multiple user values, i.e option
				 * 1 is going to compare with all the values that user wants to select, and it
				 * repeats for all options available in drop down
				 */
				for (String value : values) {
					if (text.equals(value)) {
						choice.click();
						break;
					}
				}
			}
		} else {
			try {
				for (WebElement choice : choices) {
					choice.click();
				}
			} catch (Exception e) {

			}
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*this method is used where we cannot interact with webelement i.e cannot inspect on HTML code i.e tags are not present on page*/
	public static void autoCompleteGooglePlaceDropdown(WebElement autoCompleteBox, String searchValue, String RequiredValue) {
		autoCompleteBox.clear();
		autoCompleteBox.sendKeys(searchValue);
		String text;
		do {
			autoCompleteBox.sendKeys(Keys.ARROW_DOWN);
			text = autoCompleteBox.getAttribute("value");
			if(text.equals(RequiredValue)) {
				autoCompleteBox.sendKeys(Keys.ENTER);
				break;
			}
					
		}while(!text.isEmpty());
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
}
