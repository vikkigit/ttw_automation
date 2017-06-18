package com.test.automation.uiAutomation.uiaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.uiAutomation.testbase.Testbase;

public class Search extends Testbase {

	public final String fromdate = "Select Wednesday, Jul 13, 2017";
	public final String todate = "Select Friday, Jul 15, 2017";
	public final int adult = 3;
	public final int budget = 4;
	public final int child = 2;
	public final String destination = "kerala";
	public final String acctualday="2 Nights / 3 Days";
	
	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Where would you like to go?']")
	WebElement searchinput;

	@FindBy(xpath = "//i[@class='fa fa-search searchIcon']")
	WebElement searchicon;

	@FindBy(xpath = "//i[@class='fa fa-calendar']")
	WebElement calendar;

	@FindBy(xpath = "//a[contains(text(),'Next >')]")
	WebElement calendarnext;

	@FindBy(xpath = "//a[contains(text(),'< Prev')]")
	WebElement calendarprev;

	@FindBy(xpath = "//i[@class='fa fa-users']")
	WebElement adult_logo;

	@FindBy(xpath = "//select[@id='adult_1']")
	WebElement adult_dropdown;

	@FindBy(xpath = "//select[@id='kid_1']")
	WebElement child_dropdown;

	@FindBy(xpath = "//button[@id='validateSearch']")
	WebElement booknow;

	@FindBy(xpath = "//i[@class='fa fa-money']")
	WebElement budgeticon;

	@FindBy(xpath = "//button[@id='alertify-ok']")
	WebElement alertify;

	@FindBy(xpath = "//div[@class='btn-primary addRoomButton']")
	WebElement addroombutton;

	@FindBy(xpath = "//div[@class='roomClose']")
	WebElement closeroomicon;

	@FindBy(xpath = "//button[@id='requirementClose']")
	WebElement cc_close;

	@FindBy(xpath = "//div[@class='searchContainerClose']")
	WebElement searchconatiner_close;

	@FindBy(xpath = "//p[contains(text(),'Oops! You haven’t entered a destination!')]")
	WebElement alert_msg_destination;
	
	@FindBy(xpath="//div[@id='resetDate']")
	WebElement resetdate;
	

	


	public Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void search(String destination) throws InterruptedException {
		searchicon.click();
		searchinput.sendKeys(destination);
		calendar.click();

	}

	public void calendar_navigation() {
		calendarnext.click();
		calendarnext.click();
		calendarprev.click();
	}

	public void select_child(int child) {
		child_dropdown.click();
		driver.findElement(By.xpath("//select[@id='kid_1']/option[contains(text(),'" + child + "')]")).click();
	}

	public void select_adult(int adult) {
		adult_logo.click();
		driver.findElement(By.xpath("//select[@id='adult_1']/option[contains(text(),'" + adult + "')]")).click();
		
	}

	public void alert_child_adult() {
		alertify.click();
	}

	public void members_logo() {
		adult_logo.click();
	}

	public void addroom() {
		addroombutton.click();
	}

	public void closeroom() {
		closeroomicon.click();
	}

	public void budget(int budget) {
		budgeticon.click();
		driver.findElement(By.xpath("//div[@data-val='" + budget + "']")).click();
		;
	}

	public void select_from_date(String fromdate) {
		driver.findElement(By.xpath("//td/a[@title='" + fromdate + "']")).click();
		;
	}

	public void select_to_date(String todate) {
		driver.findElement(By.xpath("//td/a[@title='" + todate + "']")).click();
		
	}

	public void dates() throws InterruptedException {
		select_from_date(fromdate);
		Thread.sleep(3000);
		select_to_date(todate);
		Thread.sleep(2000);
		// booknow.click();
	}
	
	
	public void calendar_click(){
		calendar.click();
	}

	public void booknow() {
		booknow.click();
	}

	public void customercare_close() {
		cc_close.click();
	}

	public void close_search() {
		searchconatiner_close.click();
	}

	public boolean alert_destination() {
		try {
			alert_msg_destination.isDisplayed();
			alert_msg_destination.getText();
			alertify.click();
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	
	public boolean resetdate(){
		try {
			resetdate.isDisplayed();
			resetdate.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void room_alert(){
		alertify.click();
	}
	
	
	
	
	
	
	public void clicksearch(){
		searchicon.click();
	}
	
	
	
	
	

}
