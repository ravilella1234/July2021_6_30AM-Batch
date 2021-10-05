package pom;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.project.July6_30AM_MavenBuild.BaseTest;

public class POM_001 extends BaseTest
{
	
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String bType) throws Exception 
  {
	    init();
		test = report.createTest("POM_001");
		test.log(Status.INFO, "Loading the Properties Files.....");
		
		launch(bType);
		test.log(Status.INFO, "Opening the browser :-" + prop.getProperty("chromebrowser"));
		
		navigate("automationurl");
		test.log(Status.INFO, "Navigating to application :- " + childProp.getProperty("amazonurl"));
  }
  
  
  @Test
  public void f() 
  {
	  LoginPage page = new LoginPage(driver);
	  page.login();
	  Assert.assertEquals(page.verifyLoginError(),"Authentication failed.");
  }
  

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

}
