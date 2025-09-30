package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Utils.FakerDataGenerator;
import org.openqa.selenium.Alert;



public class TestCases extends Base {


    //Home Page screen displayed

    @Test
    public void verifyHomePageIsDisplayedTest() {
        homePage.verifyHomePageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Home Page");


    }

    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTest")
    public void clickLearningMaterialTest() {

        homePage.clickLearningMaterial();
    }

//    //Login Page screen displayed
    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void verifyLoginPageIsDisplayedTest() {
        loginPage.verifyLoginPageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Login Home Page");
    }
    @Test(dependsOnMethods = "clickLearningMaterialTest")
    public void verifyLoginTest() {

        loginPage.enterEmailAddress(readFromExcel.email);
        loginPage.enterPassword(readFromExcel.password);
        loginPage.clickLoginButton();
        loginPage.verifyWelcomeMessageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Login Page after login");
        loginPage.clickLogOut();
    }

//    @AfterTest
//    public void closeBrowser() {
//        driver.quit();
//    }
}


