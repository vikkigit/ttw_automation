package com.test.automation.uiAutomation.uiaction;

import java.util.List;

import org.apache.poi.util.IntList;
import org.apache.xmlbeans.impl.xb.xsdschema.LengthDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testbase.Testbase;

public class Experiencepage  extends Testbase{
	
	WebDriver driver;
	
	public	String adventure="Adventure";
	public	String backpack="Backpackers";
	
	public String PR_filter="Price Range";
	
	
	//h3[@class='accordion-toggle collapsed'][contains(text(),'Package Star Rating')]
	
	@FindBy(xpath="//span[@class='generActivetext'][contains(text(),'Adventure')]")
	WebElement adventure_filter;
	
	
	@FindBy(xpath="//img[@data-original-title='Adventure']")
	WebElement adventure_icon;
	
	
	@FindBy(xpath="//li[@class='destinationCategoryHead']/span[contains(text(),Experience)]")
	WebElement experience_pagetitle;
	
	@FindBy(xpath="//a[contains(text(),'Reset Genre')]")
	WebElement reset_genre;
	
	@FindBy(xpath="//button[@id='requirementClose']")
	WebElement close_popup; 
	
	
	
	public Experiencepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean verify_experience(){
		try {
			experience_pagetitle.isDisplayed();
			return true;
		} catch (Exception e) {
		return false;
		}
	}
	
	
	public void select_genre_option(String genre){
		driver.findElement(By.xpath("//span[@class='generActivetext'][contains(text(),'"+genre+"')]")).click();
	}
	
	
	public void select_filtermenu_option(String filtermenu){
		driver.findElement(By.xpath("//h3[@class='accordion-toggle collapsed'][contains(text(),'"+filtermenu+"')]")).click();
	}
	
	
	
	public void close_popup(){
		close_popup.click();
	}
	
	
	public void reset_genre(){
		reset_genre.click();
	}

}
