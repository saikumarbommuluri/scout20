package com.steps.scout20;

import org.openqa.selenium.WebDriver;

import com.webpages.scout20.Loginpage;

public class Loginstep 
{
	private WebDriver driver;
	public Loginstep(WebDriver driver)
	{
		this.driver=driver;
	}
	public boolean performlogin(String userName ,String password ,String url)
	{
		Loginpage login = new Loginpage(driver);
		login.getURL(url);
		login.doLogin(userName, password);
		return login.verifypage();
		
	}

	
}
