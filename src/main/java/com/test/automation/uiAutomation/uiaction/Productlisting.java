package com.test.automation.uiAutomation.uiaction;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testbase.Testbase;

public class Productlisting extends Testbase {

	
	public static final Logger log=Logger.getLogger(Productlisting.class.getName());
	
	public final String  Royal_Coochbehar_Tour="Royal Coochbehar Tour";
	public final String Blissful_Manali="Blissful Manali";
	public final int date=23;
	
	
	
	
	@FindBy(xpath="//button[contains(text(),'Book Now !')]")
	WebElement booknowbutton;
	
	@FindBy(xpath="//input[@id='bookfrom']")
	WebElement fromdate;
	
	@FindBy(xpath="//div/div[2]/div[2]/div[4]/div[5]/div[1]/input[@type='submit']")
	WebElement popup_booknow;
	
	
	
	WebDriver driver;
	
		public Productlisting(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
		
	public void selectpackage(String packagename){
		driver.findElement(By.xpath("//a[contains(text(),'"+packagename+"')]")).click();
		log.info("selected package is :"+packagename);
	}
	
	public void booknow(){
		booknowbutton.click();
	}
	
	public void fromdate(){
		fromdate.click();
	}
	
	public void selectdate(int date) throws InterruptedException{
		fromdate.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'"+date+"')]")).click();
	}
	
	public void popup_booknow(){
		popup_booknow.click();
	}
	
	
}
