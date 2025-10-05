package Tests;

import Pages.HomePage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Utils.BrowserFactory;
import Utils.ReadFromExcel;
import Utils.TakesScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
    HomePage homePage= PageFactory.initElements(driver,HomePage.class);
    LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
    RegistrationPage registrationPage= PageFactory.initElements(driver, RegistrationPage.class);
    InventoryPage inventoryPage= PageFactory.initElements(driver, InventoryPage.class);


    TakesScreenshots takesScreenshots = new TakesScreenshots();
    ReadFromExcel readFromExcel;
    {
        try{
            readFromExcel= new ReadFromExcel();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
