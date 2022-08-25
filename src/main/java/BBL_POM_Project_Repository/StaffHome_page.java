package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHome_page {
		WebDriver driver; // Global driver available
		 public StaffHome_page(WebDriver driver) {
			 this.driver=driver;
			 PageFactory.initElements(driver, this); 
		 } 
		 
		 
		 @FindBy(name="viewdet")
			private WebElement ViewCustmr_Btn ;
		 
		 @FindBy(name="view_cust_by_ac")
			private WebElement ViewByCustomer_Btn  ;
		 
		 @FindBy(name="apprvac")
			private WebElement ApprovePendngAcc_BTn ;
		 
		 @FindBy(name="del_cust")
			private WebElement DelCust_Btn ;
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getViewCustmr_Btn() {
			return ViewCustmr_Btn;
		}

		public WebElement getViewByCustomer_Btn() {
			return ViewByCustomer_Btn;
		}

		public WebElement getApprovePendngAcc_BTn() {
			return ApprovePendngAcc_BTn;
		}

		public WebElement getDelCust_Btn() {
			return DelCust_Btn;
		}
		
			 
		 
		 
		 
		 
		 
		 
		 
		 
}
