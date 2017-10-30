package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {

    private static final String XPATH_SEARCH_PANEL = "//form[@class='metrum-search']";
    private static final By BY_SEARCH_FIELD = By.xpath(XPATH_SEARCH_PANEL + "/input[@class='metrum-search__query']");
    private static final By BY_SEARCH_BUTTON = By.xpath(XPATH_SEARCH_PANEL + "/input[@type='submit' and @value='szukaj']");

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public MainPage setSearchedArticle(final String article) {

        WebElement searchField = driver.findElement(BY_SEARCH_FIELD);
        searchField.sendKeys(article);
        return new MainPage(driver);
    }


    public MainPage clickSearchButton() {

        WebElement searchButton = driver.findElement(BY_SEARCH_BUTTON);
        searchButton.click();
        return new MainPage(driver);
    }

}
