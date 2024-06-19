package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ReusableFunctions;

public class Homepage extends ReusableFunctions{

	public WebDriver driver;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//summary[@class='header__icon header__icon--summary header__icon--search focus-inset modal__toggle']")
	public WebElement searchIcon;
	
	@FindBy(xpath = "//div[@class ='field has-recommendation']/input[@class='search__input field__input']")
	public WebElement searchBox;
	
	@FindBy(xpath = "//div[@class='field has-recommendation']/button[@class='search__button focus-inset'][1]")
	public WebElement search;
	
	@FindBy(id = "ProductCount")
	public WebElement searchText;
	
	@FindBy(xpath = "//p[@class='title h2 title--primary']")
	public WebElement errorMessage;
	
	public void clickSearchIcon() {
		clickElement(searchIcon);
	}
	
	public void enterSearchBox(String text) {
		setTextToInputField(searchBox, text);
	}
	
	public void clickSearch() {
		clickElement(search);
	}
	
	public boolean checkString(String text) {
		return searchText.getText().contains(text);
	}

	public void goBack() {
		driver.navigate().back();
	}
	
	public boolean checkErrorMessage(String text) {
		return errorMessage.getText().contains(text);
	}
}
