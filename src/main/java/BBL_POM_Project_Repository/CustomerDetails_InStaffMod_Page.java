package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDetails_InStaffMod_Page {
	
	WebDriver driver; // Global driver available
	 public CustomerDetails_InStaffMod_Page(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this); 
	 } 
	 
	 @FindBy (name="account_no")
	 private WebElement CustAccNUm_TF;
	 
	 @FindBy (name="submit_view")
	 private WebElement Submit_btn;
	 
	 //getters
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCustAccNUm_TF() {
		return CustAccNUm_TF;
	}

	public WebElement getSubmit_btn() {
		return Submit_btn;
	}
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
