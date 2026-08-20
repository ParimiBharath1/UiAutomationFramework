package AbstractClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.CartPage;

public class AbstractComponent {

	WebDriver driver;
	
	 public  AbstractComponent(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy (css = "[routerlink*='/dashboard/cart']")
	 WebElement cartHeaderElement;
	 
	 
	 public void waitForElementToAppear(By findBy) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	 }

	 public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		 Thread.sleep(1000L);
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		  wait.until(ExpectedConditions.invisibilityOf(ele));
	 }
	 
	 
	 public CartPage goToCartPage() {
		 cartHeaderElement.click();
		 CartPage cartPage = new CartPage(driver);
		 return cartPage;
	 }
}
