package com.InterestAmount.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.InterestAmount.homeClass.Screenshot;
import com.InterestAmount.homeClass.baseMethods;
import com.aventstack.extentreports.Status;



public class CarLoan extends baseMethods
{   Screenshot s = new Screenshot();
	/*
	 *  Open browser and navigate to the test URL
	 */
	public void openBrowser() 
	{
		try
		{
			logger = report.createTest("Browser Initialization");
			invokeBrowser("chrome");
			logger.log(Status.INFO, "Browser opened Successfully");
			openURL("webURL");
			RunScriptWriteExcel.write(4,3,"Pass");
			logger.log(Status.PASS, "Test Passed");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(4,3,"Fail");
		}
	}
	
	//Send's the CAR LOAN Values
	public void carEMITab() 
	{
		try
		{   
		    logger = report.createTest("Car Loan Calculation");
			elementClick("carloanmenu_Id");
			getElement("loanamount_Id").sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
			getElement("loanamount_Id").sendKeys(prop.getProperty("amount"));
			getElement("loanamount_Id").sendKeys(Keys.ENTER);
			getElement("loaninterest_Id").sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
			getElement("loaninterest_Id").sendKeys(prop.getProperty("interest"));
			getElement("loaninterest_Id").sendKeys(Keys.ENTER);
			getElement("loanterm_Id").sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
			getElement("loanterm_Id").sendKeys(prop.getProperty("tenure"));
			getElement("loanterm_Id").sendKeys(Keys.ENTER);
			s.Screenshots("1", driver);
			logger.log(Status.INFO, "Car Loan Calculated");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(5,3,"Pass");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(5,3,"Fail");
		}
	}
	
	// Print's the  One month PRINCIPLE AMOUNT and INTEREST AMOUNT
	public void getdata() 
	{
		try
		{
			logger = report.createTest("EMI Calculation for a Month");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1500)", "");
			elementClick("year_Id");
			s.Screenshots("2", driver);
			String PA = getElement("PA_Xpath").getText();
			String principle = PA.substring(1,PA.length());
			String IA = getElement("IA_Xpath").getText();
			String interest = IA.substring(1,IA.length());
			String rupees = "Rs.";
			System.out.println("The Principal Amount for One Month is:" + rupees.concat(principle));
			System.out.println("The Interest Amount for One Month is:" + rupees.concat(interest));
			RunScriptWriteExcel.write(6,3,"Pass");
			logger.log(Status.INFO, "EMI Calculated for a month");
			logger.log(Status.PASS, "Test Passed");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
			RunScriptWriteExcel.write(6,3,"Fail");
		}
	}
	//Close Browser
	public void close()
	{
		try
		{
			closeBrowser();
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
    //close the report and  creates new report
	public void endReport() 
	{
		try
		{
			report.flush();
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
}