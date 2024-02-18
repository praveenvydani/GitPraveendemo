package shoppingResorces;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import shoppingPageObjects.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage login;
	
	public WebDriver initialization() throws IOException {
		
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\shoppingProperties\\webdriver.properties"));
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public List<HashMap<String,String>> getJsonData(String filepath) throws IOException {
		String jsonData = FileUtils.readFileToString(new File(System.getProperty("user.dir")+filepath),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String,String>>>() {
		});
		return data;
	}
	
	@BeforeMethod
	public LoginPage getApplication() throws IOException {
		driver = initialization();
		login = new LoginPage(driver);
		login.getUrl();
		return login;
	}
	
	@AfterMethod
	public void closeBrowse() {
		driver.quit();
	}
	
}
