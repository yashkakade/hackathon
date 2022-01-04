package com.InterestAmount.Testcases;

 


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.InterestAmount.pages.LoanAmountCalculatorUICheck;

 

public class LoanAmountCalculatorUICheckTestcases extends LoanAmountCalculatorUICheck
{
	/*
	 *  Open browser and navigate to the test URL by calling method and using testNG
	 */
    @BeforeTest(groups = "Smoke Test")
    public void openBrowsertestCase() 
    {
        try
        {
            openBrowser();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 1, groups = {"UICheck","Smoke Test"})
    public void testloancalcnavigate()
    {
        try
        {
            loanCalcNavigate();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testEMItextbox() 
    {
        try
        {
            EMICalculatortextbox(); 
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testEMIslidercheck()
    {
        try
        {
            EMICalculatorslidercheck();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testEMIslider()
    {
        try
        {
            EMICalculatorSlider();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testinterestratetextbox() 
    {
        try
        {
            interestRateTextbox(); 
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testinterestrateslider() 
    {
        try
        {
            interestRateSlider();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testinterestrateslidercheck()
    {
        try
        {
            interestRateSliderCheck();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloantermtextbox() 
    {
        try
        {
            loanTenureTextbox();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void testloantermslider()
    {
        try
        {
            loanTenureSlider();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void TestLoanTenureSlidercheck() 
    {
        try
        {
            loanTenureSlidercheck();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void TestFeechargesTextbox()
    {
        try
        {
            feechargesTextbox();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void TestFeechargesSlider() 
    {
        try
        {
            feechargesSlider(); 
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority = 2, groups = {"UICheck","Regression Test"})
    public void TestFeeChargeSliderCheck()
    {
        try
        {
        	feesSliderCheck();
        }
        catch(Exception e)
        {
            reportFail(e.getMessage());
        }
    }
    /*
     * calling the method and adding priority the method using testNG
     */
    @Test(priority=3,groups = "Smoke Test")
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
     * calling the method and adding priority the method using testNG
     */
    @Test(priority=4,groups = "Smoke Test")
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