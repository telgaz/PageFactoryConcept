package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import basePage.BasePage;
import utils.ElementUtilPF;

public class LoginPagePF extends BasePage {

	
	WebDriver driver;
	ElementUtilPF elementUtilPF;
	
	//Locators
	
	@FindBy(how=How.ID,using = "username")
	@CacheLookup //page factory use this attribute to catch the element
	WebElement emailID;
	
	@FindBy(how=How.ID,using = "password")
	@CacheLookup 
	WebElement password;
	
	@FindBy(how=How.ID,using = "loginBtn")
	@CacheLookup 
	WebElement loginButton;
	
	public LoginPagePF(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtilPF=new ElementUtilPF(driver);
		
	}
	
	public void doLogin(String username,String pwd) {
		elementUtilPF.waitForElementPresent(emailID);
		emailID.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		
	}
}
