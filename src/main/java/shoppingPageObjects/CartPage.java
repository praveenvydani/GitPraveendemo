package shoppingPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingAbstractClass.AbstractClass;

public class CartPage extends AbstractClass{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(css = ".cartSection h3")
	WebElement product;
	
	@FindBy(css = ".subtotal.cf.ng-star-inserted .btn.btn-primary")
	WebElement checkoutButton;
	
	public boolean validateProduct(String productName) {
		cartButton.click();
		visibilityOfElement(product);
		boolean itemFlag = product.getText().equals(productName);
		return itemFlag;
	}
	
	public PaymentsPage clickOnCheckout() {
		checkoutButton.click();
		return new PaymentsPage(driver);
	}
}
