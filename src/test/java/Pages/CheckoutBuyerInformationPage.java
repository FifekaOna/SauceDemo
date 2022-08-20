package Pages;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutBuyerInformationPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();

    //Element
    private final By header = By.className("title");
    private final By firstNameField= By.id("first-name");
    private final By lastNameField= By.id("last-name");
    private final By ZIPField= By.id("postal-code");
    private final By continueButton= By.id("continue");

    // Page Action
    public String getTittle(){
        return driver.findElement(header).getText();
    }

    public CheckoutBuyerInformationPage fillFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public CheckoutBuyerInformationPage fillLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckoutBuyerInformationPage fillZIP(String ZIP){
        driver.findElement(ZIPField).sendKeys(ZIP);
        return this;
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

}
