package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InBnkgChangePassword_Page {
	WebDriver driver; // Global driver available
	 public InBnkgChangePassword_Page(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this); 
	 }
	 @FindBy(name="oldpass")
		private WebElement OldPassWord_TF  ;

	 @FindBy(name="cnfrm")
		private WebElement CnfmPwd_TF ;

	 @FindBy(name="newpass")
		private WebElement NewPwd_TF  ;

	 @FindBy(name="change_pass")
		private WebElement Submit_btn ;
	 
// Getters

	public WebElement getOldPassWord_TF() {
		return OldPassWord_TF;
	}

	public WebElement getCnfmPwd_TF() {
		return CnfmPwd_TF;
	}

	public WebElement getNewPwd_TF() {
		return NewPwd_TF;
	}

	public WebElement getSubmit_btn() {
		return Submit_btn;
	}

	 // Sending values
	public void ChangingPwd(String oldPw , String cnfrmPwd, String NewPwd)
	{
		OldPassWord_TF.sendKeys(oldPw);
		CnfmPwd_TF.sendKeys(cnfrmPwd);
		NewPwd_TF.sendKeys(NewPwd);
		Submit_btn.click();
	}
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
