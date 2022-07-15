package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.Test;


public class NewTestngClass {
	   @Test(enabled=false)
	   public void testcase1(){
	      System.out.println("Testcase 1 - Not executed");
	   }
	   @Test
	   public void testcase2(){
		   boolean flag;
	      System.out.println("Testcase 2 - skip exception example");
	     if(flag=false)
	      throw new SkipException("Skipping this exception");
	      System.out.println("Working");
	   }
	   @Test
	   public void testcase3(){
	      boolean DataAvailable=false ;
	      System.out.println("Test Case3 - Conditional Skip");
	      if(DataAvailable)
	      throw new SkipException("Skipping this exception");
	      System.out.println("Executed Successfully");
	   }
	}
