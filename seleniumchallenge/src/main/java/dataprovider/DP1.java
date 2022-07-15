package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP1 {
	public class DP
	{
	    @DataProvider (name = "data-provider")
	     public Object[][] dpMethod(){
		 Object[][]obj= {{"First-Value:","hsv"}, {"Second-Value","try"}};
		 return obj;
	     }
		
	    @Test (dataProvider = "data-provider")
	    public void myTest (String val, String val2) {
	        System.out.println("Passed Parameter Is : " + val);
	      //  System.out.println("Passed Parameter Is : " + val2);
	    }
	}

}
