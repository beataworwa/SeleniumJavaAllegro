package driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {


    private static WebDriver driver;
    private static final int IMPLICITLY_WAIT_TIMEOUT_SECONDS=10;
    private static final int PAGE_LOAD_TIMEOUT_SECONDS=120;

    public synchronized static WebDriver getDriver(final String browserName) throws InstantiationException, IllegalAccessException {
        if (driver == null) {
            switch (browserName) {
                case "CHROME":
                    driver = getChromeDriver();
                    break;
                default:
                    throw new IllegalStateException("Unsuported browser: "+browserName);
            }
            driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }

    private static WebDriver getChromeDriver() throws IllegalAccessException, InstantiationException {
        ChromeDriverManager.getInstance().setup();
        driver = ChromeDriver.class.newInstance();
        return driver;
    }

}
