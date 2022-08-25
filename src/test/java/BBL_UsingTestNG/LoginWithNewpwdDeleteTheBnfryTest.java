package BBL_UsingTestNG;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BidvestOnlineBanking.comcast.genericUtility.BaseClass;

import BBL_POM_Project_Repository.CommonLink_Btn_AllPage;
import BBL_POM_Project_Repository.HomePage;
import BBL_POM_Project_Repository.INBnkgFundTransfer_page;
import BBL_POM_Project_Repository.IN_FT_Delbnfry_Page;
import BBL_POM_Project_Repository.InBnkgChangePassword_Page;
import BBL_POM_Project_Repository.InternetLogin_Page;

public class LoginWithNewpwdDeleteTheBnfryTest extends BaseClass {
@Test(groups = "regression")
//launch the browser in baseclass
//initialisation of all the utilities in baseclass
// login to internet banking by providing custId and password


public void addbnfry() throws Throwable {
String beneficinary_name = eLib.getExcelData("Sheet1", 2, 2);
String beneficinary_acc =  eLib.getExcelData("Sheet1", 2, 3);
String beneficinary_IFSC = eLib.getExcelData("Sheet1", 2, 4);
String OldPassword= eLib.getExcelData("Sheet1", 9, 2);
String ConfirmOldPassword= eLib.getExcelData("Sheet1", 9, 3);
String NewPassword= eLib.getExcelData("Sheet1", 9, 4);
String CUSTID = fLib.getPropertyKeyValue("customerID"); 
// click on the change password link(Check)
CommonLink_Btn_AllPage pwd_LInk=new CommonLink_Btn_AllPage(driver);
pwd_LInk .getChnfPwd_link().click();


//click on the change password link
InBnkgChangePassword_Page chngPWd= new InBnkgChangePassword_Page(driver);
chngPWd.ChangingPwd(OldPassword, ConfirmOldPassword, NewPassword);

// handle the popup message password changed notification
wLib.swithToAlertWindowAndAccpect(driver,"Password changed successfully");

// logout from the customer logout page
pwd_LInk.getCustmrLogout_Btn().click();

// again login with new created customer password
InternetLogin_Page login = new InternetLogin_Page(driver);
login.IN_login(CUSTID, NewPassword);

// click on my account button and fund transfer
pwd_LInk.getMyAcc_link().click();	
pwd_LInk.getFundTrnsf_link().click();


// select del bnfry
INBnkgFundTransfer_page  del= new INBnkgFundTransfer_page(driver);
del.getDelBnfry_btn().click();
    
//select delete Benificiary and del the acc
IN_FT_Delbnfry_Page delbnfry= new IN_FT_Delbnfry_Page(driver);
delbnfry.delete();

// read the pop message
wLib.swithToAlertWindowAndAccpect(driver, "Beneficiary Deleated Successfully");
}	



}
