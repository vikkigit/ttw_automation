package com.test.automation.uiAutomation.uiaction;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testbase.Testbase;

public class Productlisting extends Testbase {

	public static final Logger log = Logger.getLogger(Productlisting.class.getName());

	public final String Royal_Coochbehar_Tour = "Royal Coochbehar Tour";
	public final String Blissful_Manali = "Blissful Manali";

	
	
	@FindBy(xpath = "//button[contains(text(),'Book Now !')]")
	WebElement booknowbutton;

	@FindBy(xpath = "//input[@id='bookfrom']")
	WebElement fromdate;

	@FindBy(xpath = "//div/div[2]/div[2]/div[4]/div[5]/div[1]/input[@type='submit']")
	WebElement popup_booknow;

	@FindBy(xpath = "//span[@id='price_low_sort']")
	WebElement low_sort;
	
	@FindBy(xpath="//span[@id='price_high_sort']")
	WebElement high_sort;

	@FindBy(xpath = "//h3[@class='priceRow']")
	WebElement price;

	WebDriver driver;

	public Productlisting(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectpackage(String packagename) {
		driver.findElement(By.xpath("//a[contains(text(),'" + packagename + "')]")).click();
		log.info("selected package is :" + packagename);
	}

	public void booknow() {
		booknowbutton.click();
	}

	public void fromdate() {
		fromdate.click();
	}

	public void selectdate(int date) throws InterruptedException {
		fromdate.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'" + date + "')]")).click();
	}

	public void popup_booknow() {
		popup_booknow.click();
	}

	

	public void price() {
		List<WebElement> amount = driver.findElements(By.xpath("//h3[@class='priceRow']"));
		Iterator<WebElement> itr = amount.iterator();
		while (itr.hasNext()) {
			String amt = itr.next().getText();
			System.out.println(amt);
		}

	}
	
	public void price_filter(String sort){
		driver.findElement(By.xpath("//span[@id='price_"+ sort +"_sort']")).click();;
	}
	//duration_low_sort
	public void duration_filter(String sort){
		driver.findElement(By.xpath("//span[@id='duration_"+sort+"_sort']")).click();
	}
	
	public void duration(){
		List<WebElement> duration=driver.findElements(By.xpath("//div[@class='holidayView']/span[1]"));
		Iterator<WebElement> itr = duration.iterator();
		
		while(itr.hasNext()){
			String days=itr.next().getText();
			System.out.println(days);
		}
		
		
		
		
	}
	
	
	

}
