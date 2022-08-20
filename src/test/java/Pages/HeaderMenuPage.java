package Pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenuPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();

    //element
    private final By cartIcon = By.className("shopping_cart_link");

    //PageAction
    public void clikCartIcon(){
        driver.findElement(cartIcon).click();
    }
}
