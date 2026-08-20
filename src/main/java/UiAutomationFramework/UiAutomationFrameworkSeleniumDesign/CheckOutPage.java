package UiAutomationFramework.UiAutomationFrameworkSeleniumDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractClasses.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (css =".action__submit")
	WebElement submit;
	
	@FindBy (css ="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy (xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By countryResults = By.cssSelector(".ta-results");
	
	
	public void SelectCountry(String countryName) {
		
		Actions a = new Actions(driver);	
		a.sendKeys(country, countryName).build().perform();	
		waitForElementToAppear(countryResults);
		selectCountry.click();
		
	}
	
	public ConfirmationPage submitOrder() {
		
		submit.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
		
	}

}
