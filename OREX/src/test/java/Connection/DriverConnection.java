package Connection;

import io.github.bonigarcia.wdm.WebDriverManager; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverConnection {

    public static WebDriver getDriver(String url) {
        // This command automatically downloads and configures the correct ChromeDriver 
        // executable that matches the version of Chrome installed on your system.
        WebDriverManager.chromedriver().setup(); 
        
        // Note: The manual System.setProperty() is no longer needed.

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}