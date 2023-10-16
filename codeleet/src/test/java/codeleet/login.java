package codeleet;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.Assert;

public class login {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/pando-ajay/Documents/chromedriver_linux64/chromedriver");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notification");
		WebDriver driver = new ChromeDriver(opt);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions act = new Actions(driver);
		driver.get("https://leetcode.com/accounts/login/");
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='input__2o8B '])[1]")));
//		WebElement login = driver.findElement(By.xpath("(//input[@class='input__2o8B '])[1]"));
		wait.until(ExpectedConditions.visibilityOf(login));
		login.sendKeys("ajayvictor");
		WebElement pass = driver.findElement(By.xpath("(//input[@class='input__2o8B '])[2]"));
		pass.sendKeys("Open@123");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement loginbutton = driver.findElement(By.xpath("//button[@id='signin_btn']"));
		js.executeScript("arguments[0].click();", loginbutton);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
		act.moveToElement(until).click();
		String explore = driver.findElement(By.xpath("//a[text()='Explore']")).getText();
		System.out.println(explore);
		Assert.assertEquals(explore, "Explore");
		System.out.println("finished");
		System.out.println("login");
		

	
	}
	
}
