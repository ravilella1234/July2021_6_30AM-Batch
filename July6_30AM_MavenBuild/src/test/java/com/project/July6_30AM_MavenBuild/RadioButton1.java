package com.project.July6_30AM_MavenBuild;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class RadioButton1 extends BaseTest
{

	@BeforeMethod(groups = {"regression","smoke"})
	@Parameters("browser")
	public void beforeMethod(String bType) throws Exception 
	{
		System.out.println("startProcess");
	    init();
	    test = report.createTest("LinksTesting1");
		test.log(Status.INFO, "Loading the Properties Files.....");
				
		launch(bType);
		test.log(Status.INFO, "Opening the browser :-" + prop.getProperty("chromebrowser"));
						
		navigate("radiourl");
		test.log(Status.INFO, "Navigating to application :- " + childProp.getProperty("radiourl"));
	 }
	
	
	@Test(groups = {"regression","smoke"})
	public void radioButton1()
	{
		WebElement radio=driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
		}
	}
 

  @AfterMethod(groups = {"regression","smoke"})
  public void afterMethod() 
  {
	  System.out.println("endProcess");
	  	report.flush();		
		driver.quit();
  }
	
}
