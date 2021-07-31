package com.icici.loans.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapUserDefineObject 
{

	public static void main(String[] args) 
	{
		Emp e1 = new Emp(100, "ravi1");
		Emp e2 = new Emp(200, "ravi2");
		Emp e3 = new Emp(300, "ravi3");
		Emp e4 = new Emp(400, "ravi4");
		
		//e1.display();
		//e2.display();
		//e3.display();
		//e4.display();
		
		HashMap<Integer, Emp> h = new HashMap<Integer, Emp>();
		h.put(e1.getEno(), e1);
		h.put(e2.getEno(), e2);
		h.put(e3.getEno(), e3);
		h.put(e4.getEno(), e4);
		
		
		Set<Entry<Integer, Emp>> entries = h.entrySet();
		for(Entry<Integer, Emp> e:entries)
		{
			System.out.print(e.getKey() + "---");
			Emp ee = e.getValue();
			ee.display();
			
		}
		
		//Alternative way to print by using Iterators
		 Iterator<Integer> iterator = h.keySet().iterator();
		 while(iterator.hasNext())
		 {
			 Emp e = h.get(iterator.next());
			 e.display();
		 }
	}

}
