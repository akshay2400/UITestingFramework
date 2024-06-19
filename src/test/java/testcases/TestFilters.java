package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pom.SearchItemPage;
import utils.DataproviderArray;
import utils.ExtentRepListener;

//@Listeners(ExtentRepListener.class)
public class TestFilters extends Hooks{

	public SearchItemPage pom;
	
	@DataProvider(name = "excel")
	public String[][] getData(){
		String path = System.getProperty("user.dir")+testConfig.getPath();
		String sheet = testConfig.getSheet();
		return DataproviderArray.getarray(path, sheet);
	}
	
	@Test(priority = 0)
	public void testOpenSite() {
		pom = new SearchItemPage(driver);
		assertEquals(getUrl(driver),testConfig.getUrl());
	}
	
	@Test(priority = 1, dependsOnMethods = "testOpenSite")
	public void testSearchItem() {
		pom.clickSearchIcon();
		pom.enterSearchBox(testConfig.getItem());
		pom.clickSearch();
		assertTrue(pom.checkString(testConfig.getMessage()));
	}
	
	@Test(priority = 2, dependsOnMethods = "testSearchItem",dataProvider = "excel")
	public void testSettingFilters(String filters) {
		assertTrue(pom.clickFilters(filters));
	}
	
	@Test(priority = 2, dependsOnMethods = "testSettingFilters")
	public void testFilters() {
		assertTrue(pom.checkFilters("Hoodie"));
	}
}
