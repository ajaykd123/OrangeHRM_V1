package com.Selenium.Utilities;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandlingLinks {

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * method will check all links availbale on page return all broken links of type
	 * List
	 */
	public static List<String> getAllBrokenLinks(WebDriver driver) throws MalformedURLException {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int countBrokenLinks=0;
		List<String> brokenLinks = new ArrayList();
		for(WebElement element : links) {
			String url = element.getAttribute("href");
			if(url==null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}
			
			URL link = new URL(url);
			try {
				HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				httpConn.connect();
				if(httpConn.getResponseCode()>=400) {
					System.out.println(httpConn.getResponseCode()+" "+url+" is broken link");
					countBrokenLinks++;
					brokenLinks.add(url);
				}else {
					System.out.println(httpConn.getResponseCode()+" "+url+" is valid link");
				}
			}catch(Exception e) {
				
			}
		} 
		System.out.println(countBrokenLinks);
		return brokenLinks;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * method return count of all links on page and display innertext and href value
	 * on console
	 */
	public static int getCountOfAllLinks(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement link : links) {
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
		return links.size();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
}
