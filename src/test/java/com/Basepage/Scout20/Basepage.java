package com.Basepage.Scout20;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Basepage {
	public WebDriver driver;
	final static Logger logger = Logger.getLogger(Basepage.class);
	String reportsPath = "C:/Projects/RevObseravtions/REVREPORTS";
	public ExtentReports er = new ExtentReports("reportsPath" + "Revtech.html", false, DisplayOrder.NEWEST_FIRST);
	public ExtentTest et = er.startTest("REvtech automation");

	public Basepage(WebDriver driver) {
		this.driver = driver;
	}

	public void click(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}

	public void enterText(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);
	}

	public Timeouts implicityWait() {
		return driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public Timeouts implicitWait(int sec) {
		return driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public WebElement explicitywait(By locator) {
		return new WebDriverWait(driver, 70).until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void explicitywaitclickable(By locator) {
		new WebDriverWait(driver, 70).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void explicitywaitvisabletiy(By locator) {
		new WebDriverWait(driver, 70).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void explicitywaitinvisibality(By locator) {
		new WebDriverWait(driver, 70).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();

	}

	public void getSize(By locator) {
		WebElement element = driver.findElement(locator);
		Dimension size = element.getSize();
		System.out.println("height of the element:" + size.height);
		System.out.println("width of the element:" + size.width);
	}

	public void getCSSvalue(By locator) {
		WebElement element = driver.findElement(locator);
		String Cssfontsize = element.getCssValue("font-size");
		String Csscolor = element.getCssValue("color");
		System.out.println("font size:" + Cssfontsize);
		System.out.println("color of the element:" + Csscolor);
	}

	public void scrollDown(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void scrollDownby(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("windows.scrollTo(0, 500);");
	}

	public void scrollUpby(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("windows.scrollTo(500, 0);");
	}

	public void scrollUp(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}

	public void sleep(long sec) {
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		}

	}

	public void Select(String value, By locator) {
		WebElement element = driver.findElement(locator);
		Select s = new Select(element);
		element.click();
		s.selectByValue(value);
		sleep(5000);
	}

	public void selectOnWait(By locator, String Visabilityoftext)

	{
		WebElement element = driver.findElement(locator);
		Select s = new Select(element);
		element.click();
		s.selectByVisibleText(Visabilityoftext);
		sleep(5000);
	}

	public void screenshot(String stepname) throws IOException {
		String path = "C:\\Projects\\RevObseravtions\\REVSCREENSHOTS";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		FileUtils.copyFile(src, des);
		sleep(4000);
	}

	public void scrollVisiabilityoftext(By locator, String visiableoftext) {
		WebElement element = driver.findElement(locator);
		Select s = new Select(element);
		element.click();
		s.selectByVisibleText(visiableoftext);
		sleep(5000);
	}

	public void Extentpassreports(String stepname) {
		et.log(LogStatus.PASS, stepname + "correct");
	}

	public void ExtentFailreports(String stepname) {
		et.log(LogStatus.FAIL, stepname + "correct");
	}

	public boolean exists(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();

		} catch (Exception e) {
			logger.error("Locator not found " + e.getMessage());
		}

		return false;
	}

	public void getExtentreports() {
		er.flush();
		er.endTest(et);
		er.close();
	}

	public void quit() {
		driver.quit();
	}

}
