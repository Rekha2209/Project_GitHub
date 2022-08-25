package com.BBL.Customer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.Bidvest_Online_Banking_Generic.ExcelUtility;
import com.Bidvest_Online_Banking_Generic.FileUtility;
import com.Bidvest_Online_Banking_Generic.JavaUtility;
import com.Bidvest_Online_Banking_Generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTheAccount_Sumbit_ViewTheDetails_GobackAndUpdateDetails_Confirk_sumbit {
	
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		WebDriver driver=null;
		
		// step1 read all the necessary common data
		//Create an object to utility
		           
				 String URL = fLib.getPropertyKeyValue("url");
				 String Browser = fLib.getPropertyKeyValue("browser");
				 
				 //  Step2: Read the TestData from Excel
				 
				//Create an object to excel utility
			 String name = eLib.getExcelData("Sheet1",11, 3);
			 String mblno =  eLib.getExcelData("Sheet1",11, 4);
			 String Pan_no = eLib.getExcelData("Sheet1",11, 5);
			 String Citizenship_no =eLib.getExcelData("Sheet1",11, 6);
			 String Home_addrs=eLib.getExcelData("Sheet1",11, 7);
			 String Area=eLib.getExcelData("Sheet1",11, 8);
			 String pincode=eLib.getExcelData("Sheet1",11, 9);
			 
			 
			// Step3: Launch the Browser
			 if (Browser.equalsIgnoreCase("Chrome")) {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}else if
					(Browser.equalsIgnoreCase("firefox")) {
						WebDriverManager.firefoxdriver().setup();
						driver=new FirefoxDriver();
				}
					else {
						System.out.println("Incorrect browser"); 
					}
					driver.get(URL);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					
// create the new account
					driver.findElement(By.xpath("//li[text()='Open Account']")).click();
			 driver.findElement(By.name("name")).sendKeys(name);	
			WebElement ele = driver.findElement(By.name("gender"));
			wLib.select(ele, "Male");
			 driver.findElement(By.name("mobile")).sendKeys(mblno);
			 driver.findElement(By.name("pin")).sendKeys(pincode);
			String dob = jLib.getSystemDate();
			 driver.findElement(By.name("dob")).click();
			jLib.getRobotClassSystemDate();
			
			 driver.findElement(By.name("pan_no")).sendKeys(Pan_no);
			 driver.findElement(By.name("citizenship")).sendKeys(Citizenship_no);
			 driver.findElement(By.name("homeaddrs")).sendKeys(Home_addrs);
			 
			 WebElement ele1 = driver.findElement(By.name("state"));
				wLib.select(ele1, "Texas");
				WebElement ele2 = driver.findElement(By.name("city"));
				wLib.select(ele2, "San Diego");
			 driver.findElement(By.name("arealoc")).sendKeys(Area);
			 WebElement ele3 = driver.findElement(By.name("acctype"));
				wLib.select(ele3, "Saving");
				driver.findElement(By.name("submit")).click();
				driver.findElement(By.className("cnfrm-submit-btn")).click();
				driver.findElement(By.name("submit")).click();
				driver.findElement(By.className("cnfrm-submit-btn")).click();
				
		// fetching confirmation message for account creation
		
				wLib.swithToAlertWindowAndAccpect(driver,"Application submitted successfully ");
				
				driver.close();
					
	}
}
