package com.launchings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		
		init();
		
		launch("chromebrowser");
		
		navigate("amazonurl");
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sony");
		
		//Thread.sleep(6000);
		
		//driver.findElement(By.name("field-keywords")).clear();
		
		//Thread.sleep(6000);
		
		//driver.findElement(By.className("nav-input")).sendKeys("philips");
		
		//Thread.sleep(6000);
		
		//driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		
		//Thread.sleep(6000);
		
		//driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("samsung");
		
		//driver.findElement(By.linkText("New Releases")).click();
		
		//driver.findElement(By.partialLinkText("New Release")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
				System.out.println(links.get(i).getText());
			}
			
		}
	
	}

}
