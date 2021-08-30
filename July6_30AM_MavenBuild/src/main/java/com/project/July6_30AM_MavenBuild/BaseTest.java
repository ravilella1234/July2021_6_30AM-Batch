package com.project.July6_30AM_MavenBuild;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String projectpath = System.getProperty("user.dir");
	
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
		
		fis = new FileInputStream("or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream("log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report = ExtentManager.getInstance();
	}
	
	public static void launch(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, projectpath+"\\logs\\chromelog.log");
			
			//ChromeOptions option = new ChromeOptions();
			//option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 24");
			//option.addArguments("--disable-notifications");
			//option.addArguments("--start-maximized");
			//option.addArguments("--ignore-certificate-errors-spki-list");
			//option.addArguments("--proxy-server=http://192.168.10.1:9090");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			//Binaries
			//Logs
			//Notifications
			//Certificate errors
			//Proxy Settings
			
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, projectpath+"\\logs\\firefox.log");
			
			//ProfilesIni p = new ProfilesIni();
			//FirefoxProfile profile = p.getProfile("AugustFFProfile");
			
			//notifications Handling
			//profile.setPreference("dom.webnotifications.enabled", false);
			
			//Certificate errors Handling
			//profile.setAcceptUntrustedCertificates(true);
			//profile.setAssumeUntrustedCertificateIssuer(false);
			
			//Working with Proxy Settings
			//profile.setPreference("network.proxy.type", 1);
			//profile.setPreference("network.proxy.socks", "192.156.10.1");
			//profile.setPreference("network.proxy.socks_port", 1987);
			
			
			//FirefoxOptions option = new FirefoxOptions();
			//option.setProfile(profile);

			//Setting the Firefox Binaries path
			//option.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			
			driver = new FirefoxDriver();
		}
	}
	
	public static void navigate(String url)
	{
		driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}
	
	public static void click(String locatorKey) 
	{
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
		getElement(locatorKey).click();
	}

	
	public static void type(String locatorKey, String text) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(text);
		getElement(locatorKey).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
		getElement(locatorKey).sendKeys(option);
	}
	
	public static WebElement getElement(String locatorKey) 
	{
		//check for presence of Element
		if(!isElementPresent(locatorKey)) {
			//report a failure
			System.out.println("Element is not present :" + locatorKey);
		}
		
		//check for visibility of Element
		if(!isElementVisible(locatorKey)) {
			//report a failure
			System.out.println("Element is not visible : " + locatorKey);
		}
		
		WebElement element=null;
		
		element = driver.findElement(getLocator(locatorKey));
		
		/*
		 * if(locatorKey.endsWith("_id")) { element =
		 * driver.findElement(By.id(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_name")) { element =
		 * driver.findElement(By.name(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_classname")) { element =
		 * driver.findElement(By.className(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_xpath")) { element =
		 * driver.findElement(By.xpath(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_css")) { element =
		 * driver.findElement(By.cssSelector(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_linktext")) { element =
		 * driver.findElement(By.linkText(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_partiallinktext")) { element =
		 * driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey))); }
		 */
		return element;
	}

	//true  - visible
	//false - not visible
	public static boolean isElementVisible(String locatorKey) 
	{
		System.out.println("Checking for Visibility of Element : " + locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try 
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
			/*
			 * if(locatorKey.endsWith("_id")) {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_name")) {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_classname")) {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_xpath")) {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_css")) {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
			 * orProp.getProperty(locatorKey)))); }else if(locatorKey.endsWith("_linktext"))
			 * {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_partiallinktext"))
			 * {
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(
			 * orProp.getProperty(locatorKey)))); }
			 */
		} 
		catch (Exception e) 
		{
			return false;
		}
		return true;		
	}

	// true - presence
	// false - not presence
	public static boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Checking for presence of Element : " + locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try 
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			
			/*
			 * if(locatorKey.endsWith("_id")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_name")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_classname")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_xpath")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_css")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_linktext")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_partiallinktext"))
			 * { wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(
			 * orProp.getProperty(locatorKey)))); }
			 */
		} 
		catch (Exception e) 
		{
			return false;
		}
		return true;
	}
	
	public static  By getLocator(String locatorKey) 
	{
		By  by = null;
		
		if(locatorKey.endsWith("_id")) {
			by = By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_classname")) {
			by = By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by = By.xpath(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by = By.cssSelector(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linktext")) {
			by = By.linkText(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(orProp.getProperty(locatorKey));
		}
		
		return by;
	}
	
	
	public static boolean isLinksEqual(String expectedLink) 
	{
		 String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		
		if(actualLink.equals(expectedLink))
			return true;
		else
			return false;
	}
	
	//  ***********************  Reportings *************************
	
	public static void reportFailure(String failMsg) throws Exception 
	{
		test.log(Status.FAIL, failMsg);
		takesScreenshot();
	}

	public static void reportSuccess(String passMsg) 
	{
		test.log(Status.PASS, passMsg);
	}
	
	public static void takesScreenshot() throws Exception
	{
		
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(projectpath+"//failurescreenshots//"+dateFormat));
		
		test.log(Status.INFO, "Screenshot --->" +test.addScreenCaptureFromPath(projectpath+"//failurescreenshots//"+dateFormat));
	}

}
