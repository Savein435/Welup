package tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class WelUp {

    WebDriver driver;
    String URL = "https://qa.welup.savein.money/signup";
    
    @BeforeMethod
    public void setup() {
        // Set up WebDriver and configure the browser settings
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode
        options.addArguments("--disable-gpu"); // Disable GPU for compatibility
        options.addArguments("--window-size=1920,1080"); // Set window size
        
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    
    @AfterMethod
    public void cleanup() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(priority = 1)
    public void testWelup() throws Exception {
      driver.get("https://qa.welup.savein.money/signup");
      driver.findElement(By.id("inputid")).click();
      driver.findElement(By.id("inputid")).clear();
      driver.findElement(By.id("inputid")).sendKeys("Ayush");
      driver.findElement(By.xpath("//div[2]/div/div[2]/input")).clear();
      driver.findElement(By.xpath("//div[2]/div/div[2]/input")).sendKeys("7378389247");
      driver.findElement(By.xpath("//div[3]/div[3]/div/div/div[2]/input")).click();
      driver.findElement(By.xpath("//div[3]/div[3]/div/div/div[2]/input")).clear();
      driver.findElement(By.xpath("//div[3]/div[3]/div/div/div[2]/input")).sendKeys("jksahdgjkas@gmail.com");
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Work Email ID'])[1]/following::button[1]")).click();
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Work Email ID'])[1]/following::button[1]")).click();
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Department'])[1]/following::button[1]")).click();
    }


    

    // Helper Methods
    private void enterName(String name) {
        WebElement nameField = driver.findElement(By.xpath("//div[@class='w-full md:w-//input[@id='inputid']"));
        nameField.clear();
        nameField.sendKeys(name);
    }

    private void enterMobileNumber(String mobile) {
        WebElement mobileField = driver.findElement(By.xpath("//div[@class='w-full md:w-//input[@id='inputid']"));
        mobileField.clear();
        mobileField.sendKeys(mobile);
    }

    private void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder='Enter email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    private void sendOTP(String otp) throws InterruptedException {
        WebElement sendButton = driver.findElement(By.xpath("//button[normalize-space()='Send OTP']"));
        sendButton.click();
        Thread.sleep(1000);

        WebElement otpField = driver.findElement(By.xpath("//div[@id='otp']//div[1]//input[1]"));
        otpField.sendKeys(otp);

        WebElement verifyButton = driver.findElement(By.xpath("//button[normalize-space()='Verify']"));
        verifyButton.click();
    }

    private void selectDesignation(String designation) {
        WebElement designationButton = driver.findElement(By.xpath("//button[normalize-space()='" + designation + "']"));
        designationButton.click();
    }

    private void submitDetails() {
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        submitButton.click();
    }

    private void enterCompanyName(String companyName) {
        WebElement manualEntryButton = driver.findElement(By.xpath("//button[normalize-space()='Click here']"));
        manualEntryButton.click();

        WebElement companyEntryField = driver.findElement(By.xpath("//input[@id='inputid']"));
        companyEntryField.clear();
        companyEntryField.sendKeys(companyName);
    }

    private void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueButton.click();
    }

    private void bookActivationMeeting() {
        WebElement bookButton = driver.findElement(By.cssSelector(".ml-2"));
        bookButton.click();
    }

    private void submitOTP(String otp) {
        WebElement otpField = driver.findElement(By.xpath("//div[@id='otp']//div[1]//input[1]"));
        otpField.click();
        otpField.sendKeys(otp);

        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        submitButton.click();
    }

    private void addEmployeeViaForm(String name, String email, String phone, String employeeCode) {
        WebElement formButton = driver.findElement(By.cssSelector("span[class='border-b border-black']"));
        formButton.click();

        WebElement nameField = driver.findElement(By.cssSelector("input[placeholder='Enter Employee Name']"));
        nameField.clear();
        nameField.sendKeys(name);

        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Enter Your Email ID']"));
        emailField.clear();
        emailField.sendKeys(email);

        WebElement phoneField = driver.findElement(By.cssSelector("input[placeholder='Enter phone number']"));
        phoneField.clear();
        phoneField.sendKeys(phone);

        WebElement employeeCodeField = driver.findElement(By.cssSelector("input[placeholder='Enter employee code']"));
        employeeCodeField.sendKeys(employeeCode);

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }
    
    
}
