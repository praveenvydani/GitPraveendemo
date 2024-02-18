package shoppingPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingAbstractClass.AbstractClass;

public class Dashboard extends AbstractClass {
	WebDriver driver;
	public Dashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".card-body")
	List<WebElement> productList;
	
	@FindBy (xpath="//div[@id='toast-container']//div[@role='alert']")
	WebElement alertElement;
	
	public WebElement findElement(String product) {
		visibilityOfElement(productList.get(0));
		WebElement fetchedProduct = productList.stream().filter(item->item.findElement(By.tagName("b")).getText().equalsIgnoreCase(product)).findFirst().orElse(null);
		return fetchedProduct;
	}

	public CartPage clickOnItem(String Product) {
		WebElement productItem = findElement(Product);
		productItem.findElement(By.xpath("button[2]")).click();
//		Thread.sleep(2000l);
		invisibilityOfElement(alertElement);
		return new CartPage(driver);
	}
	
}
