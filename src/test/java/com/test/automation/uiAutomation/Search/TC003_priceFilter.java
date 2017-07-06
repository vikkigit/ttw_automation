package com.test.automation.uiAutomation.Search;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testbase.Testbase;
import com.test.automation.uiAutomation.uiaction.Productlisting;
import com.test.automation.uiAutomation.uiaction.Search;

public class TC003_priceFilter extends Testbase  {

	Search search;
	Productlisting productlisting;
	
	@BeforeClass
	public void setup() throws IOException{
		init();
	}
	
	@Test
	public void duration_filter() throws InterruptedException{
		productlisting = new Productlisting(driver);
		productlisting.duration_filter(prop.getProperty("duration_high"));
		Thread.sleep(4000);
		productlisting.duration();
		Thread.sleep(2000);
		productlisting.duration_filter(prop.getProperty("duration_low"));
		Thread.sleep(2000);
		productlisting.duration();
		
	}
	
	@Test
	public void price_filter() throws InterruptedException{	
		productlisting = new Productlisting(driver);
		productlisting.price_filter(prop.getProperty("high_sort"));
		Thread.sleep(5000);
		productlisting.price();
		productlisting.price_filter(prop.getProperty("low_sort")); 
		Thread.sleep(4000);
		productlisting.price();
	}
	
	
	
	
}
