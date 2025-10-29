package mandetory_Data;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestContext;
import org.testng.annotations.*;
import Connection.DriverConnection;
import java.time.Duration;

public class RE_LO_Floow {

    static WebDriver driver;
    private final String url = "http://dev.orextrade.com/";
    private WebDriverWait wait;
    private Actions actions;

    @BeforeClass
    public void setup(ITestContext context) {
        driver = DriverConnection.getDriver(url);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);

        context.setAttribute("driver", driver);
        System.out.println("Browser opened successfully and navigated to: " + url);
    }

    @Test
    public void fullRegistrationTest(ITestContext context) {
        waitAndClick(By.linkText("Register"));
        System.out.println("Navigated to Registration page");

        waitAndSendKeys(By.name("first_name"), "parth");
        waitAndSendKeys(By.id("last_name"), "koshti");
        waitAndSendKeys(By.name("phone"), "1234567890");

        scrollBy(150);
        waitAndSendKeys(By.id("company_name"), "TCS");
        waitAndSendKeys(By.id("website"), "https://www.tcs.com/");

        selectDropdown(By.xpath("//*[@id=\"shipment_mode\"]/div/div[1]/div[2]"));
        selectDropdown(By.xpath("//*[@id=\"account-detail\"]/div[1]/div[10]/div/div/div/div/div[1]/div[2]"));

        waitAndSendKeys(By.id("email"), "xyz@mailsac.com");
        waitAndSendKeys(By.id("password"), "Test@123");

        System.out.println("Registration details entered successfully.");
        context.setAttribute("driver", driver);
    }

    @Test(dependsOnMethods =  {"fullRegistrationTest"})
    public void login(ITestContext context) throws InterruptedException {
        waitAndClick(By.linkText("Login"));
        System.out.println("Navigated to Login page");

        waitAndSendKeys(By.name("email"), "tushar@mailsac.com");
        Thread.sleep(3000);
        waitAndSendKeys(By.name("password"), "Test@123");
        waitAndClick(By.xpath("//*[@id=\"root\"]/div/main/section/div[1]/div/div[2]/div/form/div/div[6]/button"));

//        try {
//            waitAndClick(By.xpath("/html/body/div[7]/div/div/div[3]/button[2]"));
//        } catch (Exception e) {
//            System.out.println("No popup appeared");
//        }

        Thread.sleep(3000);
        Thread.sleep(3000);

        System.out.println("Login completed successfully");
        context.setAttribute("driver", driver);
    }

    // ===== Helper Methods =====

    private void waitAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void waitAndSendKeys(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }

    private void scrollBy(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
    }

    private void selectDropdown(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }
    

}
