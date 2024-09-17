package tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.Base;

import java.net.MalformedURLException;
import java.util.Random;

public class CreateAccountTest extends Base {

    @BeforeMethod
    public void setup() throws MalformedURLException {
        openBrowser("Chrome", "Windows 11", "latest");
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void createAccount() {
        // Perform actions using the driver initialized in the Base class
        driver.findElement(By.xpath("//a[text() = 'Create an Account'][1]")).click();
        driver.findElement(By.id("firstname")).sendKeys(generateRandomFName());
        driver.findElement(By.id("lastname")).sendKeys(generateRandomLName());
        driver.findElement(By.id("email_address")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("password")).sendKeys("Admin@123");
        driver.findElement(By.id("password-confirmation")).sendKeys("Admin@123");
        driver.findElement(By.cssSelector("button[title='Create an Account'] span")).click();
        driver.findElement(By.xpath("//div[@class='message-success success message']")).isDisplayed();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public String generateRandomEmail() {
        String emailPrefix = "Sam";
        String emailDomain = "@yopmail.com";
        int randomNum = new Random().nextInt(1000);
        return emailPrefix + randomNum + emailDomain;
    }

    public String generateRandomFName() {
        String[] firstNames = { "John", "Jane", "Alex", "Emily", "Michael", "Sarah" };
        Random random = new Random();
        return firstNames[random.nextInt(firstNames.length)];
    }
    public String generateRandomLName() {
        String[] lastNames = { "Doe", "Smith", "Johnson", "Williams", "Jones", "Brown" };
        Random random = new Random();
        return lastNames[random.nextInt(lastNames.length)];
    }


}
