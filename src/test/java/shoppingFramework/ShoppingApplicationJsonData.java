package shoppingFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import shoppingPageObjects.CartPage;
import shoppingPageObjects.Dashboard;
import shoppingPageObjects.PaymentsPage;
import shoppingResorces.BaseTest;

public class ShoppingApplicationJsonData extends BaseTest {

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
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData("\\src\\main\\java\\shoppingDataPackage\\ShoppingTestdata.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
}
