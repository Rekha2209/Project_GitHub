package BBL_UsingTestNG;

import org.testng.annotations.Test;

import com.BidvestOnlineBanking.comcast.genericUtility.BaseClass;

import BBL_POM_Project_Repository.CommonLink_Btn_AllPage;
import BBL_POM_Project_Repository.CustomerDetails_InStaffMod_Page;
import BBL_POM_Project_Repository.StaffHome_page;

public class LogInAsStaffAndViewTheCustomerByAccNoTest extends BaseClass{
	@Test(groups = "regression")
	public void addbnfry() throws Throwable {
		String bnfryName= eLib.getExcelData("Sheet1", 16, 1);
		
	// click on the view Customer by acc number	
StaffHome_page custAcc= new StaffHome_page(driver);
custAcc.getViewByCustomer_Btn().click();

// enter the customer acc number n submit
CustomerDetails_InStaffMod_Page cust =new CustomerDetails_InStaffMod_Page(driver);
cust.getCustAccNUm_TF().sendKeys(bnfryName);
cust.getSubmit_btn().click();

	
	
	
	}
	
}
