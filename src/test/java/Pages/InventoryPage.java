package Pages;

import net.thucydides.core.pages.PageObject;

public class InventoryPage extends PageObject {
    private  String pageURl= "https://www.saucedemo.com/inventory.html";
    public String getPageURl() {
        return pageURl;
    }

    public void setPageURl(String pageURl) {
        this.pageURl = pageURl;
    }
}
