package com.webpages.scout20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Basepage.Scout20.Basepage;
import com.constants.scout20.Scout20constants;
import com.pages.scout20.ILoginpage;

public class Loginpage extends Basepage implements ILoginpage
{
	private By username;
	private By password;
	private By Loginbutton;

	public Loginpage(WebDriver driver) 
	{
		super(driver);
		this.username=By.id("username");
		this.password=By.id("password");
		this.Loginbutton=By.xpath(".//*[@data-bind='click: loginSubmitClick']");
		

}

	public boolean verifypage() {
		
		return exists(By.xpath(".//*[@data-bind='click: loginHelpClick']"));
	}

	
	

	
	public void stageURL() 
	{
		driver.get(Scout20constants.LOGIN_Stage_URL);
		
	}

	public void prodURL()
	{
		
		driver.get(Scout20constants.LOGIN_URL_PROD);
	}
	
       public void getURL(String url) 
    {
    	   if (url.contains("stage"))
    	   {
			driver.get(Scout20constants.LOGIN_Stage_URL);
		}
    	   else if (url.contains("prod")) 
    	   {
			driver.get(Scout20constants.LOGIN_URL_PROD);
		}
		}
		
		
	

	@Override
	public void doLogin(String userName, String password) 
	{try 
	{
		setUsername(userName);
		setPassword(password);
		screenshot("login credtinals");
		click(Loginbutton);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}
	
	private void setUsername(String username) 
	{
		enterText(this.username, username);
		
	}
	
	private void setPassword(String password)
	{
		enterText(this.password, password);
	}
}