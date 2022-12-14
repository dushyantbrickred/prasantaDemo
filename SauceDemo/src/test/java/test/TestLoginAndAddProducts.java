package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddToCart;
import pages.CommonElement;
import pages.LoginPage;

public class TestLoginAndAddProducts {

	LoginPage loginPage = null;
	CommonElement commonElement = null;
	AddToCart addToCart = null;
	
	WebDriver driver = null;
	String pageUrl = Util.BASE_URL;
	
	@BeforeTest
	public void setUpFn(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(pageUrl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginFn(){
		// Object declaration for Login Page.
		loginPage = new LoginPage(driver);
		commonElement = new CommonElement(driver);
		addToCart = new AddToCart(driver);
		
		try {
			Thread.sleep(2000);
			loginPage.loginUserNameFn(Util.USER_NAME);
			loginPage.loginPassWord(Util.PASS_WORD);
			loginPage.loginBtnFn();
			
			commonElement.loginValidationFn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Function declaration for Product List Page. 
		addToCart.priceLowToHighFn();
		addToCart.priceHighToLowFn();
	
		// All common function
		commonElement.cartBtnFn();
	}
	
	@AfterTest
	public void loginFn1(){
		commonElement.closeBrowserFn();
	}
	
}
