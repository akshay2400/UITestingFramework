package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.openqa.selenium.edge.EdgeOptions;

import utils.DriverUtils;
import utils.TestConfig;

public class ReusableFunctions {
	public WebDriver driver;
	public TestConfig testConfig = ConfigFactory.create(TestConfig.class);
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public WebDriver invokeDriver() {
		
		switch(testConfig.getBrowser()) {
		case "chrome":
			ChromeOptions options1 = new ChromeOptions();
			options1.addArguments("--start-maximized");
			options1.addArguments("--guest");
			options1.addArguments("--disable-notifications");
			driver = new ChromeDriver(options1);
			break;
				
		case "edge":
			EdgeOptions options2 = new EdgeOptions();
			options2.addArguments("--start-maximized");
			options2.addArguments("--guest");
			options2.addArguments("--disable-notifications");
			driver = new EdgeDriver(options2);
			break;
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		DriverUtils.driver = driver;
		return driver;
	}
	
	public void closeDriver() {
		driver.quit();
	}
	
	public static void takeScreenshot(WebDriver driver ,String filepath) {		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(filepath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void navigateToSite(WebDriver webDriver, String url) {
		webDriver.get(url);
	}
	public void waits(int num) {
		try {
			Thread.sleep(num*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void clickElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void setTextToInputField(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}
	
	public String get_Text(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
}
