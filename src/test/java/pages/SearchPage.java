package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends AbstractPage {

    private static final String XPATH_SEARCH_PANEL = "//div[@id='opbox-filters']";
    private static final By BY_USED_ARTICLE = By.xpath(XPATH_SEARCH_PANEL + "//span[contains(text(),'używane')]");
    private static final By BY_ARTICLE_PRICE_FROM = By.xpath(XPATH_SEARCH_PANEL + "//input[@id='od']");


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage setFilterUsedArticle() {
        WebElement filterUsed = driver.findElement(BY_USED_ARTICLE);
        filterUsed.click();
        return new SearchPage(driver);
    }

    public SearchPage setFilterPriceFrom(final String priceFrom) {
        WebElement filterPriceFrom = driver.findElement(BY_ARTICLE_PRICE_FROM);
        filterPriceFrom.sendKeys(priceFrom);
        return new SearchPage(driver);
    }
}
