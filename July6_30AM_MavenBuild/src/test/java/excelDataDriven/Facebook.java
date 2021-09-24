package excelDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		ExcelAPI e = new ExcelAPI("C:\\Users\\ravi\\Desktop\\testdata1.xlsx");
		
		driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "UserName", 1));
		
		driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "password", 1));

	}

}
