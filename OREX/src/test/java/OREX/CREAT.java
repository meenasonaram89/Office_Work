package OREX;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import Connection.DriverConnection;

public class CREAT {
    // 1. Declare WebDriver and Actions at the class level
    private WebDriver driver;
    private Actions actions;
    private final String url = "http://dev.orextrade.com/"; // URL is final

    // 2. Setup Method (Runs once before all tests in this class)
    @BeforeClass
    public void setup() throws InterruptedException {
        // Initialize driver
        driver = DriverConnection.getDriver(url);
        driver.manage().window().maximize(); // Maximize for better element visibility

        // Initialize Actions
        actions = new Actions(driver);
        
        System.out.println("Browser opened successfully and navigated to: " + url);

        Thread.sleep(5000); // Wait for initial page load
    }

    // 3. Test Method
    @Test
    public void fullRegistrationTest(ITestContext context) throws InterruptedException{

        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        System.out.println("Go to profile page ");

        // --- Fill Personal Details ---
        driver.findElement(By.name("first_name")).sendKeys("parth");
        driver.findElement(By.id("last_name")).sendKeys("koshti");

        // The City selection code is commented out (using old logic, keep it that way for now)

        WebElement phone = driver.findElement(By.name("phone"));
        Thread.sleep(2000); // Reduced sleep
        phone.sendKeys("1234567890");

        // --- Scroll Down ---
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 150);");

        // --- Fill Company Details ---
        driver.findElement(By.id("company_name")).sendKeys("TCS");
        driver.findElement(By.id("website")).sendKeys("https://www.tcs.com/");

        // --- Trade Mode Dropdown ---
        WebElement trade = driver.findElement(By.xpath("//*[@id=\"shipment_mode\"]/div/div[1]/div[2]"));
        trade.click();

        // Use ARROW_DOWN to highlight the first option, then ENTER to select
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        System.out.println("Trade mode select sucessfully");
        Thread.sleep(3000);
        
        // --- Industry Dropdown ---
        WebElement industry = driver.findElement(By.xpath("//*[@id=\"account-detail\"]/div[1]/div[10]/div/div/div/div/div[1]/div[2]"));
        industry.click();
        Thread.sleep(2000);

        // Use ARROW_DOWN to highlight the first option, then ENTER to select
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        System.out.println("Industry select sucessfully");
        
        driver.findElement(By.id("email")).sendKeys("xyz@mailsac.com");
        
        driver.findElement(By.id("password")).sendKeys("Test@123");
        Thread.sleep(2000);

//        driver.findElement(By.id("recaptcha-anchor")).click();
        
        
        Thread.sleep(5000); // Final check wait
        context.setAttribute("driver", driver);
    }
    
    
    @Test(dependsOnMethods = {"fullRegistrationTest"})
    
    public void login (ITestContext context) throws InterruptedException {
    	System.out.println("login page");
    	WebElement login = driver.findElement(By.linkText("Login"));
    	login.click();
    	
    	System.out.println("Go to login page");
    	
    	
    	
        Thread.sleep(5000);

        driver.findElement(By.name("email")).sendKeys("tushar@mailsac.com");
    	driver.findElement(By.name("password")).sendKeys("Test@123");
    	
        Thread.sleep(2000);
        System.out.println("click on login button");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/section/div[1]/div/div[2]/div/form/div/div[6]/button")).click();
//        
        Thread.sleep(2000);
//        // pop up
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div[3]/button[2]")).click();
     	
        Thread.sleep(12000);
       
        context.setAttribute("driver", driver);

    	
    }
    
    
    

//    // 4. Teardown Method (Runs once after all tests in this class)
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            System.out.println("Close window");
//        }
    }
