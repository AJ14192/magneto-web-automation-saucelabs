package tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.Base;

import java.net.MalformedURLException;

public class SigninTest extends Base {

    @BeforeMethod
    public void setup() throws MalformedURLException {
        // Calling openBrowser to initialize the driver
        openBrowser("Chrome", "Windows 11", "latest");
        // Use the 'driver' initialized in the Base class
        driver.get("https://magento.softwaretestingboard.com/");
    }

   @Test
    public void Signin() throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("unik45@yopmail.com");
        driver.findElement(By.id("pass")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")).click();
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in']")).isDisplayed();

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
