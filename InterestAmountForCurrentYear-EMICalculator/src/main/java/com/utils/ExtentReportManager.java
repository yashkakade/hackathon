package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager 
{
	public static ExtentReports report;
    public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports getReportInstance() 
	{
       try
       {
		if (report==null) 
		{
			String reportName = DateUtils.getTimeStamp() + ".html";
			htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "/extend report/" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Browser", "Chrome");

			htmlReporter.config().setDocumentTitle("EMI Calculator Automation Results");
			htmlReporter.config().setReportName("EMI Calculator Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}
       }
       catch(Exception e)
       {
    	   System.out.println(e);
       }

		return report;
     }
}
