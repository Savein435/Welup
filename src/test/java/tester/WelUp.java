package tester;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import java.lang.Thread;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelUp {

   // public WebDriver driver;
    WebDriver driver = new ChromeDriver();
    String URL = "https://qa.welup.savein.money/signup";
    
    
    
    

    @BeforeMethod
    public void setup() throws InterruptedException {
        // Use WebDriverManager to handle driver binaries
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.get("https://www.savein.money");
        //driver.get("https://www.savein.money");	
        
        
        
    }
    @Test (priority = 1)
    public void EmployerOnboard() throws InterruptedException
    {
    	driver.get(URL);	
    	driver.manage().window().maximize();
        Thread.sleep(20);
        //Name
        WebElement Name = driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Name.click();
        Name.clear();
        Name.sendKeys("Ayush Tiwari");
        //
        Thread.sleep(200);
        //Mobile number 
        WebElement Mobile = driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"));
        Mobile.click();
        Mobile.sendKeys("398778");
        System.out.println("Invalid Number Check Passed");
        Mobile.sendKeys("2873849723");
        System.out.println("Valid Number Check Passed");
        Thread.sleep(200);
        //Email
        WebElement Email = driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Email.clear();
        Email.sendKeys("randomeirui@gmail.com");
        System.out.println("Valid Email Check Passed");
        Thread.sleep(2000);
        //Send OTP 
        WebElement Send = driver.findElement(By.xpath("//button[normalize-space()='Send OTP']"));
        Send.click();
        Thread.sleep(200);
        //Enter OTP
        WebElement OTP = driver.findElement(By.xpath("//div[@id='otp']//div[1]//input[1]"));
        OTP.sendKeys("1111111");
        System.out.println("Valid OTP Check Passed");
        Thread.sleep(200);
        //Verify OTP
        WebElement verify = driver.findElement(By.xpath("//button[normalize-space()='Verify']"));
        verify.click();
        Thread.sleep(200);
        //Select Designation
        WebElement Designation = driver.findElement(By.xpath("//button[normalize-space()='HR']"));
        Designation.click();
        Thread.sleep(200);
        // Submit Detail
        WebElement Submit = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        Submit.click();
        Thread.sleep(200);
        
        
        // Company Name Entry
        
        //Couldn't Find your company
        WebElement Manual = driver.findElement(By.xpath("//button[normalize-space()='Click here']"));
        Manual.click();
        Thread.sleep(200);
        //Type Your Company name 
        WebElement CompanyEntry = driver.findElement(By.xpath("//input[@id='inputid']"));
        CompanyEntry.clear();
        CompanyEntry.sendKeys("Test Company Entry");
        System.out.println("Manual Entry Of Company Name");
        Thread.sleep(200);
        
        
        //Continue Button
        WebElement Continue2 = driver.findElement(By.cssSelector("//button[normalize-space()='Continue']"));
        Continue2.click();
        System.out.println("Continue Button Clicked");
        Thread.sleep(200);
         
        	
        // Plan Overview Continue
        Continue2.click();
        System.out.println("Plan Selected");
        Thread.sleep(200);
        
        //Book Activation Meeting Popup
        //Book Activation meeting 
        
        WebElement Book = driver.findElement(By.cssSelector(".ml-2"));
        Book.click();
        
        
        
        
       
        
        }
    @Test (priority = 2)
    public void Login() throws InterruptedException
    {
    	driver.get("https://qa.welup.savein.money/login");	
    	driver.manage().window().maximize();
        Thread.sleep(20);
        // Enter Email
        WebElement Email = driver.findElement(By.xpath("//input[@id='inputid']"));
       Email.click();
       Email.clear();
       Email.sendKeys("dogroppicare-3776@yopmail.com");
       System.out.println("Email Entered ");
       Thread.sleep(200);
       
       //Continue Click 
       WebElement Continue = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
       Continue.click();
       
       //Submit OTP
       WebElement EnterOTP = driver.findElement(By.xpath("//div[@id='otp']//div[1]//input[1]"));
       EnterOTP.click();
       EnterOTP.sendKeys("111111");
       
       //submit Otp ;
       WebElement VerifyOTP = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
       VerifyOTP.click();
       
       
       
    	
    }
    @Test (priority = 3)
    public void AddEmployee() throws InterruptedException
    {
    	//Employee Login
    	Login();
    	
    	//Select Employee Management
    	WebElement EmployeeManagement = driver.findElement(By.xpath("//button[normalize-space()='Employee Management']"));
    	EmployeeManagement.click();
    	
    	System.out.print("PAssed");
    	
    	//Add Employee Button Click
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        WebElement AddEmployee = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Add Employee')])[1]")));
    	AddEmployee.click();
    	
    	//Add Employees Via Form 
    	WebElement Form = driver.findElement(By.cssSelector("span[class='border-b border-black']"));
    	Form.click();
    	
    	   // Form Entry 
    	   //Name
    	WebElement EmployeeName = driver.findElement(By.cssSelector("input[placeholder='Enter Employee Name']"));
    	EmployeeName.clear();
    	EmployeeName.sendKeys("Ayush Tiwari");
    	
    	    //Email
    	WebElement WorkEmail = driver.findElement(By.xpath("//input[@placeholder='Enter Your  Email ID']"));
    	WorkEmail.clear();
    	WorkEmail.sendKeys("randomworkemail@gmail.com");
    	
    	    //Enter Phone Number
    	WebElement  WorkPhone = driver.findElement(By.cssSelector("input[placeholder='Enter phone number']"));
    	WorkPhone.clear();
    	WorkPhone.sendKeys("9928492949");
    	
    	   // Employee Code
    	WebElement ECODE = driver.findElement(By.cssSelector("input[placeholder='Enter employee code']"));
    	ECODE.sendKeys("SI38390");
    	
    	
    	//Submit Detail
    	WebElement SubmitDetail = driver.findElement(By.cssSelector("button[type='submit']"));
    	SubmitDetail.click();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

    @Test (priority = 4)
    public void DeleteEmployee() throws InterruptedException
    {
    	//Employee Login
    	Login();
    	
    	//Select Employee Management
    	WebElement EmployeeManagement = driver.findElement(By.xpath("//button[normalize-space()='Employee Management']"));
    	EmployeeManagement.click();
    	
    	System.out.println("PAssed");
    	
    }
    	
    
    
    
   
   
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

