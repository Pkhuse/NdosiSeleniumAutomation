package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RegistrationPage {

    WebDriver driver;

    @FindBy(id = "signup-toggle")
    WebElement signUpButton_id;

    @FindBy(id="registration-heading")
    WebElement registerPageTitle_id;

    @FindBy(id="register-firstName")
    WebElement firstNamefield_id;

    @FindBy(id="register-lastName")
    WebElement lastNamefield_id;

    @FindBy(id="register-email")
    WebElement registerEmail_id;

    @FindBy(id="register-password")
    WebElement registerPassword_id;

    @FindBy(id="register-confirmPassword")
    WebElement confirmedPassword_id;

    @FindBy(id="register-submit")
    WebElement submitButton_id;


    public RegistrationPage (WebDriver driver){
        this.driver=driver;
    }

    public void clickSignUpButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(signUpButton_id));
        signUpButton_id.click();
    }
    public void verifyRegisterPageIsDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(registerPageTitle_id));
        registerPageTitle_id.isDisplayed();
    }
    public void validRegistration(String firstName,String lastName,String email,String Password,String ConfirmPassword){

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(firstNamefield_id));
        firstNamefield_id.clear();
        firstNamefield_id.sendKeys(firstName);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(lastNamefield_id));
        lastNamefield_id.clear();
        lastNamefield_id.sendKeys(lastName);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(registerEmail_id));
        registerEmail_id.clear();
        registerEmail_id.sendKeys(email);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(registerPassword_id));
        registerPassword_id.clear();
        registerPassword_id.sendKeys(Password);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(confirmedPassword_id));
        confirmedPassword_id.clear();
        confirmedPassword_id.sendKeys(ConfirmPassword);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(submitButton_id));
        submitButton_id.click();

    }
    public void registrationPasswordMismatch(String firstName,String lastName,String Email,String Password,String ConfirmPassword){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(firstNamefield_id));
        firstNamefield_id.clear();
        firstNamefield_id.sendKeys(firstName);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(lastNamefield_id));
        lastNamefield_id.clear();
        lastNamefield_id.sendKeys(lastName);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(registerEmail_id));
        registerEmail_id.clear();
        registerEmail_id.sendKeys(Email);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(registerPassword_id));
        registerPassword_id.clear();
        registerPassword_id.sendKeys(Password);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(confirmedPassword_id));
        confirmedPassword_id.clear();
        confirmedPassword_id.sendKeys(ConfirmPassword);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf( submitButton_id));
        submitButton_id.click();
    }
    public void registrationPasswordLength(String firstName,String lastName,String Email,String Password,String ConfirmPassword){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(firstNamefield_id));
        firstNamefield_id.clear();
        firstNamefield_id.sendKeys(firstName);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(lastNamefield_id));
        lastNamefield_id.clear();
        lastNamefield_id.sendKeys(lastName);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(registerEmail_id));
        registerEmail_id.clear();
        registerEmail_id.sendKeys(Email);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(registerPassword_id));
        registerPassword_id.clear();
        registerPassword_id.sendKeys(Password);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(confirmedPassword_id));
        confirmedPassword_id.clear();
        confirmedPassword_id.sendKeys(ConfirmPassword);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(submitButton_id));
        submitButton_id.click();
    }
    public void registrationBadEmailFormat(String firstName,String lastName,String Email,String Password,String ConfirmPassword){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(firstNamefield_id));
        firstNamefield_id.clear();
        firstNamefield_id.sendKeys(firstName);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(lastNamefield_id));
        lastNamefield_id.clear();
        lastNamefield_id.sendKeys(lastName);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(registerEmail_id));
        registerEmail_id.clear();
        registerEmail_id.sendKeys(Email);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(registerPassword_id));
        registerPassword_id.clear();
        registerPassword_id.sendKeys(Password);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(confirmedPassword_id));
        confirmedPassword_id.clear();
        confirmedPassword_id.sendKeys(ConfirmPassword);
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(submitButton_id));
        submitButton_id.click();
    }
}
