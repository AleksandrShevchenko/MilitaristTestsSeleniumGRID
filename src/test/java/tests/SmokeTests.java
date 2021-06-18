package tests;

import TestDataProvider.TestDataProvider;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest
{
    private static final long DEFAULT_WAITING_TIME = 60;


    @Test(priority = 1, dataProviderClass = TestDataProvider.class, dataProvider = "checkAuthorizationDataProvider")
    public void checkUserAuthorization(String email, String password)
    {
        getHomePage().clickSignInButton();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getSignInPopup());
        getHomePage().enterEmail(email);
        getHomePage().enterPassword(password);
        getHomePage().clickConfirmLoginButton();
        try {
            assertTrue(getHomePage().getAccountName().getText().contains("\"testName testSurname\""));
        }
        catch (NoSuchElementException Error)
        {
            assertTrue(getHomePage().isProperlyErrorIsVisible(email, password));
        }
    }

    @Test(priority = 1, dataProviderClass = TestDataProvider.class, dataProvider = "checkProductPurchasingDataProvider")
    public void checkProductPurchasing(String fullName, String email, String phoneNumber){
        getHomePage().moveMousePointerToElement(getHomePage().getTacticalGearMenuTab());
        getHomePage().clickPlateCarrierButton();
        getProductPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getProductPage().clickFirstProduct();
        getProductPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getProductCardPage().clickAddToCartButton();
        getProductCardPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getProductCardPage().getOrderTheProductButton());
        getProductCardPage().clickOrderTheProductButton();
        getCheckoutPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getCheckoutPage().clickCartBlockContinueButton();
        getProductPage().waitInvisibilityOfElement(DEFAULT_WAITING_TIME, getCheckoutPage().getLoadingScreen());
        getCheckoutPage().clickRegionBlockContinueButton();
        getProductPage().waitInvisibilityOfElement(DEFAULT_WAITING_TIME, getCheckoutPage().getLoadingScreen());
        getCheckoutPage().clickSelfDeliveryButton();
        getProductPage().waitInvisibilityOfElement(DEFAULT_WAITING_TIME, getCheckoutPage().getLoadingScreen());
        getCheckoutPage().clickDeliveryBlockContinueButton();
        getProductPage().waitInvisibilityOfElement(DEFAULT_WAITING_TIME, getCheckoutPage().getLoadingScreen());
        getCheckoutPage().enterFullName(fullName);
        getCheckoutPage().enterCustomerEmail(email);
        getCheckoutPage().enterPhoneNumber(phoneNumber);
        getCheckoutPage().clickMakeOrderButton();
        assertTrue(getCheckoutPage().isProperlyErrorIsVisible(fullName, phoneNumber, email));
    }

    @Test(priority = 1, dataProviderClass = TestDataProvider.class, dataProvider = "checkProductSearchBySearchFieldDataProvider")
    public void checkProductSearchBySearchField(String searchQuery)
    {
        getHomePage().enterSearchQuery(searchQuery);
        getHomePage().clickSearchButton();
        assertTrue(getSearchResultPage().isSearchQueryContainsInAllFoundProducts(searchQuery)
                      || getSearchResultPage().isNoSearchResultsPageDisplayed());
    }

    @Test(priority = 1, dataProviderClass = TestDataProvider.class, dataProvider = "checkAccountEmailChangeDataProvider")
    public void checkAccountEmailChange(String email){
        getHomePage().clickSignInButton();
        getHomePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getHomePage().getSignInPopup());
        getHomePage().enterEmail("amazonTestAcc1234@gmail.com");
        getHomePage().enterPassword("qweasd");
        getHomePage().clickConfirmLoginButton();
        getHomePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        getHomePage().clickPersonalAccountSettingsPageButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getAccountPage().clickEditProfileButton();
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getEditProfilePage().enterEmailToChangeEmailInputField(email);
        getEditProfilePage().clickSaveChangesButton();
        try {

            getEditProfilePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
            assertTrue(getEditProfilePage().isPersonalInfoChanged());
        }catch (NoSuchElementException noErrors) {
            assertTrue(getEditProfilePage().isEmailErrorVisible());
        }
    }
}
