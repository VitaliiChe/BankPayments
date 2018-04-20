package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.PaymentsPage;

public class PaymentsSteps extends BasePage{

    PaymentsPage paymentsPage = new PaymentsPage(driver);

    public void clickOnPaymentsMenuTab(){
        WebElement element = paymentsPage.getPaymentsMenuTab();
        waitUntilElementVisible(element);
        element.click();
    }

    public void clickOnZHKHLink() {
        WebElement element = paymentsPage.getZHKHLink();
        waitUntilElementVisible(element);
        element.click();
    }

    public void clickOnReceiverSearchField(){
        WebElement element = paymentsPage.getReceiverSearchField();
        waitUntilElementVisible(element);
        element.click();
    }

    public void clickOnFirstProviderFromMenu(){
        WebElement element = paymentsPage.getFirstProviderFromMenu();
        waitUntilElementVisible(element);
        element.click();
    }

    public void clearAndFillSearchField(String value) {
        clickOnReceiverSearchField();
        paymentsPage.getReceiverSearchField().clear();
        paymentsPage.getReceiverSearchField().sendKeys(value, Keys.ENTER);
    }

    public String getTextFirstProviderFromMenu(){
        return paymentsPage.getFirstProviderFromMenu().getText();
    }
}
