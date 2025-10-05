package TestData;

import org.testng.annotations.DataProvider;
import org.testng.annotations.DataProvider;

public class PricingDataProvider {

        @DataProvider(name = "pricingData")
        public Object[][] getPricingData() {
            return new Object[][]{
                    {"", "", "—", "—", "1"}, // No device + storage
                    {"Phone", "64GB", "R400.00", "R400.00", "1"},
                    {"Phone", "128GB", "R480.00", "R960.00", "2"},
                    {"Laptop", "256GB", "R1360.00", "R1360.00", "1"},
            };
        }
    }

