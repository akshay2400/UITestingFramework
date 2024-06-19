package pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ReusableFunctions;
import utils.DriverUtils;

public class SearchItemPage extends ReusableFunctions {
	
	public WebDriver driver;
	
	public SearchItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

	@FindBy(xpath = "//summary[@class='header__icon header__icon--summary header__icon--search focus-inset modal__toggle']")
	public WebElement searchIcon;
	
	@FindBy(xpath = "//div[@class ='field has-recommendation']/input[@class='search__input field__input']")
	public WebElement searchBox;
	
	@FindBy(xpath = "//div[@class='field has-recommendation']/button[@class='search__button focus-inset'][1]")
	public WebElement search;
	
	@FindBy(xpath = "//ul[@id='product-grid']//p[@class='product-type']")
	public List<WebElement> items;
	
	@FindBy(id = "ProductCount")
	public WebElement searchText;
	
	public void clickSearchIcon() {
		clickElement(searchIcon);
	}
	
	public void enterSearchBox(String text) {
		setTextToInputField(searchBox, text);
	}
	
	public void clickSearch() {
		clickElement(search);
	}
	
	public boolean clickFilters(String item) {
		return isEnabled(DriverUtils.clickWithDynamicXpath(item));
	}
	
	public boolean checkFilters(String item) {
		for(WebElement i:items) {
			System.out.println(i.getText());
		}
		return items.contains(item);
	}
	
	public boolean checkString(String text) {
		return searchText.getText().contains(text);
	}

}
