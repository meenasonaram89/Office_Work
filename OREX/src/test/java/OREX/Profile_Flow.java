package OREX;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.*;


public class Profile_Flow {
	WebDriver driver;

	@BeforeClass
	public void setup(ITestContext context) {
		driver = (WebDriver) context.getAttribute("driver");
//		CREAT creat = new CREAT();
	}

	@Test(dependsOnMethods = { "login" })
	public void companyinfo(ITestContext context) throws InterruptedException {
		System.out.println("go to company info");

		String filePath = "C:\\Users\\IG07\\Downloads\\small banner.jpg";

		try {
			WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));

			fileInput.sendKeys(filePath);
			System.out.println("File path entered into the file input field.");

			WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
			saveButton.click();

			Thread.sleep(3000);

			WebElement verificationElement = driver.findElement(By.xpath("//div[contains(text(),'successfully')]"));
			if (verificationElement.isDisplayed()) {
				System.out.println("File upload successful!");
			}
		} catch (Exception e) {
			System.out.println("An error occurred during file upload.");
			e.printStackTrace();
		}
		System.out.println("upload logo sucessfull");
		// Form
		WebElement fname = driver.findElement(By.name("first_name"));
		fname.clear();
		fname.sendKeys("Thushar");

		WebElement lname = driver.findElement(By.name("last_name"));
		lname.sendKeys("last");

		WebElement des = driver.findElement(By.name("designation"));
		des.sendKeys("QA");

		WebElement Cname = driver.findElement(By.name("company_name"));
		Cname.sendKeys("Alight");

		// To select the third option:
		WebElement companysize = driver.findElement(By.xpath(
				"//*[@id=\"left-tabs-example-tabpane-Compney Info\"]/div/form/div/div[3]/div[6]/div/div/div/div[1]/div[2]"));
		companysize.click();
		System.out.println("Select company name");
		Actions actions = new Actions(driver);
		// Down, Down, Down, Enter (selects the 3rd option)
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
				.perform();

		System.out.println("company size select suce");
		// *[@id="left-tabs-example-tabpane-Compney
		// Info"]/div/form/div/div[3]/div[9]/div/div/div[1]

		// To select the third option:
		WebElement city = driver.findElement(By.xpath(
				"//*[@id=\"left-tabs-example-tabpane-Compney Info\"]/div/form/div/div[3]/div[9]/div/div/div[1]"));
		city.click();
		System.out.println("select city");
		// Down, Down, Down, Enter (selects the 3rd option)
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
				.perform();
		System.out.println("city select sucessfully");

		// mobile number
		driver.findElement(By.name("mobile")).sendKeys("9874569875");
		System.out.println("mobile number add sucess full");

		// Website addd
		driver.findElement(By.name("website")).sendKeys("https://chatgpt.com/");

		WebElement bsl = driver.findElement(By.xpath(
				"//*[@id=\"left-tabs-example-tabpane-Compney Info\"]/div/form/div/div[3]/div[13]/div/div/div/div[1]/div[2]"));
		bsl.click();

		// Down, Down, Down, Enter (selects the 1rd option)
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

		System.out.println("select sucessfully byer");
		System.out.println("move");
		WebElement yr = driver.findElement(By.xpath(
				"//*[@id=\"left-tabs-example-tabpane-Compney Info\"]/div/form/div/div[3]/div[14]/div/div/div/div[1]/div[2]"));
		System.out.println("click");
		yr.click();
		// Down, Down, Down, Enter (selects the 3rd option)
		actions.sendKeys(Keys.ARROW_DOWN)
//				.sendKeys(Keys.ARROW_DOWN)
//				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ENTER).perform();

		System.out.println("year select sucessfully");

		// HSCODE
		WebElement HS = driver.findElement(By.xpath("//*[@id=\"hs_code_dropdown\"]/div[1]/div[1]/div[2]"));
		HS.click();
		System.out.println("select hs code");
		// Down, Down, Down, Enter (selects the 3rd option)
		actions.sendKeys(Keys.ARROW_DOWN)
//				.sendKeys(Keys.ARROW_DOWN)
//				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ENTER).perform();

		System.out.println("HS CODE SUCESSFULLY");

		WebElement country = driver.findElement(By.xpath(
				"//*[@id=\"left-tabs-example-tabpane-Compney Info\"]/div/form/div/div[3]/div[16]/div/div[1]/div[1]/div[2]"));
		country.click();

		actions.sendKeys(Keys.ARROW_DOWN)
