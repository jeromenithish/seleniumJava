package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageObjectsModel.LoginPage2;
import pageObjectsModel.SFpage;

public class TC01_LoginAsAdmin {

	WebDriver driver;

	@BeforeSuite
	void setup() {
//		ChromeOptions options = new ChromeOptions();	
//		options.addArguments("user-data-dir=C:/Users/1361953/AppData/Local/Google/Chrome/User Data");
//		options.addArguments("user-data-dir=C:/Users/1361953/AppData/Local/Google/Chrome/User Data");
//		options.addArguments("profile-directory=Default");  // Or specify a custom profile name

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://test.salesforce.com");
		driver.manage().window().maximize();
	}

	@Test
	void LoginAsAdmin() throws InterruptedException {
		String user = "Akhil NPC";
		LoginPage2 lp = new LoginPage2(driver);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		lp.setUsername("jn@tcs.woolworths.com.au.phuat");
		lp.setPassword("Tcs@1234");
		lp.clickLogin();
		lp.clickAgree(w);
		Thread.sleep(10000);
		SFpage sf = new SFpage(driver);
		sf.setHomescreen(w);
		sf.searchUser(user);
		sf.clickOnContactsTab(w);
		sf.clickOnUser(user);
		sf.clickOnLogin();
	}
	

}
