package com.Ui.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.CartPage;
import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.CheckOutPage;
import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.ConfirmationPage;
import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.LandingPage;
import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.ProductCatalouge;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {

		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatalouge productCatalouge = landingPage.loginApplication("parimibharath225@gmail.com", "Learn@123");

		// List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addProductToCart(productName);
		CartPage cartPage = productCatalouge.goToCartPage();

		boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);

		CheckOutPage checkOutPage = cartPage.checkoutPage();
		checkOutPage.SelectCountry("india");
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();

		String Confirmmessage = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(Confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		//System.out.print("Done creation of product");

		driver.close();

	}

}
