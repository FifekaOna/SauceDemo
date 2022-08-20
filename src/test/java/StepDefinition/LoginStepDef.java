package StepDefinition;

import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.Action;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.*;

public class LoginStepDef {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    Action action;

    @Given("I am logged in as general user")
    public void i_am_already_login() {
        loginPage.open();
        loginPage.fillUserName("standard_user")
                .fillPassword("secret_sauce")
                .clickLoginButton();
    }


    @Given("I am on the login Page")
    public void iamOnLoginPage() {
        loginPage.open();

    }

    @When("I fill user name with {string}")
    public void iFillUserName(String username) {
        loginPage.fillUserName(username);
    }

    @And("I fill password with {string}")
    public void iFillPassword(String password) {
        loginPage.fillPassword(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I am directed to inventory page")
    public void iAmDirectedToInventoryPage() {
        assertEquals(action.getCurrentUrl(), inventoryPage.getPageURl());
    }


}
