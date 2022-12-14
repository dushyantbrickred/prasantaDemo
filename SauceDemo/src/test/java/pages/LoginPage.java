package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	static WebDriver driver = null;
	static By userName = By.id("user-name");
	static By passWord = By.id("password");
	static By loginBtn = By.id("login-button");
	
	
	public LoginPage(WebDriver driver){
		LoginPage.driver = driver;
	}
	
	public static String loginUserNameFn(String username){
		driver.findElement(userName).sendKeys(username);
		return username;
	}
	
	public static String loginPassWord(String password){
		driver.findElement(passWord).sendKeys(password);
		return password;
	}
	
	public static void loginBtnFn(){
		driver.findElement(loginBtn).click();
	}
}

