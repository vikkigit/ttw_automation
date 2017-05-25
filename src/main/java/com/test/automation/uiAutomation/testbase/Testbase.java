package com.test.automation.uiAutomation.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.customelistner.Webeventlistners;
import com.test.automation.uiAutomation.excelreader.Excelreader;

public class Testbase {

	public static final Logger log = Logger.getLogger(Testbase.class.getName());

	public WebDriver dr;
	public EventFiringWebDriver driver;
	public Webeventlistners eventlistner;
	public Properties prop = new Properties();
	public static ExtentReports extent;
	public ExtentTest test;
	Excelreader excel;
	
	static{
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String filename=formater.format(calendar.getTime());
		extent = new ExtentReports(System.getProperty("user.dir")
				+ "/src/main/java/com/test/automation/uiAutomation/config/extentreport/"+filename+".html", false);
	}

	public void init() throws IOException {
		loadpropdata();
	
		selectbrowser(prop.getProperty("browser"));
		driver.manage().window().maximize();
		geturl(prop.getProperty("url"));
		// log 4j properties
		String log4j = "log4j.properties";
		PropertyConfigurator.configure(log4j);

	}

	public void loadpropdata() throws IOException {

		File file = new File(System.getProperty("user.dir")
				+ "/src/test/java/com/test/automation/uiAutomation/addtocart/config.properties");
		FileInputStream f = new FileInputStream(file);
		prop.load(f);

	}

	private void geturl(String url) {
		driver.get(url);

	}

	private void selectbrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			dr = new ChromeDriver();
			driver = new EventFiringWebDriver(dr);
			eventlistner = new Webeventlistners();
			driver.register(eventlistner);

		} else if (browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/driver/operadriver.exe");
			dr = new OperaDriver();
			driver = new EventFiringWebDriver(dr);
			eventlistner = new Webeventlistners();
			driver.register(eventlistner);

		}

	}

	public String[][] getdata(String excelname, String sheetname) {
		String path = System.getProperty("user.dir") + "/src/main/java/com/test/automation/uiAutomation/data/"
				+ excelname;
		excel = new Excelreader(path);
		String[][] data = excel.getDataFromSheet(sheetname, excelname);
		return data;
	}

	public void scrolldown() {
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
	}

	public void scrollup() {
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("scroll(0, -250);");
	}

	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + "the reason is" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName());
			String screen = capturescreen("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName());
		}
	}

	private String capturescreen(String filename) {
		if (filename == "") {
			filename = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/test/automation/uiAutomation/screenshot/";
			destFile = new File(
					(String) reportDirectory + filename + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

	@BeforeMethod()
	public void beforemethod(java.lang.reflect.Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}

	@AfterMethod()
	public void aftermethod(ITestResult result) {
		getresult(result);
	}

	@AfterClass(alwaysRun = true)
	public void endtest() {
		closebrowser();
	}

	public void closebrowser() {
		driver.quit();
		log.info("browser closed");
		extent.endTest(test);
		extent.flush();
	}

	/*
	 * public void getScreenShot(String name){
	 * 
	 * Calendar calendar = Calendar.getInstance(); SimpleDateFormat formater =
	 * new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	 * 
	 * File scrFile = (File)
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * try { String reportDirectory = new
	 * File(System.getProperty("user.dir")).getAbsolutePath() +
	 * "/src/main/java/com/test/automation/uiAutomation/screenshot/"; File
	 * destFile = new File((String) reportDirectory + name + "_" +
	 * formater.format(calendar.getTime()) + ".png");
	 * FileUtils.copyFile(scrFile, destFile); // This will help us to link the
	 * screen shot in testNG report Reporter.log("<a href='" +
	 * destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
	 * + "' height='100' width='200'/> </a>"); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */

	/*
	 * public void waitForPageToLoad(long timeOutInSeconds) {
	 * ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
	 * { public Boolean apply(WebDriver driver) { return ((JavascriptExecutor)
	 * driver).executeScript("return document.readyState").equals("complete"); }
	 * }; try { System.out.println("Waiting for page to load..."); WebDriverWait
	 * wait = new WebDriverWait(driver, timeOutInSeconds);
	 * wait.until(expectation); } catch (Throwable error) { System.out.println(
	 * "Timeout waiting for Page Load Request to complete after " +
	 * timeOutInSeconds + " seconds"); Assert.assertFalse(true,
	 * "Timeout waiting for Page Load Request to complete.");
	 * 
	 * } }
	 * 
	 * public void expliciteWait(WebElement element, int timeToWaitInSec) {
	 * WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
	 * wait.until(ExpectedConditions.visibilityOf(element)); }
	 */

}
