package resources;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;




public class Base {

    public RemoteWebDriver driver;
    String USERNAME = "oauth-adjadeja14192-05f71";
    String ACCESS_KEY = "9253d44b-e245-456e-a55e-cb3f4812aabf";
    String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    @Parameters({"browser","platform","version"})
    public void openBrowser(String browser, String platform, String version) throws MalformedURLException {

        if(browser.equalsIgnoreCase("Chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPlatformName(platform);
            chromeOptions.setBrowserVersion(version);
            URL url = new URL(URL);
            driver = new RemoteWebDriver(url, chromeOptions);
        }

        else if(browser.equalsIgnoreCase("Edge")){
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setPlatformName(platform);
            edgeOptions.setBrowserVersion(version);
            URL url = new URL(URL);
            driver = new RemoteWebDriver(url, edgeOptions);
        }
        else if(browser.equalsIgnoreCase("Firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPlatformName(platform);
            firefoxOptions.setBrowserVersion(version);
            URL url = new URL(URL);
            driver = new RemoteWebDriver(url, firefoxOptions);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
}
