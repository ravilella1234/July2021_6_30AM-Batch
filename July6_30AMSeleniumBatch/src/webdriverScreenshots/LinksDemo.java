package webdriverScreenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksDemo 
{

	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		String linkName1 = driver.findElement(By.linkText("Customer Service")).getText();
		System.out.println(linkName1);
		
		
		List<WebElement> linkName2 = driver.findElements(By.tagName("a"));
		System.out.println(linkName2.size());
		for(int i=0;i<linkName2.size();i++)
		{
			System.out.println(linkName2.get(i).getText());
		}
		
		
		List<WebElement> linkName3 = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
		System.out.println(linkName3.size());
		for(int j=0;j<linkName3.size();j++)
		{
			System.out.println(linkName3.get(j).getText());
		}
	}

}
