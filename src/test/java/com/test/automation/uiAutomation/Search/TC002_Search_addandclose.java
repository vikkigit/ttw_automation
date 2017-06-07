package com.test.automation.uiAutomation.Search;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testbase.Testbase;
import com.test.automation.uiAutomation.uiaction.Search;

public class TC002_Search_addandclose extends Testbase {

	Search search;

	@BeforeClass
	public void setup() throws IOException {
		init();
	}

	@Test
	public void addandclose_rooms() throws InterruptedException {
		search = new Search(driver);
		search.search(search.destination);
		Thread.sleep(4000);
		search.members_logo();
		for (int room = 1; room <= 1; room++) {
			search.addroom();
			Thread.sleep(3000);

		}
		scrolldown();
		search.closeroom();
		Thread.sleep(2000);
		search.alert_child_adult();
		Thread.sleep(3000);
		search.close_search();
		Thread.sleep(3000);

		Thread.sleep(4000);
		search.alert_child_adult();
		Thread.sleep(30000);

	}

	@Test(alwaysRun = true)
	public void alertdestination() throws InterruptedException {
		search.clicksearch();
		search.booknow();
		Thread.sleep(3000);
		search.alert_destination();

	}

	@Test(alwaysRun = true)
	public void check_resetdate() throws InterruptedException {

		//search.clicksearch();
		search.dates();

		Thread.sleep(2000);
		search.resetdate();
		Thread.sleep(3000);
	

	}

}
