package Pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverviewPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();

    //Element
    private final By header = By.className("title");
    private final By itemName= By.className("inventory_item_name");
    private final By itemPrice =By.className("inventory_item_price");
    private final By finishButton = By.id("finish");

    //Page Action
    public String getItemName() {
        return driver.findElement(itemName).getAttribute("innerHTML");
    }

    public String getItemPrice() {
        return driver.findElement(itemPrice).getAttribute("innerHTML");
    }

    public String getTittle(){
        return driver.findElement(header).getText();
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
}
