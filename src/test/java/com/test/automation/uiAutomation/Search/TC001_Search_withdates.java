package com.test.automation.uiAutomation.Search;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testbase.Testbase;
import com.test.automation.uiAutomation.uiaction.Search;

public class TC001_Search_withdates extends Testbase {

	Search Search;

	@BeforeClass
	public void setup() throws IOException {
		init();
	}

	@Test(priority=1)
	public void dest() throws InterruptedException {
		Search = new Search(driver);
		scrolldown();
		Thread.sleep(5000);
		Search.search(Search.destination);
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)
	public void calendar_month_navigation() throws InterruptedException{
		Search = new Search(driver);
		Search.calendar_click();
		Search.calendar_navigation(prop.getProperty("next_month"));
		Thread.sleep(3000);
		boolean next_month_title=Search.month_heading(prop.getProperty("month_title"));
		Assert.assertEquals(next_month_title, true);
		Thread.sleep(3000);
		Search.calendar_navigation(prop.getProperty("prev_month"));
		Thread.sleep(2000);
		boolean prev_month_title=Search.month_heading(prop.getProperty("month_title"));
		Assert.assertEquals(prev_month_title, true);
		Thread.sleep(3000);
	}
	
	
	
	@Test(priority=3)
	public void calendar_select_date1() throws InterruptedException{
		Search=new Search(driver);
		Search.calendar_navigation(prop.getProperty("next_month"));
		Search.dates();
	}
	
	@Test(priority=4)
	public void calendar_reset_date(){
		Search=new Search(driver);
		Search.resetdate();
		
	}
	
	@Test(priority=5)
	public void calendar_select_date2() throws InterruptedException{
		Search=new Search(driver);
		Search.calendar_navigation(prop.getProperty("next_month"));
		Search.dates();
	}
	
	
	@Test(priority=6)
	public void click_search() throws InterruptedException{
		Search=new Search(driver);
		Search.booknow();
		Thread.sleep(5000);
	}
	

	@Test(priority=7)
	public void validate_search(){
		Search=new Search(driver);
		boolean dates= Search.validate_dates();
		Assert.assertEquals(true, dates);
	}
	
	
}
