package AddMultiple_forms;

import java.time.Duration;

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

public class info {

	WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup(ITestContext context) {
		driver = (WebDriver) context.getAttribute("driver");
//		CREAT creat = new CREAT();
	}

	@Test(dependsOnMethods = { "login" })
	public void companyinfo(ITestContext context) throws InterruptedException {
		System.out.println("Starting Company Info form automation...");

		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String logoPath = "C:\\Users\\IG07\\Downloads\\company_logo.jpg";

		try {
			WebElement logoUploadInput = driver.findElement(By.xpath("//input[@type='file']"));
			logoUploadInput.sendKeys(logoPath);
			System.out.println("Selected company logo: " + logoPath);

			WebElement saveLogoButton = driver.findElement(By.xpath("//button[text()='Save']"));
			saveLogoButton.click();
			Thread.sleep(3000);

			WebElement uploadMsg = driver.findElement(By.xpath("//div[contains(text(),'successfully')]"));
			if (uploadMsg.isDisplayed()) {
				System.out.println("Logo uploaded successfully.");
			}
		} catch (Exception e) {
			System.out.println("Logo upload failed. Skipping this step.");
		}

		System.out.println("Filling out basic company details...");

		WebElement firstNameInput = driver.findElement(By.name("first_name"));
		firstNameInput.clear();
		typeLikeHuman(firstNameInput, "Rahul");
  
		WebElement lastNameInput = driver.findElement(By.name("last_name"));
		lastNameInput.clear();
		typeLikeHuman(lastNameInput, "Sharma");

		WebElement designationInput = driver.findElement(By.name("designation"));
		designationInput.clear();
		typeLikeHuman(designationInput, "Automation Engineer");

		WebElement companyNameInput = driver.findElement(By.name("company_name"));
		companyNameInput.clear();
		typeLikeHuman(companyNameInput, "TechVision Solutions");

		WebElement companySizeDropdown = driver.findElement(By.xpath(
				"//*[@id='left-tabs-example-tabpane-Compney Info']/div/form/div/div[3]/div[6]/div/div/div/div[1]/div[2]"));
		companySizeDropdown.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		System.out.println("Company size selected.");

		WebElement cityDropdown = driver.findElement(By
				.xpath("//*[@id='left-tabs-example-tabpane-Compney Info']/div/form/div/div[3]/div[9]/div/div/div[1]"));
		cityDropdown.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		System.out.println("City selected successfully.");

		System.out.println("Adding contact information...");

		WebElement mobileInput = driver.findElement(By.name("mobile"));
		typeLikeHuman(mobileInput, "9876543021");

		WebElement websiteInput = driver.findElement(By.name("website"));
		typeLikeHuman(websiteInput, "https://www.techvision.in");

		WebElement buyerSellerDropdown = driver.findElement(By.xpath(
				"//*[@id='left-tabs-example-tabpane-Compney Info']/div/form/div/div[3]/div[13]/div/div/div/div[1]/div[2]"));
		buyerSellerDropdown.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		System.out.println("Buyer/Seller option selected.");

		WebElement yearDropdown = driver.findElement(By.xpath(
				"//*[@id='left-tabs-example-tabpane-Compney Info']/div/form/div/div[3]/div[14]/div/div/div/div[1]/div[2]"));
		yearDropdown.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		System.out.println("Year selected successfully.");

		WebElement hsCodeDropdown = driver.findElement(By.xpath("//*[@id='hs_code_dropdown']/div[1]/div[1]/div[2]"));
		hsCodeDropdown.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		System.out.println("HS Code selected successfully.");

		WebElement countryDropdown = driver.findElement(By.xpath(
				"//*[@id='left-tabs-example-tabpane-Compney Info']/div/form/div/div[3]/div[16]/div/div[1]/div[1]/div[2]"));
		countryDropdown.click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		System.out.println("Country selected successfully.");

		WebElement addressInput = driver.findElement(By.name("address1"));
		typeLikeHuman(addressInput, "B-102 Sunrise Park, SG Highway, Ahmedabad");

		WebElement pincodeInput = driver.findElement(By.name("pincode"));
		typeLikeHuman(pincodeInput, "380015");

		js.executeScript("window.scrollBy(0, -1500)");
		Thread.sleep(2000);

		System.out.println("Company Info form filled successfully.");
	}

	private void typeLikeHuman(WebElement element, String text) throws InterruptedException {
		for (char ch : text.toCharArray()) {
			element.sendKeys(String.valueOf(ch));
			Thread.sleep(120 + (int) (Math.random() * 80));
		}
	}

