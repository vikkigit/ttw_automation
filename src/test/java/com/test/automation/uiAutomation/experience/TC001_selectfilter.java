package com.test.automation.uiAutomation.experience;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testbase.Testbase;
import com.test.automation.uiAutomation.uiaction.Experiencepage;
import com.test.automation.uiAutomation.uiaction.Homepage;

public class TC001_selectfilter extends Testbase {

	
	@BeforeClass
	public void setup() throws IOException{
		init();
	}
	
	Homepage homepage;
	Experiencepage experience;
	@Test
	public void select_genrefilter() throws InterruptedException{
		experience= new Experiencepage(driver);
		homepage=new Homepage(driver);
		
		
		
		homepage.menuicon();
		homepage.clickonnavigation_menu(prop.getProperty("experience_menu"));
		Thread.sleep(4000);
		boolean titlename=experience.verify_experience();
		
			
		Assert.assertEquals(titlename, true);
//		
//		Thread.sleep(15000);
//		experience.reset_genre();
		experience.select_filtermenu_option(prop.getProperty("PriceRange"));
		Thread.sleep(3000);
		experience.select_genre_option(prop.getProperty("adventure_genre"));
		Thread.sleep(15000);
		
		
		
	
	}
	
	
	
	
}
