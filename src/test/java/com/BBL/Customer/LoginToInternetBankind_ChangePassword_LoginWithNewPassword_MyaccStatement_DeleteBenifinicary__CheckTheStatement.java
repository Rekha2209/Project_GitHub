package com.BBL.Customer;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Bidvest_Online_Banking_Generic.ExcelUtility;
import com.Bidvest_Online_Banking_Generic.FileUtility;
import com.Bidvest_Online_Banking_Generic.JavaUtility;
import com.Bidvest_Online_Banking_Generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToInternetBankind_ChangePassword_LoginWithNewPassword_MyaccStatement_DeleteBenifinicary__CheckTheStatement {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		WebDriver driver=null;
		// step1 read all the necessary common data
	     String URL = fLib.getPropertyKeyValue("url");
		 String CustId =fLib.getPropertyKeyValue("customerID");
		 String PWD = fLib.getPropertyKeyValue("Password");
		 String Browser= fLib.getPropertyKeyValue("browser");
		 
		 //  Step2: Read the TestData from Excel
		 
		 
		 String beneficinary_name = eLib.getExcelData("Sheet1", 2, 2);
		 String beneficinary_acc =  eLib.getExcelData("Sheet1", 2, 3);
		 String beneficinary_IFSC = eLib.getExcelData("Sheet1", 2, 4);
		 String OldPassword= eLib.getExcelData("Sheet1", 9, 2);
		 String ConfirmOldPassword= eLib.getExcelData("Sheet1", 9, 3);
		 String NewPassword= eLib.getExcelData("Sheet1", 9, 4);
		 
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
				
// login to the Internet banking
				
				WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Internet ')]"));

				wLib.mouseOverOnElement(driver, ele);
				driver.findElement(By.xpath("//li[text()='Login ']")).click();
				driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys( CustId );
				driver.findElement(By.xpath("//input[@class='password']")).sendKeys(PWD);
				driver.findElement(By.name("login-btn")).click();
				driver.findElement(By.className("link3")).click();
				
// Change the password
     driver.findElement(By.name("oldpass")).sendKeys(OldPassword);
     driver.findElement(By.name("cnfrm")).sendKeys(ConfirmOldPassword);
     driver.findElement(By.name("newpass")).sendKeys(NewPassword);
     driver.findElement(By.name("change_pass")).click();
     
  // Fetching password changed  popup message
		
		wLib.swithToAlertWindowAndAccpect(driver,"Password changed successfully");
		
// logout from the page
		
	driver.findElement(By.name("logout_btn")).click();
	
// login to the Internet banking by new password
	
	driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys( CustId );
	driver.findElement(By.xpath("//input[@class='password']")).sendKeys(NewPassword);
	Thread.sleep(5000);
	
	driver.findElement(By.name("login-btn")).click();

// click on my account button
	driver.findElement(By.xpath("//li [contains(text(),'Account')]")).click();

// click on fund transfer and click on the delete benificary
	driver.findElement(By.className("link4")).click(); // fund tranfer
	
	driver.findElement(By.name("delete_beneficiary")).click();
	
	driver.findElement(By.name("radio")).click();
	driver.findElement(By.name("delete_beneficiary")).click();
	
// read the pop message
	wLib.swithToAlertWindowAndAccpect(driver, "Beneficiary Deleated Successfully");
	


	

   
     
     
     
     
     
     
     
     
     
     
     
     
				
				
				
				
				
				
				
				
				
		 
		 
		 
		 
		 
   }
}