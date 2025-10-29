package mandetory_Data;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.time.Duration;

public class Pro_Flow {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setup(ITestContext context) {
        driver = (WebDriver) context.getAttribute("driver");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }

    @Test(dependsOnMethods =  {"login"})
    public void companyinfo(ITestContext context) throws InterruptedException {
        System.out.println("Navigating to Company Info...");

        String filePath = "C:\\Users\\IG07\\Downloads\\small banner.jpg";

        try {
            waitAndClearAndSendKeys(By.xpath("//input[@type='file']"), filePath);
            System.out.println("File uploaded successfully.");

            waitAndClick(By.xpath("//button[text()='Save']"));
            waitForElementVisible(By.xpath("//div[contains(text(),'successfully')]"));
            System.out.println("File upload verified successfully.");

        } catch (Exception e) {
            System.out.println("Error during file upload: " + e.getMessage());
        }

        waitAndClearAndSendKeys(By.name("first_name"), "Thushar");
        waitAndClearAndSendKeys(By.name("last_name"), "last");
        waitAndClearAndSendKeys(By.name("designation"), "QA");
        waitAndClearAndSendKeys(By.name("company_name"), "Alight");

        waitAndClick(By.xpath("//*[@id=\"left-tabs-example-tabpane-Compney Info\"]/div/form/div/div[3]/div[6]/div/div/div/div[1]/div[2]"));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        waitAndClick(By.xpath("//*[@id=\"left-tabs-example-tabpane-Compney Info\"]/div/form/div/div[3]/div[9]/div/div/div[1]"));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        waitAndClearAndSendKeys(By.name("mobile"), "9874569875");
        waitAndClearAndSendKeys(By.name("website"), "https://chatgpt.com/");

        waitAndClick(By.xpath("//*[@id=\"left-tabs-example-tabpane-Compney Info\"]/div/form/div/div[3]/div[13]/div/div/div/div[1]/div[2]"));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        waitAndClick(By.xpath("//*[@id=\"left-tabs-example-tabpane-Compney Info\"]/div/form/div/div[3]/div[14]/div/div/div/div[1]/div[2]"));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        waitAndClick(By.xpath("//*[@id=\"hs_code_dropdown\"]/div[1]/div[1]/div[2]"));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        waitAndClick(By.xpath("//*[@id=\"left-tabs-example-tabpane-Compney Info\"]/div/form/div/div[3]/div[16]/div/div[1]/div[1]/div[2]"));
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        waitAndClearAndSendKeys(By.name("address1"), "Ahmedabad");
        waitAndClearAndSendKeys(By.name("pincode"), "380005");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -1550)");
        Thread.sleep(2000);

        System.out.println("Company Info completed successfully.");
    }

    // ===== Helper Methods =====

    private void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void waitAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void waitAndClearAndSendKeys(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(value);
    }
    
    @Test(dependsOnMethods = {"companyinfo"})
    public void certificate(ITestContext context) {
        System.out.println("Navigating to Certificate page...");
        waitAndClick(By.xpath("//*[@id='left-tabs-example-tab-Certificate']"));

        uploadCertificate("//input[@id='certificate#@TAX_CERTI']", "C:\\Users\\IG07\\Downloads\\small banner.jpg");
        uploadCertificate("//*[@id='certificate#@BUSINESS_CERTI']", "C:\\Users\\IG07\\Downloads\\11.jpg");

        System.out.println("All certificates uploaded successfully.");
        context.setAttribute("driver", driver);
    }

    // ====== Helper Methods ======
    private void uploadCertificate(String inputXpath, String filePath) {
        try {
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(inputXpath)));
            fileInput.sendKeys(filePath);

            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
            saveButton.click();

            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'successfully')]")));
            if (successMsg.isDisplayed()) {
                System.out.println("✅ Uploaded file: " + filePath);
            }
        } catch (Exception e) {
            System.out.println("❌ Error uploading file: " + filePath);
            e.printStackTrace();
        }
    }
    
}
