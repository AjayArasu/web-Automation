package Testing;

import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flipkart {
	public static void main(String[] args) throws AWTException, IOException {
		System.setProperty("webdriver.chrome.driver", "/home/pando-ajay/Documents/chromedriver_linux64/chromedriver");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
//		driver.navigate().back();
//		driver.navigate().forward();
//		driver.findElement(By.xpath("//span[@class='_30XB9F']")).click();	
//		driver.findElement(By.xpath("//div[@class='_2GaeWJ']")).click();
		WebElement mens = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		act.moveToElement(mens).perform();
//		driver.findElement(By.xpath("//span[title='T-Shirts]")).click();
		WebElement tshirt = driver.findElement(By.xpath("(//a[text()='T-Shirts'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(tshirt)).click();
//		Robot rob = new Robot();
//		rob.keyPress(KeyEvent.VK_DOWN);
		driver.findElement(By.xpath("(//li[@class='product-base']/a)[1]")).click();
		Set<String> Handles = driver.getWindowHandles();
		List<String> ls = new ArrayList<String>(Handles);
		driver.switchTo().window(ls.get(1));
		WebElement seller = driver.findElement(By.xpath("//span[contains(text(),'AHP APPAREL PRIVATE LIMITED - SJIT')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", seller);
		js.executeScript("arguments[0].click();", seller );
		File frst = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("/home/pando-ajay/Documents/snaps/image.png");
		FileHandler.copy(frst, dest);
		///span[@class='supplier-productSellerName']
		
		}
}
