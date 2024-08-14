package pageObjectsModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage2 extends BasePage{
	

	// Constructor
	public LoginPage2(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(id="username")
	WebElement txt_username;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(id="Login")
	WebElement btn_login;
	
	@FindBy(css="input[value='I Agree']")
	WebElement btn_agree;
//	By txt_username_loc = By.id("username");
//	By txt_password_loc = By.id("password");
//	By btn_login_loc = By.id("Login");
//	By btn_agree_loc = By.cssSelector("input[value='I Agree']");
	// Actions

	public void setUsername(String user) {
		txt_username.sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	public void clickAgree(WebDriverWait w) {
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='I Agree']")));
		btn_agree.click();
	}
}
