package com.test.automation.uiAutomation.Search;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testbase.Testbase;
import com.test.automation.uiAutomation.uiaction.Search;

public class TC001_Search_search extends Testbase {

	Search Search;

	@BeforeClass
	public void setup() throws IOException {
		init();
	}

	@Test
	public void hp() throws InterruptedException {
		Search = new Search(driver);

		scrolldown();
		Thread.sleep(5000);
		Search.search();
		Thread.sleep(5000);
		Search.dates();
		Thread.sleep(5000);
		Search.adult_no(Search.adult);
		Search.select_child(Search.child);
		if (Search.adult == 2 || Search.child >= 2) {
			Search.alert_child_adult();
		} else if (Search.adult == 3 || Search.child >= 1) {
			Search.alert_child_adult();
			Thread.sleep(4000);
		}

		Search.budget(Search.budget);
		Thread.sleep(5000);
		Search.booknow();
		Thread.sleep(9000);

	}

}
