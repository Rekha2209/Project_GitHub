package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonLink_Btn_AllPage {
     WebDriver driver;
	public CommonLink_Btn_AllPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}	
	
	@FindBy(xpath="//li[text()='My Account']")
	private WebElement MyAcc_link;
	
	@FindBy(xpath="//li[text()='My Profile']")
	private WebElement MyProfile_link;
	
	@FindBy(xpath="//li[text()='Change Password']")
	private WebElement chnfPwd_link;
	
	@FindBy(xpath="//li[text()='Fund Transfer']")
	private WebElement FundTrnsf_link;
	
	@FindBy(xpath="//li[text()='Statement']")
	private WebElement Statement_link;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getMyAcc_link() {
		return MyAcc_link;
	}

	public WebElement getMyProfile_link() {
		return MyProfile_link;
	}

	public WebElement getChnfPwd_link() {
		return chnfPwd_link;
	}

	public WebElement getFundTrnsf_link() {
		return FundTrnsf_link;
	}

	public WebElement getStatement_link() {
		return Statement_link;
	}

	public WebElement getCstmeHome_Btn() {
		return CstmrHome_Btn;
	}

	public WebElement getCustmrLogout_Btn() {
		return CustmrLogout_Btn;
	}

	public WebElement getMainPageHome_btn() {
		return MainPageHome_btn;
	}

	public WebElement getMainPageStaff_btn() {
		return MainPageStaff_btn;
	}

	@FindBy(xpath="//input[@name='home']")
	private WebElement CstmrHome_Btn;
	
	@FindBy(xpath="//input[@name='logout_btn']")
	private WebElement CustmrLogout_Btn;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement MainPageHome_btn;
	
	@FindBy(xpath="//a[text()='Staff Login']")
	private WebElement MainPageStaff_btn;
}

