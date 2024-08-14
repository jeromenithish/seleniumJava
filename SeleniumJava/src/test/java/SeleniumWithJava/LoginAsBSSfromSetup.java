package SeleniumWithJava;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAsBSSfromSetup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:\\test.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("jn@tcs.woolworths.com.au.phuat");
		driver.findElement(By.id("password")).sendKeys("Tcs@1234");
		driver.findElement(By.id("Login")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='I Agree']")));
		driver.findElement(By.cssSelector("input[value='I Agree']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@role='menu']//li[@class='slds-listbox__item'][1]")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul//li//div[@class='setupGear']")).click();

		w.until(ExpectedConditions.presenceOfElementLocated(By.id("all_setup_home")));
		driver.findElement(By.id("all_setup_home")).click();
		Thread.sleep(2000);
		//Window Handling
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(parentWindow);
		driver.close();
		driver.switchTo().window(childWindow);
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.cssSelector("input[title='Search Setup']"));
		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[title='Search Setup']")));
		element.click();
		Thread.sleep(2000);
		//Actions
		Actions a = new Actions(driver);
		a.moveToElement(element).sendKeys("Sruthi UAT BSS").build().perform();
		Thread.sleep(3000);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		//w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"topButtonRow\"]/input[4]")));
		driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[4]")).click();
	}

}
