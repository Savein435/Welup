package tester;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.Thread;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Class {

   // public WebDriver driver;
    WebDriver driver = new ChromeDriver();
    String URL = "https://q.savein.money/OdYm";
    String PAN = "BDBPS9453C";
    
    
    

    @BeforeMethod
    public void setup() throws InterruptedException {
        // Use WebDriverManager to handle driver binaries
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.get("https://www.savein.money");
        //driver.get("https://www.savein.money");	
        
        
        
    }
    @Test(priority=1)
    public void Pan() throws InterruptedException
    {
    	driver.get(URL);	
    	driver.manage().window().maximize();
        Thread.sleep(20);
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")); // Checkbox button
        Thread.sleep(20);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")).click();
        Thread.sleep(20);
        
        driver.findElement(By.xpath("//button[normalize-space()='Continue application']")).click(); // CONTINue CTA
        Thread.sleep(200);
        //driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1)")).click();//Yes Button
        //Thread.sleep(20000);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")).click(); //No button
        Thread.sleep(400);
        //driver.findElement(By.linkText("Continue Application")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[4]/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).sendKeys(PAN);
        Thread.sleep(900);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).sendKeys("10/02/1998");
        Thread.sleep(900);
        driver.findElement(By.cssSelector("img[src='/assets/unCheckedBox-bc143899.svg']")).click();
        Thread.sleep(300);
        driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
        Thread.sleep(30000);
        }
    @Test(priority=2)
    public void Adhaar() throws InterruptedException
    {
    	driver.get(URL);	
    	driver.manage().window().maximize();
        Thread.sleep(20);
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")); // Checkbox button
        Thread.sleep(20);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")).click();
        Thread.sleep(20);
        driver.findElement(By.xpath("//button[normalize-space()='Continue application']")).click(); // CONTINue CTA
        Thread.sleep(20);
        driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click(); //Continue Cta on reload
        Thread.sleep(40);
        driver.findElement(By.xpath("//input[@id='inputid']")).sendKeys("475366331970"); // Send Adhaar 
        Thread.sleep(30);
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div//img")).click();//Click on Conntinue adhaar button
        Thread.sleep(40);
        driver.findElement(By.xpath("//button[normalize-space()='Next']")).click(); // Checkbox click
        Thread.sleep(9000);
        driver.findElement(By.xpath("//div[@id='otp']//div[1]//input[1]")).sendKeys("123456"); // Send OTP
        Thread.sleep(90);
        driver.findElement(By.xpath("//button[normalize-space()='Verify & Proceed']")).click(); // Verify annd Proceed Button
       Thread.sleep(9000);
       driver.findElement(By.xpath("//button[@class='cta']")).click();// Yes its me CTA
       Thread.sleep(4500);
       }
    @Test(priority  = 3)
    public void Selfie() throws Exception
    {
    	//Camera Permission Handling
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "130.0.6723.59");
        caps.setCapability("os_version", "11");
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        
        WebDriver driver = new ChromeDriver(options);
        
       
        // Code
    	driver.get(URL);	
    	driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")); // Checkbox button
        Thread.sleep(2000);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")).click();
        Thread.sleep(20);
        driver.findElement(By.xpath("//button[normalize-space()='Continue application']")).click(); // CONTINue CTA
        Thread.sleep(20);
     // Create WebDriverWait instance and wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Continue']")));

        // Now click the button
        CTA.click();
        driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
        Thread.sleep(20000);
        WebElement Camera = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='h-[70px] w-[70px] rounded-full bg-savein-blue flex items-center justify-center text-white hover:scale-105']")));
        Camera.click();
        Thread.sleep(20000);
        Camera.click();
        Thread.sleep(20000);
        Thread.sleep(20000);
        driver.findElement(By.xpath("//button[@class='cta ']")).click();

    }
    @Test(priority=4)
    public void Professional() throws Exception
    {
    	driver.get(URL);	
    	driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")); // Checkbox button
        Thread.sleep(2000);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")).click();
        Thread.sleep(20);
        driver.findElement(By.xpath("//button[normalize-space()='Continue application']")).click(); // CONTINue CTA
        Thread.sleep(20);
     // Create WebDriverWait instance and wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Continue']")));

        // Now click the button
        CTA.click();
        
        //
        driver.findElement(By.xpath("//input[@id='inputid']")).sendKeys("sadkjhjas@gmail.com");
        Thread.sleep(2000); 
        driver.findElement(By.xpath("//body/div/div/div/div/div/div[3]/div[1]/button[1]")).click();
        Thread.sleep(2300);
        driver.findElement(By.xpath("//div[normalize-space()='Graduate']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div/div/div/div/div/div[4]/div[1]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[4]//div[1]//div[1]//div[1]//div[2]//button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
        Thread.sleep(20000);
        
        
    	
    }
    @Test(priority=5)
    public void Criff() throws Exception
    {
    	driver.get(URL);	
    	driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")); // Checkbox button
        Thread.sleep(2000);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")).click();
        Thread.sleep(20);
        driver.findElement(By.xpath("//button[normalize-space()='Continue application']")).click(); // CONTINue CTA
        Thread.sleep(20);
     // Create WebDriverWait instance and wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        WebElement CTA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Continue']")));

        // Now click the button
        CTA.click();
        
        //
        driver.findElement(By.cssSelector("img[src='/assets/unCheckedBox-bc143899.svg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Check my credit Limit']")).click();
        
        Thread.sleep(40000);
        
        
        
    }
    @Test(priority=5)
    public void CustomerLogin() throws Exception
    {
    	driver.get("https://qa.customer.savein.money");	
    	driver.manage().window().maximize();
        Thread.sleep(20);
        driver.findElement(By.xpath("//input[@id='inputid']")).sendKeys("8237490832");
        Thread.sleep(200);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(200);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
       WebElement approve = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Continue']")));

     }
    
    @Test(priority=6)
    public void CCFLOw() throws InterruptedException
    {
    	driver.get("https://u1.savein.money/lRE");	
    	driver.manage().window().maximize();
        Thread.sleep(20);
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")); // Checkbox button
        Thread.sleep(20);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
        driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div[1]")).click();
        Thread.sleep(20);
        
        driver.findElement(By.xpath("//button[normalize-space()='Continue application']")).click(); // CONTINue CTA
        Thread.sleep(200);
        //driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1)")).click();//Yes Button
        //Thread.sleep(20000);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).sendKeys("34000");
        Thread.sleep(200);
        driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div/img[1]")).click();
        Thread.sleep(200);
        driver.findElement(By.xpath("//button[normalize-space()='Proceed']")).click();
        Thread.sleep(2000);
        driver.switchTo().frame(1);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".stack.svelte-j1plw7.horizontal")).click();
        Thread.sleep(2000);
        
    }
    

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

