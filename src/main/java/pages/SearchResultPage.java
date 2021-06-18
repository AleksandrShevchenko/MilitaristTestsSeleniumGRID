package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage
{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class=\"item-name\"]")
    private List<WebElement> productsNames;

    public Boolean isSearchQueryContainsInAllFoundProducts(String query) {
        for (WebElement webElement : productsNames){
            if (!webElement.getText().contains(query))
                return false;
        }
        return true;
    }

    @FindBy(xpath = "//div[contains(text(),\"За вашим запитом нічого не знайдено. Спробуйте змінити параметри пошуку.\")]")
    private WebElement noSearchResultsText;

    public Boolean isNoSearchResultsPageDisplayed()
    {
        return noSearchResultsText.isDisplayed();
    }
}
