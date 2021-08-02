package com.cakeProgram;

public class BlueBerry extends Cake
{

	public BlueBerry() 
	{
		setName("BlueBerry");
		setType("Egg");
		setPrice(800);
	}

	@Override
	public void recipe() 
	{
		System.out.println("--- BlueBerry Recipe -----");
		System.out.println("First Prepare Flour & Baking Power mixture");
		System.out.println("Add Milk & Eggs Yolks");
		System.out.println("Coat Berries");
		System.out.println("Bake for 30 Minutes...");
		
	}

	@Override
	public void myFans() 
	{
		System.out.println("Moms Loves me");
	}

}
