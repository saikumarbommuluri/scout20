package com.Basetest.scout20;

import java.io.IOException;
import java.util.jar.JarException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Basedriver.Scout20.DriverManger;
import com.google.gson.JsonParseException;

public class Basetest 
{protected WebDriver driver;
protected String url;
@BeforeMethod
@Parameters({"browser", "testEnvironment"})
public void init(String browser, String url) throws JarException, JsonParseException, IOException {

	this.url= url;
	if (browser.equalsIgnoreCase("chrome")) {
		driver = DriverManger.getChromeDriver();

	} 
	 else if (browser.equalsIgnoreCase("IE")) 
	 {
			driver = DriverManger.IEdriver();
		}
	 else if (browser.equalsIgnoreCase("firefox"))
		{
		driver = DriverManger.getfirefoxDriver();

	}
	 else if (browser.equalsIgnoreCase("edge")) 
	{
		driver = DriverManger.getEdgeDriver();
	}
	else if (browser.equalsIgnoreCase("headlesschrome")) 
	{
		driver = DriverManger.getheadlesschromedriver();
	}
	else if (browser.equalsIgnoreCase("headlessfirefox")) 
	{
		driver = DriverManger.getheadlessfirefoxdriver();
	}

	driver.manage().window().maximize();
}

@AfterMethod
public void kill() {
	if (driver != null)
		driver.quit();
}



}
