package Pages;

import Utility.Action;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class InventoryPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();
    //helper
    Action action = new Action();
    //Url
    private String pageURl = "https://www.saucedemo.com/inventory.html";
    // element
    private final By productSortContainer = By.className("product_sort_container");
    private final By activeSortOption= By.className("active_option");
    private final By itemPrice = By.className("inventory_item_price");
    private final By firstItemOnTheList = By.cssSelector("#inventory_container > div > div:nth-child(1) > .inventory_item_description > .inventory_item_label >a >div");

    //settergetter
    public String getPageURl() {
        return pageURl;
    }

    public void setPageURl(String pageURl) {
        this.pageURl = pageURl;
    }

    //Page action
    public InventoryPage goToPage(){
        driver.get(pageURl);
        return this;
    }

    public InventoryPage sortProduct(String sortMethod) {
        action.SelectByVisibleText(productSortContainer, sortMethod);
        return this;
    }

    public String getSortStatus (){
        return driver.findElement(activeSortOption).getAttribute("innerHTML");
    }

    public boolean checkSortResult(String sortMethod){
        switch (sortMethod){
            case "Price (high to low)":
               return  checkSortByPriceHighLow();
            case"":
                break;
        }
        return false;
    }

    private boolean checkSortByPriceHighLow(){
        List<WebElement> itemPriceElement = driver.findElements(itemPrice);
        List<Double> itemPriceList= new ArrayList<>();
        for (WebElement p: itemPriceElement){
            itemPriceList.add(Double.valueOf(p.getText().replace("$","")));
        }
        List<Double> sortedlist= itemPriceList;
        Collections.sort(sortedlist);
        return itemPriceList.equals(sortedlist);

    }
    public InventoryPage clickFirstItemOnTheList(){
        driver.findElement(firstItemOnTheList).click();
        return this;
    }


}
