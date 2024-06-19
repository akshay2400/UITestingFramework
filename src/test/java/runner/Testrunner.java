package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	glue = "stepdefinitions"
	,features = "classpath:features"
//	,tags="@HomePage"
	,plugin = {"pretty",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"timeline:test-output-thread/"}
)
public class Testrunner extends AbstractTestNGCucumberTests {

}