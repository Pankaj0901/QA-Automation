package loginregistration;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Magento {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64.exe"); // Replace with your ChromeDriver path

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();
	        
	            driver.get("https://magento.softwaretestingboard.com/");
	            driver.manage().window().maximize();

	            // Step 2: Go to the "Create an Account" page
	           WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	           WebElement createAccountLink = wait.until(
	               ExpectedConditions.elementToBeClickable(By.linkText("Create an Account"))
	          );
	            createAccountLink.click();

	            // Step 3: Fill out the registration form
	           wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).sendKeys("Jhonny");
	           driver.findElement(By.id("lastname")).sendKeys("Doe");
	            driver.findElement(By.id("email_address")).sendKeys("Johnnydoe@gmail.com");
	            driver.findElement(By.id("password")).sendKeys("Password123!");
	            driver.findElement(By.id("password-confirmation")).sendKeys("Password123!");

	            // Submit the form
	            driver.findElement(By.cssSelector("button.submit")).click();

	           

	            // Step 5: Log out (if logged in automatically)
	            driver.findElement(By.xpath("//button[@data-action='customer-menu-toggle'][1]")).click();	
	            driver.findElement(By.linkText("Sign Out")).click();
	            Thread.sleep(3000);
	         
	            WebElement signInLink = wait.until(
	                ExpectedConditions.elementToBeClickable(By.linkText("Sign In"))
	            );
	            signInLink.click();
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("Johnnydoe@gmail.com");
	            driver.findElement(By.id("pass")).sendKeys("Password123!");
	            driver.findElement(By.id("send2")).click();
                Thread.sleep(5000);
	            // Step 7: Confirm login success
	            driver.findElement(By.xpath("//button[@data-action='customer-menu-toggle'][1]")).click();	
	            driver.findElement(By.linkText("Sign Out")).click();
	            Thread.sleep(3000);
	            // Step 8: Close the brow
	            driver.close();
	        }
	    }
	


	

