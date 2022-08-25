package com.BidvestOnlineBanking.comcast.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOExceptionList;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Bidvest_Online_Banking_Generic.ExcelUtility;
import com.Bidvest_Online_Banking_Generic.FileUtility;
import com.Bidvest_Online_Banking_Generic.JavaUtility;
import com.Bidvest_Online_Banking_Generic.WebDriverUtility;
import com.google.common.util.concurrent.Service.State;

import BBL_POM_Project_Repository.CommonLink_Btn_AllPage;
import BBL_POM_Project_Repository.HomePage;
import BBL_POM_Project_Repository.InternetLogin_Page;
import BBL_POM_Project_Repository.StaffLogin_Page;
import BBL_POM_Project_Repository.StafflLogout_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

 /* object creation for Lib*/
 
  public  JavaUtility jLib= new JavaUtility();
  public WebDriverUtility wLib= new WebDriverUtility();
  public FileUtility fLib= new FileUtility(); 
  public ExcelUtility eLib = new ExcelUtility(); 
  public static WebDriver driver;
  
  public int p=1;	
	
	 @BeforeSuite
  
	public void connct_DB() {
		System.out.println("connect to the database"); 
	}
	//@Parameters("browser")
   @BeforeClass
	public void configBC() throws Throwable {
		String BROWSER = fLib.getPropertyKeyValue("browser"); 
		System.out.println("=============Launch the Browser=======");  
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		}
		else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
		}   
	@BeforeMethod
	public void configBM() throws Throwable { 
		/*common Data*/  
		
		String URL = fLib.getPropertyKeyValue("url");  
		//String BROWSER = fLib.getPropertyKeyValue("browser");  
		String StaffId= fLib.getPropertyKeyValue("StaffID");
		String staff_Pwd=fLib.getPropertyKeyValue("psw");
		driver.get(URL);
		  
		// step1: log to the customerLogin and staff login	
/*	if(p<=2) {
CommonLink_Btn_AllPage stafflink=new CommonLink_Btn_AllPage(driver);
stafflink.getMainPageStaff_btn().click();
StaffLogin_Page stafflog=new StaffLogin_Page(driver);
stafflog.IN_login(StaffId, staff_Pwd);
p++;
	}
	else if(p==3)	*/
	{
		
		String CUSTID = fLib.getPropertyKeyValue("customerID"); 
		String CUSTPASSWORD = fLib.getPropertyKeyValue("Password");  
		HomePage hp=new HomePage(driver);
		  WebElement lgn = hp.getInternetBankingMouseOverElement();
		  wLib.mouseOverOnElement(driver, lgn);
		hp.getInternetBankingLoginButton().click();
		InternetLogin_Page custlg= new InternetLogin_Page(driver);
		custlg.IN_login(CUSTID, CUSTPASSWORD);
	}
	}		
		
	@AfterMethod
	public void configAM() { 
	StafflLogout_Page staffout= new StafflLogout_Page(driver);
	staffout.getStafflogout_Btn().click();
		 
		}   
	
	@AfterClass
	public void configAC() {  
		System.out.println("=============Close the Browser======="); 
		driver.quit();  
		}  
	/*@AfterSuite
	public void configAS() { 
		System.out.println("=============close the DB ================");*/
public void captureScreenShoot(String scriptName) throws IOException {
		
TakesScreenshot ts= (TakesScreenshot)driver;
File src = ts.getScreenshotAs(OutputType.FILE);
File dst = new File(".\\screenShots/"+ jLib.getSystemDateAndTime()+scriptName);
try {
	FileUtils.copyFile(src, dst);
	
}
	catch(IOExceptionList e) {
		
	}
System.out.println("Screenshot saved successfully");
	}
	
}		 
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

