package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCardPage extends BasePage
{
    public ProductCardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class=\"btn add-to-basket addtoCart\"]")
    private WebElement addToCartButton;

    public void clickAddToCartButton() {addToCartButton.click();}
    @FindBy(xpath = "//div[@class=\"small_basket_content\"]//a[@href=\"/ua/personal/order/make/\"]")
    private WebElement orderTheProductButton;
    public WebElement getOrderTheProductButton() {return orderTheProductButton;}
    public void clickOrderTheProductButton() {orderTheProductButton.click();}

}
