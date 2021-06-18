package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Integer.parseInt;

public class ProductPage extends BasePage
{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class=\"item-name\"]")
    private List<WebElement> listOfProducts;

    public WebElement getFirstProduct() {return listOfProducts.get(0);}

    public void clickFirstProduct() {getFirstProduct().click();}

}
