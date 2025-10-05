package Pages;

import Tests.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;



public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Web Automation Advance']")
    WebElement webAutomationAdvance_tab;

    @FindBy(id = "inventory-next-btn")
    WebElement inventoryNextButton_id;

    @FindBy(id = "deviceType")
    WebElement deviceType_dropdown;

    @FindBy(id = "brand")
    WebElement brand_dropdown;


    @FindBy(id = "storage-256GB")
    WebElement storage_button;

    @FindBy(id = "color")
    WebElement color_dropdown;

    @FindBy(id = "quantity")
    WebElement quantity_dropdown;

    @FindBy(id = "address")
    WebElement address_field;

    @FindBy(id = "current-price-header")
    WebElement currentprice_value;

    @FindBy(id = "unit-price-value")
    WebElement unitprice_value;

    @FindBy(id = "quantity-label")
    WebElement quantity_label;

    @FindBy(id = "subtotal-value")
    WebElement subtotal_value;

    public void clickWebAutomationAdvanceTab() {
        webAutomationAdvance_tab.click();
    }

    public void clickinventoryNextButton() {
        inventoryNextButton_id.click();
    }

    public void verifyNextButtonDisabledByDefault() {
        WebElement nextBtn = inventoryNextButton_id;
        Assert.assertFalse(nextBtn.isEnabled(), "Next button should be disabled by default");
    }

    public void selectDeviceType(String deviceType) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(deviceType_dropdown));
        deviceType_dropdown.sendKeys(deviceType);
    }

    public void selectBrand(String brand) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(brand_dropdown));
        brand_dropdown.sendKeys(brand);
    }

    public void clickStorage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(storage_button));
        storage_button.click();
    }

    public void selectColor(String Color) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(color_dropdown));
        color_dropdown.sendKeys(Color);
    }

    public void selectQuality(String Quality) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(quantity_dropdown));
        quantity_dropdown.clear();
        quantity_dropdown.sendKeys(Quality);
    }

    public void enterAddress(String Address) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(address_field));
        address_field.sendKeys(Address);
    }

    public void verifyPriceDetails() {
        Assert.assertTrue(currentprice_value.isDisplayed(), "Current Price is not displayed");
        Assert.assertTrue(unitprice_value.isDisplayed(), "Unit Price is not displayed");
        Assert.assertTrue(quantity_label.isDisplayed(), "Quantity is not displayed");
        Assert.assertTrue(subtotal_value.isDisplayed(), "Subtotal is not displayed");
        System.out.println("Current Price: " + currentprice_value.getText());
        System.out.println("Unit Price: " + unitprice_value.getText());
        System.out.println("Quantity: " + quantity_label.getText());
        System.out.println("Subtotal: " + subtotal_value.getText());
    }

    public void selectStorage(String storage) {
        if (storage == null || storage.trim().isEmpty() || storage.equals("—")) {
            System.out.println("No storage selected for this test case. Skipping storage selection.");
            return; // skip clicking
        }

        // Always normalize the ID
        if (!storage.endsWith("GB")) {
            storage = storage + "GB";
        }

        String storageId = "storage-" + storage.trim();
        System.out.println("Clicking storage option with ID: " + storageId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement storageOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.id(storageId))
        );

        storageOption.click();
        System.out.println("Selected storage: " + storageId);
    }

    public String[] selectPricingPanel(String device, String storage, String qtyValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // device
        if (device != null && !device.trim().isEmpty()) {
            deviceType_dropdown.sendKeys(device);
            // wait for storage radios to appear
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[id^='storage-']")));
        }

        // storage
        if (storage != null && !storage.trim().isEmpty() && !storage.equals("—")) {
            if (!storage.endsWith("GB")) storage = storage + "GB";

            String storageId = "storage-" + storage.trim();
            System.out.println("Clicking storage option with ID: " + storageId);

            WebElement storageOption =
                    wait.until(ExpectedConditions.elementToBeClickable(By.id(storageId)));
            storageOption.click();

            System.out.println("Selected storage: " + storageId);
        } else {
            System.out.println("No storage selected for this test case. Skipping storage selection.");
        }

        // quantity
        if (qtyValue != null && !qtyValue.trim().isEmpty()) {
            quantity_dropdown.clear();
            quantity_dropdown.sendKeys(qtyValue);
        }

        // 🟢 Safe subtotal handling
        By subtotalLocator = By.id("subtotal-value");
        WebElement subtotalElement = driver.findElement(subtotalLocator);
        String currentText = subtotalElement.getText();

        if (currentText == null || currentText.trim().isEmpty() || currentText.trim().equals("—")) {
            System.out.println("Subtotal not visible or contains '—', skipping numeric wait.");
        } else {
            wait.until(ExpectedConditions.textMatches(subtotalLocator, java.util.regex.Pattern.compile("R\\d")));
        }

        // 🟢 Retrieve values
        String unit = unitprice_value.getText().trim();
        // remove the "Qty:" label from the text so it only returns the number
        String qtyLabel = quantity_label.getText().trim().replace("Qty:", "").trim();
        String subtotal = subtotal_value.getText().trim();

        // 🟢 Return normalized values (no commas)
        return new String[]{unit.replace(",", ""), qtyLabel, subtotal.replace(",", "")};
    }
}







