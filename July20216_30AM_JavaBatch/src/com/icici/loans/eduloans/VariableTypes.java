package com.icici.loans.eduloans;

public class VariableTypes 
{
	//Primitive Variable
	int x = 100; // instance (or) non-static (or) instance-global Variable
	static String cname = "vmware"; //static (or) static-global variable
	static VariableTypes obj;
	
	public void m1()
	{
		int x = 200; //local variable
		System.out.println(x);
		System.out.println(this.x);
		System.out.println(cname);
	}
	
	public static void m2()
	{
		obj = new VariableTypes();
		System.out.println(obj.x);
		System.out.println(VariableTypes.cname);
		
	}

	public static void main(String[] args) 
	{
		//Non-primitive (or) reference Variable
		obj = new VariableTypes();
		System.out.println(obj.x);
		System.out.println(VariableTypes.cname);		
	}

}
