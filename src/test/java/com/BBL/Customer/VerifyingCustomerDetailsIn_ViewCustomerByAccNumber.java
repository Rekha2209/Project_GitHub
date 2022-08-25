package com.BBL.Customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Bidvest_Online_Banking_Generic.ExcelUtility;
import com.Bidvest_Online_Banking_Generic.FileUtility;
import com.Bidvest_Online_Banking_Generic.JavaUtility;
import com.Bidvest_Online_Banking_Generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyingCustomerDetailsIn_ViewCustomerByAccNumber {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		WebDriver driver=null;
		// step1 read all the necessary common data
		 
		 String URL = fLib.getPropertyKeyValue("url");
		 String StaffId =fLib.getPropertyKeyValue("staffID");
		 String Password =fLib.getPropertyKeyValue("pwd");
		 String Browser = fLib.getPropertyKeyValue("browser");
		 
		 
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
				
	//login to the staff module
				driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
				driver.findElement(By.className("customer_id")).sendKeys(StaffId);
				driver.findElement(By.className("password")).sendKeys(Password);
				driver.findElement(By.className("login-btn")).click();
				driver.findElement(By.name("viewdet")).click();
		 
   }
}