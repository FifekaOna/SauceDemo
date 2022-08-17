package Pages;



import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {
    @Managed
    WebDriver driver = getDriver();

    private final By userNameField= By.id("user-name");
    private final By passwordField =By.id("password");
    private final By loginButton= By.id("login-button");

    
    public LoginPage fillUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public  LoginPage fillPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public void clickLoginButton (){
        driver.findElement(loginButton).click();
    }


}
