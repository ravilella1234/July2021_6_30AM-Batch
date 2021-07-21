package com.icici.loans.eduloans;

public class StringDemo 
{

	public static void main(String[] args) 
	{
		String s1 = "ravikanth";
		System.out.println(s1);
		System.out.println(s1.length());
		System.out.println(s1.isEmpty());
		System.out.println(s1.charAt(2));
		System.out.println(s1.indexOf('v'));
		
		String s2 = new String("Ravikanth");
		System.out.println(s2);
		
		//Checking for equality
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		
		String s3 = "Ravikan";
		System.out.println(s1.contains(s3));
		
		//lower & upper case conversion
		System.out.println(s3.toLowerCase());
		System.out.println(s3.toUpperCase());
		
		//concatination
		//s2 = s2+s3;
		s2 = s2.concat(s3);
		System.out.println(s2);
		
		//SubString
		System.out.println(s2.substring(2, 7));
		
		//Replace 
		System.out.println(s1);
		System.out.println(s1.replace('r', 'K'));
		
		System.out.println(s1.startsWith("Ravi"));
		System.out.println(s1.replace('r', 'R').startsWith("Ravi"));
		System.out.println(s1.endsWith("nth"));
		
		String s4 = " Ravikanth";
		System.out.println(s4);
		//System.out.println(s4.trim());
		System.out.println(s1.equals(s4));
		System.out.println(s1.equals(s4.trim()));
		System.out.println(s1.equals(s4.trim().replace('R', 'r')));
		System.out.println(s1.equals(s4.trim().toLowerCase()));
		
		//splitting the strings
		String s5 = "ravi kanth lella";
		System.out.println(s5);
		String[] str = s5.split(" ");
		for(String s :str)
		{
			System.out.println(s);
		}
		
	}

}
