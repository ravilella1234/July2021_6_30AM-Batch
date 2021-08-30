package com.project.July6_30AM_MavenBuild;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LinksTesting1 extends BaseTest
{
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String bType) throws Exception
	{
		System.out.println("startProcess");
	    init();
	    test = report.createTest("LinksTesting1");
		test.log(Status.INFO, "Loading the Properties Files.....");
				
		launch(bType);
		test.log(Status.INFO, "Opening the browser :-" + prop.getProperty("chromebrowser"));
						
		navigate("googleurl");
		test.log(Status.INFO, "Navigating to application :- " + childProp.getProperty("googleurl"));
	}
	
	
	@Test
	public void linktesting1()
	
	 {
		String expval="Google Images";
		
		driver.findElement(By.linkText("Image")).click();	
		Reporter.log("Clicked on Image Link");
		String actval=driver.getTitle();
		
		Assert.assertEquals(actval, expval);
		
	 }
	
	@AfterMethod
	public void tearDown()
	{
		 System.out.println("endProcess");
		  	report.flush();			
			driver.quit();
	}

}
