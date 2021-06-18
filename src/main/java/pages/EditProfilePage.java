package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends  BasePage
{
    public EditProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name=\"EMAIL\"]")
    private WebElement changeEmailInputField;

    public void enterEmailToChangeEmailInputField(String email)
    {
        changeEmailInputField.clear();
        changeEmailInputField.sendKeys(email);
    }

    @FindBy(xpath = "//input[@name=\"save\"]")
    private WebElement saveChangesButton;

    public void clickSaveChangesButton() {saveChangesButton.click();}

    @FindBy(xpath = "//font[@class=\"errortext\"][contains(text(),\"Невірний e-mail.\")]")
    private WebElement invalidEmailErrorLabel;
    public WebElement getInvalidEmailErrorLabel() {return invalidEmailErrorLabel;}

    @FindBy(xpath = "//font[@class=\"notetext\"][contains(text(),\"Змінення збережені\")]")
    private WebElement successPersonalInformationChangeLabel;
    public Boolean isEmailErrorVisible()
    {
        return invalidEmailErrorLabel.isDisplayed(); }
    public Boolean isPersonalInfoChanged()
    {
        return successPersonalInformationChangeLabel.isDisplayed();
    }
}
