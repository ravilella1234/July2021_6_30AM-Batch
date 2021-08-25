package verifications;

import com.aventstack.extentreports.Status;
import com.launchings.BaseTest;

public class Verify3 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test = report.createTest("Verify3");
		test.log(Status.INFO, "Loading the Properties Files.....");
		
		launch("chromebrowser");
		test.log(Status.INFO, "Opening the browser :-" + prop.getProperty("chromebrowser"));
		
		navigate("amazonurl");
		test.log(Status.INFO, "Navigating to application :- " + childProp.getProperty("amazonurl"));
		
		String expectedLink = "Customer Serv";
		
		if(!isLinksEqual(expectedLink))
			reportFailure("Both Links are not equal...");
			//System.out.println("Both Links are not equal...");
		else
			reportSuccess("Both links are equal...");
			//System.out.println("Both links are equal...");
		
		report.flush();

	}

}
