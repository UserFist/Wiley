package Wiley.pages;

import Wiley.driver.Browser;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(Browser.init(), this);
    }

}
