package Pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class InventoryPage extends PageObject {
    @Managed
    WebDriver driver =getDriver();
    private  String pageURl= "https://www.saucedemo.com/inventory.html";
    public String getPageURl() {
        return pageURl;
    }

    public void setPageURl(String pageURl) {
        this.pageURl = pageURl;
    }

}
