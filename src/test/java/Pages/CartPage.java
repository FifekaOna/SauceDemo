package Pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();
    //Url
    private String pageURl = "https://www.saucedemo.com/cart.html";
    //Element
    private final By removeButton= By.id("remove-sauce-labs-backpack");

    //Page action
    public CartPage goToPage(){
        driver.get(pageURl);
        return this;
    }
    public CartPage clickRemoveButton(){
        driver.findElement(removeButton).click();
        return this;
    }
    public CartPage allProductRemoved(){
        List<WebElement> removeButtons = driver.findElements(removeButton);
        for (WebElement rb :removeButtons){
            rb.click();
        }
        return  this;
    }
}
