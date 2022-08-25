package com.Bidvest_Online_Banking_Generic;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BidvestOnlineBanking.comcast.genericUtility.BaseClass;


public class IListeners extends BaseClass implements ITestListener{
//	JavaUtility jLib= new JavaUtility();
	
    public void onTestFailure(ITestResult result) {
    	String scriptName=result.getMethod().getMethodName();
    	wLib.capturescreenshot(driver,scriptName+".png");
    }
}