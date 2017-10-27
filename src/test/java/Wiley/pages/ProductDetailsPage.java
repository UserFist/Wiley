package Wiley.pages;

import Wiley.driver.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import static Wiley.pages.HomePage.KEY;

public class ProductDetailsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='links-site']//li[1]/a")
    private WebElement linkHome;

    @FindBy(css = ".productDetail-title")
    private WebElement headerTile;

    public HomePage clickHome() {
        linkHome.click();
        return new HomePage();
    }

        public ProductDetailsPage checkHeaderEqualToTheTitle() {
            String headerInSearchResult = System.getProperty(KEY);
            Browser.waitDriver().until(ExpectedConditions.visibilityOf(headerTile));
            Assert.assertEquals(headerInSearchResult, headerTile.getText());
            return new ProductDetailsPage();
        }


    }

