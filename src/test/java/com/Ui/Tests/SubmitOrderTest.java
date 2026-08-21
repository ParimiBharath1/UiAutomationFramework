package com.Ui.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ui.TestComponents.BaseTest;

import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.CartPage;
import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.CheckOutPage;
import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.ConfirmationPage;
import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.OrderPage;
import UiAutomationFramework.UiAutomationFrameworkSeleniumDesign.ProductCatalouge;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";
	
	@Test
	public void submitOrder() throws InterruptedException, IOException {

		
 
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

	}
	
	
	@Test(dataProvider = "getData")
	public void submitOrderDataDrivenJson(HashMap<String,String> input) throws InterruptedException, IOException {

		
 
		ProductCatalouge productCatalouge = landingPage.loginApplication(input.get("email"), input.get("password"));

		// List<WebElement> products = productCatalouge.getProductList();
		productCatalouge.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalouge.goToCartPage();

		boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);

		CheckOutPage checkOutPage = cartPage.checkoutPage();
		checkOutPage.SelectCountry("india");
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();

		String Confirmmessage = confirmationPage.getConfirmationMessage();

		Assert.assertTrue(Confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		//System.out.print("Done creation of product");

	}
	
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		//"ZARA COAT 3";
		ProductCatalouge productCatalogue = landingPage.loginApplication("parimibharath225@gmail.com", "Learn@123");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
		
}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//PurchaseOrder.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
	}
	
	
	
	
//	 @DataProvider
//	  public Object[][] getData()
//	  {
//	    return new Object[][]  {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL" } };
//	    
//	  }
//	HashMap<String,String> map = new HashMap<String,String>();
//	map.put("email", "anshika@gmail.com");
//	map.put("password", "Iamking@000");
//	map.put("product", "ZARA COAT 3");
//	
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("email", "shetty@gmail.com");
//	map1.put("password", "Iamking@000");
//	map1.put("product", "ADIDAS ORIGINAL");
	  

}