	@Test(dependsOnMethods = { "companyinfo" })
	public void staffInfo(ITestContext context) throws InterruptedException {

		driver = (WebDriver) context.getAttribute("driver");
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		new Actions(driver);

		// --- Step 1: Open Staff Info tab ---
		WebElement staffInfoTab = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Staff Info")));
		staffInfoTab.click();

		// --- Step 2: Fill staff details ---
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='0']/div/div[1]/div/div/div/input")))
				.sendKeys("Karan");
		driver.findElement(By.xpath("//*[@id='0']/div/div[2]/div/input")).sendKeys("Patel");
		driver.findElement(By.xpath("//*[@id='0']/div/div[3]/div/input")).sendKeys("Accounts Executive");
		driver.findElement(By.xpath("//*[@id='0']/div/div[4]/div/input")).sendKeys("karan.patel@companymail.com");

		// --- Step 3: Mobile number ---
		WebElement mobileField = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/form/div/div[1]/div[2]/div/div[5]/div/input"));
		mobileField.clear();
		mobileField.sendKeys("+91 9876501234");

		// --- Step 4: Upload image ---
		String imagePath = "C:\\Users\\IG07\\Downloads\\0001.jpg";
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file' and @id='images#@0']"));
		fileInput.sendKeys(imagePath);

//        // --- Step 5: Save form ---
//        WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
//        saveButton.click();
//
//        // --- Step 6: Wait for confirmation ---
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//div[contains(text(),'successfully')]")));
//        
//        
		Thread.sleep(3000);

		System.out.println("-------->>>>> Start Second form <<<<<------------");
		WebElement addButton = driver.findElement(By.xpath(
				"//div[@id='left-tabs-example-tabpane-Contact Info']//form//div[@class='p-4 card-shadow bg-white rounded']//div//button[@id='addButton']"));
		addButton.click();

		System.out.println("__-->new<--__");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"1\"]/div[2]/div[1]/div/div/div/input")))
				.sendKeys("shubham");
		driver.findElement(By.xpath("//*[@id=\"1\"]/div[2]/div[2]/div/input")).sendKeys("raval");
		driver.findElement(By.xpath(
				"//div[@id='1']//div[contains(@class,'row pt-3 contact-info-wrapper')]//input[contains(@placeholder,'Enter your designation')]"))
				.sendKeys("graphic");
		driver.findElement(By.xpath("//*[@id=\"1\"]/div[2]/div[4]/div/input")).sendKeys("raval@companymail.com");

		// --- Step 3: Mobile number ---
		WebElement mobileField1 = driver.findElement(By.xpath(
				"//div[@id='1']//div[contains(@class,'row pt-3 contact-info-wrapper')]//input[@id='contact-form-mobile']"));
		mobileField1.clear();
		mobileField1.sendKeys("+91 9871101234");

		Thread.sleep(3000);

		String imagePath1 = "C:\\Users\\IG07\\Downloads\\eight.png";
		WebElement fileInput1 = driver.findElement(By.xpath("//input[@type='file' and @id='images#@1']"));
		fileInput1.sendKeys(imagePath1);

		Thread.sleep(3000);

		WebElement addButton1 = driver.findElement(By.xpath(
				"//div[@id='left-tabs-example-tabpane-Contact Info']//form//div[@class='p-4 card-shadow bg-white rounded']//div//button[@id='addButton']"));
		addButton1.click();

		System.out.println("-------->>>>> Start Third form <<<<<------------");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

//		WebElement addButton2 = driver.findElement(By.xpath(
//				"//div[@id='left-tabs-example-tabpane-Contact Info']//form//div[@class='p-4 card-shadow bg-white rounded']//div//button[@id='addButton']"));
//		addButton2.click();

		System.out.println("__-->new<--__");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"2\"]/div[2]/div[1]/div/div/div/input")))
				.sendKeys("shubham");
		driver.findElement(By.xpath("//*[@id=\"2\"]/div[2]/div[2]/div/input")).sendKeys("raval");
		driver.findElement(By.xpath("//*[@id=\"2\"]/div[2]/div[3]/div/input")).sendKeys("graphic");
		driver.findElement(By.xpath("//*[@id=\"2\"]/div[2]/div[4]/div/input")).sendKeys("aval@companymail.com");

		// --- Step 3: Mobile number ---
		WebElement mobileField2 = driver.findElement(By.xpath("//div[@id='2']//input[@id='contact-form-mobile']"));
		mobileField2.clear();
		mobileField2.sendKeys("+91 2271101234");

		Thread.sleep(3000);

		String imagePath2 = "C:\\Users\\IG07\\Downloads\\eight.png";
		WebElement fileInput2 = driver.findElement(By.xpath("//input[@type='file' and @id='images#@2']"));
		fileInput2.sendKeys(imagePath2);

		System.out.println("Third for sucessfully");
		Thread.sleep(5000);

		System.out.println("Click on all form remove button");

		WebElement remove = driver.findElement(By.xpath("//*[@id=2]/div[1]/button"));
		remove.click();
		Thread.sleep(2000);

		WebElement remove1 = driver.findElement(By.xpath("//*[@id=1]/div[1]/button"));
		remove1.click();
		
		
	}

}