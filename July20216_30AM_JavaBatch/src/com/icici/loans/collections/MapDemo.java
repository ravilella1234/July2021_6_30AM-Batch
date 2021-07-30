package com.icici.loans.collections;

import java.util.Set;
import java.util.TreeMap;

public class MapDemo 
{

	public static void main(String[] args) 
	{
		TreeMap<String, Integer> h = new TreeMap<String, Integer>();
		h.put("ravi", 100);
		h.put("vamsi", 200);
		h.put("anand", 200);
		h.put("sai", 300);
		h.put("anand1", 400);
		
		System.out.println(h);
		System.out.println(h.get("kiran"));
		
		Set<String> keys = h.keySet();
		for(String key:keys)
		{
			System.out.println(key + "----"+ h.get(key));
		}
		
		System.out.println(h.size());
		System.out.println(h.isEmpty());

	}

}
