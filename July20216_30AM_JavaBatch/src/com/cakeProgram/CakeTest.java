package com.cakeProgram;

import java.util.Scanner;

public class CakeTest 
{

	public static void main(String[] args) 
	{
		System.out.println("Which cake you would like to Eat (BlackForest/BlueBerry/PineApple)");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		
		CakeFactory cakeFactory = new CakeFactory();
		Cake cake = cakeFactory.createCake(choice);
		cake.aboutCake();
	}

}
