package Wiley.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static DesiredCapabilities capabilities;

    static {
//        System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
//        capabilities = DesiredCapabilities.firefox();
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("marionette", false);
        capabilities.setCapability("acceptInsecureCerts", true);
    }

    private Browser(){}

    public static WebDriver init(){
        if(null == driver){
            driver = new ChromeDriver(capabilities);
//            driver = new FirefoxDriver(capabilities);
            wait = new WebDriverWait(driver,60);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static WebDriverWait waitDriver(){
        return wait;
    }
}
