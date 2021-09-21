package testngrunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestcaseRunner 
{

	public static void main(String[] args) 
	{
		TestNG testng = new TestNG();
		
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("loginSuite");
		List<XmlSuite> allSuites = new ArrayList<XmlSuite>();
		allSuites.add(mySuite);
		
		testng.setXmlSuites(allSuites);
		
		XmlTest test = new XmlTest(mySuite);
		test.setName("loginTest");
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("testngrunner.Login"));
		//classes.add(new XmlClass("testngrunner.Login1"));
		//classes.add(new XmlClass("testngrunner.Login1"));
		test.setXmlClasses(classes);
		
		testng.run();
	}

}
