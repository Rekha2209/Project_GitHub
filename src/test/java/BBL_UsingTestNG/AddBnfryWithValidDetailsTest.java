package BBL_UsingTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BidvestOnlineBanking.comcast.genericUtility.BaseClass;
import com.Bidvest_Online_Banking_Generic.ExcelUtility;
import com.Bidvest_Online_Banking_Generic.WebDriverUtility;

import BBL_POM_Project_Repository.CommonLink_Btn_AllPage;
import BBL_POM_Project_Repository.HomePage;
import BBL_POM_Project_Repository.INB_FT_AddBnrfy_Page;
import BBL_POM_Project_Repository.INBnkgFundTransfer_page;
import BBL_POM_Project_Repository.InternetLogin_Page;

public class AddBnfryWithValidDetailsTest extends BaseClass {
	
@Test(groups = "smoke")

// Beneficiary Credentials
public void addbnfry() throws Throwable {
	String bnfryName= eLib.getExcelData("Sheet1", 2, 2);
	String bnfryacc= eLib.getExcelData("Sheet1", 2, 3);
	String BnfryIfsc=eLib.getExcelData("Sheet1", 2, 4);
	String exprslt= eLib.getExcelData("Sheet1", 2, 5);

	// click on the fund transfer link
CommonLink_Btn_AllPage FdLink= new CommonLink_Btn_AllPage(driver);
FdLink.getFundTrnsf_link().click();


// click on the add beneficiary button 
INBnkgFundTransfer_page addbnfryBtn= new INBnkgFundTransfer_page(driver);
addbnfryBtn.getAddBnfry_btn().click();



// enter all the credentials in add beneficiary
INB_FT_AddBnrfy_Page add= new INB_FT_AddBnrfy_Page(driver);
add.AddingBeneficiary(bnfryName, bnfryacc, BnfryIfsc);
Thread.sleep(3000);
add.getAdd_Btn().click();

// handle the alert message
wLib.swithToAlertWindowAndAccpect(driver,"Beneficiary Added Successfully");
   
//   String actualResult= wLib.swithToAlertWindowAndAccpectvalidate(driver);
 //  Assert.assertEquals(actualResult, exprslt);
   





}




}
