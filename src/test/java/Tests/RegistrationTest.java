package Tests;
import Pages.RegistrationPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Utils.FakerDataGenerator;
import org.openqa.selenium.Alert;

import java.time.Duration;

public class RegistrationTest extends Base {

    //Home Page screen displayed
    @Test(priority = 1)
    public void verifyHomePageIsDisplayedTest() {
        homePage.verifyHomePageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Home Page");


    }

    @Test(priority = 2)
    public void clickLearningMaterialTest() {

        homePage.clickLearningMaterial();
    }

    //Login Page screen displayed
    @Test(priority = 3)
    public void verifyLoginPageIsDisplayedTest() {
        loginPage.verifyLoginPageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Login Page");
    }


    //Registration scenarios:
    @Test(priority = 4)

    public void clickSignUpButtonTest() {
        registrationPage.clickSignUpButton();
    }

    @Test(priority = 5)
    public void verifyRegistrationPageIsDisplayedTest() {
        registrationPage.verifyRegisterPageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Registration Page");
    }

    //Invalid Registration with password mismatch
    @Test(priority = 6)
    public void invalidPasswordMismatch() {

        FakerDataGenerator fakerDataGenerator = new FakerDataGenerator();
        String fName = fakerDataGenerator.firstName();
        String lName = fakerDataGenerator.lastName();
        String email = fakerDataGenerator.email();
        String password = fakerDataGenerator.password();
        String confirmPassword = fakerDataGenerator.password() + 123;

        registrationPage.registrationPasswordMismatch(fName, lName, email, password, confirmPassword);


        // Handle the alert popup
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message: " + alert.getText());
            alert.accept();
            takesScreenshots.takesSnapShot(driver, "invalid PasswordMismatch");
        } catch (Exception e) {
            System.out.println("No alert present.");
        }




    }

    //Invalid Registration with bad email format
    @Test(priority = 7)
    public void invalidBadEmailFormat() {

        FakerDataGenerator fakerDataGenerator = new FakerDataGenerator();
        String fName = fakerDataGenerator.firstName();
        String lName = fakerDataGenerator.lastName();
        String email = fakerDataGenerator.email().replace("@", "#");
        String password = fakerDataGenerator.password();


        registrationPage.registrationBadEmailFormat(fName, lName, email, password, password);


        // Handle the alert popup
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message: " + alert.getText());
            alert.accept();
            takesScreenshots.takesSnapShot(driver, "BadEmail Format");
        } catch (Exception e) {
            System.out.println("No alert present.");
        }

    }

    //    //Invalid Registration with password length less than 8 characters
    @Test(priority = 8)
    public void invalidPasswordLength() {

        FakerDataGenerator fakerDataGenerator = new FakerDataGenerator();
        String fName = fakerDataGenerator.firstName();
        String lName = fakerDataGenerator.lastName();
        String email = fakerDataGenerator.email();
        String password = "vbn67";


        registrationPage.registrationPasswordLength(fName, lName, email, password, password);

        // Handle the alert popup
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message: " + alert.getText());
            alert.accept();
            takesScreenshots.takesSnapShot(driver, " invalid PasswordLength");
        } catch (Exception e) {
            System.out.println("No alert present.");
        }

    }


   //Valid Registration
   @Test(priority = 9)
    public void validRegistrationTest() {

        FakerDataGenerator fakerDataGenerator = new FakerDataGenerator();
      String fName = fakerDataGenerator.firstName();
       String lName = fakerDataGenerator.lastName();
       String email = fakerDataGenerator.email();
       String password = fakerDataGenerator.password();
       String confirmPassword= password;

        registrationPage.validRegistration(fName, lName, email, password,confirmPassword);

      // Handle the alert popup
        try {
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
           Alert alert = driver.switchTo().alert();
           System.out.println("Alert message: " + alert.getText());
           alert.accept();
            takesScreenshots.takesSnapShot(driver, " valid Registration");
       } catch (Exception e)
        {
            System.out.println("No alert present.");
        }

    }

}




