package com.InterestAmount.homeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.DateUtils;
import com.utils.ExtentReportManager;

public class baseMethods
{
	public WebDriver driver;//driver variable is created
	public String directory = System.getProperty("user.dir");//current working directory 
	public Properties prop;//object of properties 
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	/*******INVOKE's BROWSER****/
	public void invokeBrowser(String browserName) 
	{	
		try 
		{
			if (browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",
						directory + "\\src\\test\\resources\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if (browserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", directory + "\\src\\test\\resources\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		if (prop == null) 
		{
			prop = new Properties();
			try 
			{
				FileInputStream file = new FileInputStream(directory + "\\src\\test\\resources\\ApplicationProperty\\configuration.properties");
				prop.load(file);
			}
			catch (Exception e)
			{
				reportFail(e.getMessage());
				e.printStackTrace();
			}
		}
	}
    
	//THIS METHOD OPEN'S URL
	public void openURL(String webURL)
	{
		try 
		{
			driver.get(prop.getProperty(webURL));
			reportPass(webURL + " Identified Successfully");
		} 
		catch (Exception e) 
		{
			reportFail(e.getMessage());
		}

	}
	
	//IDENTIFYING ELEMENT
	public WebElement getElement(String locatorKey) {
		WebElement element = null;

		try {
			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_ClassName")) {
				element = driver.findElement(By.className(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_LinkText")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_PartialLinkText")) {
				element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));
				logger.log(Status.INFO, "Locator Identified : " + locatorKey);
			} else {
				reportFail("Failing the Testcase, Invalid Locator " + locatorKey);
			}
		}
		catch (Exception e)
		{
            /* IF TEST CASE FAIL'S THIS METHOD REPORTS ERROR */
			reportFail(e.getMessage());
			e.printStackTrace();
		}

		return element;
	}
	
	//CLICKING THE ELEMENT
	public void elementClick(String Key)
	{
		try 
		{
			getElement(Key).click();
			reportPass(Key + " : Element Clicked Successfully");
		} 
		catch (Exception e) 
		{
			reportFail(e.getMessage());
		}
	}
	
	//SLIDER MOVEMENT
	public void dragSlider(String Key)
	{
		try 
		{
			WebElement slider = getElement(Key);
			Actions move = new Actions(driver);
			Action action = (Action) move.dragAndDropBy(slider, 30, 0).build();
			action.perform();
		} 
		catch (Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	//REPORTING FUNCTIONS
	/*1.reportFail()*/
	public void reportFail(String reportString) 
	{
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}
	
	/*2.reportPass()*/
	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

    //CLOSING BROWSE(close() method shall close the browser which is in focus)
	public void closeBrowser() 
	{
		driver.close();
	}

	//QUIT BROWSER(quit() method closes all the active WebDriver instances.)
	public void quitBrowser() {
		driver.quit();
	}
	
	//Capture ScreenShot of Failure case
	public void takeScreenShotOnFailure() 
	{
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		// Get screenshot of the visible part of the web page
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		//store the image
		File destFile = new File(directory + "/Screenshots/" + DateUtils.getTimeStamp() + ".png");
		try
		{
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(directory + "/Screenshots/" + DateUtils.getTimeStamp() + ".png");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
