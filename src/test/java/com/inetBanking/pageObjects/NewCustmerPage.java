package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustmerPage {
	
	WebDriver ldriver;
	
	public NewCustmerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='New Customer']")
	@CacheLookup
	WebElement AddnewCustmer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement Uname;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement gender;
	
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtaddr;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtpinno;

	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;

	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtemailid;

	@FindBy(name="sub")
	@CacheLookup
	WebElement btnsub;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement cpass;
	
	public void clickAddNewCustmer() {
		AddnewCustmer.click();
		
	}
	
	public void custName(String name) {
		Uname.sendKeys(name);
		
	}
	public void custGender(String cgender) {
		gender.click();
		
	}
	public void custdob(String mm, String dd , String yy) {
		
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}
	public void custaddr(String caddr) {
		txtaddr.sendKeys(caddr);
		
	}
	public void custcity(String cCity) {
		txtcity.sendKeys(cCity);
		
	}
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
		
	}
	public void custpin(String cpin) {
		txtpinno.sendKeys(String.valueOf(cpin));
		
	} 
	public void custTelephone(String cphone) {
		 txttelephoneno.sendKeys(cphone);
		
	}
	public void custmail(String cmail) {
		txtemailid.sendKeys(cmail);
		
	}
	public void custpass(String cpwd) {
		cpass.sendKeys(cpwd);
		
	}
	public void custsubmit() {
		btnsub.click();
		
	}
	

	

}
