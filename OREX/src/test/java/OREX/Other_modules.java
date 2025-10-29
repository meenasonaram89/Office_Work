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

public class Other_modules {
	WebDriver driver;

	@BeforeClass
	public void setup(ITestContext context) {
		driver = (WebDriver) context.getAttribute("driver");
//		CREAT add = new CREAT();

//		Profile_Flow p = new Profile_Flow();

		System.out.println("New module");
	}

	@Test(dependsOnMethods = { "certificate" })
	public void otherinfo(ITestContext context) throws InterruptedException {
		System.out.println("open other info");

		driver.findElement(By.xpath("//*[@id=\"left-tabs-example-tab-Other Info\"]")).click();

		System.out.println("service click sucessfull");

		WebElement cabout = driver.findElement(By.xpath(
				"//*[@id=\"left-tabs-example-tabpane-Other Info\"]/div/div/form/div[1]/div/div/div/div[2]/div[2]/div"));
		cabout.sendKeys(
				"Reliable logistics solutions delivering goods safely and on time worldwide. We simplify supply chains with smart transport and warehouse services.");

		System.out.println("---------------------------------------------------------------------------");

		String filePath1 = "C:\\Users\\IG07\\Downloads\\33.jpeg";

		try {
			WebElement fileInput = driver.findElement(By.xpath(
					"//*[@id=\"left-tabs-example-tabpane-Other Info\"]/div/div/form/div[2]/div/div/section/div/div"));

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

		System.out.println("upload image sucessfull");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Enter video link']"))
				.sendKeys("https://www.pexels.com/video/");

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1800)");
		System.out.println("Select social media");
		Actions actions = new Actions(driver);

		WebElement social = driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div/div/div/div/div/div[1]/div[2]"));
		social.click();
		System.out.println("select media");

		Thread.sleep(5000);

		// Down, Down, Down, Enter (selects the 3rd option)
		actions.sendKeys(Keys.ARROW_DOWN)
//				sendKeys(Keys.ARROW_DOWN)
//				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ENTER).perform();
		System.out.println("select dropdown sucessfully");

		driver.findElement(By.xpath("//*[@id=\"0\"]/div[2]/div/div/div/input")).sendKeys("https://mail.google.com/");
		Thread.sleep(3000);

		js.executeScript("window.scrollBy(0,-1800)");

		Thread.sleep(5000);

	}

	@Test(dependsOnMethods = { "otherinfo" })
	public void referenceinfo(ITestContext context) throws InterruptedException {
		System.out.println("Go to reference info");

		WebElement Rinfo = driver.findElement(By.xpath("//a[@id='left-tabs-example-tab-Rferral']"));
		Rinfo.click();

		System.out.println("Click on the button sucessfull");
		Thread.sleep(2000);

		// COMPANY NAME
		driver.findElement(By.xpath("//div[@id='0']//input[@placeholder='Enter your company name']")).sendKeys("HOCCO");

		// FIRST NAME

		driver.findElement(By.xpath("//*[@id=\"0\"]/div[1]/div[2]/div/div/div/input")).sendKeys("bhavesh");

		// lastname
		driver.findElement(By.xpath(
				"//div[@id='0']//div[@class='row pt-3 reference-wrapper']//input[@placeholder='Enter your last name']"))
				.sendKeys("raval");

		// email
		driver.findElement(By.xpath(
				"//div[@id='0']//div[@class='row pt-3 reference-wrapper']//input[@placeholder='Enter your email']"))
				.sendKeys("bhavesh@gmail.com");

		// mobile
		driver.findElement(
				By.xpath("//div[@id='0']//div[@class='row pt-3 reference-wrapper']//input[@id='contact-form-mobile']"))
				.sendKeys("+91 1545454546");

		// des
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[5]/form[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/input[1]"))
				.sendKeys("new");

		System.out.println("start second form");
		// company name

		driver.findElement(By.xpath("//div[@id='1']//input[contains(@placeholder,'Enter your company name')]"))
				.sendKeys("tcs");

		// fname
		driver.findElement(By.xpath("//*[@id=\"1\"]/div/div[2]/div/div/div/input")).sendKeys("abccd");

		// lname
		driver.findElement(By.xpath("//div[@id='1']//input[contains(@placeholder,'Enter your last name')]"))
				.sendKeys("patel");

		// email
		driver.findElement(By.xpath("//div[@id='1']//input[contains(@placeholder,'Enter your email')]"))
				.sendKeys("abd@gmail.com");

		// phone
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[5]/form[1]/div[1]/div[1]/div[3]/div[1]/div[5]/div[1]/input[1]"))
				.sendKeys("+91 6565423546");

		// description

		driver.findElement(By.xpath("//div[@id='1']//input[contains(@placeholder,'Enter your designation')]"))
				.sendKeys("dfasf");

		System.out.println("form fill sucessfull");

	}

	@Test(dependsOnMethods = { "referenceinfo" })
	public void promotion(ITestContext context) throws InterruptedException {
		System.out.println("start promotion media");

		WebElement media = driver.findElement(By.xpath("//a[@id='left-tabs-example-tab-promotion_media']"));
		media.click();

		Thread.sleep(3000);

		// first name
		driver.findElement(By.xpath("//input[@placeholder='Enter your full name']")).sendKeys("abhay");

		// desiganation
		driver.findElement(By.xpath(
				"//div[contains(@class,'col-md-6 py-2')]//input[contains(@placeholder,'Enter your designation')]"))
				.sendKeys("QA");

		// email
		driver.findElement(
				By.xpath("//div[contains(@class,'col-md-6 py-2')]//input[contains(@placeholder,'Enter your email')]"))
				.sendKeys("QA@gmail.com");

		Actions actions = new Actions(driver);
		// To select the third option:
		WebElement country = driver.findElement(By.xpath(
				"//*[@id=\"left-tabs-example-tabpane-promotion_media\"]/div/div/form/div[1]/div/div[2]/div[5]/div/div/div/div[1]"));
		country.click();
		System.out.println("select city");
		// Down, Down, Down, Enter (selects the 3rd option)
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
				.perform();
		System.out.println("Country select sucessfully");

		Thread.sleep(3000);

		WebElement city = driver.findElement(By.xpath(
				"//*[@id=\"left-tabs-example-tabpane-promotion_media\"]/div/div/form/div[1]/div/div[2]/div[6]/div/div/div/div[1]/div[2]"));
		city.click();
		System.out.println("select city");
		// Down, Down, Down, Enter (selects the 3rd option)
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
				.perform();
		System.out.println("city select sucessfully");

		System.out.println("---------------------------------------------------------------------------");

		String filePath = "C:\\Users\\IG07\\Downloads\\small banner.jpg";

		try {
			WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"certificate#@BUSINESS_CERTI\"]"));

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

		System.out.println("Form completed sucessfully");

	}

}
