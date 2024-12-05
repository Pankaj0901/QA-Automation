package MagentoAutomation;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class MagentoAutomation {

	    public static void main(String[] args) {
	        // Set the path to your WebDriver executable
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64.zip\\chromedriver-win64.exe"); // Replace with your ChromeDriver path

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Step 1: Navigate to the Magento website
	            driver.get("https://magento.softwaretestingboard.com/");
	            driver.manage().window().maximize();

	            // Step 2: Go to the "Create an Account" page
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            WebElement createAccountLink = wait.until(
	                ExpectedConditions.elementToBeClickable(By.linkText("Create an Account"))
	            );
	            createAccountLink.click();

	            // Step 3: Fill out the registration form
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname"))).sendKeys("Pankaj");
	            driver.findElement(By.id("lastname")).sendKeys("Jadhav");
	            driver.findElement(By.id("email_address")).sendKeys("Pankaj.jadhav7278@gmail.com");
	            driver.findElement(By.id("password")).sendKeys("Password123!");
	            driver.findElement(By.id("password-confirmation")).sendKeys("Password123!");

	            // Submit the form
	            driver.findElement(By.cssSelector("button.submit")).click();

	            // Step 4: Wait for account creation to complete
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".welcome-msg")));
	            System.out.println("Account created successfully!");

	            // Step 5: Log out (if logged in automatically)
	            WebElement signOutLink = wait.until(
	                ExpectedConditions.elementToBeClickable(By.linkText("Sign Out"))
	            );
	            signOutLink.click();

	            // Step 6: Log in with the new account
	            WebElement signInLink = wait.until(
	                ExpectedConditions.elementToBeClickable(By.linkText("Sign In"))
	            );
	            signInLink.click();
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("pankaj.jadhav7278@gmail.com");
	            driver.findElement(By.id("pass")).sendKeys("Password123!");
	            driver.findElement(By.id("send2")).click();

	            // Step 7: Confirm login success
	            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".welcome-msg")));
	            System.out.println("Logged in successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Step 8: Close the browser
	            driver.quit();
	        }
	    }
	}

}
