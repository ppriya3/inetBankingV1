package com.inetbanking.testcases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
@Test
public void loginTest()
{
	
	logger.info("URL is opened");
	
	LoginPage lp= new LoginPage(driver);
	lp.setUserName(username);
	logger.info("Entered username");
	lp.setPassword(password);
	logger.info("Entered password");
	lp.clickSubmit();
	
	if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
		logger.info("Login test passed");
	}
	else
	{
		Assert.assertTrue(false);
		logger.info("Login test failed");
	}
	
	}
}
