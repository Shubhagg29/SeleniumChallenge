package day1;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorldPopulation {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	   driver =	new ChromeDriver();
		//driver=WebDriverManager.chromedriver().create();
		
		driver.get("https://www.worldometers.info/world-population/");

		String xpath_curnt_pop = "//div[@class='maincounter-number']/span[@class='rts-counter']";
		

		String xpath_this_Year="//div[text()='This year']//parent::div//span[@class='rts-counter']";
		String xpath_today= "//div[text()='Today']//parent::div//span[@class='rts-counter']";
		
		String combined_xpath_today_thisYear="//div[text()='This year'or text()='Today']//parent::div//span[@class='rts-counter']";
		int count =1;
		while (count<=20) {
			System.out.println(count +" sec");
			if(count==20)break;	
			System.out.println("------Current population Count --------");
		worldPopulationData(xpath_curnt_pop);
		
		System.out.println("----------Today's population Count--------");
		
		worldPopulationData(combined_xpath_today_thisYear);
		
		System.out.println("=========================");
		
		Thread.sleep(1000);
		count ++;
		}
		
      driver.quit();
	}

	public static void worldPopulationData(String locator) throws InterruptedException{

	
			List<WebElement> popList = driver.findElements(By.xpath(locator));
			for (WebElement pop : popList) {
				String vlaue = pop.getText();
			System.out.println(vlaue);

			}
			
			
		}
			
		

	

	public void usingJavaScript(WebDriver driver) {

//		// Using JavaScript Executor
//		String script = "setInterval(() => {\n"
//				+ "   let pop = document.querySelectorAll(\"#maincounter-wrap > div > span>span\")\n"
//				+ "    pop.forEach(element=>{\n" + "       console.log (element.innerText)\n" + "    })   \n"
//				+ "}, 100);";
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		js.executeScript(script);

	}

}
