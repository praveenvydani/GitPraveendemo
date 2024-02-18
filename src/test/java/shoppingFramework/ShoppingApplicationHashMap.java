package shoppingFramework;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shoppingPageObjects.CartPage;
import shoppingPageObjects.Dashboard;
import shoppingPageObjects.PaymentsPage;
import shoppingResorces.BaseTest;

public class ShoppingApplicationHashMap extends BaseTest {

	@Test (dataProvider = "getData")
	public void processApplication(HashMap<String, String> input) {
		
		Dashboard dash = login.loginApplication(input.get("mail"), input.get("pass"));
		CartPage cart = dash.clickOnItem(input.get("product"));
		boolean itemflag = cart.validateProduct(input.get("product"));
		Assert.assertTrue(itemflag);

		PaymentsPage payment = cart.clickOnCheckout();
		payment.proceedPayments();
	}

	@DataProvider
	public Object[][] getData() {
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("mail", "praveenvydani@gmail.com");
		map1.put("pass", "Praveen@29");
		map1.put("product", "IPHONE 13 PRO");
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("mail", "vydanipraveen@gmail.com");
		map2.put("pass", "Praveen@29");
		map2.put("product", "ADIDAS ORIGINAL");
		

		return new Object[][] { { map1 }, { map2 } };
	}
}
