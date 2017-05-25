package com.test.automation.uiAutomation.uiaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testbase.Testbase;

public class Cartpage extends Testbase{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='cartterms']")
	WebElement termsandcondition;
	
	@FindBy(xpath="//button[contains(text(),'CHECKOUT')]")
	WebElement checkout;

	@FindBy(xpath="//h1[contains(text(),'Blissful Manali')]")
	WebElement packagename;
	
	
	public Cartpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void checkout() throws InterruptedException{
		
		termsandcondition.click();
		checkout.click();
		Thread.sleep(70000);
	}
	
}
