package com.test.automation.uiAutomation.uiaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testbase.Testbase;

public class Search extends Testbase{

	public final String fromdate="Select Wednesday, Jun 7, 2017";
	public final String todate="Select Friday, Jun 9, 2017";
	public final int adult=3;
	public final int budget=4;
	public final int child=2;
	
	WebDriver driver;
	
	
	@FindBy(xpath="//input[@placeholder='Where would you like to go?']")
	WebElement searchinput;
	
	@FindBy(xpath="//i[@class='fa fa-search searchIcon']")
	WebElement searchicon;
	
	@FindBy(xpath="//i[@class='fa fa-calendar']")
	WebElement calendar;
	
	@FindBy(xpath="//a[contains(text(),'Next >')]")
	WebElement calendarnext;
	
	
	@FindBy(xpath="//a[contains(text(),'< Prev')]")
	WebElement calendarprev;
	
	
	@FindBy(xpath="//i[@class='fa fa-users']")
	WebElement adult_logo;
	
	
	@FindBy(xpath="//select[@id='adult_1']")
	WebElement adult_dropdown;
	
	
	@FindBy(xpath="//select[@id='kid_1']")
	WebElement child_dropdown;
	
	@FindBy(xpath="//button[@id='validateSearch']")
	WebElement booknow;
	
	@FindBy(xpath="//i[@class='fa fa-money']")
	WebElement budgeticon;
	
	
	@FindBy(xpath="//button[@id='alertify-ok']")
	WebElement alertify;
	
	
	public Search(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void search() throws InterruptedException{
		searchicon.click();
		searchinput.sendKeys("kerala");
		calendar.click();
		
	}
	
	public void calendar_navigation(){
		calendarnext.click();
		calendarnext.click();
		calendarprev.click();
	}
	
	
	public void select_child(int child){
		child_dropdown.click();
		driver.findElement(By.xpath("//select[@id='kid_1']/option[contains(text(),'"+child+"')]")).click();
	}
	
	public void adult_no(int adult){
		adult_logo.click();
		driver.findElement(By.xpath("//select[@id='adult_1']/option[contains(text(),'"+adult+"')]")).click();;
	}
	
	public void alert_child_adult(){
		alertify.click();
	}
	
	
	
	
	public void budget(int budget){
		budgeticon.click();
		driver.findElement(By.xpath("//div[@data-val='"+budget+"']")).click();;
	}
	
	public void select_from_date(String fromdate){
		driver.findElement(By.xpath("//td/a[@title='"+fromdate+"']")).click();;
	}
	
	public void select_to_date(String todate){
		driver.findElement(By.xpath("//td/a[@title='"+todate+"']")).click();;
	}
	
	public void dates() throws InterruptedException{
		select_from_date(fromdate);
		Thread.sleep(3000);
		select_to_date(todate);
		Thread.sleep(2000);
//		booknow.click();
	}
	
	public void booknow(){
		booknow.click();
	}
	
	
	
}
