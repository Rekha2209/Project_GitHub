package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetLogin_Page {
	public InternetLogin_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@class='customer_id']")
	private WebElement CustomerId_TF;
	
	@FindBy(xpath="//input[@class='password']")
	private WebElement PWD_TF;
	
	@FindBy(xpath="//input[@class='login-btn']")
	private WebElement Login_btn ;

	public WebElement getCustomerId_TF() {
		return CustomerId_TF;
	}

	public WebElement getPWD_TF() {
		return PWD_TF;
	}

	public WebElement getLogin_btn() {
		return Login_btn;
	}
	
	public void IN_login(String custmrId , String Cstmr_Password)
	{
		CustomerId_TF.sendKeys(custmrId);
		PWD_TF.sendKeys(Cstmr_Password);
		Login_btn.click();
	}
	
}
