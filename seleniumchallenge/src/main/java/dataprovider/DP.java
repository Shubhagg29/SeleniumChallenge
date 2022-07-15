package dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP
	{
	
	static String TEST_DATA_SHEET_PATH = "/Users/shubhagg/Documents/Details.xlsx";
	static Workbook book;
	static Sheet sheet;
	  
	@DataProvider (name = "data-provider")
	     public Object[][] dpMethod(){
	    	FileInputStream file = null;
			
			try {
				file =new FileInputStream(TEST_DATA_SHEET_PATH);
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			try {
			book=WorkbookFactory.create(file);	
				
			} catch (EncryptedDocumentException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 sheet=book.getSheet("NewPatient");
			 
			 Object[][] data  = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				
				for(int i = 0; i < sheet.getLastRowNum(); i++) {
					
					for(int j=0;j<sheet.getRow(0).getLastCellNum();j++ ) {
						data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
						
				//	System.out.println(data[i][j]);
					}
					
				}
	    	return data;
	    	
	     }
		
	    @Test (dataProvider = "data-provider")
	    public void myTest (String firstName, String lastName, String gender, String dob, String dom,
				String doy) {
	       // System.out.println("Passed Parameter Is : "+ firstName  + " " + lastName  + " " + gender +" "+ dob);
	    	
	    	
	    
	    }
	}


