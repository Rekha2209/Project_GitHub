package com.BBL.Customer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Bidvest_Online_Banking_Generic.ExcelUtility;
import com.Bidvest_Online_Banking_Generic.FileUtility;
import com.Bidvest_Online_Banking_Generic.JavaUtility;
import com.Bidvest_Online_Banking_Generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToVerifyCustomerAddBeneficiaryThenGotoFundTransferPageLogoutApplication {
 public static void main(String[] args) throws Throwable {
	 FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();	
		WebDriver driver=null;
	
		
//step1 read all the necessary common data
		 String URL = fLib.getPropertyKeyValue("url");
		 String CustId = fLib.getPropertyKeyValue("customerID");
		 String PWD = fLib.getPropertyKeyValue("Password");
		 String Browser = fLib.getPropertyKeyValue("browser");
		 String stfid=fLib.getPropertyKeyValue("StaffID");
		 String password=fLib.getPropertyKeyValue("psw");
		 
//  Step2: Read the TestData from Excel
			//Create an object to excel utility
			String beneficinary_name = eLib.getExcelData("Sheet1", 2, 2);
			String beneficinary_acc = eLib.getExcelData("Sheet1", 2, 3);
			String beneficinary_IFSC = eLib.getExcelData("Sheet1", 2, 4);
			String amnt=eLib.getExcelData("Sheet1", 13, 1);
			String custmer_acc =eLib.getExcelData("Sheet1", 13, 2);
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
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get(URL);
			wLib.waitForElementInDOM(driver);

// Step4: Login to the Internet banking
	
			WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Internet ')]"));
			wLib.mouseOverOnElement(driver,ele);


			driver.findElement(By.xpath("//li[text()='Login ']")).click();
			driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys( CustId );
			driver.findElement(By.xpath("//input[@class='password']")).sendKeys(PWD);
			driver.findElement(By.name("login-btn")).click();
			
// Step 5: FundTransfer page
			driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
			
			
//          Adding beneficiary 
			Thread.sleep(3000);
			driver.findElement(By.name("add_beneficiary")).click();// clicking on add beneficiary link
			driver.findElement(By.name("beneficiary_name")).sendKeys(beneficinary_name);
			driver.findElement(By.name("beneficiary_acno")).sendKeys(beneficinary_acc);
			driver.findElement(By.name("Ifsc_code")).sendKeys(beneficinary_IFSC);
			WebElement ele1 = driver.findElement(By.name("beneficiary_acc_type"));// select beneficiary
			wLib.select(ele1, 1);
			driver.findElement(By.name("add_beneficiary_btn")).click();
		    Thread.sleep(3000);
		    wLib.swithToAlertWindowAndAccpect(driver,"Beneficiary Added Successfully");

// FundTransfer page
			
			driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
		 WebElement ele2 = driver.findElement(By.name("beneficiary"));
		 wLib.select(ele2,2);
		 driver.findElement(By.name("trnsf_amount")).sendKeys(amnt);
		 driver.findElement(By.name("fnd_trns_btn")).click();
		 WebElement ele3 = driver.findElement(By.xpath("//*[@id=\"customer_profile\"]/label"));
		 String  ele4= ele3.getText();
		 String [] value= ele4.split(" ");
		 int length= value.length;
		 String arr= value[length-1];
// handling the OTP
		 driver.findElement(By.name("otpcode"));
		  
// Staff Login		 
		 
		 driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		 driver.findElement(By.className("customer_id")).sendKeys(stfid);
		 driver.findElement(By.className("password")).sendKeys(password);
		 driver.findElement(By.className("login-btn")).click();
		 
// Credit amount
		 driver.findElement(By.name("credit_cust_ac")).click();
		 driver.findElement(By.name("customer_account_no")).sendKeys(custmer_acc);
		 driver.findElement(By.name("credit_amount")).sendKeys(amnt);
		 driver.findElement(By.name("credit_btn")).click();

// Fetching the alert message
		 wLib.swithToAlertWindowAndAccpect(driver, "Amount credited Successfully to customer account");
		
// logout from the staff module
		 driver.findElement(By.name("logout_btn")).click();
		 driver.findElement(By.xpath("//a[text()='Home']")).click();// click on the home button
		 driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click(); // click on the fund transfer button
		 driver.findElement(By.xpath("//input[@class='customer_id']")).sendKeys( CustId );
			driver.findElement(By.xpath("//input[@class='password']")).sendKeys(PWD);
			driver.findElement(By.name("login-btn")).click();
			driver.findElement(By.className("link5")).click();// checking in the statement to check amount is created r not
			
		 
		 
		 
			
			

	
		
		
		
		
		
		
		
		
		
		
		
		
}
	
}
