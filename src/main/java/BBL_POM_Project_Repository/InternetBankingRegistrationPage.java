package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingRegistrationPage {
	

	public InternetBankingRegistrationPage (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(name="holder_name")
	private WebElement AccHolderName_TF ;
	
	@FindBy(name="accnum")
	private WebElement AccNO_TF;
	
	@FindBy(name="dbtcard")
	private WebElement DebitCardNo_TF ;
	
	@FindBy(name="dbtpin")
	private WebElement DbtCrdPin_TF ;
	
	@FindBy(name="mobile")
	private WebElement Mbl_TF ;
	
	@FindBy(name="pan_no")
	private WebElement PANno_TF ;
	
	@FindBy(xpath="//input[@name='pan_no' and @placeholder='Date of Birth']")
	private WebElement DOB_TF;
	
	@FindBy(name="last_trans")
	private WebElement LstTracs_TF;
	
	@FindBy(name="password")
	private WebElement Pwd_TF ;
	
	@FindBy(name="cnfrm_password")
	private WebElement CnfmPwd_TF ;
	
	@FindBy(name="submit")
	private WebElement SubmitBtn ;

	public WebElement getAccHolderName_TF() {
		return AccHolderName_TF;
	}

	public WebElement getAccNO_TF() {
		return AccNO_TF;
	}

	public WebElement getDebitCardNo_TF() {
		return DebitCardNo_TF;
	}

	public WebElement getDbtCrdPin_TF() {
		return DbtCrdPin_TF;
	}

	public WebElement getMbl_TF() {
		return Mbl_TF;
	}

	public WebElement getPANno_TF() {
		return PANno_TF;
	}

	public WebElement getDOB_TF() {
		return DOB_TF;
	}

	public WebElement getLstTracs_TF() {
		return LstTracs_TF;
	}

	public WebElement getPwd_TF() {
		return Pwd_TF;
	}

	public WebElement getCnfmPwd_TF() {
		return CnfmPwd_TF;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	
}
