package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CustomerCommunication 
{
	@Test
	public void checkEMail(ITestContext context)
	{
		System.out.println("Checking mail for confirmation");
		String bookingid = (String)context.getAttribute("BookingID");
		System.out.println("Checking mail for confirmation : "+ bookingid);
	}
}
