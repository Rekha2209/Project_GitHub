package BBL_UsingTestNG;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BidvestOnlineBanking.comcast.genericUtility.BaseClass;

import BBL_POM_Project_Repository.CommonLink_Btn_AllPage;
import BBL_POM_Project_Repository.INB_FT_AddBnrfy_Page;
import BBL_POM_Project_Repository.INBnkgFundTransfer_page;
import BBL_POM_Project_Repository.InternetLogin_Page;
import BBL_POM_Project_Repository.StaffHome_page;
import BBL_POM_Project_Repository.StaffLogin_Page;

public class CreatingBnfryWithInvalidIFSCDetailsTest extends BaseClass {

	
@Test(groups = "smoke")

// Beneficiary Credentials
public void addbnfry() throws Throwable {
	String bnfryName= eLib.getExcelData("Sheet1", 5, 2);
	String bnfryacc= eLib.getExcelData("Sheet1", 5, 3);
	String BnfryIfsc=eLib.getExcelData("Sheet1", 5, 4);
	String exprslt= eLib.getExcelData("Sheet1", 5, 5);

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
/*SoftAssert alt= new SoftAssert();
alt.assertAll();
String actualResult= wLib.swithToAlertWindowAndAccpectvalidate(driver);
Assert.assertEquals(actualResult, exprslt);	
	/*TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
   File des = new File("C://photos/.jpeg");
FileUtils.copyFile(src, des);
*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
