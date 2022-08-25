package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IN_FT_Delbnfry_Page {
	
//	WebDriver driver; // Global driver available
	 public IN_FT_Delbnfry_Page(WebDriver driver) {
	//	 this.driver=driver;
		 PageFactory.initElements(driver, this); 
	 } 
	 
	 
	 @FindBy(name="radio")
	 private WebElement Radio_Btn;
	 
	 @FindBy(xpath="//input[@name='delete_beneficiary']")
	 private WebElement DElBnfry_Btn;

	public WebElement getRadio_Btn() {
		return Radio_Btn;
	}

	public WebElement getDElBnfry_Btn() {
		return DElBnfry_Btn;
	}
	
	public void delete() {
		Radio_Btn.click();
		DElBnfry_Btn.click();
		
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
