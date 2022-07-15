package day1;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorSel4 {
	
	 static WebDriver driver;
	
	public static void main (String args[]) throws InterruptedException, IOException 
	{
		//ChromeOptions opt = new ChromeOptions();
		
		//driver=WebDriverManager.chromedriver().create();
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		//driver.executeCdpCommand("Emulation.se", parameters)
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
	   WebElement username=	driver.findElement(By.id("txtUsername"));
	
	     username.sendKeys("Admin");
	     File src  =	username.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(src, new File("./target/screenShot/name.png"));
		driver.findElement(By.xpath("//*[@id='txtUsername']//following::input[1]")).sendKeys("admin123");
		
	driver.findElement(with(By.tagName("input")).below(By.id("txtPassword"))).click();
		
	
		
		
		File src1=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("./target/screenShot/page.png"));
	
		//driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.quit();
			
	}





	
}
