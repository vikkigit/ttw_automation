package com.test.automation.uiAutomation.homepage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testbase.Testbase;
import com.test.automation.uiAutomation.uiaction.Homepage;

public class TC001_verifylogin_withinvalidcredentials extends Testbase {

	public static final Logger log = Logger.getLogger(TC001_verifylogin_withinvalidcredentials.class.getName());

	Homepage homepage;
	
	@DataProvider(name = "logindata_invalid")
	public String[][] gettestdata_invalid() {
		String[][] testrecords = getdata("userlogins.xlsx", "invalidemail");
		return testrecords;

	}

	@BeforeClass
	public void setup() throws IOException {
		init();
		
	}


	@Test(dataProvider = "logindata_invalid" , enabled=true)
	public void logintest_invalid(String email, String password) throws InterruptedException  {

		homepage = new Homepage(driver);
		homepage.signin();
		homepage.verifying_invalid_login(email, password);
		Thread.sleep(9000);
		
	}
	


/*	@AfterTest
	public void exit() {
		driver.close();
	}
*/
}
