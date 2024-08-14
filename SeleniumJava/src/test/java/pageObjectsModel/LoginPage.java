package pageObjectsModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	
	
	// Constructor
	LoginPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	By txt_username_loc = By.id("username");
	By txt_password_loc = By.id("password");
	By btn_login_loc = By.id("Login");
	By btn_agree_loc = By.cssSelector("input[value='I Agree']");
	// Actions

	public void setUsername(String user) {
		driver.findElement(txt_username_loc).sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		driver.findElement(txt_password_loc).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(btn_login_loc).click();
	}
	
	public void clickAgree() {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='I Agree']")));
		driver.findElement(btn_agree_loc).click();
	}
}
