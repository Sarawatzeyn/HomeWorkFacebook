package loginTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openFacebook {
	WebDriver driver;
	@BeforeTest
	public void openApplication() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	@Test
	public void logInTest1() {
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("NurulBhai");
		WebElement password= driver.findElement(By.xpath("//input[@name='pass']"));
		password.clear();
		password.sendKeys("lala");
        driver.findElement(By.xpath("//button[@name='login']")).click();
		
	}
 @Test
 public void assertionTest() {
	 String actualTitle = "Facebook - log in or sign up";
	 String expectedTitle= driver.getTitle();
	 System.out.println("Facebook expected title : " + expectedTitle);
	 Assert.assertEquals(actualTitle,expectedTitle );

	 String actualURL = "https://www.facebook.com/";
	 String expectedURL= driver.getCurrentUrl();
	 System.out.println("Facebook expected URL : " + expectedURL);
	 Assert.assertEquals(actualURL,expectedURL );
 }
 
}
