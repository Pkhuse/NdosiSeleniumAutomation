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

    @FindBy(id = "shipping-option-express")
    WebElement shippingexpress_button;

    @FindBy(id = "warranty-option-2yr")
    WebElement warrantyoption_button;

    @FindBy(id = "discount-code")
    WebElement discountcode_field;

    @FindBy(id = "apply-discount-btn")
    WebElement apply_button;

    @FindBy(id = "discount-feedback")
    WebElement discountcode_message;


    @FindBy(id = "base-price-value")
    private WebElement basePriceValue;

    @FindBy(id = "breakdown-quantity-value")
    private WebElement quantityValue;

    @FindBy(id = "breakdown-subtotal-value")
    private WebElement subtotalValue;

    @FindBy(id = "breakdown-warranty-value")
    private WebElement warrantyValue;

    @FindBy(id = "breakdown-shipping-value")
    private WebElement shippingValue;

    @FindBy(id = "breakdown-discount-value")
    private WebElement discountValue;

    @FindBy(id = "breakdown-total-value")
    private WebElement totalValue;

    @FindBy(id = "add-to-cart-btn")
    WebElement addToCart_button;

    @FindBy(id = "cart-title")
    WebElement carttitle_label;

    @FindBy(id = "review-cart-btn")
    WebElement reviewcart_button;

    @FindBy(id="cancel-cart-btn")
    WebElement cancel_button;

    @FindBy(id="confirm-cart-btn")
    WebElement confirm_button;

    @FindBy(id="purchase-success-toast")
    WebElement ordersuccess_screen;

    @FindBy(id="view-history-btn")
    WebElement viewhistory_button;

















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

        // Retrieve values
        String unit = unitprice_value.getText().trim();
        // remove the "Qty:" label from the text so it only returns the number
        String qtyLabel = quantity_label.getText().trim().replace("Qty:", "").trim();
        String subtotal = subtotal_value.getText().trim();

        // 🟢 Return normalized values (no commas)
        return new String[]{unit.replace(",", ""), qtyLabel, subtotal.replace(",", "")};
    }
// Shipping, Warranty, Discount Code methods
    public void selectShippingExpress() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(shippingexpress_button));
        shippingexpress_button.click();
    }
    public void selectWarrantyOption() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(warrantyoption_button));
        warrantyoption_button.click();
    }
    public void enterDiscountCode(String discountCode) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(discountcode_field));
        discountcode_field.clear();
        discountcode_field.sendKeys(discountCode);
    }
    public void clickApplyButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(apply_button));
        apply_button.click();
    }
    public void verifyDiscountMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(discountcode_message));
        String actualMessage = discountcode_message.getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage, "Discount message mismatch!");
        System.out.println(" "+ actualMessage);

    }

    public double getBasePrice() {
        return Double.parseDouble(basePriceValue.getText().replace("R", "").trim());
    }

    public int getQuantity() {
        return Integer.parseInt(quantityValue.getText().trim());
    }

    public double getWarranty() {
        return Double.parseDouble(warrantyValue.getText().replace("R", "").trim());
    }

    public double getShipping() {
        return Double.parseDouble(shippingValue.getText().replace("R", "").trim());
    }

    public double getDiscount() {
        return Double.parseDouble(discountValue.getText().replace("- R", "").trim());
    }

    public double getTotal() {
        return Double.parseDouble(totalValue.getText().replace("R", "").trim());
    }
    public void clickAddToCart() {
        addToCart_button.click();
    }
    public void verifyCartTitle(String expectedCartText) {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(carttitle_label));

        String actualText = carttitle_label.getText().trim();
        Assert.assertEquals(actualText, expectedCartText, "Cart title mismatch!");
        System.out.println("Verified cart title: " + actualText);
    }
    public void clickRemoveButtonByIndex(int index) {
        String xpath = "(//button[starts-with(@id,'cart-item-remove-')])[" + index + "]";
        WebElement removeButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        removeButton.click();
        System.out.println("Removed item at position " + index);
    }
    public void clickReviewButton()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(reviewcart_button));
        reviewcart_button.click();
    }
    public void clickCancelButton()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(cancel_button));
        cancel_button.click();
    }
    public void clickConfirmButton()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(confirm_button));
        confirm_button.click();
    }
    public void verifyOrderSuccessDetails() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(ordersuccess_screen));

        String popupText = ordersuccess_screen.getText();

        Assert.assertTrue(popupText.contains("ORDER SUCCESSFUL"), "Missing success title");
        Assert.assertTrue(popupText.contains("purchased successfully"), "Missing success message");
        System.out.println("Order success details validated:\n" + popupText);
    }
    public void clickViewHistory()
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(viewhistory_button));
        viewhistory_button.click();
    }
    public void clickViewInvoiceButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By viewButton = By.cssSelector("button[id^='view-invoice-INV-']");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(viewButton));
        button.click();
        System.out.println("Clicked on the View Invoice button");
    }


}












