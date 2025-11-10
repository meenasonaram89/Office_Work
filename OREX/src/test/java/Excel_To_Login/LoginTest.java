package Excel_To_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.ExcelReader;

public class LoginTest {

    @Test
    public void loginUsingExcel() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String filePath = "C:\\Users\\IG07\\Desktop\\test.xlsx";
        String email = ExcelReader.getCellValue(filePath, "Sheet1",1,0);
        String password = ExcelReader.getCellValue(filePath, "Sheet1",1,1);

        driver.get("http://dev.orextrade.com/login");
        
        
        System.out.println("open website");
        
        Thread.sleep(3000);
//        WebElement login = driver.findElement(By.xpath("//a[@title='Login']//a[@title='Login']"));
//    	login.click();
    	
    	System.out.println("login buttton click sucessfully");


        driver.findElement(By.name("email")).sendKeys(email);
    	driver.findElement(By.name("password")).sendKeys(password);
    	
        Thread.sleep(2000);
        System.out.println("click on login button");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/section/div[1]/div/div[2]/div/form/div/div[6]/button")).click();
//        
        Thread.sleep(2000);
//        // pop up
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div[3]/button[2]")).click();
     	
        Thread.sleep(3000);
        driver.quit();
    }
}
	