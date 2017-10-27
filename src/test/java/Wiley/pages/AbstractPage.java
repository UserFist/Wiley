package Wiley.pages;

import Wiley.driver.Browser;
import org.openqa.selenium.support.PageFactory;
import java.util.Iterator;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(Browser.init(), this);
    }

//    public void switchToLastOpenedTab(){
//        String currentUrl = Browser.init().getCurrentUrl();
//
//        Iterator<String> iter = Browser.init().getWindowHandles().iterator();
//        while ( iter.hasNext() && Browser.init().getCurrentUrl().equals(currentUrl)){
//            Browser.init().switchTo().window(iter.next());
//        }
//    }
}
