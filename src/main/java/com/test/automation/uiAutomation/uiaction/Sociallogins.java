package com.test.automation.uiAutomation.uiaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testbase.Testbase;

public class Sociallogins extends Testbase {

	WebDriver driver;

	
	@FindBy(xpath = "//span[@ data-original-title='Instagram']")
	WebElement instalink;

	/*------------------fb--------------------------*/
	@FindBy(xpath = "//div[@class='signinOverly']/div/div/div[1]/div/div/ul/li[1]/a/span")
	WebElement fblink;

	@FindBy(xpath = "//div[contains(text(),'Log in to use your Facebook account with')]")
	WebElement fb_welcomepage;

	@FindBy(xpath = "//input[@id='email']")
	WebElement fb_email;

	@FindBy(xpath = "//input[@id='pass']")
	WebElement fb_pwd;

	@FindBy(xpath = "//input[@id='u_0_2']")
	WebElement fb_loginbutton;
	/*----------end of fb-----------------------------*/

	/*------------twitter----------------*/

	@FindBy(xpath = "//div[@class='signinOverly']/div/div/div[1]/div/div/ul/li[3]/a/span")
	WebElement twitterlink;

	@FindBy(xpath = "//input[@id='username_or_email']")
	WebElement tweet_email;

	@FindBy(xpath = "//input[@id='password']")
	WebElement tweet_pwd;
	
	@FindBy(xpath="//input[@id='allow']")
	WebElement tweet_loginbutton;

	@FindBy(xpath = "//h2[contains(text(),'Authorize thetripworks.com to use your account?')]")
	WebElement tweet_welcomepage;

	/*----------------end of twitter----------------------*/
	
	
	
	/*---------------------g+----------------------*/
	
	@FindBy(xpath = "//div[@class='signinOverly']/div/div/div[1]/div/div/ul/li[2]/a/span")
	WebElement glink;
	
	@FindBy(xpath="//a[contains(text(),'thetripworks.com')]")
	WebElement g_welcomepage;
	
	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement g_email;
	
	@FindBy(xpath="//div[@class='ZFr60d CeoRYc']")
	WebElement g_next;
	
	@FindBy(xpath="//input[@class='whsOnd zHQkBf']")
	WebElement g_pwd;
	
	

	/*-------------------end of g+-------------------------*/
	

	public Sociallogins(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*---------------fb-------------*/

	public void fblink_click() {
		fblink.click();
	}

	public boolean verifyfb_text() {
		try {
			fb_welcomepage.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void signin_fb() throws InterruptedException {
		fb_email.sendKeys("vikkiwiggi@gmail.com");
		fb_pwd.sendKeys("vvv9894502383");
		fb_loginbutton.click();
		Thread.sleep(5000);
	}
   
	
	/*----------------------tweet-------------------*/
	public void twitterlink_click() {
		twitterlink.click();
	}
	
	
	public void signin_tweet() throws InterruptedException{
		tweet_email.sendKeys("vicky24.ttw@gmail.com");
		tweet_pwd.sendKeys("vvv9894502383");
		tweet_loginbutton.click();
		Thread.sleep(5000);
	}
	
	
	public boolean verifytweet_text(){
		try {
			tweet_welcomepage.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*----------------g+--------------------------*/
	
	public void glink_click() {
		glink.click();
	}
	
	
	
	public boolean verifyg_text(){
		try {
			g_welcomepage.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void sigin_gplus(){
		g_email.sendKeys("vicky24.ttw@gmail.com");
		g_next.click();
		g_pwd.sendKeys("vvv9894502383");
		g_next.click();
	}

	/*--------------------insta------------------------------------*/

	public void instalink_click() {
		instalink.click();
	}

}
