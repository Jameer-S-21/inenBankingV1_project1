package com.inetBanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String  baseURL= readconfig.getApplicationURL();
	public String username= readconfig.getUsername() ;
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
//		System.setProperty("Webdriver.chrome.driver" , readconfig.getChromepath());
//		driver = new ChromeDriver();
		
		Logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome")) {
			System.setProperty("Webdriver.chrome.driver" , readconfig.getChromepath());
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
		driver.get(baseURL);
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver , String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShots/" +tname+".png" );
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot taken");
	}
	public String randomrstring() {
		String genretedstring = RandomStringUtils.randomAlphabetic(5);
		return(genretedstring);
	}
}
