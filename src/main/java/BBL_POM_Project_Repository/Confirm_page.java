package BBL_POM_Project_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirm_page {

	public Confirm_page (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="cnfrm-submit")
	private WebElement Conform_btn;
	
	@FindBy (xpath="//input[@class='cnfrm-submit-btn' and @value='Go back']")
	private WebElement Cancel_btn;
	
}
