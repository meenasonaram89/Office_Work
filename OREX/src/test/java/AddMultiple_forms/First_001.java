package AddMultiple_forms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import Connection.DriverConnection;

import java.time.Duration;

public class First_001 {

	private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;
	private final String url = "http://dev.orextrade.com/";

	@BeforeClass
	public void setup() {
		// Initialize WebDriver
		driver = DriverConnection.getDriver(url);
		driver.manage().window().maximize();

		// Initialize utilities
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		System.out.println("Browser opened successfully and navigated to: " + url);
	}

	@Test
	public void fullRegistrationTest(ITestContext context) {
		try {
			// --- Click on Register ---
			click(By.linkText("Register"));
			System.out.println("Navigated to registration page.");

			// --- Personal Details ---
			type(By.name("first_name"), "yes");
			type(By.id("last_name"), "patel");
			type(By.name("phone"), "1234567890");

			// --- Scroll Down ---
			scrollBy(0, 150);

			// --- Company Details ---
			type(By.id("company_name"), "TCS");
			type(By.id("website"), "https://www.tcl.com/");

			// --- Select Trade Mode ---
			selectDropdown(By.xpath("//*[@id=\"shipment_mode\"]/div/div[1]/div[2]"));
			System.out.println("Trade mode selected successfully.");

			// --- Select Industry ---
			selectDropdown(By.xpath("//*[@id=\"account-detail\"]/div[1]/div[10]/div/div/div/div/div[1]/div[2]"));
			System.out.println(" Industry selected successfully.");

			// --- Account Info ---
			type(By.id("email"), "xyz@mailsac.com");
			type(By.id("password"), "Test@123");

			// (Captcha cannot be automated legally, skip)
			System.out.println(" Form filled successfully.");

			context.setAttribute("driver", driver);

		} catch (Exception e) {
			System.err.println("❌ Test failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ---------------------- Helper Methods ----------------------

	private void click(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	private void type(By locator, String value) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
	}

	private void selectDropdown(By dropdownLocator) {
		click(dropdownLocator);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	}

	private void scrollBy(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
		
	}
	
	

	@Test (dependsOnMethods = {"fullRegistrationTest"})
	
	public void login(ITestContext context) {
		System.out.println("Navigating to login page...");

		try {
			// --- Click on Login link ---
			click(By.linkText("Login"));
			System.out.println("Login link clicked successfully.");

			// --- Wait for login form ---
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			Thread.sleep(5000);  // you can adjust to 2–5 seconds if needed


			// --- Enter credentials ---
			type(By.name("email"), "tushar@mailsac.com");
			Thread.sleep(5000);  // you can adjust to 2–5 seconds if needed

			type(By.name("password"), "Test@123");

			// --- Click Login button ---
			System.out.println("Clicking on login button...");
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

			// 🔹 Wait briefly for popup to appear (optional safety)
			Thread.sleep(5000);  // you can adjust to 2–5 seconds if needed

			// --- Handle popup ---
			try {
			    WebElement popupButton = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[3]/button[2]"));
			    popupButton.click();
			    System.out.println("Popup closed successfully.");
			} catch (Exception e) {
			    System.out.println(" No popup appeared after login.");
			}


			context.setAttribute("driver", driver);

			// --- Optional popup handling ---
			try {
				By popupButton = By.xpath("//button[contains(text(),'OK') or contains(text(),'Yes')]");
				wait.withTimeout(Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(popupButton))
						.click();
				System.out.println("Popup closed successfully.");
			} catch (Exception ignore) {
				System.out.println("No popup appeared after login.");
			}

			// --- Verify successful login ---
			By dashboardLocator = By.xpath("//*[contains(text(),'Dashboard') or contains(text(),'Welcome')]");
			wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLocator));
			System.out.println("Login successful — dashboard visible!");

			// Save driver context for next test
			context.setAttribute("driver", driver);

		} catch (Exception e) {
			System.err.println("❌ Login test failed: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Login failed", e);
			
			
			
		}
	}


}
