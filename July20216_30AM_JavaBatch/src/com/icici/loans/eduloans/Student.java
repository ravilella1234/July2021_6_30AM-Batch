package com.icici.loans.eduloans;

class Student 
{
	int sno;
	String sname;
	
	public Student(int sno, String sname) 
	{
		super();
		this.sno = sno;
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + "]";
	}
	
}
