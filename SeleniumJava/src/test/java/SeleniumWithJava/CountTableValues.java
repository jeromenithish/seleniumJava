package SeleniumWithJava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import junit.framework.Assert;

public class CountTableValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
//       driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> values = driver.findElements(By.cssSelector("table[name='courses'] td:nth-child(3)"));
		int sum_course = 0;
		for (WebElement value : values) {
			sum_course += Integer.parseInt(value.getText());
		}

		List<WebElement> values1 = driver.findElements(By.cssSelector("table[id='product'] td:nth-child(4)"));
		int sum_emp = 0;
		for (WebElement value : values1) {
			sum_emp += Integer.parseInt(value.getText());
		}
		String totalAmt = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		String[] AmtArray = totalAmt.split(":");
		int amt = Integer.parseInt(AmtArray[1].trim());

		System.out.println("Course Table--->" + sum_course);
		System.out.println("Product Table--->" + sum_emp);
		System.out.println("Total Amount: " + amt);
		Assert.assertEquals(amt, sum_emp);

	}
}
