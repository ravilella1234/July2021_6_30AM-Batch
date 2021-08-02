package com.cakeProgram;

public class BlackForest extends Cake
{

	public BlackForest() 
	{
		setName("BlackForest");
		setType("Egg");
		setPrice(700);
	}

	@Override
	public void recipe() 
	{
		System.out.println("--- BlackForest Recipe -----");
		System.out.println("Seve together maida & coca Power");
		System.out.println("Add milf & vanilla essance");
		System.out.println("Top up with whipped cream & Cherries");
		System.out.println("Chill & Sever...");
	}

	@Override
	public void myFans() 
	{
		System.out.println("Both Adults & Kids loves me");
	}
	
}
