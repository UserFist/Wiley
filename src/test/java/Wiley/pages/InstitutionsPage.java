package Wiley.pages;

import Wiley.driver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InstitutionsPage extends AbstractPage {

    public void checkLinkOnTab(String institutionUrlExpected) {
        WebDriver driver = Browser.init();
        driver.switchTo().window(driver.getWindowHandle()).close();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.switchTo().defaultContent();
        String newTabURL = Browser.init().getCurrentUrl();
        Assert.assertEquals(newTabURL, institutionUrlExpected);
    }
}
