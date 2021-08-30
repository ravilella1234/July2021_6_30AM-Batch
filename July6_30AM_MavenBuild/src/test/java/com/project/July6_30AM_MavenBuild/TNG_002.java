package com.project.July6_30AM_MavenBuild;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_002 extends BaseTest
{
	
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String bType) throws Exception 
  {
	    init();
		test = report.createTest("TNG_002");
		test.log(Status.INFO, "Loading the Properties Files.....");
		
		launch(bType);
		test.log(Status.INFO, "Opening the browser :-" + prop.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		test.log(Status.INFO, "Navigating to application :- " + childProp.getProperty("amazonurl"));
  }
  
  @Test
  public void f() 
  {
	    selectOption("amazondropoption_id","Books");
		test.log(Status.PASS, "Selecting the option Books By using the locator :-" + orProp.getProperty("amazondropoption_id"));
		
		type("amazonsearchtext_id","Harry Potter");
		test.log(Status.FAIL, "Entered the tedt Harry Potter By using the locator :- " + orProp.getProperty("amazonsearchtext_id"));
		
		click("amazonsearchbutton_xpath");
		test.log(Status.SKIP,"Clicked the element by using the locator :- " + orProp.getProperty("amazonsearchbutton_xpath"));
  }

  @AfterMethod
  public void afterMethod() 
  {
	  report.flush();
	  driver.quit();
  }

}
