package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddToCart {
	
	static WebDriver driver = null;
	static By drpProduct = By.className("product_sort_container");
	static By firstItem = By.xpath("//div[@id='inventory_container']/div[1]/div[1]/div[2]//button[1]");
	
	public AddToCart(WebDriver driver){
		AddToCart.driver = driver;
	}
	
	public static void priceLowToHighFn(){
		Select selectLow = new Select(driver.findElement(drpProduct));
		selectLow.selectByValue("lohi");
		driver.findElement(firstItem).click();
	}

	public static void priceHighToLowFn(){
		Select selectHigh = new Select(driver.findElement(drpProduct));
		selectHigh.selectByValue("hilo");
		driver.findElement(firstItem).click();
	}
}
