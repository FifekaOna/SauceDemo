package Pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage extends PageObject {
    @Managed
    WebDriver driver = getDriver();

    //Element
    private final By header = By.className("title");

    //Page Action
    public String getTittle(){
        return driver.findElement(header).getText();
    }
}
