package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.Base;

import java.net.MalformedURLException;
import java.util.Random;

public class BuyProductTest extends Base {

    @BeforeMethod
    public void setup() throws MalformedURLException {
        // Calling openBrowser to initialize the driver
        openBrowser("Chrome", "Windows 11", "latest");
        // Use the 'driver' initialized in the Base class
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void BuyProduct() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("unik45@yopmail.com");
        driver.findElement(By.id("pass")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")).click();

        Actions action = new Actions(driver);

        WebElement menmenu = driver.findElement(By.xpath("//a[@id='ui-id-5']"));
        WebElement topwear = driver.findElement(By.xpath("//a[@id='ui-id-17']"));
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-19']"));

        action.moveToElement(menmenu).perform();
        action.moveToElement(topwear).perform();
        action.moveToElement(jackets).click().perform();

        driver.findElement(By.xpath("//a[@class='product-item-link'][normalize-space()='Proteus Fitness Jackshirt']")).click();
        driver.findElement(By.id("option-label-size-143-item-168")).click();
        driver.findElement(By.id("option-label-color-93-item-56")).click();
        WebElement productQuantity = driver.findElement(By.id("qty"));
        productQuantity.clear();
        productQuantity.sendKeys("2");
        driver.findElement(By.id("product-addtocart-button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("top-cart-btn-checkout")).click();
//        driver.findElement(By.name("company")).sendKeys("Google Inc");
//        driver.findElement(By.name("street[0]")).sendKeys("F 150 first floor zulu mall");
//        driver.findElement(By.name("street[1]")).sendKeys("SG highway");
//        driver.findElement(By.name("street[2]")).sendKeys("Gota");
//        driver.findElement(By.name("city")).sendKeys("Ahmedabad");
//        selectCountry(driver.findElement(By.name("country_id")),"India" );
//        selectState(driver.findElement(By.name("region_id")),"Gujarat" );
//        driver.findElement(By.name("postcode")).sendKeys("385645");
//        driver.findElement(By.name("telephone")).sendKeys(generateRandomMobile());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@title='Place Order']")).click();
        driver.findElement(By.xpath("//span[@class='base'][text()='Thank you for your purchase!']")).isDisplayed();

    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void selectCountry(WebElement webElement, String countryName) {
        Select dropdown = new Select(webElement);  // Corrected usage
        dropdown.selectByVisibleText(countryName);
    }

    public void selectState(WebElement webElement, String stateName) {
        Select dropdown = new Select(webElement);  // Corrected usage
        dropdown.selectByVisibleText(stateName);
    }
    public String generateRandomMobile() {
        Random random = new Random();
        long min = 1000000000L;
        long max = 9999999999L;
        long randomNumber = min + (long) (random.nextDouble() * (max - min));
        return String.valueOf(randomNumber);
    }


}
