package Wiley.tests;

import Wiley.driver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public abstract class BaseTest {
    private WebDriver driver = Browser.init();

    @Test
    public abstract void test();

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }
}
