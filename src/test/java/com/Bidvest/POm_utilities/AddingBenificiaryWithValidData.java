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

public class AddingBenificiaryWithValidData {
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
				HomePage hm=new HomePage(driver);
	WebElement ele=hm.getInternetBankingMouseOverElement();
	wLib.mouseOverOnElement(driver, ele);
	hm.getInternetBankingLoginButton().click();

      // Step5: Login to the page By entering Customer id and password  
		InternetLogin_Page LoginPage= new InternetLogin_Page(driver);
		LoginPage.IN_login(CustId, PWD);
		
		//step 6: click on the fund transfer link
		CommonLink_Btn_AllPage cmn= new CommonLink_Btn_AllPage(driver);
		cmn.getFundTrnsf_link().click();
		
		// Step6: Click on the AddBeneficiary button
		INBnkgFundTransfer_page addbnfry= new INBnkgFundTransfer_page(driver);
		addbnfry.getAddBnfry_btn().click();
     // Step 7:Adding beneficiary  
		 
	INB_FT_AddBnrfy_Page AddBnfry= new INB_FT_AddBnrfy_Page(driver);
	
		AddBnfry.AddingBeneficiary(beneficinary_name, beneficinary_acc, beneficinary_IFSC);
		
		WebElement ele1 = AddBnfry.getSelectBnfryAccType_DD();
		wLib.select(ele1, 1);
		AddBnfry.getAdd_Btn().click();
		// step6 confirmation message popup

		wLib.swithToAlertWindowAndAccpect(driver,"Beneficiary Added Successfully");
	
	}


}
