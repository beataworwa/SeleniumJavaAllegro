package tests;

import config.SupportedBrowser;
import driver.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AllegroTest {

    private static final String TESTED_PAGE = "https://allegro.pl/";
    private static final String SEARCHED_ITEM = "aparat fotograficzny Canon";
    private static final String LOWER_PRICE = "200,01";
    private static WebDriver driver;

    @Before
    public void openPage() throws IllegalAccessException, InstantiationException {
        driver = DriverFactory.getDriver(SupportedBrowser.CHROME.name());
        driver.get(TESTED_PAGE);
    }

    @Test
    public void verifySearchingUsedItem() {
        MainPage mainPage = new MainPage(driver);
        mainPage.setSearchedArticle(SEARCHED_ITEM);
        mainPage.clickSearchButton();
        mainPage.waitUntilTitleChange(SEARCHED_ITEM);
        SearchPage searchPage = new SearchPage(driver);
        searchPage.setFilterUsedArticle();
        searchPage.waitForJQueryToLoad();
        searchPage.setFilterPriceFrom(LOWER_PRICE);
        OfferListPage offerListPage = new OfferListPage(driver);
        offerListPage.openFirstArticleFromOfferList();
        ItemPage itemPage = new ItemPage(driver);
        itemPage.waitForOpenItem(offerListPage.getNewArticleUrl());
        itemPage.saveItemTitleToVariable();
        itemPage.addArticleToCart();
        itemPage.goToCart();
        String openedArticle = itemPage.getItemTitle().trim();
        CartPage cartPage = new CartPage(driver);
        String articleInCart = cartPage.getItemInCartName().trim();
        assertThat(openedArticle).isEqualTo(articleInCart);
    }

    @After
    public void cleanUp() {
        DriverFactory.closeDriver();
    }
}
