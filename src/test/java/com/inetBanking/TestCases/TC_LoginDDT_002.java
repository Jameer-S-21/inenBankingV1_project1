0package com.inetBanking.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.loginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002  extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user , String pwd) throws InterruptedException {
		loginPage  lp = new loginPage(driver);
		lp.setUserName(user);
		Logger.info("username is provide");
		lp.setPassword(pwd);
		Logger.info("password is provide");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.warn("login fail");
		}else {
		   Assert.assertTrue(true);
		   Logger.info("login pass");
		   lp.clickLogout();
		   Thread.sleep(3000);
		   driver.switchTo().alert().accept();
		   driver.switchTo().defaultContent();
		   
		}
		
		
	}
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch (NoAlertPresentException e) {
			return false;
		}
	}
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+ "/src/test/java/com/inetBanking/TestData/loginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount= XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]= XLUtils.getcellData(path, "Sheet1", i, j);
			}
		}
		
	return logindata;
		
	}
	

}
