package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest
{
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();// ThreadLocal позволяет нам хранить данные, которые будут доступны только конкретным потоком. Каждый поток будет иметь свой собственный экземпляр ThreadLocal
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String CANADIAN_TIRE_URL = "https://militarist.ua/ua/";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("firefox") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.60.1:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(CANADIAN_TIRE_URL);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }
    public AccountPage getAccountPage() {
        return new AccountPage(getDriver());
    }
    public ProductPage getProductPage() {
        return new ProductPage(getDriver());
    }
    public EditProfilePage getEditProfilePage() {
        return new EditProfilePage(getDriver());
    }
    public ProductCardPage getProductCardPage() {
        return new ProductCardPage(getDriver());
    }
    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(getDriver());
    }
    public SearchResultPage getSearchResultPage() {return new SearchResultPage(getDriver());}
}
