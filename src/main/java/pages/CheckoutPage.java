package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage
{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id=\"bx-soa-basket\"]//a[@class=\"pull-right btn btn-default btn-md\"]")
    private WebElement cartBlockContinueButton;

    public void clickCartBlockContinueButton() {cartBlockContinueButton.click();}
    @FindBy(xpath = "//div[@id=\"bx-soa-region\"]//a[@class=\"pull-right btn btn-default btn-md\"]")
    private WebElement regionBlockContinueButton;
    public WebElement getRegionBlockContinueButton() {return regionBlockContinueButton;}

    @FindBy(xpath = "//div[@id=\"bx-soa-total\"]//a[@class=\"btn btn-default btn-lg btn-order-save\"]")
    private WebElement makeOrderButton;

    public void clickMakeOrderButton()
    {
        makeOrderButton.click();
    }
    public void clickRegionBlockContinueButton() {regionBlockContinueButton.click();}
    @FindBy(xpath = "//div[contains(text(),'Самовивіз з магазину')]")
    private WebElement selfDeliveryButton;
    public WebElement getSelfDeliveryButton() {return selfDeliveryButton;}

    public void clickSelfDeliveryButton() { selfDeliveryButton.click();}
    @FindBy(xpath = "//div[@id=\"bx-soa-delivery\"]//a[@class=\"pull-right btn btn-default btn-md\"]")
    private WebElement deliveryBlockContinueButton;
    public WebElement getDeliveryBlockContinueButton() {return deliveryBlockContinueButton;}

    public void clickDeliveryBlockContinueButton() {deliveryBlockContinueButton.click();}
    @FindBy(xpath = "//input[@autocomplete=\"name\"]")
    private WebElement customerFullNameInputField;

    public void enterFullName(String fullName) {customerFullNameInputField.sendKeys(fullName);}
    @FindBy(xpath = "//input[@name=\"ORDER_PROP_3\"]")
    private WebElement customerPhoneNumberInputField;

    public void enterPhoneNumber(String phoneNumber) {customerPhoneNumberInputField.sendKeys(phoneNumber);}
    @FindBy(xpath = "//input[@autocomplete=\"email\"]")
    private WebElement customerEmailInputField;

    public void enterCustomerEmail(String email) {customerEmailInputField.sendKeys(email);}


    @FindBy(xpath = "//div[contains(text(),\"П.І.Б.\")]")
    private WebElement emptyFullNameInputFieldErrorLabel;

    @FindBy(xpath = "//div[contains(text(),\"Телефон\")]")
    private WebElement emptyPhoneNumberInputFieldErrorLabel;

    @FindBy(xpath = "//div[contains(text(),\"E-Mail\")]")
    private WebElement emptyEmailInputFieldErrorLabel;

    @FindBy(xpath = "//div[contains(text(),\"неправильний e-mail\")]")
    private WebElement invalidEmailInputFieldErrorLabel;

    public Boolean isProperlyErrorIsVisible(String fullName, String phoneNumber, String email)
    {
        if (fullName.isEmpty()) return emptyFullNameInputFieldErrorLabel.isDisplayed();
        else if (phoneNumber.isEmpty()) return emptyPhoneNumberInputFieldErrorLabel.isDisplayed();
        else if (email.isEmpty()) return emptyEmailInputFieldErrorLabel.isDisplayed();
        else if (!validate(email)) return invalidEmailInputFieldErrorLabel.isDisplayed();
        else return false;
    }

    @FindBy(xpath = "//div[@id=\"popup-window-overlay-loading_screen\"]")
    private WebElement loadingScreen;
    public WebElement getLoadingScreen() {return loadingScreen;}
}
