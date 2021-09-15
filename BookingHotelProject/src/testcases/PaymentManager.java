package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager
{
	@Parameters({"action"})
	@Test
	public void makePayment(String paymentType)
	{
		if(paymentType.equals("instantPayment"))
			System.out.println("Making a instantPayment");
		else
			System.out.println("Pay@Hotel Booking");
	}
	
	@Test
	public void applyDiscount()
	{
		System.out.println("Apply Discount");
	}
}
