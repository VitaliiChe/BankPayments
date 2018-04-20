package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.ZhkuPaymentPage;

public class ZhkuPaymentSteps extends BasePage{

    ZhkuPaymentPage  zhkuPaymentPage =  new ZhkuPaymentPage(driver);
    CommunProvidersSteps communProvidersSteps =  new CommunProvidersSteps();
    PaymentsSteps paymentsSteps =new PaymentsSteps();


    public void clickOnPayZhkuTab(){
        WebElement element = zhkuPaymentPage.getPayForZhkuTab();
        waitUntilElementVisible(element);
        element.click();
    }

    public void navigateToZhkuMoskvaPayTab()  {
        communProvidersSteps.navigateToProvidersList();
        communProvidersSteps.clickOnTheFirstProvider();
        clickOnPayZhkuTab();
    }

    public void navigateToZhkuMoskvaFromProviders(){
        communProvidersSteps.navigateToProvidersList();
        communProvidersSteps.clickOnTheFirstProvider();
    }

    public void navigateToZhkuMoskvaFromSearch(){
        paymentsSteps.clickOnPaymentsMenuTab();
        paymentsSteps.clearAndFillSearchField("ЖКУ");
        paymentsSteps.clickOnFirstProviderFromMenu();
    }

    public void clearAndFillPayerCodeInputField(String value) {
        WebElement element = zhkuPaymentPage.getPayerCodeInputField();
        waitUntilElementVisible(element);
        element.clear();
        element.sendKeys(value, Keys.ENTER);
    }

    public void clearAndFillPaymentPeriodInputField(String value) {
        WebElement element = zhkuPaymentPage.getPaymentPeriodInputField();
        waitUntilElementVisible(element);
        element.clear();
        element.sendKeys(value, Keys.ENTER);
    }

    public void clearAndFillSumInputField(String value) {
        WebElement element = zhkuPaymentPage.getSumInputField();
        waitUntilElementVisible(element);
        element.sendKeys(Keys.PAGE_DOWN);
        element.sendKeys(Keys.DELETE);
        element.sendKeys(value, Keys.ENTER);
    }

    public String getTextOfErrorMessageCodeField(){
        return zhkuPaymentPage.getErrorMessageCodeField().getText();
    }

    public String getTextErrorMessagePayPeriodField(){
        return zhkuPaymentPage.getErrorMessagePayPeriodField().getText();
    }

    public String getTextErrorMessageSumField(){
        return zhkuPaymentPage.getErrorMessageSumField().getText();
    }

    public String getTextErrorMessageBigSumField(){
        return zhkuPaymentPage.getErrorMessageBigSumField().getText();
    }
}
