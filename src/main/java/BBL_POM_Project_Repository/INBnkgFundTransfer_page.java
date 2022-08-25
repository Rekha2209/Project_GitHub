package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INBnkgFundTransfer_page {
	WebDriver driver; // Global driver available
	 public INBnkgFundTransfer_page(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this); 
	 }
	 
	@FindBy(xpath="//input[@name='add_beneficiary']") 
	 private WebElement AddBnfry_btn;
	
	@FindBy(xpath="//input[@name='delete_beneficiary']") 
	 private WebElement DelBnfry_btn;
	
	@FindBy(xpath="//input[@name='view_beneficiary']") 
	 private WebElement viewBnfry_btn;
	
	@FindBy(xpath="//select[@name='beneficiary']")
	private WebElement selectBnfry_DD;
	 
	@FindBy(name="trnsf_amount ")
	private WebElement amnt_TF; 
	
	@FindBy(name="trnsf_remark")
	private WebElement Remark_TF;
	
	@FindBy(name="fnd_trns_btn")
	private WebElement Send_btn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddBnfry_btn() {
		return AddBnfry_btn;
	}

	public WebElement getDelBnfry_btn() {
		return DelBnfry_btn;
	}

	public WebElement getViewBnfry_btn() {
		return viewBnfry_btn;
	}

	public WebElement getSelectBnfry_DD() {
		return selectBnfry_DD;
	}

	public WebElement getAmnt_TF() {
		return amnt_TF;
	}

	public WebElement getRemark_TF() {
		return Remark_TF;
	}

	public WebElement getSend_btn() {
		return Send_btn;
	}
	 
	public void FunfTransfer(String amnt, String Remark)
	{
		amnt_TF.sendKeys(amnt);
		Remark_TF.sendKeys(Remark);
		Send_btn.click();
		
	}
	 
	 
	 
	 
	 
	 
	 
}
