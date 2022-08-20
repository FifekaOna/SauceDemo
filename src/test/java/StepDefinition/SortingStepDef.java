package StepDefinition;

import Pages.InventoryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class SortingStepDef {
    InventoryPage inventoryPage;

    @When("I sort the product by {string}")
    public void i_order_product_by(String sortMethod) {
        inventoryPage.sortProduct(sortMethod);
    }

    @Then("Sort menu shows {string}")
    public void sort_menu_shows(String sortMethod) {
        assertEquals("Product is not sorted by " + sortMethod, sortMethod, inventoryPage.getSortStatus());

    }

    @Then("Product sorted by {string}")
    public void product_sorted_by(String sortMethod) {
        assertTrue("Product is not sorted by " + sortMethod, inventoryPage.checkSortResult(sortMethod));
    }

}
