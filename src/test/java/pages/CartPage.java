package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends AbstractPage {

    private static final By BY_ITEM_IN_CART = By.xpath("//form[@id='goToDeskForm']/seller-items/section/ul//div[@class='item-name']//span[@class='ng-binding']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemInCartName() {
        WebElement item = driver.findElement(BY_ITEM_IN_CART);
        return item.getText();
    }

}
