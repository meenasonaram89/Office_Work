package Excel_To_Login_multiple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilitie.ExcelReader_new;

import java.time.Duration;

public class LoginTest_new {

    @Test
    public void loginMultipleUsers() {
        String filePath = "C:\\Users\\IG07\\Desktop\\Multiple login data.xlsx";
        String sheetName = "Sheet1";

        // Get total rows (including header)
        int totalRows = ExcelReader_new.getRowCount(filePath, sheetName);
        System.out.println("Total rows found: " + totalRows);

        // Loop through Excel rows (skip header row 0)
        for (int i = 1; i < totalRows; i++) {
            String email = ExcelReader_new.getCellValue(filePath, sheetName, i, 0);
            String password = ExcelReader_new.getCellValue(filePath, sheetName, i, 1);

            System.out.println("\n=== Attempting login for: " + email + " ===");

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            try {
                driver.get("http://dev.orextrade.com/login");

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Enter email
                WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
                emailField.clear();
                emailField.sendKeys(email);

                // Enter password
                WebElement passField = driver.findElement(By.name("password"));
                passField.clear();
                passField.sendKeys(password);

                // Click login button
                WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
                loginBtn.click();

                // Wait and verify
                Thread.sleep(3000);
                System.out.println("Login attempted for user: " + email);

            } catch (Exception e) {
                System.out.println("Error logging in user: " + email);
                e.printStackTrace();
            } finally {
                driver.quit();
                System.out.println("Browser closed for user: " + email);
            }
        }
    }
}
