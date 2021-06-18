package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id=\"popup-window-overlay-loading_screen\"]")
    private WebElement loadingScreen;
    public WebElement getLoadingScreen() {return loadingScreen;}
}
