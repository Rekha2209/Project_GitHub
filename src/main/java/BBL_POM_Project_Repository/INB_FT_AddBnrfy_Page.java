package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Bidvest_Online_Banking_Generic.WebDriverUtility;

public class INB_FT_AddBnrfy_Page {
	
	public INB_FT_AddBnrfy_Page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	 @FindBy(name="beneficiary_name")
	 private WebElement bnfry_TF ;
	 

	 @FindBy(name="beneficiary_acno")
	 private WebElement bnfryAccNo_TF ;

	 @FindBy(name="Ifsc_code")
	 private WebElement IFSC_TF ;

	 @FindBy(name="beneficiary_acc_type")
	 private WebElement SelectBnfryAccType_DD ;

	 @FindBy(name="add_beneficiary_btn")
	 private WebElement Add_Btn ;
	 
	// Getters

	public WebElement getBnfry_TF() {
		return bnfry_TF;
	}

	public WebElement getBnfryAccNo_TF() {
		return bnfryAccNo_TF;
	}

	public WebElement getIFSC_TF() {
		return IFSC_TF;
	}

	public WebElement getSelectBnfryAccType_DD() {
		return SelectBnfryAccType_DD;
	}

	public WebElement getAdd_Btn() {
		return Add_Btn;
	}
	 
	 public void AddingBeneficiary(String BnfryName, String BnfryAccNo,String BnfryIfscNo) {
		 
	 bnfry_TF.sendKeys(BnfryName);
	 bnfryAccNo_TF.sendKeys(BnfryAccNo);
	 IFSC_TF.sendKeys(BnfryIfscNo);
	     WebDriverUtility wdLib=new WebDriverUtility();
		wdLib.select(SelectBnfryAccType_DD, 2);
	 
	 
}
	 	 
}

