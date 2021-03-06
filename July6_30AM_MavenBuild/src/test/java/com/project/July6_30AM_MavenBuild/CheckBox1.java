package com.project.July6_30AM_MavenBuild;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class CheckBox1  extends BaseTest
{
  
	@BeforeMethod(groups = {"regression","smoke","sanity"})
	@Parameters("browser")
	public void beforeMethod(String bType) throws Exception 
	{
		System.out.println("startProcess");
	    init();
	    test = report.createTest("LinksTesting1");
		test.log(Status.INFO, "Loading the Properties Files.....");
				
		launch(bType);
		test.log(Status.INFO, "Opening the browser :-" + prop.getProperty("chromebrowser"));
						
		navigate("chekboxurl");
		test.log(Status.INFO, "Navigating to application :- " + childProp.getProperty("chekboxurl"));
	}
	  
	  
	@Test(groups = {"regression","smoke","sanity"})
	public void checkboxTest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			//System.out.println(check.get(i).isSelected());
		}
	}
 

  @AfterMethod(groups = {"regression","smoke","sanity"})
  public void afterMethod() 
  {
	  System.out.println("endProcess");
	  	report.flush();
		driver.quit();
  }

}
