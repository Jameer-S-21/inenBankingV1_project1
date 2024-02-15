package com.inetBanking.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.loginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		driver.get(baseURL);
		Logger.info("URL is opened");
		
		loginPage lp= new loginPage(driver);
		lp.setUserName(username);
		Logger.info("Enter UserName");
		
		lp.setPassword(password);
		Logger.info("Enter Password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			Logger.info("login Test Pass");
		}
		else {
			
			captureScreen(driver , "loginTest");
			Assert.assertTrue(false);
			Logger.info("login test Fail");
		}
		
	}

}
