package shoppingFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import shoppingPageObjects.CartPage;
import shoppingPageObjects.Dashboard;
import shoppingPageObjects.PaymentsPage;
import shoppingResorces.BaseTest;

public class ShoppingApplication extends BaseTest{
	
	@Test
	public void processApplication() {
		String mail="praveen.vydani@gmail.com"; 
		String pass="Praveen@29";
		String product="ADIDAS ORIGINAL";
		
		Dashboard dash = login.loginApplication(mail, pass);
		CartPage cart = dash.clickOnItem(product);
		boolean itemflag = cart.validateProduct(product);
		Assert.assertTrue(itemflag);
		
		PaymentsPage payment = cart.clickOnCheckout();
		payment.proceedPayments();
	}
}
