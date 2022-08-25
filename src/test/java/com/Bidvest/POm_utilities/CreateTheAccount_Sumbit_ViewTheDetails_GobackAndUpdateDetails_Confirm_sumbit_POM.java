package com.Bidvest.POm_utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.CustomAttribute;

import com.Bidvest_Online_Banking_Generic.ExcelUtility;
import com.Bidvest_Online_Banking_Generic.FileUtility;
import com.Bidvest_Online_Banking_Generic.JavaUtility;
import com.Bidvest_Online_Banking_Generic.WebDriverUtility;

import BBL_POM_Project_Repository.Create_OpenAccountForCustomer;
import BBL_POM_Project_Repository.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTheAccount_Sumbit_ViewTheDetails_GobackAndUpdateDetails_Confirm_sumbit_POM {
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
			 String pin=eLib.getExcelData("Sheet1",11, 9);
			 
			 
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
					
//create the new account
// Click on the open acc button
				
	HomePage hp=new HomePage(driver);
	hp.getOpenAccountButton().click();
	
// Fill the details in the registerForm	
Create_OpenAccountForCustomer custacc= new Create_OpenAccountForCustomer(driver);
	custacc.getName_TF().sendKeys(name);	
    custacc.getSelectGender_DD().click();	
	WebElement ele = custacc.getSelectGender_DD();
		wLib.select(ele, "Male");
	custacc.getMobileNo_TF().sendKeys(mblno);
	custacc.getDOB_TF().click();
	jLib.getRobotClassSystemDate();
		/* driver.findElement(By.name("pin")).sendKeys(pincode);
		String dob = jLib.getSystemDate();
		 driver.findElement(By.name("dob")).click();
		jLib.getRobotClassSystemDate(); */
	custacc.getPinCode_TF().sendKeys(pin);
		custacc.getPanNo_TF().sendKeys(Pan_no);
		custacc.getCitizenship_TF().sendKeys(Citizenship_no);
        custacc.getHomeAddrs_TF().sendKeys(Home_addrs);
		custacc.getSelectState_DD().click();
		WebElement ele1 = custacc.getSelectState_DD();
		wLib.select(ele1, "Texas");// state
		custacc.getSelectCity_DD().click();
		WebElement ele2 = custacc.getSelectCity_DD();
			wLib.select(ele2, "San Diego");
			custacc.getPinCode_TF();
			custacc.getAreaLoc_TF().sendKeys(Area);
			custacc.getSelectAccType_DD();
		 WebElement ele3 = custacc.getSelectAccType_DD();
			wLib.select(ele3, "Saving");
			custacc.getSubmit_Btn().click();
			// check
			driver.findElement(By.xpath("//input[@class='cnfrm-submit-btn' and @value='Go back']")).click();// go back
			
			driver.findElement(By.name("submit")).click();// Verifying
			driver.findElement(By.className("cnfrm-submit-btn")).click();
			
	// fetching confirmation message for account creation
	
			wLib.swithToAlertWindowAndAccpect(driver,"Application submitted successfully ");
			
			driver.close();
			
		 
		 	
	
	
	
	
	
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

