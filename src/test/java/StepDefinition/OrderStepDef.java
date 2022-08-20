package StepDefinition;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class OrderStepDef {
    CartPage cartPage;
    InventoryPage inventoryPage;
    InventoryItemPage inventoryItemPage;
    HeaderMenuPage headerMenuPage;
    CheckoutBuyerInformationPage checkoutBuyerInformationPage;
    CheckOutOverviewPage checkOutOverviewPage;
    CheckOutCompletePage checkOutCompletePage;

    @Given("My cart is empty")
    public void myCartIsEmpty() {
        cartPage.goToPage()
                .allProductRemoved();
    }

    @And("Product is sorted with {string}")
    public void productIsSortedWith(String sortMethod) {
        inventoryPage.sortProduct(sortMethod);
    }

    @When("I click the first product on the list")
    public void iClickTheFirstOnTheList() {
        inventoryPage.clickFirstItemOnTheList();
    }

    @Then("Product with {string} and {string} detail opened")
    public void productDetailOpened(String productName, String productPrice) {
        assertEquals("Product name is not "+productName,productName,inventoryItemPage.getItemName());
        assertEquals("Product price is not "+productName,productPrice,inventoryItemPage.getItemPrice());
    }

    @When("I click add to cart button")
    public void iClickAddToCartButton() {
        inventoryItemPage.clickAddToCartButton();
    }

    @And("I click cart icon")
    public void iClickCartIcon() {
        headerMenuPage.clikCartIcon();

    }

    @Then("{string} is on the cart list with price {string}")
    public void productIsOnTheCartList(String productName, String productPrice) {
        assertEquals("Product name is not "+productName,productName,cartPage.getItemName());
        assertEquals("Product price is not "+productName,productPrice,cartPage.getItemPrice());
    }

    @When("I click checkout button")
    public void iClickCheckoutButton() {
        cartPage.clickCheckOutButton();
    }

    @Then("Buyer data form appear")
    public void buyerDataFormAppear() {
        assertEquals("Buyer data form does not appear","CHECKOUT: YOUR INFORMATION",checkoutBuyerInformationPage.getTittle());
    }

    @When("I fill my data with {string},{string} and {string}")
    public void fillCheckoutData(String firstName, String lastName, String ZIP) {
        checkoutBuyerInformationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillZIP(ZIP)
                .clickContinueButton();
    }

    @Then("Shopping list appear with {string} which price {string}")
    public void shoppingListAppear( String productName, String productPrice) {
        assertEquals("Check out Overview does not appear","CHECKOUT: OVERVIEW",checkOutOverviewPage.getTittle());
        assertEquals("Product name is not "+productName,productName,checkOutOverviewPage.getItemName());
        assertEquals("Product price is not "+productName,productPrice,checkOutOverviewPage.getItemPrice());
    }

    @When("I click finish button")
    public void iClickFinishBUtton() {
        checkOutOverviewPage.clickFinishButton();
    }

    @Then("Order process completed")
    public void orderProcessCompleted() {
        assertEquals("Check out Fail","CHECKOUT: COMPLETE!",checkOutCompletePage.getTittle());
    }
}
