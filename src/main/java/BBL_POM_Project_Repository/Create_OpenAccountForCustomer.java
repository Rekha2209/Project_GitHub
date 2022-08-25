package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_OpenAccountForCustomer {

	public Create_OpenAccountForCustomer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="name")
	private WebElement Name_TF;
	
	@FindBy(name="gender")
	private WebElement SelectGender_DD;
	
	@FindBy(name="mobile")
	private WebElement MobileNo_TF;
	
	@FindBy(name="email")
	private WebElement Email_TF;
	
	@FindBy(name="landline")
	private WebElement LandLineNo_TF;
	
	@FindBy(name="dob")
	private WebElement DOB_TF;
	
	@FindBy(name="pan_no")
	private WebElement PanNo_TF;
	
	@FindBy(name="citizenship")
	private WebElement Citizenship_TF;
	
	@FindBy(name="homeaddrs")
	private WebElement HomeAddrs_TF;
	
	@FindBy(name="officeaddrs")
	private WebElement OfficeAddrs_TF;
	
	@FindBy(name="state")
	private WebElement SelectState_DD;
	
	@FindBy(name="city")
	private WebElement SelectCity_DD;
	
	@FindBy(name="pin")
	private WebElement PinCode_TF;
	
	@FindBy(name="arealoc")
	private WebElement AreaLoc_TF;
	
	@FindBy(name="nominee_name")
	private WebElement NomineeName_TF;
	
	@FindBy(name="nominee_ac_no")
	private WebElement NomineeAccNO_TF;
	
	@FindBy(name="acctype")
	private WebElement SelectAccType_DD;
	
	@FindBy(name="submit")
	private WebElement Submit_Btn;

	public WebElement getName_TF() {
		return Name_TF;
	}

	public WebElement getSelectGender_DD() {
		return SelectGender_DD;
	}

	public WebElement getMobileNo_TF() {
		return MobileNo_TF;
	}

	public WebElement getEmail_TF() {
		return Email_TF;
	}

	public WebElement getLandLineNo_TF() {
		return LandLineNo_TF;
	}

	public WebElement getDOB_TF() {
		return DOB_TF;
	}

	

	public WebElement getPanNo_TF() {
		return PanNo_TF;
	}

	public WebElement getCitizenship_TF() {
		return Citizenship_TF;
	}

	public WebElement getHomeAddrs_TF() {
		return HomeAddrs_TF;
	}

	public WebElement getOfficeAddrs_TF() {
		return OfficeAddrs_TF;
	}

	public WebElement getSelectState_DD() {
		return SelectState_DD;
	}

	public WebElement getSelectCity_DD() {
		return SelectCity_DD;
	}

	public WebElement getPinCode_TF() {
		return PinCode_TF;
	}

	public WebElement getAreaLoc_TF() {
		return AreaLoc_TF;
	}

	public WebElement getNomineeName_TF() {
		return NomineeName_TF;
	}

	public WebElement getNomineeAccNO_TF() {
		return NomineeAccNO_TF;
	}

	public WebElement getSelectAccType_DD() {
		return SelectAccType_DD;
	}

	public WebElement getSubmit_Btn() {
		return Submit_Btn;
	}
	
}
