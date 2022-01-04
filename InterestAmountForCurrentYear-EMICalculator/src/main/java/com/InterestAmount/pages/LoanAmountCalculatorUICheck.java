package com.InterestAmount.pages;

import java.util.concurrent.TimeUnit;

import com.InterestAmount.homeClass.Screenshot;
import com.InterestAmount.homeClass.baseMethods;
import com.aventstack.extentreports.Status;

public class LoanAmountCalculatorUICheck extends baseMethods
{
	Screenshot s = new Screenshot();
	// Open browser and navigate to the test URL
	public void openBrowser() 
	{
		try
		{
			logger = report.createTest("Browser Initialization");
			invokeBrowser("chrome");
			logger.log(Status.INFO, "Browser opened Successfully");
			openURL("webURL");
			logger.log(Status.PASS, "Test Passed");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
        }
	}
    
    // Navigating to the loan amount calculator and clicking on loan amount calculator
	public void loanCalcNavigate()
	{
		try
		{
			logger = report.createTest("Loan Amount Calculator Navigation");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			elementClick("calculatormenu_Xpath");
			elementClick("loancalculator_Xpath");
			driver.navigate().to("https://emicalculator.net/loan-calculator/");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			elementClick("loanAmountCalculator_Id");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(22,3,"Pass");
		  }
			catch(Exception e)
	        {
	            reportFail(e.getMessage());
	            RunScriptWriteExcel.write(22,3,"Fail");
	        }
	}
   
	// checking whether EMI textbox is visible or not
	public void EMICalculatortextbox() 
	{
		try
		{
			logger = report.createTest("EMI Text Box");
			boolean iselementpresent = getElement("emiCheckBox_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("EMI Text Box is Visible");
			} else {
				System.out.println("EMI Text Box is Not Visible");
			}
			s.Screenshots("5", driver);
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(23,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(23,3,"Fail");
        }
	}
	/*
	 * checking whether EMI slider is working or not
	 */
	public void EMICalculatorslidercheck()
	{
		try
		{
			logger = report.createTest("EMI Check Slider");
			dragSlider("emiSlider_Id");
			System.out.println("EMI Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(24,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(24,3,"Fail");
        }
	}
	
	// checking whether EMI slider is visible or not
	public void EMICalculatorSlider() 
	{	
		try
		{
			logger = report.createTest("EMI Slider");
			boolean iselementpresent = getElement("emiSlider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("EMI Slider is Visible");
			} else {
				System.out.println("EMI Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(25,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(25,3,"Fail");
        }
	}
	
	//checking whether interest rate textbox is visible or not 
	public void interestRateTextbox()
	{
		try
		{
			logger = report.createTest("Interest Rate Text Box");
			boolean iselementpresent = getElement("LoanAmountCalculatorInterestRate_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Interest Rate Text Box is Visible");
			} else {
				System.out.println("Interest Rate Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(26,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(26,3,"Fail");
        }
	}

	//checking whether interest rate slider is visible or not
	public void interestRateSlider() {
		try
		{
		    logger = report.createTest("Interest Rate Slider");
			boolean iselementpresent = getElement("LoanAmountCalculatorInterestRateSlider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Interest Rate Slider is Visible");
			} else {
				System.out.println("Interest Rate Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(27,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(27,3,"Fail");
        }
	}

	//checking whether interest rate slider working or not
	public void interestRateSliderCheck() {
		try
		{
			logger = report.createTest("Interest Rate Check Slider");
			dragSlider("LoanAmountCalculatorInterestRateSlider_Id");
			System.out.println("Interest Rate Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(28,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(28,3,"Fail");
        }
	}

	// checking whether loan tenure textbox visible or not
	public void loanTenureTextbox() 
	{
		try
		{
			logger = report.createTest("Loan Term Text Box");
			boolean iselementpresent = getElement("LoanAmountCalculatorLoanTenure_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Tenure Text Box is Visible");
			} else {
				System.out.println("Loan Tenure Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(29,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(29,3,"Fail");
        }
	}
    /*
     * checking whether loan tenure slider visible or not
     */
	public void loanTenureSlider() 
	{
		try
		{
			logger = report.createTest("Loan Tenure Slider");
			boolean iselementpresent = getElement("LoanAmountCalculatorLoanTenureSlider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Loan Tenure Slider is Visible");
			} else {
				System.out.println("Loan Tenure Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(30,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(30,3,"Fail");
        }
	}
   /*
    * checking whether loan tenure slider is working or not
    */
	public void loanTenureSlidercheck()
	{
		try
		{
			logger = report.createTest("Loan Term Check Slider");
			dragSlider("LoanAmountCalculatorLoanTenureSlider_Id");
			System.out.println("Loan Tenure Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(31,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(31,3,"Fail");
        }
	}
    /*
     * checking whether fee & charges textbox is visible or not
     */
	public void feechargesTextbox()
	{
		try
		{
			logger = report.createTest("Fees & Charges Text Box");
			boolean iselementpresent = getElement("LoanAmountCalculatorFee_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Fees & Charges Text Box is Visible");
			} else {
				System.out.println("Fees & Charges Text Box is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(32,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(32,3,"Fail");
        }
	}
	/*
	 * checking whether fee & charges slider is visible or not 
	 */
	public void feechargesSlider() 
	{
		try
		{
			logger = report.createTest("Fees & Charges Slider");
			boolean iselementpresent = getElement("LoanAmountCalculatorFeesSlider_Id").isDisplayed();
			if (iselementpresent == true) {
				System.out.println("Fees & Charges Slider is Visible");
			} else {
				System.out.println("Fees & Charges Slider is Not Visible");
			}
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(33,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(33,3,"Fail");
        }
	}
	/*
	 * checking whether fee & charge slider is working or not 
	 */
	public void feesSliderCheck()
	{
		try
		{
			logger = report.createTest("Fees & Charges Check Slider");
			dragSlider("LoanAmountCalculatorFeesSlider_Id");
			System.out.println("Loan Fees Slider is Checked");
			logger.log(Status.PASS, "Test Passed");
			RunScriptWriteExcel.write(34,3,"Pass");
		}
		catch(Exception e)
        {
            reportFail(e.getMessage());
            RunScriptWriteExcel.write(34,3,"Fail");
        }
	}
	/*
	 * close the browser
	 */
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
	/*
	 * close the report and create new report
	 */
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