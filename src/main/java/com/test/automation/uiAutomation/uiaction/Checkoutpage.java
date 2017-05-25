package com.test.automation.uiAutomation.uiaction;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@value='Vikas Sandip Kale']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='checkmain_traveller']")
	WebElement primarytraveller_checkbox;
	
	@FindBy(xpath="//span[@id='select2-cotnfo_1_adult_2-container']")
	WebElement cotraveller_dropdown;
	
	@FindBy(xpath="//ul[@id='select2-cotnfo_1_adult_2-results']//li[2]")
	WebElement select_cotraveller;
	
	@FindBy(xpath="//input[@id='tbtn']")
	WebElement continuetopayment;
	
	@FindBy(xpath="//h1[contains(text(),'Payments')]")
	WebElement payments;
	
	@FindBy(xpath="//input[@id='pay_now']")
	WebElement paynow;
	
	public Checkoutpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
/*	public boolean verify(){
		return username.isDisplayed();
	}*/
	
	public void selecttravellers() throws InterruptedException{
		primarytraveller_checkbox.click();
		Thread.sleep(5000);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		
		cotraveller_dropdown.click();
		Thread.sleep(5000);
		select_cotraveller.click();
		Thread.sleep(5000);
		continuetopayment.click();	
	}
	
	public boolean verify_payment_text(){
		try {
			payments.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public void clickpaynow(){
		paynow.click();
	}
	
	
	
}
