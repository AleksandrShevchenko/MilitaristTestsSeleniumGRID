package TestDataProvider;

import org.testng.annotations.DataProvider;

public class TestDataProvider
{
    @DataProvider(name = "checkAuthorizationDataProvider")
    public Object[][] checkAuthorizationDataProviderMethod() {
        return new Object[][]{{"","qweasd"}, {"amazonTestAcc1234@gmail.com", ""},
                {"", ""}};
    }

    @DataProvider(name = "checkProductPurchasingDataProvider")
    public Object[][] checkProductPurchasingDataProvider() {
        return new Object[][]{{"Ivan Petrov", "amazonTestAcc1234@gmail.com", ""},
                {"","amazonTestAcc1234@gmail.com", "380690000000"}, {"amazonTestAcc1234@gmail.com", "", "380690000000"},
                {"amazonTestAcc12@gmail.com", "qweqwe", "380690000000"}};
    }

    @DataProvider(name = "checkAccountEmailChangeDataProvider")
    public Object[][] checkAccountEmailChangeDataProvider() {
        return new Object[][]{{"amazonTestAcc1234@gmail.com"},
                {"380690000000"}, {""}};
    }

    @DataProvider(name = "checkProductSearchBySearchFieldDataProvider")
    public Object[][] checkProductSearchBySearchFieldDataProvider() {
        return new Object[][]{{"M-Tac"}, {""}};
    }
}