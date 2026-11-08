package swagpagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class swagloginpage {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"user-name\"]") WebElement username;
	
	@FindBy(xpath="//*[@id=\"password\"]") WebElement password;
	
	@FindBy(xpath="//*[@id=\"login-button\"]") WebElement button;
	
	
	
	

	public swagloginpage(WebDriver driver)// constuctor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String titlemethod()
	{
	String title = driver.getTitle();
	return title;
	
	}
	
	
 public void loginmethod(String un,String pwd)
 {
 username.sendKeys(un);
 password.sendKeys(pwd);
 button.click();
 
 }
 
 public String urlmethod()
 {
	 String actualtitle = driver.getCurrentUrl();
	return actualtitle;
	 
 }

}
