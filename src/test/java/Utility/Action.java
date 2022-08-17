package Utility;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class Action extends PageObject {
    @Managed
    WebDriver driver =getDriver();

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
