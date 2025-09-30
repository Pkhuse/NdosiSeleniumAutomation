package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "login-heading")
    WebElement loginPageTitle_id;

    @FindBy(id="login-email")
    WebElement emailfield_id;

    @FindBy(id="login-password")
    WebElement passwordfield_id;

    @FindBy(id="login-submit")
    WebElement loginbutton_id;

    @FindBy(id = "practice-heading")
     WebElement welcomeMessage_id;

    @FindBy(id = "logout-button")
    WebElement logoutbutton_id;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void verifyLoginPageIsDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf( loginPageTitle_id));
        loginPageTitle_id.isDisplayed();
    }
    public void enterEmailAddress(String email){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(emailfield_id));
        emailfield_id.sendKeys(email);
    }
    public void enterPassword(String password){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(passwordfield_id));
        passwordfield_id.sendKeys(password);
    }

    public void clickLoginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(loginbutton_id));
        loginbutton_id.click();
     }
     public void verifyWelcomeMessageIsDisplayed(){
         new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(welcomeMessage_id));
         welcomeMessage_id.isDisplayed();
     }
    public void clickLogOut(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(logoutbutton_id));
        logoutbutton_id.click();
    }





}
