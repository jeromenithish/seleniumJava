package SeleniumWithJava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://woolworths--phuat.sandbox.my.salesforce.com");
       driver.findElement(By.id("username")).sendKeys("jn@tcs.woolworths.com.au.phuat");
       driver.findElement(By.id("password")).sendKeys("Tcs@1234");
       driver.findElement(By.id("Login")).click();
       WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
       w.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[@name='j_id0:j_id2:j_id6']"))));
       driver.findElement(By.xpath("//input[@name='j_id0:j_id2:j_id6']")).click();
       Thread.sleep(10000);
       
       w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Show Navigation Menu']//lightning-primitive-icon[@variant='bare']")));
       driver.findElement(By.xpath("//button[@title='Show Navigation Menu']//lightning-primitive-icon[@variant='bare']")).click();
       driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
       Thread.sleep(3000);
//       Actions act = new Actions(driver);
//       act.click(driver.findElement(By.className("slds-button slds-button_icon slds-button_icon-small slds-button_icon-border")));
//       act.click(driver.findElement(By.id("all_setup_home")));
//       act.perform();
//       driver.close();
       
	}

}
