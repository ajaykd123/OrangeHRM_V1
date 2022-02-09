package com.Selenium.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowsHandling {

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Method is used to close opened windows by choice, by passing title of windows as argument to method
	 * to get windowIDs Set<String> windowIDs =driver.getWindowHandles();
	 */
	public static void closeWindowsByTitle(WebDriver driver, Set<String> windowIDs, String... windowsTitleToClose) {
		List<String> windowsIDsList = new ArrayList(windowIDs);
		for(String winID: windowsIDsList) {
			String winTitle =driver.switchTo().window(winID).getTitle();
			for(String winToClose : windowsTitleToClose) {
				if(winTitle.equals(winToClose)) {
					driver.close();
				}
			}
			
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
