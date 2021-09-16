package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager
{
	@Parameters({"action"})
	@Test
	public void makePayment(String paymentType,ITestContext context)
	{
		if(paymentType.equals("instantPayment"))
			System.out.println("Making a instantPayment");
		else
			System.out.println("Pay@Hotel Booking");
		
		//Booking Number
		String bookingID = "abcd1234";
		System.out.println(bookingID);
		context.setAttribute("BookingID", bookingID);
	}
	
	@Test
	public void applyDiscount()
	{
		System.out.println("Apply Discount");
	}
}
