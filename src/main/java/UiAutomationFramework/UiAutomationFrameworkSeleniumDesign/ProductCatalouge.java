package UiAutomationFramework.UiAutomationFrameworkSeleniumDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractClasses.AbstractComponent;

public class ProductCatalouge extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (css =".mb-3")
	List<WebElement> products;
	
	@FindBy (css = ".ng-animating")
	WebElement spinnerElement;
	
	
	By productsBy  = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	public List<WebElement> getProductList(){
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getByProductName(String productName) {
		  WebElement prod= getProductList().stream().filter(product -> product.findElement(By.cssSelector("b"))
		            .getText().equals(productName)).findFirst().orElse(null);
		  return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		
		 WebElement prod = getByProductName(productName);
		 prod.findElement(addToCart).click();
		 waitForElementToAppear(toastMessage);
		 waitForElementToDisappear(spinnerElement);
		 
		 
		 
		 
	}
	
	 
 

}
