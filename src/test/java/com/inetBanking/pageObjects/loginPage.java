package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	
		WebDriver ldriver;
		
		public loginPage(WebDriver rdriver){
			
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
	}
		@FindBy(name="uid")
		@CacheLookup
		WebElement txtUserName;
		
		@FindBy(name="password")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(name="btnLogin")
		@CacheLookup
		WebElement btnLogin;
		
		
		@FindBy(xpath="//a[text()='Log out']")
		@CacheLookup
		WebElement btnLogout;
		
		
		public void setUserName(String uname) {
			txtUserName.sendKeys(uname);
		}
		
		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);
		}
		public void clickSubmit() {
			btnLogin.click();;
		}
		public void clickLogout() {
			btnLogout.click();
		}

}
