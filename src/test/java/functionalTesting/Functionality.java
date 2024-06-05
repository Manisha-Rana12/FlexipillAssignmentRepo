package functionalTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Functionality {

	
	WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		
	    driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://flexipill-ui-new-staging.vercel.app/");
	}
	
	@Test(priority = 0)
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall platinumrx-1o6z5ng']")).sendKeys("1111111111");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//p[text()='Continue']")).click();
		Thread.sleep(2000);          
		
		driver.findElement(By.xpath("//input[@maxlength='1' and @type='text']")).sendKeys("1111");
		
	}
	
	@Test(priority = 1)
	public void addToCart() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//button[@class='Header_cartButton__Giyrb']")).click();
		
		 WebElement element = driver.findElement(By.xpath("//input[@class='Searchbar_searchInput__x6r9u Searchbar_headerSearchInput__IGw_V']"));
		 element.sendKeys("Paracip");
		 element.sendKeys(Keys.ENTER);
		    
		 driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-p platinumrx-8ygzv4'])[1]")).click();
		 
	}
	
	@Test(priority = 2)
	public void createOrder() {
		
		//driver.findElement(By.xpath("//input[@class='Searchbar_searchInput__x6r9u Searchbar_headerSearchInput__IGw_V']")).sendKeys("Montelukast");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//		WebElement scroll = driver.findElement(By.xpath("//button[text()='Place Order']"));
//		
//		js.executeScript("arguments[0].scrollIntoView()", scroll);
//		driver.findElement(By.xpath("//button[@class='Header_cartButton__Giyrb']")).click();
	}
	
	@AfterTest
	public void teardown() {
	 //driver.quit();
	}
}
