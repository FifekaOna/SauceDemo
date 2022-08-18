package Utility;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Action extends PageObject {
    @Managed
    WebDriver driver =getDriver();

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void SelectByVisibleText(By element, String text){
        Select dropDown = new Select(driver.findElement(element));
        dropDown.selectByVisibleText(text);
    }
}
