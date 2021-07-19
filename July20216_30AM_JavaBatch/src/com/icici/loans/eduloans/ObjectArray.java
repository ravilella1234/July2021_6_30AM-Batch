package com.icici.loans.eduloans;

public class ObjectArray 
{

	public static void main(String[] args) 
	{
		Student s1 = new Student(1744, "ravilella");
		Student s2 = new Student(1745, "sai");
		Student s3 = new Student(1746, "siva");
		
		//System.out.println(s1);
		//System.out.println(s2);
		//System.out.println(s3);
		
		//int[] a = new int[3];
		
		Student[] st = new Student[3];
		st[0]=s1;
		st[1]=s2;
		st[2]=s3;
		
		for(Student s:st)
		{
			System.out.println(s);
		}
	}
}