//		.sendKeys(Keys.ARROW_DOWN)
//		.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ENTER).perform();

		System.out.println("country select sucessfully");

		// Address
		driver.findElement(By.name("address1")).sendKeys("Ahemdabad");

		driver.findElement(By.name("pincode")).sendKeys("380005");

		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1550)");
		Thread.sleep(5000);       

	}

	@Test(dependsOnMethods = { "companyinfo" })

	public void staffinfo(ITestContext context) throws InterruptedException {
		System.out.println("go to staff info");

		WebElement info = driver.findElement(By.linkText("Staff Info"));
		info.click();

		Thread.sleep(5000);
		WebElement finame = driver.findElement(By.xpath("//*[@id=\"0\"]/div/div[1]/div/div/div/input"));
		finame.sendKeys("shumit");

		WebElement laname = driver.findElement(By.xpath("//*[@id=\"0\"]/div/div[2]/div/input"));
		laname.sendKeys("shumit");

		WebElement des = driver.findElement(By.xpath("//*[@id=\"0\"]/div/div[3]/div/input"));
		des.sendKeys("Accounter");

		WebElement eml = driver.findElement(By.xpath("//*[@id=\"0\"]/div/div[4]/div/input"));
		eml.sendKeys("abc@gmail.com");

//		WebElement ph =driver.findElement(By.xpath("//*[@id=\"contact-form-mobile\"]"));
//		ph.sendKeys("+91 2121122121");

		WebElement mobileField = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/form/div/div[1]/div[2]/div/div[5]/div/input"));
		mobileField.sendKeys("+91 6565656565");

		System.out.println("Mobile number entered via JavaScript.");

		System.out.println("----------------------------------------------------------");
		String filePath = "C:\\Users\\IG07\\Downloads\\small banner.jpg";

		try {
			WebElement fileInput = driver.findElement(By.xpath("//label[@for='images#@0']"));

			fileInput.sendKeys(filePath);
			System.out.println("File path entered into the file input field.");

			WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
			saveButton.click();

			Thread.sleep(3000);

			WebElement verificationElement = driver.findElement(By.xpath("//div[contains(text(),'successfully')]"));
			if (verificationElement.isDisplayed()) {
				System.out.println("File upload successful!");
			}
		} catch (Exception e) {
			System.out.println("An error occurred during file upload.");
			e.printStackTrace();
		}
		System.out.println("upload image sucessfull");
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods = {"staffinfo"})
	public void service(ITestContext context) throws InterruptedException {
		System.out.println("Go to service");
		
		driver.findElement(By.xpath("//*[@id=\"left-tabs-example-tab-Services\"]")).click();
		
		System.out.println("Click on the selector");
		
		driver.findElement(By.xpath("//input[@id='0']")).click();
		System.out.println("select");
		Thread.sleep(2000);
		
		driver.findElement(By.name("other_service")).sendKeys("new");
		System.out.println("Add services");
		
		Thread.sleep(3000);
        context.setAttribute("driver", driver);

	}
	
	@Test (dependsOnMethods = {"service"})
	public void certificate(ITestContext context) throws InterruptedException {
		System.out.println("Go to certificate page");
		
		driver.findElement(By.xpath("//*[@id=\"left-tabs-example-tab-Certificate\"]")).click();
		
		Thread.sleep(2000);
		
		System.out.println("---------------------------------------------------------------------------");
		
		String filePath = "C:\\Users\\IG07\\Downloads\\small banner.jpg";

		try {
			WebElement fileInput = driver.findElement(By.xpath("//input[@id='certificate#@TAX_CERTI']"));

			fileInput.sendKeys(filePath);
			System.out.println("File path entered into the file input field.");

			WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
			saveButton.click();

			Thread.sleep(3000);

			WebElement verificationElement = driver.findElement(By.xpath("//div[contains(text(),'successfully')]"));
			if (verificationElement.isDisplayed()) {
				System.out.println("File upload successful!");
			}
		} catch (Exception e) {
			System.out.println("An error occurred during file upload.");
			e.printStackTrace();
		}
		System.out.println("upload first certificat sucessfull");
	
		
		
System.out.println("---------------------------------------------------------------------------");
		
		String filePath1 = "C:\\Users\\IG07\\Downloads\\11.jpg";

		try {
			WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"certificate#@BUSINESS_CERTI\"]"));

			fileInput.sendKeys(filePath1);
			System.out.println("File path entered into the file input field.");

			WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
			saveButton.click();

			Thread.sleep(3000);

			WebElement verificationElement = driver.findElement(By.xpath("//div[contains(text(),'successfully')]"));
			if (verificationElement.isDisplayed()) {
				System.out.println("File upload successful!");
			}
		} catch (Exception e) {
			System.out.println("An error occurred during file upload.");
			e.printStackTrace();
		}
		System.out.println("upload second certificat sucessfull");
	
		
        context.setAttribute("driver", driver);

		
		
    }
		
		
}

