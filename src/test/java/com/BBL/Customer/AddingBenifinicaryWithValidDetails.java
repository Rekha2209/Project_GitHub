package com.BBL.Customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

import com.Bidvest_Online_Banking_Generic.ExcelUtility;
import com.Bidvest_Online_Banking_Generic.FileUtility;
import com.Bidvest_Online_Banking_Generic.WebDriverUtility;

import BBL_POM_Project_Repository.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddingBenifinicaryWithValidDetails {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		// step1 read all the necessary common data
		//Create an object to utility
		FileUtility fLib=new FileUtility();
		String URL = fLib.getPropertyKeyValue("url");
		String CustId = fLib.getPropertyKeyValue("customerID");
		String PWD = fLib.getPropertyKeyValue("Password");
		String Browser = fLib.getPropertyKeyValue("browser");

		//  Step2: Read the TestData from Excel
		//Create an object to excel utility
		ExcelUtility eLib=new ExcelUtility();
		String beneficinary_name = eLib.getExcelData("Sheet1", 2, 2);
		String beneficinary_acc = eLib.getExcelData("Sheet1", 2, 3);
		String beneficinary_IFSC = eLib.getExcelData("Sheet1", 2, 4);

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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);



		// Step4: Login to the Internet banking
	
		WebDriverUtility wLib=new WebDriverUtility();
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Internet ')]"));
		HomePage hm=new HomePage(driver);
		
		wLib.mouseOverOnElement(driver,hm.getInternetBankingMouseOverElement());

        
		driver.findElement(By.xpath("//li[text()='Login ']")).click();
		driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys( CustId );
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys(PWD);
		driver.findElement(By.name("login-btn")).click();

		// Step 5: FundTransfer page
		driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();

		// Adding beneficiary 
		driver.findElement(By.className("beneficiary")).click();
		driver.findElement(By.name("beneficiary_name")).sendKeys(beneficinary_name);
		driver.findElement(By.name("beneficiary_acno")).sendKeys(beneficinary_acc);
		driver.findElement(By.name("Ifsc_code")).sendKeys(beneficinary_IFSC);
		WebElement ele1 = driver.findElement(By.name("beneficiary_acc_type"));
		wLib.select(ele1, 1);
		driver.findElement(By.name("add_beneficiary_btn")).click();
		// step6 confirmation message popup

		wLib.swithToAlertWindowAndAccpect(driver,"Beneficiary Added Successfully");
	










	}

}
