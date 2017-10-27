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
    private static final Long DEFAULT_TIMEOUT= 60L;

    static {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
    }

    private Browser(){}

    public static WebDriver init(){
        if(null == driver){
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver,DEFAULT_TIMEOUT);
            driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static WebDriverWait waitDriver(){
        return wait;
    }
}
