package Resolution;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
	public static String driverPath = "C:/Users/Hp/Downloads/chromedriver_win32 (2)/";
	 public static WebDriver driver;
	 
	
	@BeforeTest
	public void launchbrowser() throws InterruptedException {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.lambdatest.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException {
		WebElement loginbutton = driver.findElement(By.xpath("//*[contains(text(),'Log in')]"));
		loginbutton.click();
		Thread.sleep(4000);
		
		WebElement id = driver.findElement(By.xpath("//input[@type='email']"));
		id.sendKeys("asadkhan153@gmail.com");
		Thread.sleep(4000);
	
		
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("Asad#123");
		Thread.sleep(4000);
		
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
	}
	
	@Test(priority= 2)
	public void verifyAutomationClick() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		WebElement waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='https://automation.lambdatest.com'])[2]")));
		WebElement automation = driver.findElement(By.xpath("(//a[@href='https://automation.lambdatest.com'])[2]"));
		automation.click();
		
		System.out.println("Clciking on !!!!!!");
		Thread.sleep(3000);
		WebElement build = driver.findElement(By.xpath(("//*[@id=\"build_view_accordion-heading-299103\"]/div/a/a/div[1]/div[1]/span")));
		build.click();
	}
//	}
//	
//	@Test
//	
	@Test(priority=3)
	public void verifyresolution1() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		WebElement waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"uncontrolled-tab-example-pane-0\\\"]/div/div[3]/div/div[2]/div/div/span[1]/div/ul/li[6]")));
		
		WebElement resolution = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-pane-0\"]/div/div[3]/div/div[2]/div/div/span[1]/div/ul/li[6]"));
		//resolution.getText()
		Thread.sleep(2000);
		//driver.get("http://www.lambdatest.com");
		String Actualtext = resolution.getText();
		Thread.sleep(2000);
		String ExpectedText = "1024x768";
		Thread.sleep(2000);
		Assert.assertEquals(Actualtext, ExpectedText);
		Thread.sleep(2000);
		System.out.print("Assert passed");
		
		}

	@AfterTest
	private void closewindow() {
		driver.quit();
		
	}
	
}
