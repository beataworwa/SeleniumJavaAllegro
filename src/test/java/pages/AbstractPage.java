package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private static final long MAX_TIMEOUT = 30;
    final WebDriver driver;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitUntilTitleChange(final String title) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        return wait.until(driver1 -> driver1.getTitle().toUpperCase().contains(title.toUpperCase()));

    }


    boolean waitUntilURLChange(final String url) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        return wait.until(driver -> driver.getCurrentUrl().equals(url));

    }

    public boolean waitForJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true;
            }
        };

        return wait.until(jQueryLoad);
    }

    void waitUntilObjectOnPageClickable(final By object) {

        WebDriverWait wait = new WebDriverWait(driver, MAX_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(object));

    }


}
