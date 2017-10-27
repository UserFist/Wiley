package Wiley.pages;

import Wiley.driver.Browser;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StudentPage extends AbstractPage {

    @FindBy(xpath = "//ul[@class='autonavLevel1']/li/*[1]")
    private List<WebElement> menuOnTheLeftActual;

    @FindBy(xpath = "//ul[@class='autonavLevel1']/li[@class='autonavItem']")
    private List<WebElement> unselectedItemsMenuOnTheLeft;

    @FindBy(xpath = "//ul[@class='autonavLevel1']/li[@class='active autonavItem parent']")
    private WebElement selectedItemsMenuOnTheLeft;

    @FindBy(css = "#page-title>h1")
    private WebElement studentsHeaderActual;

    @FindBy(xpath = ".//*[@id='links-site']//a")
    private WebElement buttonHome;

    public StudentPageCheck checker() {
        return this.new StudentPageCheck();
    }

    public HomePage clickHome() {
        buttonHome.click();
        return new HomePage();
    }

    public class StudentPageCheck {
        public StudentPageCheck checkStudentHeader(String studentsHeader) {
            Assert.assertEquals(studentsHeaderActual.getText(), studentsHeader);
            return this;
        }

        public StudentPageCheck checkMenuOnTheLeft(List<String> expectedListMenuOnTheLeft) {
            for (int c = 0; c < menuOnTheLeftActual.size(); c++) {
                Assert.assertEquals(expectedListMenuOnTheLeft.get(c), menuOnTheLeftActual.get(c).getText());
            }
            Assert.assertEquals(menuOnTheLeftActual.size(), expectedListMenuOnTheLeft.size());
            return this;
        }

        public StudentPage studentsItemStyleAndClickable() {
            Assert.assertTrue(selectedItemsMenuOnTheLeft.getAttribute("class").contains("active"));

            for (int d = 0; d < unselectedItemsMenuOnTheLeft.size(); d++) {
                Assert.assertFalse(unselectedItemsMenuOnTheLeft.get(d).getAttribute("class").equals(selectedItemsMenuOnTheLeft.getAttribute("class")));
            }
            Assert.assertFalse(isClickable(selectedItemsMenuOnTheLeft));
            return new StudentPage();
        }

        public StudentPageCheck checkStudentsLink(String expectedStudentsLink) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String currentUrl = Browser.init().getCurrentUrl();
            Assert.assertTrue(currentUrl.contains(expectedStudentsLink));
            return this;
        }
    }

    private boolean isClickable(WebElement element) {
        return element.getAttribute("href") != null;
    }
}
