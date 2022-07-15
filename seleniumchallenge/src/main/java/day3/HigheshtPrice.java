package day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HigheshtPrice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/inventory.html");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<Double> amountList = new ArrayList<Double>();
		List<WebElement> priceList = driver.findElements(By.className("inventory_item_price"));	
		for (WebElement e : priceList) {
			String amount = e.getText().replace("$", "");
			
			double price= Double.parseDouble(amount);
			amountList.add(price);
		}
		
			Double maxPrice = Collections.max(amountList);
		//System.out.println(largest);
		
		String button = "//div[normalize-space()='$" + maxPrice + "']/following-sibling::button[text()='Add to cart']";
		driver.findElement(By.xpath(button)).click();
		
		Double minPrice = Collections.min(amountList);
		//System.out.println(max);
		
		String minButton = "//div[normalize-space()='$" + minPrice + "']/following-sibling::button[text()='Add to cart']";
		driver.findElement(By.xpath(minButton)).click();
	}

}
