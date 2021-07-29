package com.icici.loans.collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorDemo 
{

	public static void main(String[] args) 
	{
		ArrayList<String> a = new ArrayList<String>();
		a.add("oracle");
		a.add("kosmik");
		a.add("softQ");
		a.add("Oaktech");
		
		System.out.println(a);
		
		ListIterator<String> var = a.listIterator();
		while(var.hasNext())
		{
			String val = var.next();
			if(val.contains("oracle"))
				var.set("GTS");
			else
				var.remove();
		}
		System.out.println(a);
	}

}
