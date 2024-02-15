package com.inetBanking.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.NewCustmerPage;
import com.inetBanking.pageObjects.loginPage;

public class TC_NewCustmer_003  extends BaseClass {
	
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		loginPage lp = new loginPage(driver);
		lp.setUserName(username);
		Logger.info(" User name is provided");
		lp.setPassword(password);
		Logger.info(" password is provided");
		lp.clickSubmit();
		
		
		Thread.sleep(3000);
		NewCustmerPage addcust= new NewCustmerPage(driver);
		addcust.clickAddNewCustmer();
		Logger.info("providing customer detials.......");
		addcust.custName("Sayyad");
		addcust.custdob("10", "12", "2001");
		Thread.sleep(3000);
		addcust.custaddr("India");
		addcust.custcity("Pune");
		addcust.custstate("Maharashtra");
		addcust.custpin("411001");
		addcust.custTelephone("856585265");
		String email=randomrstring()+"@gmail.com";
		addcust.custmail(email);
		addcust.custpass("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		Logger.info("Validation Started ......");
		
		boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		
	   if(res==true) {
		   Assert.assertTrue(true);
		   Logger.info("Test Case is Pass");
	   }else {
		   captureScreen(driver,"NewCustmerPage");
		   Logger.info("Test case is fail"
		   		+ ""
		   		+ "");
		   Assert.assertTrue(false);
	   }
		
		
		
	}
	


}
