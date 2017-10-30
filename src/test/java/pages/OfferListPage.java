package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfferListPage extends AbstractPage {

    private static final By BY_FIRST_ITEM_FROM_OFFER_LIST = By.xpath("//div[@id='opbox-listing']/div/div/section[2]/section/article[1]//h2/a");
    private String newArticleUrl = null;

    public OfferListPage(WebDriver driver) {
        super(driver);
    }

    public String getNewArticleUrl() {
        return newArticleUrl;
    }

    public OfferListPage openFirstArticleFromOfferList() {
        WebElement item = driver.findElement(BY_FIRST_ITEM_FROM_OFFER_LIST);
        newArticleUrl = item.getAttribute("href");
        item.click();
        return new OfferListPage(driver);
    }
}
