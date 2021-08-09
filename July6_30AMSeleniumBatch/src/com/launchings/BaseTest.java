package com.launchings;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static Properties mainProp;
	public static Properties childProp;
	
	public static void init() throws Exception
	{
		fis = new FileInputStream("data.properties");
		prop = new Properties();
		prop.load(fis);
		
		fis = new FileInputStream("environment.properties");
		mainProp  = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		System.out.println(childProp.getProperty("amazonurl"));
	}
	
	public static void launch(String browser)
	{
		if(prop.getProperty(browser).equals("chrome"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "logs//chromelog.log");
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 24");
			option.addArguments("--disable-notifications");
			option.addArguments("--start-maximized");
			//option.addArguments("--ignore-certificate-errors-spki-list");
			//option.addArguments("--proxy-server=http://192.168.10.1:9090");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
		}
		else if(prop.getProperty(browser).equals("firefox"))
		{
			//Binaries
			//Logs
			//Notifications
			//Certificate errors
			//Proxy Settings
			
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "logs\\firefox.log");
			
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("AugustFFProfile");
			
			//notifications Handling
			profile.setPreference("dom.webnotifications.enabled", false);
			
			//Certificate errors Handling
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			
			//Working with Proxy Settings
			//profile.setPreference("network.proxy.type", 1);
			//profile.setPreference("network.proxy.socks", "192.156.10.1");
			//profile.setPreference("network.proxy.socks_port", 1987);
			
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);

			//Setting the Firefox Binaries path
			//option.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			
			driver = new FirefoxDriver(option);
		}
	}
	
	public static void navigate(String url)
	{
		driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}

}
