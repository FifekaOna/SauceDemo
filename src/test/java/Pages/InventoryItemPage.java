package Pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();
    //Element
    private final By itemName = By.className("inventory_details_name");
    private final By itemPrice = By.className("inventory_details_price");
    private final By addToCartButton = By.className("btn_inventory");


    //Page Action
    public String getItemName() {
        return driver.findElement(itemName).getAttribute("innerHTML");
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getAttribute("innerHTML");
    }

    public InventoryItemPage clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
        return this;
    }
}
