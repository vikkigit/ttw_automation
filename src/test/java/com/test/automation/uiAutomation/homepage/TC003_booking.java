package com.test.automation.uiAutomation.homepage;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testbase.Testbase;
import com.test.automation.uiAutomation.uiaction.Cartpage;
import com.test.automation.uiAutomation.uiaction.Checkoutpage;
import com.test.automation.uiAutomation.uiaction.Homepage;
import com.test.automation.uiAutomation.uiaction.Productlisting;

public class TC003_booking extends Testbase {

	Productlisting product;
	Homepage homepage;
	Cartpage cartpage;
	Checkoutpage checkout;

	String emailid = "ram";
	String passcode = "ramram";

	@BeforeTest
	public void startup() throws IOException {
		init();
	}

	@Test
	public void selectpackage() throws InterruptedException {

		homepage = new Homepage(driver);
		product = new Productlisting(driver);
		cartpage = new Cartpage(driver);
		checkout = new Checkoutpage(driver);

	/*	homepage.signin();
		Thread.sleep(2000);
		homepage.verifying_valid_login(emailid, passcode);
		Thread.sleep(5000);*/
		homepage.menuicon();
		homepage.clickonnavigation_menu(prop.getProperty("weekendgateways_menu"));
		Thread.sleep(7000);

		product.selectpackage(product.Blissful_Manali);
		 product.booknow(); Thread.sleep(5000);
		 product.fromdate();
		 product.navigate_month(prop.getProperty("next"));
		 
		 product.navigate_month(prop.getProperty("prev"));
		 
		/*
		 *
		 * product.selectdate(product.date); Thread.sleep(5000);
		 * product.popup_booknow(); Thread.sleep(5000);
		 * 
		 * cartpage.checkout();
		 * 
		 * 
		 * 
		 * 
		 * // checkout.selecttravellers(); Thread.sleep(7000);
		 * 
		 * checkout.verify_payment_text(); Thread.sleep(3000);
		 * checkout.clickpaynow();
		 */

	}

	
}
