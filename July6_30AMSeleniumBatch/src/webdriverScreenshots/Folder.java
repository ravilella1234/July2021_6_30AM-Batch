package webdriverScreenshots;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Folder 
{
	public static ExtentReports reports;
	public static String screenshotFolderPath;
	
	public static ExtentReports getReports()
	{
		if(reports == null)
		{
			reports = new ExtentReports();
			//init the report folder
			Date d = new Date();
			String reportsFolder = d.toString().replaceAll(":", "_")+"//screenshots";
			
			screenshotFolderPath = System.getProperty("user.dir")+"//reports//"+reportsFolder;
			System.out.println(screenshotFolderPath);
			String reportFolderPath = System.getProperty("user.dir")+"//reports//"+d.toString().replaceAll(":", "-");	
			System.out.println(reportFolderPath);
			File f = new File(screenshotFolderPath);
			f.mkdirs();
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFolderPath);
			sparkReporter.config().setReportName("Production Regression Testing...");
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setTheme(Theme.STANDARD);
			
			reports.attachReporter(sparkReporter);
		}
		return reports;
	}
	

	public static void main(String[] args) 
	{
		//File f = new File("C:\\Users\\DELL\\Desktop\\July 6_30 AM Batch Drivers\\folder1\\folder2");
		//f.mkdirs();
		
		
		 //String directories = "D:\\a\\b\\c\\d\\e\\f\\g\\h\\i";
	     // File file = new File(directories);
	     // boolean result = file.mkdirs();
	     // System.out.println("Status = " + result);
		
		/*
		 * String projectpath = System.getProperty("user.dir");
		 * System.out.println(projectpath); Date d = new Date(); String reportsFolders =
		 * d.toString().replace(':', '_').replace(' ', '_')+"//screenshots";
		 * System.out.println(reportsFolders);
		 * 
		 * String reportsFolder = projectpath+"//reports//"+reportsFolders;
		 * 
		 * File f= new File(reportsFolder); f.mkdirs();
		 */
		
		Folder.getReports();

	}

}
