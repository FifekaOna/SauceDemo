package StepDefinition;

import Pages.InventoryPage;
import io.cucumber.java.en.Given;
import static org.junit.Assert.*;

public class NavigationStepDef {
    InventoryPage inventoryPage;
    @Given("I am on the inventory page")
    public void i_am_on_the_inventory_page() {
        inventoryPage.goToPage();
    }
}
