package com.Selenium.Utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TableHandling {

	public static void sortingColumn(WebDriver driver, WebElement nameColumn, List<WebElement> columnNameValues,
			String value) throws Exception {

		/* Find 'name' column, and fetch 'class' attribute value, if
		 * (class=sorting_desc), then it will click column name and do sorting in
		 * ascending order, or else remain as it is in ascending order
		 */
		String attributValue = nameColumn.getAttribute("class");
		if (attributValue.equalsIgnoreCase(value)) {
			nameColumn.click();
		}

		/*
		 * after sorting, Fetching and storing actual text values of 'name' column in
		 * String list 'originalcol1Values'
		 */
		List<String> originalcol1Values = columnNameValues.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println(originalcol1Values);

		/*
		 * Fetching and storing sorted text values of 'originalcol1Values' list in
		 * String list 'sortedcol1Values'
		 */
		List<String> sortedcol1Values = originalcol1Values.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedcol1Values);

		/*
		 * compare 'originalcol1Values' and 'originalcol1Values'. if sorting doesn't
		 * work, then 'originalcol1Values' will contain non sorted value, and assert
		 * will return false on comparison
		 */
		Assert.assertTrue(originalcol1Values.equals(sortedcol1Values));
	}
	
	private static List<String> searchingUsingPagination(WebDriver driver, WebElement searchox, String name,
			List<WebElement> columnNameValues, WebElement nextBtn) throws Exception {
		// clears search box
		searchox.clear();
		Thread.sleep(3000);

		// declare List of type string
		List<String> name1;
		do {
			// store xpath of all webelement of 1st column of webtable
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			// filtering webelement with text 'S. Frost' and getting his age
			name1 = rows.stream().filter(s -> s.getText().contains("S. Frost")).map(s -> s.getText())
					.collect(Collectors.toList());
			// print age
			name1.forEach(a -> System.out.println(a));
			// age.size() always remain less than 1, if it doesn't get webelement on page 1,
			// then it will enter if loop and click on next button and search text on second
			// page, once it will get text, then age.size() become greater than 1, and loop
			// will break
			if (name1.size() < 1) {
				driver.findElement(By.cssSelector("a[class='paginate_button next']")).click();
			}
		} while (name1.size() < 1);
		return name1;
	}
	
	private static void filteringWebtable(WebDriver driver, WebElement searchox, String country,
			List<WebElement> columnCountryValues) throws Exception {

		// search any office value in search box
		searchox.sendKeys(country);

		// after search, Fetch and store webelement of country column in
		// 'allvalueElement'
		List<WebElement> allvalueElement = driver.findElements(By.xpath("//tr//td[3]"));

		// Filter 'allvalueElement', and store filtered webelements in 'filteredList'
		List<WebElement> filteredList = allvalueElement.stream().filter(s -> s.getText().contains(country))
				.collect(Collectors.toList());

		// compare'allvalueElement' and 'filteredList'
		Assert.assertEquals(allvalueElement.size(), filteredList.size());

	}
	
}
