package com.test.automation.uiAutomation.uiaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.uiAutomation.testbase.Testbase;

public class Paymentpage extends Testbase {
	WebDriver driver;

	@FindBy(xpath="//span[@id='totalAmount']")
	WebElement amount;
	
	public Paymentpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
/*	public void verifyamount() throws InterruptedException{
		scrollup();
		Thread.sleep(4000);
		amount.isDisplayed();
		if(true){
		String acctualamount=amount.getText();
		Assert.assertEquals(acctualamount, "26725.00");
		}
	
	}*/


	
	
}


