package com.launchings;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	static ExtentHtmlReporter htmlReport;
	static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(htmlReport==null)
		{
			htmlReport = new ExtentHtmlReporter("D:\\AprilWorkSpace\\July6_30AMSeleniumBatch\\HtmlReports\\report.html");
			htmlReport.config().setDocumentTitle("Automation Report");
			htmlReport.config().setReportName("Functional Testing Report");
			htmlReport.config().setTheme(Theme.STANDARD);
		
			report = new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("OS", "Windows10");
			report.setSystemInfo("Tester Name", "Ravikanth lella");
			report.setSystemInfo("Browser", "Chrome");
		}
		
		return report;
	}

}
