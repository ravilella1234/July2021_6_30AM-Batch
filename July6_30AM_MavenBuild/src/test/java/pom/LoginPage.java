package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(linkText="Sign in")public WebElement signIn;
	@FindBy(id="email")public WebElement emailAddress;
	@FindBy(id="passwd")public WebElement emailPassword;
	@FindBy(xpath="//button[@id='SubmitLogin']")public WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")public WebElement getLoginError;
	
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void login()
	{
		signIn.click();
		emailAddress.sendKeys("qatest76767@gmail.com");
		emailPassword.sendKeys("password");
		submitLogin.click();
	}
	
	public String verifyLoginError()
	{
		return getLoginError.getText();
	}
}
