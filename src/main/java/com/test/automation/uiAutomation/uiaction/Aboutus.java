package com.test.automation.uiAutomation.uiaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testbase.Testbase;

public class Aboutus extends Testbase {

	WebDriver driver;

	public String aboutus_menu = "About Us";
	public String HowTheTripWorks="How does TheTripWorks";
	public String WhoWeAre="Who We Are";
	public String Team="Team";
	public String Contact="Contact";
	public String More="More";
	
	
	

	@FindBy(xpath = "//h1[contains(text(),'About TheTripWorks')]")
	WebElement aboutus_text;
	
	@FindBy(xpath="//span[contains(text(),'Pune')]")
	WebElement contact_pune;
	

	public Aboutus(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verify_aboutus() {
		try {
			aboutus_text.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean verify_contact(){
		try {
			contact_pune.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	
	
	public void clickon_aboutus_tab(String tab){
		driver.findElement(By.xpath("//span[@class='aboutNavText'][contains(text(),'"+tab+"')]")).click();
	}

}
