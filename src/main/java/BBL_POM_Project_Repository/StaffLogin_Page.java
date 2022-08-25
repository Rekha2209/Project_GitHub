package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLogin_Page {
	WebDriver driver; // Global driver available
	 public StaffLogin_Page(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this); 
	 }
	 
	@FindBy(name="staff_id") 
	 private WebElement StaffLgn_TF ;
	
	@FindBy(name="password")
	private WebElement Pwd_Tf;
	
	@FindBy(name="staff_login-btn")
	private WebElement logn_Btn;
	
	// Getters
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getStaffLgn_TF() {
		return StaffLgn_TF;
	}

	public WebElement getPwd_Tf() {
		return Pwd_Tf;
	}

	public WebElement getLogn_Btn() {
		return logn_Btn;
	}
	
	public void IN_login(String StaffId , String Staff_Password)
	{
		StaffLgn_TF.sendKeys(StaffId);
		Pwd_Tf.sendKeys(Staff_Password);
		logn_Btn.click();
	}
		

	
	}

	

	
	
	
	
	

