package com.cakeProgram;

public class CakeFactory implements Factory
{
	Cake cake;
	
	@Override
	public Cake createCake(String cakeName) 
	{
		if(cakeName.equals("BlackForest")) 
		{
			cake = new BlackForest();
		}
		else if(cakeName.equals("BlueBerry"))
		{
			cake = new BlueBerry();
		}
		else if(cakeName.equals("PineApple"))
		{
			cake = new PineApple();
		}
		
		return cake;
	}

}
