package com.launchings;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest
{
    private static final Logger log = Logger.getLogger(TC_003.class);
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Loading the Properties Files.....");
		
		launch("chromebrowser");
		log.info("Opening the browser :-" + prop.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		log.info("Navigating to application :- " + childProp.getProperty("amazonurl"));
		
		selectOption("amazondropoption_id","Books");
		log.info("Selecting the option Books By using the locator :-" + orProp.getProperty("amazondropoption_id"));
		
		type("amazonsearchtext_id","Harry Potter");
		log.info("Entered the tedt Harry Potter By using the locator :- " + orProp.getProperty("amazonsearchtext_id"));
		
		click("amazonsearchbutton_xpath");
		log.info("Clicked the element by using the locator :- " + orProp.getProperty("amazonsearchbutton_xpath"));
		
					
		
		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		//loc.sendKeys("Books");
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

	}
}
