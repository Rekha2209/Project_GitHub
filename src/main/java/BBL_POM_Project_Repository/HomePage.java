package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver; // Global driver available
	 public HomePage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this); 
	 } 
 
 public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

@FindBy(xpath="//li[text()='Open Account']")
 private WebElement OpenAccountButton;
 
 @FindBy(xpath="//li[text()='Apply Debit Card']")
 private WebElement ApplyDebitCardButton ;
 
 @FindBy(xpath="//a[contains(text(),'Internet ')]")
 private WebElement InternetBankingMouseOverElement ;
 
 @FindBy(xpath="//li[text()='Login ']")
 private WebElement InternetBankingLoginButton;
 
 @FindBy(xpath="//li[text()='Register']")
 private WebElement InternetBankingRegisterButton;
 
 @FindBy(xpath="//li[text()='Fund Transfer']")
 private WebElement FundTransferButton ;

public WebElement getOpenAccountButton() {
	return OpenAccountButton;
}

public WebElement getApplyDebitCardButton() {
	return ApplyDebitCardButton;
}

public WebElement getInternetBankingMouseOverElement() {
	return InternetBankingMouseOverElement;
}

public WebElement getInternetBankingLoginButton() {
	return InternetBankingLoginButton;
}

public WebElement getInternetBankingRegisterButton() {
	return InternetBankingRegisterButton;
}

public WebElement getFundTransferButton() {
	return FundTransferButton;
}


 
 
 
 
 
 
 
 
 
 
 
 
 
}
