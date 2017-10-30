package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage extends AbstractPage {
    private static final String XPATH_ITEM_TITLE = "//div[@id='showitem-main']//h1[@class='title']";
    private static final By BY_ADD_TO_CART_BUTTON = By.xpath("//form[@id='purchase-form']//a[@id='add-to-cart']");
    private static final By BY_GO_TO_CART_BUTTON = By.xpath("//div[@class='modal-dialog']//button[@id='add-to-cart-si-precart']");
    private static final By BY_ITEM_TITLE = By.xpath(XPATH_ITEM_TITLE);
    private static final By BY_ITEM_TITLE_SMALL = By.xpath(XPATH_ITEM_TITLE + "/small");
    private String itemTitle;

    public ItemPage(WebDriver driver) {
        super(driver);
    }


    public ItemPage waitForOpenItem(final String itemUrl) {
        waitUntilURLChange(itemUrl);
        return new ItemPage(driver);

    }

    public ItemPage addArticleToCart() {
        WebElement addToBasketButton = driver.findElement(BY_ADD_TO_CART_BUTTON);
        addToBasketButton.click();
        return new ItemPage(driver);

    }

    public ItemPage goToCart() {
        waitUntilObjectOnPageClickable(BY_GO_TO_CART_BUTTON);
        WebElement goToCartButton = driver.findElement(BY_GO_TO_CART_BUTTON);
        goToCartButton.click();
        return new ItemPage(driver);
    }

    public ItemPage saveItemTitleToVariable() {
        WebElement title = driver.findElement(BY_ITEM_TITLE);
        WebElement subtitle = driver.findElement(BY_ITEM_TITLE_SMALL);
        itemTitle = title.getText().trim().replace(subtitle.getText().trim(), "");
        return new ItemPage(driver);
    }

    public String getItemTitle() {
        return itemTitle;
    }
}
