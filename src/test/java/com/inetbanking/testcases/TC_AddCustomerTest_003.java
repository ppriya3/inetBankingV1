package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException {
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	logger.info("Username is Provided");
	lp.setPassword(password);
	logger.info("Password is Provided");
	lp.clickSubmit();
	
	Thread.sleep(3000);
	
	AddCustomerPage addcust=new AddCustomerPage(driver);
	logger.info("Providing the customer details");
	addcust.clickAddNewCustomer();
	addcust.custName("Daksh");
	addcust.custgender("Male");
	addcust.custdob("10","10","1985");
	Thread.sleep(5000);
	
	logger.info("Validation Started");
	addcust.custaddress("INDIA");
	addcust.custcity("Kollam");
	addcust.custstate("Kerala");
	addcust.custpinno("691005");
	addcust.custtelephoneno("9876543218");
	
	String email=randomestring()+"@gmail.com";
	addcust.custemailid(email);
	addcust.custpassword("abcdef");
	addcust.custsubmit();
	
	Thread.sleep(3000);
	
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("Test case is passed");
			}
			else
			{
				captureScreen(driver,"addNewCustomer");
				Assert.assertTrue(false);
				logger.info("Test case is failed");
			}
	}
}
