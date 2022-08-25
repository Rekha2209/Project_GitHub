package com.Bidvest_Online_Banking_Generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

public class IRetryAnalysisClass implements IRetryAnalyzer {

	int counter;
	int retrylimits=3;
	 public boolean retry(ITestResult result)
	 {
		 if(counter<retrylimits) {
			 counter++;
		 return true;
		 }
		 return false;
		 }
	 }
	
	
	
	
	
	
	
	
	
	
	
	

