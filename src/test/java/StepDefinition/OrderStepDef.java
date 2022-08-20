package StepDefinition;

import Pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderStepDef {
    CartPage cartPage;

    @Given("My cart is empty")
    public void myCartIsEmpty() {
        cartPage.goToPage()
                .allProductRemoved();
    }

    @And("Product is sorted with {string}")
    public void productIsSortedWith(String sortMethod) {
    }

    @When("I click the first product on the list")
    public void iClickTheFirstOnTheList() {

    }

    @Then("Product with {string} and {string} detail opened")
    public void productDetailOpened(String productName, String productPrice) {
    }

    @When("I click add to cart button")
    public void iClickAddToCartButton() {

    }

    @And("I click cart icon")
    public void iClickCartIcon() {

    }

    @Then("{string} is on the cart list")
    public void productIsOnTheCartList(String productName) {
    }

    @When("I click checkout button")
    public void iClickCheckoutButton() {
    }

    @Then("Buyer data form appear")
    public void buyerDataFormAppear() {
    }

    @When("I fill my data with {string},{string} and {string}")
    public void fillCheckoutData(String firstName, String lastName, String ZIP) {
    }

    @Then("Shopping list appear")
    public void shoppingListAppear() {
    }

    @When("I click finish button")
    public void iClickFinishBUtton() {
    }

    @Then("Order process completed")
    public void orderProcessCompleted() {
    }
}
