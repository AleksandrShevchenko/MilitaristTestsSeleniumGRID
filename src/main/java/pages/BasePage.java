package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePage {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForAjaxToComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickabilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitInvisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void moveMousePointerToElement(WebElement webElement) {
        new Actions(driver).moveToElement(webElement).build().perform();
    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    //amazonTestAcc1234@gmail.com  qweasd

    @FindBy(xpath = "//a[@class=\"login\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class=\"modal fade show\"]")
    private WebElement modalFadeSHow;

    public WebElement getModalFadeSHow() {
        return modalFadeSHow;
    }

    @FindBy(xpath = "//div[@class=\"u_name\"]")
    private WebElement accountName;

    public WebElement getAccountName() {
        return accountName;
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    @FindBy(xpath = "//div[@class=\"window-content window\"]")
    private WebElement signInPopup;

    public WebElement getSignInPopup() {
        return signInPopup;
    }

    @FindBy(xpath = "//input[@name=\"USER_LOGIN\"]")
    private WebElement emailInputField;

    public void enterEmail(String email) {
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    @FindBy(xpath = "//input[@name=\"USER_PASSWORD\"]")
    private WebElement passwordInputField;

    public void enterPassword(String password) {
        passwordInputField.sendKeys(password);
    }

    @FindBy(xpath = "//input[@class=\"btn black\"]")
    private WebElement confirmLoginButton;

    public void clickConfirmLoginButton() {
        confirmLoginButton.click();
    }

    @FindBy(xpath = "//label[@id=\"USER_LOGIN-error\"]")
    private WebElement emptyUserLoginErrorLabel;

    public Boolean isProperlyErrorIsVisible(String email, String password) {
        if (email.isEmpty() && password.isEmpty())
            return emptyUserLoginErrorLabel.isDisplayed() && emptyUserPasswordErrorLabel.isDisplayed();
        if (email.isEmpty()) return emptyUserLoginErrorLabel.isDisplayed();
        else if (password.isEmpty()) return emptyUserPasswordErrorLabel.isDisplayed();
        else if (!validate(email)) return invalidUserLoginErrorLabel.isDisplayed();
        else
            try {
                return invalidEmailOrPasswordError.isDisplayed();
            } catch (NoSuchElementException noErrors) {
                return false;
            }
    }

    @FindBy(xpath = "//label[@id=\"USER_PASSWORD-error\"]")
    private WebElement emptyUserPasswordErrorLabel;

    @FindBy(xpath = "//label[@id=\"USER_LOGIN-error\"][contains(text(),\"Email введено невірно\")]")
    private WebElement invalidUserLoginErrorLabel;

    @FindBy(xpath = "//div[contains(text(), \"Невірно вказані пароль або емейл, спробуйте ще раз\")]")
    private WebElement invalidEmailOrPasswordError;

    @FindBy(xpath = "//nav[@class=\"main-menu clearfix\"]//a[@href=\" /ua/catalog/tacticalgear/\"]")
    private WebElement tacticalGearMenuTab;

    public WebElement getTacticalGearMenuTab() {
        return tacticalGearMenuTab;
    }

    @FindBy(xpath = "//a[@href=\" /ua/catalog/tacticalgear/razgruzochnye-sistem%D1%96/plitonoski-plate-carrier/\"]")
    private WebElement plateCarrierButton;

    public void clickPlateCarrierButton() {
        plateCarrierButton.click();
    }

    @FindBy(xpath = "//div[@class=\"u_name\"]")
    private WebElement personalAccountSettingsPageButton;

    public void clickPersonalAccountSettingsPageButton() {
        personalAccountSettingsPageButton.click();
    }

    @FindBy(xpath = "//input[@id=\"title-search-input\"]")
    private WebElement searchInputField;

    @FindBy(xpath = "//input[@name=\"s\"]")
    private WebElement searchButton;

    public void clickSearchButton() {
        searchButton.click();
    }

    public void enterSearchQuery(String query) {
        searchInputField.sendKeys(query);
    }
}
