package com.launchings;

import com.aventstack.extentreports.Status;

public class TC_005 extends BaseTest
{
   
	
	public static void main(String[] args) throws Exception 
	{
		init();
		test = report.createTest("TC_005");
		test.log(Status.INFO, "Loading the Properties Files.....");
		
		launch("chromebrowser");
		test.log(Status.INFO, "Opening the browser :-" + prop.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		test.log(Status.INFO, "Navigating to application :- " + childProp.getProperty("amazonurl"));
		
		selectOption("amazondropoption_id","Books");
		test.log(Status.PASS, "Selecting the option Books By using the locator :-" + orProp.getProperty("amazondropoption_id"));
		
		type("amazonsearchtext_id","Harry Potter");
		test.log(Status.FAIL, "Entered the tedt Harry Potter By using the locator :- " + orProp.getProperty("amazonsearchtext_id"));
		
		click("amazonsearchbutton_xpath");
		test.log(Status.SKIP,"Clicked the element by using the locator :- " + orProp.getProperty("amazonsearchbutton_xpath"));
		
		report.flush();
					
	}
}
