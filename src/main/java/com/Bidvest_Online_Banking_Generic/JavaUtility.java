package com.Bidvest_Online_Banking_Generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

/**
 *   it's Contains java specific libraries like getRandomdata & getsystemDate   etc
 * @author Rekha
 *
 */
public class JavaUtility {
	/**
	 * its used to generate the random number with in the range of 1000
	 * @return
	 */
	public static int getRanDomNumber() {
		Random ranDom = new Random();
		int ranDomNum =  ranDom.nextInt(1000);
		return ranDomNum;
	
	}
	/**
	 * its used to get the current system Date and system time
	 * @return 
	 
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		String currentDate = date.toString().replace(" ", " ").replace(":", "_");
		return currentDate;
	
	}
	/**
	 *  its used to get the current system date based on YYYY-MM-DD formate
	 * @return
	 */
	public String  getSystemDate() {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;
	
			String formate = yyyy+"-"+mm+"-"+dd;
			return formate;
	}
	/**
	 *  its used to get the current system date based on DD-MM-YYYY format 
	 * @return
	 */
	public String  getSystemDateInIST() {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		
		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;
	
			String formate = dd+"-"+mm+"-"+yyyy;
			return formate;
	}
	
	public void getRobotClassSystemDate() throws AWTException{
		Robot rbt = new Robot();
		 rbt.keyPress(KeyEvent.VK_1);
		 rbt.keyRelease(KeyEvent.VK_1);
		 rbt.keyPress(KeyEvent.VK_8);
		 rbt.keyRelease(KeyEvent.VK_8);
		 rbt.keyPress(KeyEvent.VK_1);
		 rbt.keyRelease(KeyEvent.VK_1);
		 rbt.keyPress(KeyEvent.VK_8);
		 rbt.keyRelease(KeyEvent.VK_8);
		 
		 rbt.keyPress(KeyEvent.VK_1);
		 rbt.keyRelease(KeyEvent.VK_1);
		 rbt.keyPress(KeyEvent.VK_2);
		 rbt.keyRelease(KeyEvent.VK_2);
	}
	
}
	




