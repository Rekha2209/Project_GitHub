package com.Bidvest.POm_utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Bidvest_Online_Banking_Generic.ExcelUtility;
import com.Bidvest_Online_Banking_Generic.FileUtility;
import com.Bidvest_Online_Banking_Generic.WebDriverUtility;

import BBL_POM_Project_Repository.CommonLink_Btn_AllPage;
import BBL_POM_Project_Repository.HomePage;
import BBL_POM_Project_Repository.INB_FT_AddBnrfy_Page;
import BBL_POM_Project_Repository.INBnkgFundTransfer_page;
import BBL_POM_Project_Repository.InternetLogin_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class addingBeneficaryWithInvaid_IdscDetails {
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wdLib=new WebDriverUtility();
		WebDriver driver=null;
		//step1 read all the necessary common data
		 FileUtility fLib=new FileUtility();
		 String URL = fLib.getPropertyKeyValue("url");
		 String CustId = fLib.getPropertyKeyValue("customerID");
		 String PWD = fLib.getPropertyKeyValue("Password");
		 String Browser = fLib.getPropertyKeyValue("browser");
		
		
		 
		 //  Step2: Read the TestData from Excel
		 
		 ExcelUtility elib=new ExcelUtility();
		 String beneficinary_name = elib.getExcelData("Sheet1", 5, 2);
		 String beneficinary_acc = elib.getExcelData("Sheet1", 5, 3); 
		 String beneficinary_IFSC = elib.getExcelData("Sheet1", 5, 4);
		 
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
				
				
		// Step4: Login to the Internet banking
				HomePage hm= new HomePage(driver);
				WebElement ele = hm.getInternetBankingMouseOverElement();
				wdLib.mouseOverOnElement(driver, ele);
				hm.getInternetBankingLoginButton().click();
				
			// Step5: Login by entering customerId and password	
				InternetLogin_Page Login_Page= new InternetLogin_Page(driver);
				Login_Page.IN_login(CustId, PWD);
				
	// step6 click on the fund transfer page
				CommonLink_Btn_AllPage Ft_page=new CommonLink_Btn_AllPage(driver);
				Ft_page.getFundTrnsf_link().click();
				
	
	// Step 7    Adding beneficiary 
				// click on the add benificary button
				INBnkgFundTransfer_page ClickAdd= new INBnkgFundTransfer_page(driver);
				ClickAdd.getAddBnfry_btn().click();
				
				// Adding details of the benificiary
				INB_FT_AddBnrfy_Page AddBnfry= new INB_FT_AddBnrfy_Page(driver);
				AddBnfry.AddingBeneficiary(beneficinary_name, beneficinary_acc, beneficinary_IFSC);
				WebElement ele1 = AddBnfry.getSelectBnfryAccType_DD();                   
				wdLib.select(ele1, 2);
				AddBnfry.getAdd_Btn().click();
	// step 8 confirmation message popup
				
				wdLib.swithToAlertWindowAndAccpect(driver,"Incorrect IFSC Code");
				
						
				

	}


}


