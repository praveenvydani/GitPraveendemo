package shoppingFramework;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shoppingPageObjects.CartPage;
import shoppingPageObjects.Dashboard;
import shoppingPageObjects.PaymentsPage;
import shoppingResorces.BaseTest;

public class ShoppingApplicationDataObjects extends BaseTest {

	@Test (dataProvider = "getData")
	public void processApplication(String mail, String pass, String product) {
		
		Dashboard dash = login.loginApplication(mail, pass);
		CartPage cart = dash.clickOnItem(product);
		boolean itemflag = cart.validateProduct(product);
		Assert.assertTrue(itemflag);

		PaymentsPage payment = cart.clickOnCheckout();
		payment.proceedPayments();
	}

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "praveenvydani@gmail.com", "Praveen@29", "IPHONE 13 PRO" },
				{ "vydanipraveen@gmail.com", "Praveen@29", "ADIDAS ORIGINAL" } };
	}
}
