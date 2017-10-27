package Wiley.pages;

import Wiley.driver.Browser;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.Random;


public class SearchResultPage extends AbstractPage {

    public static final String KEY = "book.name";

    @FindBy(css = ".product-title>a")
    public List<WebElement> searchResultList;

    @FindBy(css = "#search-results")
    public WebElement searchResult;

    public void checkSearchResultListIsNotEmpty() {
        Assert.assertTrue(searchResultList.size() > 0);
    }

    public ProductDetailsPage clickAndSetBookTitle() {
        Browser.waitDriver().until(ExpectedConditions.visibilityOf(searchResult));
        WebElement randomBook = searchResultList.get(new Random().nextInt(searchResultList.size()));
        System.setProperty(KEY, randomBook.getText());
        randomBook.click();
        return new ProductDetailsPage();
    }

}
