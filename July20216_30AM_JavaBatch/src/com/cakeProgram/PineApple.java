package com.cakeProgram;

public class PineApple extends Cake
{

	public PineApple() {
		setName("PineApple");
		setType("Egg");
		setPrice(900);
	}

	@Override
	public void recipe() {
		System.out.println("--- PineApple Recipe ----");
		System.out.println("Take some fresh PineApples");
		System.out.println("Wash them & Grind for 5 Minutes & add some sugar");
		System.out.println("Mix with midha & mixed grinded pineapple mixture");
		System.out.println("bake for 30 Minutes");
		System.out.println("Apply the cream for cake...");
	}

	@Override
	public void myFans() 
	{
		System.out.println("PineApple cake loves by the Children...");
		
	}

}
