package com.Ui.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ui.TestComponents.BaseTest;

import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.CartPage;
import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.ProductCatalouge;

public class ErrorValidationsTest extends BaseTest{
	
	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException {

	
		landingPage.loginApplication("parimibharath225@gmail.com", "Learn@123345");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		 ProductCatalouge productCatalogue = landingPage.loginApplication("parimibharath225@gmail.com", "Learn@123");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	

	}

	
	

}
