package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import base.ReusableFunctions;

public class Hooks extends ReusableFunctions{
	
	@BeforeClass
	public void setup() {
		navigateToSite(invokeDriver(),testConfig.getUrl());
    }

	@AfterClass
	public void teardown(){
		driver.quit();
	}
}
