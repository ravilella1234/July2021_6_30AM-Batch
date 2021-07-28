package com.icici.loans.collections;

import java.util.ArrayList;

public class ListDemo 
{

	public static void main(String[] args) 
	{
		ArrayList<Object> a  = new ArrayList<>();
		a.add(10);
		a.add("ravilella");
		a.add(12.34f);
		a.add(10);
		a.add(20);
		a.add(30);
		
		System.out.println(a);
		System.out.println(a.get(1));
		System.out.println(a.indexOf(20));
		
		System.out.println(a.isEmpty());
		System.out.println(a.size());
		a.add(40);
		System.out.println(a);
		
		a.add(1, "sai");
		System.out.println(a);
		
		a.set(2, "ravi");
		System.out.println(a);
		
		System.out.println(a.subList(1, 6));
		
		System.out.println(a.contains("ravi"));
		
		System.out.println(a);
		
		a.remove(1);
		System.out.println(a);
		
		a.remove("ravi");
		System.out.println(a);
		
		a.clear();
		System.out.println(a);
		
	}
}
