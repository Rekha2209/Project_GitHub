package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StafflLogout_Page {
	WebDriver driver; // Global driver available
	 public StafflLogout_Page(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this); 
	 } 
	 
	 
	 @FindBy(name="logout_btn")
		private WebElement stafflogout_Btn ;
	 
	 
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getStafflogout_Btn() {
		return stafflogout_Btn;
	}
	 

	 
}
