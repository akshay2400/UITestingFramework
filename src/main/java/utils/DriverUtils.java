package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverUtils {

	public static WebDriver driver;
	
	public static WebElement clickWithDynamicXpath(String item) {
		WebElement element = driver.findElement(By.xpath("//ul[@class='facets__list list-unstyled']//label[@title=\""+item+"\"]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, -500);");
		element.click();
		return element;
	}
}
