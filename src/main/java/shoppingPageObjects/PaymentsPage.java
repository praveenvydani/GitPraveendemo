package shoppingPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shoppingAbstractClass.AbstractClass;

public class PaymentsPage extends AbstractClass{
	
	WebDriver driver;
	public PaymentsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button")
	List<WebElement> countryList;
	
	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement placeOrder;
	
	@FindBy(xpath = "//td[@class='em-spacer-1']/label[@class='ng-star-inserted']")
	WebElement orderId;
	
	@FindBy(xpath = "(//tr[@class='line-item ng-star-inserted']//div[@class='title'])[1]")
	WebElement title;
	
	public void proceedPayments() {
		selectCountry.sendKeys("Ind");
		WebElement countryButton = countryList.stream().filter(country->country.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		countryButton.click();
		placeOrder.click();
		System.out.println(orderId.getText());
		System.out.println(title.getText());
	}

}
