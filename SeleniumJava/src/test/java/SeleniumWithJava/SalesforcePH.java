package SeleniumWithJava;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesforcePH {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:\\test.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("jn@tcs.woolworths.com.au.phuat");
		driver.findElement(By.id("password")).sendKeys("Tcs@1234");
		driver.findElement(By.id("Login")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='I Agree']")));
		driver.findElement(By.cssSelector("input[value='I Agree']")).click();

		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Show Navigation Menu']")));
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();

		driver.findElement(By.xpath("//ul[@role='menu']//li[@class='slds-listbox__item'][1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("Sruthi UAT BSS");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='People']")).click();
		Thread.sleep(2000);
		boolean bool = driver.findElement(By.xpath("//div[@class='name']")).isDisplayed();
		if (bool == true) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='name']")).click();
		} else {
			System.out.println("Element is not visible");
		}
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div[title='User Detail']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Login']")).click();
//		driver.close();
//		driver.quit();
	}

}
