package com.test.automation.uiAutomation.homepage;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testbase.Testbase;
import com.test.automation.uiAutomation.uiaction.Homepage;

public class TC002_verifylogin_withvalidcredentials extends Testbase {

	
	Homepage homepage;
	
	
	
	
	@DataProvider(name = "logindata_valid")
	public String[][] gettestdata_valid() {
		String[][] testrecords = getdata("userlogins.xlsx", "validemail");
		return testrecords;

	}
	
	@BeforeTest
	public void setup() throws IOException {
		init();
		
		
	}

	
	
	
	
	@Test(dataProvider="logindata_valid" , enabled=true)
	public void logintest_valid(String email, String password) throws InterruptedException{
		homepage=new Homepage(driver);
		homepage.signin();
		homepage.verifying_valid_login(email, password);	
		homepage.menuicon();
		Thread.sleep(5000);
		
		homepage.clickonnavigation_menu(prop.getProperty("weekendgateways_menu"));
		Thread.sleep(10000);
	//	getScreenShot("testlogin-"+email);
	}
	
	
	
	
	
	
	
}
