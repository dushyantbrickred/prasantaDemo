package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import config.Util;

public class CommonElement {

	static WebDriver driver = null;
	static By cartIco = By.xpath("//div[@id='shopping_cart_container']//a");

	public CommonElement(WebDriver driver){
		CommonElement.driver = driver;
	}

	public static void cartBtnFn(){
		driver.findElement(cartIco).click();
	}

	public static void loginValidationFn(){
		String expText = driver.getTitle();
		
		//System.out.println(expText);
		String actualText = Util.LOGIN_TITLE;
		Assert.assertEquals(expText, actualText);
		System.out.println("Login Successful");
	}

	public static void closeBrowserFn(){
		driver.close();
	}
}
