package com.launchings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public static void init() throws Exception
	{
		FileInputStream fis = new FileInputStream("data.properties");
		prop = new Properties();
		prop.load(fis);
	}
	
	public static void launch(String browser)
	{
		if(prop.getProperty(browser).equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(prop.getProperty(browser).equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
	public static void navigate(String url)
	{
		driver.get(prop.getProperty(url));
	}

}
