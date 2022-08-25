package com.Bidvest.POm_utilities;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Bidvest_Online_Banking_Generic.ExcelUtility;
import com.Bidvest_Online_Banking_Generic.FileUtility;
import com.Bidvest_Online_Banking_Generic.JavaUtility;
import com.Bidvest_Online_Banking_Generic.WebDriverUtility;

import BBL_POM_Project_Repository.CommonLink_Btn_AllPage;
import BBL_POM_Project_Repository.StaffHome_page;
import BBL_POM_Project_Repository.StaffLogin_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTheCustomerDetails_viewInCustomerDetailsPage {
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
		// click on the staff login
				CommonLink_Btn_AllPage staflink= new CommonLink_Btn_AllPage(driver);
				staflink.getMainPageStaff_btn().click();
	//login to the staff module
		
			StaffLogin_Page stflgn= new StaffLogin_Page(driver);	
			stflgn.IN_login(StaffId, Password);
			
				
	// view in customerpagez
			StaffHome_page view_clk= new StaffHome_page(driver);
			view_clk.getViewCustmr_Btn() .click();
		 
   }

}
