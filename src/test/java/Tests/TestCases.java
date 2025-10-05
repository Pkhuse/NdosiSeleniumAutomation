package Tests;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import Utils.FakerDataGenerator;
import org.openqa.selenium.Alert;

import java.time.Duration;

import static Utils.FakerDataGenerator.address;
import TestData.PricingDataProvider;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class TestCases extends Base {

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
        takesScreenshots.takesSnapShot(driver, "Login Home Page");
    }

    //Valid Login with correct credentials
    @Test(priority = 4)
    public void validLoginTest() {

        loginPage.enterEmailAddress(readFromExcel.email);
        loginPage.enterPassword(readFromExcel.password);
        loginPage.clickLoginButton();
        loginPage.verifyWelcomeMessageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Login Success Page");
        loginPage.clickLogOut();
    }

    //Invalid Login with incorrect credentials
    @Test(priority = 5)
    public void invalidLoginTest() {

        loginPage.enterEmailAddress(readFromExcel.email);
        loginPage.enterPassword(readFromExcel.invalidpassword);
        loginPage.clickLoginButton();

        // Handle the alert popup
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            System.out.println(" " + alert.getText());
            alert.accept();

        } catch (Exception e) {
            System.out.println("No alert present.");
        }
        takesScreenshots.takesSnapShot(driver, "invalid Login credentials");
    }

    @Test(priority = 6)
    public void testLoginWithExtraSpaces() {

        loginPage.enterEmailAddress("      amee.johnson@hotmail.com      ");

        loginPage.enterPassword("   5oe620cnnialx  ");
        loginPage.clickLoginButton();
        loginPage.verifyWelcomeMessageIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Login Success Page with extra spaces");

    }
    //Inventory Page screen displayed
    @Test(priority = 7)
    public void verifyInventoryPageIsDisplayedTest() {
        inventoryPage.clickWebAutomationAdvanceTab();
        takesScreenshots.takesSnapShot(driver, "Inventory Page");
    }

    //Pricing Panel Validation with multiple data sets
    @Test(priority = 8, dataProvider = "pricingData", dataProviderClass = PricingDataProvider.class)
    public void verifyPricing(String device, String storage,String expectedUnit, String expectedSubtotal, String qtyValue) {


        String[] actualPricing = inventoryPage.selectPricingPanel(device,storage, qtyValue);

        takesScreenshots.takesSnapShot(driver, "Clear Pricing Panel");

        inventoryPage.selectDeviceType(device);
        inventoryPage.selectStorage(storage.replace("GB", ""));
        inventoryPage.selectQuality(qtyValue);


        // Normalize actual values
        String actualUnit = actualPricing[0].trim().replace(",", "");
        String actualQty = actualPricing[1].trim();
        String actualSubtotal = actualPricing[2].trim().replace(",", "");

// Normalize expected values
        String expectedUnitNorm = expectedUnit.trim().replace(",", "");
        String expectedQtyNorm = qtyValue.trim();
        String expectedSubtotalNorm = expectedSubtotal.trim().replace(",", "");

// Assert with normalized comparison
        Assert.assertEquals(actualUnit, expectedUnitNorm, "❌ Unit price mismatch!");
        Assert.assertEquals(actualQty, expectedQtyNorm, "❌ Quantity mismatch!");
        Assert.assertEquals(actualSubtotal, expectedSubtotalNorm, "❌ Subtotal mismatch!");

// Log output for debugging
        System.out.println("✅ Unit Price: " + actualPricing[0]);
        System.out.println("✅ Quantity: " + actualPricing[1]);
        System.out.println("✅ Subtotal: " + actualPricing[2]);

    }
        @Test(priority = 9)
        public void inventoryValidationTest()
        {

            inventoryPage.verifyNextButtonDisabledByDefault();
            inventoryPage.selectDeviceType("Phone");
            inventoryPage.selectBrand("Apple");
            inventoryPage.clickStorage();
            inventoryPage.selectColor("Gold");
            inventoryPage.selectQuality("2");
            inventoryPage.enterAddress(address);
            inventoryPage.verifyPriceDetails();
            takesScreenshots.takesSnapShot(driver, "Inventory Page Details");
            inventoryPage.clickinventoryNextButton();
        }


    }


//    @AfterTest
//    public void closeBrowser() {
//        driver.quit();
//    }



