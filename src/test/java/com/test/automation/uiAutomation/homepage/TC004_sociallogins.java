package com.test.automation.uiAutomation.homepage;

import java.io.IOException;
import java.util.Iterator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testbase.Testbase;
import com.test.automation.uiAutomation.uiaction.Homepage;
import com.test.automation.uiAutomation.uiaction.Sociallogins;

public class TC004_sociallogins extends Testbase {

	Sociallogins social;
	Homepage homepage;

	@BeforeClass
	public void setup() throws IOException {
		init();
	}

/*	@Test
	public void signthrough_fb() throws InterruptedException {
		social = new Sociallogins(driver);
		homepage = new Homepage(driver);
		homepage.signin();
		Thread.sleep(4000);
		social.fblink_click();

		Iterator<String> itr = allwindows();
		String parentwindow = itr.next();
		String childwindow = itr.next();
		driver.switchTo().window(childwindow);
		boolean status = social.verifyfb_text();
		Assert.assertEquals(true, status);
		
		social.signin_fb();
		Thread.sleep(5000);
		
		driver.switchTo().window(parentwindow);
		Thread.sleep(5000);

	}
	
	
	@Test(priority=2)
	public void signthrough_tweet() throws InterruptedException{
		homepage.signin();
		Thread.sleep(4000);
		social.twitterlink_click();
		Iterator<String> itr = allwindows();
		String parentwindow = itr.next();
		String childwindow = itr.next();
		driver.switchTo().window(childwindow);
		
		boolean status=social.verifytweet_text();
		Assert.assertEquals(true, status);
		
		social.signin_tweet();
		Thread.sleep(5000);
		
		
		driver.switchTo().window(parentwindow);
		Thread.sleep(5000);
		
		
		homepage.signout();
		Thread.sleep(5000);
		
	}*/
	
	@Test(priority=1)
	public void signthorough_g() throws InterruptedException{
		social = new Sociallogins(driver);
		homepage = new Homepage(driver);
		homepage.signin();
		Thread.sleep(4000);
		social.glink_click();
		
		Iterator<String> itr = allwindows();
		String parentwindow = itr.next();
		String childwindow = itr.next();
		driver.switchTo().window(childwindow);
		
		boolean status=social.verifyg_text();
		Assert.assertEquals(true, status);
		
		social.sigin_gplus();
		Thread.sleep(5000);
		
		driver.switchTo().window(parentwindow);
		Thread.sleep(5000);
		
		
		homepage.signout();
		Thread.sleep(5000);

	}
	

}
