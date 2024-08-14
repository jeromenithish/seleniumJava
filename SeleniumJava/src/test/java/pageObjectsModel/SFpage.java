package pageObjectsModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFpage extends BasePage {

	public SFpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//button[@title='Show Navigation Menu']")
	WebElement objectNav;

	@FindBy(xpath = "//ul[@role='menu']//li[@class='slds-listbox__item'][1]")
	WebElement homeObj;

	@FindBy(xpath = "//button[normalize-space()='Search...']")
	WebElement globalSearch1;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement globalSearch2;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactsTab;

//	@FindBy(css="a[title='" + titleValue + "']")
//	List<WebElement> contacts;

	@FindBy(xpath = "//button[@name='LoginToNetworkAsUser']")
	WebElement loginToExperienceAsUser;

	public void setHomescreen(WebDriverWait w) throws InterruptedException {
		objectNav.click();
		// WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//ul[@role='menu']//li[@class='slds-listbox__item'][1]")));
		homeObj.click();
		Thread.sleep(5000);
	}

	public void searchUser(String user) throws InterruptedException {
		globalSearch1.click();
		Thread.sleep(1000);
		// w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search...']")));
//		Actions a = new Actions(driver);
//		a.moveToElement(globalSearch2).sendKeys(user).sendKeys(Keys.ENTER);
		globalSearch2.sendKeys(user);
		Thread.sleep(2000);
		globalSearch2.sendKeys(Keys.ENTER);

	}

	public void clickOnContactsTab(WebDriverWait w) {

		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search...']")));
		contactsTab.click();
	}

	public void clickOnUser(String user) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[title='" + user + "']")).click();

	}

	public void clickOnLogin() throws InterruptedException {
		Thread.sleep(5000);
		loginToExperienceAsUser.click();
	}

}
