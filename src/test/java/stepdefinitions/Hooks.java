package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import base.ReusableFunctions;

public class Hooks extends ReusableFunctions{

    public static WebDriver driver;
    @Before
    public void setupdriver(){
    	driver = invokeDriver();
    	navigateToSite(driver,testConfig.getUrl());
    }
    @After
    public void teardown() throws InterruptedException {
    	driver.quit();
    }
}
