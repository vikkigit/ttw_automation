package com.test.automation.uiAutomation.aboutus;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testbase.Testbase;
import com.test.automation.uiAutomation.uiaction.Aboutus;
import com.test.automation.uiAutomation.uiaction.Homepage;

public class TC001_aboutus extends Testbase {

	
	
	Homepage homepage;
	Aboutus aboutus;
	
	
	
	@BeforeClass
	public void setup() throws IOException{
		init();
	}
	
	
	@Test
	public void verify_aboutus() throws InterruptedException{
		homepage=new Homepage(driver);
		aboutus=new Aboutus(driver);
		homepage.menuicon();
		homepage.clickonnavigation_menu(prop.getProperty("aboutus_menu"));
		Thread.sleep(4000);
		boolean text=aboutus.verify_aboutus();
		Assert.assertEquals(true, text);
		aboutus.clickon_aboutus_tab(prop.getProperty("HowTheTripWorks"));
		Thread.sleep(3000);
		aboutus.clickon_aboutus_tab(prop.getProperty("Contact"));
		boolean contact_text=aboutus.verify_contact();
		Assert.assertEquals(contact_text, true);
	}
	
	
	
}
