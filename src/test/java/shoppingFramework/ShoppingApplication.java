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
		
		System.out.println("Java Application");
	}
	
	@Test
	public void webApplication() {
		System.out.println("This is sample web application");
	}
	
	@Test
	public void MobileApplication() {
		System.out.println("This is sample mobile application");
	}
	
	@Test
	public void APIApplication() {
		System.out.println("This is sample API application developed by branch");
	}
	
	@Test
	public void mobileAPIApplication() {
		System.out.println("This is sample mobile API application developed by test branch");
	}
	
}
