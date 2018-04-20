package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BasePage {

    protected static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void openMainPage() {
        driver.get("https://www.tinkoff.ru");
        driver.manage().window().maximize();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }


    public void waitUntilElementVisible(WebElement element) {
        (new WebDriverWait(driver, 7))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementClickable(WebElement element) {
        (new WebDriverWait(driver, 7))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
