package SeleniumWithJava;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatusCodeAllLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
       WebDriver driver = new ChromeDriver();
       driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
       for(WebElement link:links) {
    	   String url = link.getAttribute("href");
    	   HttpURLConnection Conn= (HttpURLConnection)new URL(url).openConnection();
    	   Conn.setRequestMethod("HEAD");
    	   Conn.connect();
    	   int rescode = Conn.getResponseCode();
    	   System.out.println("\""+url+"\"" +"--->"+ rescode);
       }
	}

}
