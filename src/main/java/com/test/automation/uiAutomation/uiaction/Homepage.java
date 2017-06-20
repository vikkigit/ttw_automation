package com.test.automation.uiAutomation.uiaction;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.test.automation.uiAutomation.testbase.Testbase;

import javafx.scene.control.Alert;

public class Homepage extends Testbase {
	
	public static final Logger log=Logger.getLogger(Homepage.class.getName());
	
	public final String weekendgateways="https://thetripworks.com/weekend_getaways";
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@alt='The Trip Works']")
	WebElement logo;
	
	@FindBy(xpath="//a[@class='signinLink'][text()='Log In'] ")
	WebElement signinlink;
	
	@FindBy(xpath="//input[@id='home_username']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='home_password']")
	WebElement password ;
	
	@FindBy(xpath="//input[@value='Sign In']")
	WebElement submitsignin;
	
	@FindBy(xpath="//div[@id='home_username-error']")
	WebElement Authentication_failed;
	
/*	@FindBy(xpath="//div[contains(text(),'Escape to')]")
	WebElement search;*/
	
	
//	@FindBy(xpath="//select[@id='adult_1']/option[contains(text(),'3')]")
	
	@FindBy(xpath="//div[@id='home_username-error'][text()='Please enter valid Email Address.']")
	WebElement nullalert;
	
	@FindBy(xpath="//span[@class='caret']")
	WebElement signout_dropdown;
	
	@FindBy(xpath="//a[text()='Signout']")
	WebElement signout;
	
/*	@FindBy(xpath="//div[@class='searchInput']")
	WebElement mainsearch;*/
	
	@FindBy(xpath="//input[@id='experiencedata']")
	WebElement subsearch;
	
	@FindBy(xpath="//a[@href='https://www.thetripworks.com/search/detail/1642']/button")
	WebElement packagedetails;
	
	
	
	
	@FindBy(xpath="//i[@class='fa fa-bars floatLeft menuIcon']")
	WebElement menuicon;
	
	
	
	
	


	public Homepage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifylogindisplay(){
		try {
			signinlink.isDisplayed();
			String signin=signinlink.getText();
			System.out.println(signin);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	public void logo(){
		boolean display=logo.isDisplayed();
		if(display==true){
			logo.click();
		}
	}
	
	public void verifying_invalid_login(String emailid, String passcode) throws InterruptedException {
		
		log.info("clicking on email:"+email.toString());
		email.sendKeys(emailid);
		log.info("clicking on passwored:"+password.toString());
		password.sendKeys(passcode);
		log.info("clicking on signinbutton:"+submitsignin.toString());
		submitsignin.click();
		Thread.sleep(4000);
		String text1=Authentication_failed.getText();
		log.info("alert text is:"+text1);
	    Assert.assertEquals(text1, "Sorry, unrecognized Email Address or Password");
		signinlink.click();

		
	}
	
	
	public void verifying_valid_login(String emailid, String passcode) throws InterruptedException{
		email.sendKeys(emailid);
		log.info("clicking on passwored:"+password.toString());
		password.sendKeys(passcode);
		log.info("clicking on signinbutton:"+submitsignin.toString());
		submitsignin.click();
		Thread.sleep(10000);
		
	}
	
	
	
	
	
	
	public void menuicon(){
		menuicon.click();
	}
	
	
	
	public void alert_authentication_failed(){
		String text1=Authentication_failed.getText();
		log.info("alert text is:"+text1);
	    Assert.assertEquals(text1, "Sorry, unrecognized Email Address or Password");
	}
	
	public void signout() throws InterruptedException{
		signout_dropdown.click();
		signout.click();
		Thread.sleep(10000);
		
	}
	
	public void signin(){
		signinlink.click();
	}
	
	
	
	

	
	
	
	
	
	/*public void person_alert(){
		driver.findElement(By.xpath("//button[@id='alertify-ok']")).click();
	}*/
	
	
	

	
	
	
// date formate:   Select Friday, Aug 4, 2017
	
	
	
	public void clickonnavigation_menu(String menuname){
		//driver.findElement(By.xpath("//a[contains(text(),'"+menuname+"')]")).click();
		driver.findElement(By.xpath("//a[@href='"+menuname+"']")).click();
		log.info("clicked on :"+menuname+"navigation menu");
	}
	
	


	
	
	
	
	
	

	
	

}
