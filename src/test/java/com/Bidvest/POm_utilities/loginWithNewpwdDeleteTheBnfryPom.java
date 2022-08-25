package com.Bidvest.POm_utilities;

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

import BBL_POM_Project_Repository.CommonLink_Btn_AllPage;
import BBL_POM_Project_Repository.HomePage;
import BBL_POM_Project_Repository.INBnkgFundTransfer_page;
import BBL_POM_Project_Repository.IN_FT_Delbnfry_Page;
import BBL_POM_Project_Repository.InBnkgChangePassword_Page;
import BBL_POM_Project_Repository.InternetLogin_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginWithNewpwdDeleteTheBnfryPom {
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
				
				//WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Internet ')]"));
    HomePage hp= new HomePage(driver);
    WebElement ele= hp.getInternetBankingMouseOverElement();
	wLib.mouseOverOnElement(driver, ele);
	hp.getInternetBankingLoginButton().click();	
	
// login with customer id and password
	InternetLogin_Page login = new InternetLogin_Page(driver);
	login.IN_login(CustId, PWD);

// Click on FundTransfer Link
	CommonLink_Btn_AllPage FT_LInk=new CommonLink_Btn_AllPage(driver);
			FT_LInk.getChnfPwd_link().click();
			
// Change the password
			InBnkgChangePassword_Page chngPWd= new InBnkgChangePassword_Page(driver);
			chngPWd.ChangingPwd(OldPassword, ConfirmOldPassword, NewPassword);
		     
// Fetching password changed  popup message
			
			wLib.swithToAlertWindowAndAccpect(driver,"Password changed successfully");
	
// logout from the page
			FT_LInk.getCustmrLogout_Btn().click();
	
// login to the Internet banking by new password
			login.IN_login(CustId, PWD);	
			
// click on my account button and fund transfer
		FT_LInk.getMyAcc_link().click();	
        FT_LInk.getFundTrnsf_link().click();
        
// In fund transfer page click on the del bnfry button
    INBnkgFundTransfer_page  del= new INBnkgFundTransfer_page(driver);
    del.getDelBnfry_btn().click();
        
        
// select delete Benificiary and del the acc
        IN_FT_Delbnfry_Page delbnfry= new IN_FT_Delbnfry_Page(driver);
        delbnfry.delete();
        
        
    // read the pop message
    	wLib.swithToAlertWindowAndAccpect(driver, "Beneficiary Deleated Successfully");
	}	
	
}
