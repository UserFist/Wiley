package Wiley.pages;

import Wiley.driver.Browser;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Wiley.driver.Browser.waitDriver;

public class HomePage extends AbstractPage {

    public static final String KEY = "book.name";

    @FindBy(xpath = "//*[@id='links-site']//a")
    private List<WebElement> headerListActual;

    @FindBy(xpath = "//*[@id='homepage-links']//a")
    private List<WebElement> subHeaderActual;

    @FindBy(xpath = "//*/a[.='Students']")
    private WebElement linkStudentsActual;

    @FindBy(css = "#EmailAddress")
    private WebElement emailAdressField;

    @FindBy(css = "[class='submit']")
    private WebElement emailFieldSubmit;

    @FindBy(css = "#query")
    private WebElement searchField;

    @FindBy(css = "[class='icon icon__search search-form-submit']")
    private WebElement searchFieldSubmit;

    @FindBy(css = ".resource-institutions>a")
    private WebElement linkInstitutions;

    public StudentPage clickStudentLink() {
        linkStudentsActual.click();
        return new StudentPage();
    }

    public void clickInstitutions() {
        Browser.waitDriver().until(ExpectedConditions.visibilityOf(linkInstitutions));
        linkInstitutions.click();
    }


    public void checkNavigationMenu(List<String> constListNavigationMenu) {
        for (int i = 0; i < headerListActual.size(); i++) {
            Assert.assertEquals(headerListActual.get(i).getText(), constListNavigationMenu.get(i));
        }
    }

    public void checkResourcesItemsTitle(List<String> expectedResourcesSubHeader) {
        for (int b = 0; b < subHeaderActual.size(); b++) {
            Assert.assertEquals(subHeaderActual.get(b).getText(), expectedResourcesSubHeader.get(b));
            Assert.assertEquals(subHeaderActual.size(), expectedResourcesSubHeader.size());
        }
    }

    public void checkEmailAddressFieldByEmail(String email, String alertExpected) {
        waitDriver().until(ExpectedConditions.visibilityOf(emailAdressField));
        emailAdressField.clear();
        emailAdressField.sendKeys(email);
        emailFieldSubmit.click();
        Alert alert = Browser.init().switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, alertExpected);
        alert.accept();

    }

    public SearchResultPage checkSearchField(String keyForSearch) {
        searchField.clear();
        if (!keyForSearch.isEmpty()) {
            searchField.sendKeys(keyForSearch);
        }
        searchFieldSubmit.click();
        return new SearchResultPage();
    }

    public void switchOnTab() {
        Browser.init().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "tab");
    }

}





