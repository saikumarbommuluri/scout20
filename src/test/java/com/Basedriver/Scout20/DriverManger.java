package com.Basedriver.Scout20;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManger 
{

    private static WebDriver driver;
	
	public static WebDriver getChromeDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		VerifyBrowserOS();
		return driver;
		
	}
	
	public static WebDriver getfirefoxDriver()
	{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		VerifyBrowserOS();
		return driver;
	}
	
	public static WebDriver getEdgeDriver()
	{
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		VerifyBrowserOS();
		return driver;
	}

	public static WebDriver getIedriver()
	{
		WebDriverManager.iedriver().setup();
		driver= new InternetExplorerDriver();
		VerifyBrowserOS();
		return driver;

	}
	public static WebDriver getheadlesschromedriver()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
		options.addArguments("disable-infobars"); 
		options.addArguments("--disable-extensions"); 
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		VerifyBrowserOS();
		return driver;
	}
	public static WebDriver getheadlessfirefoxdriver()
	{
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1200x600");
		driver = new FirefoxDriver(options);
		VerifyBrowserOS();
		return driver;
	}
	public static WebDriver IEdriver()
	{
		WebDriverManager.iedriver().setup();
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		// this line of code is to resolve protected mode issue
		// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
		// true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		driver = new InternetExplorerDriver();
		VerifyBrowserOS();
		return driver;
	}
	
	public static void VerifyBrowserOS()
	{
		  Capabilities ca = ((RemoteWebDriver)driver).getCapabilities();
		  String browserName = ca.getBrowserName();
		  String browserVersion = ca.getVersion();	  
		  String os = System.getProperty("os.name").toLowerCase();
		  System.out.println("OS = " + os + ", Browser = " + browserName + " "+ browserVersion);
	}


}
