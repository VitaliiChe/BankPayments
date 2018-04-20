package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZhkuPaymentPage {

    public ZhkuPaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = " (//*[@class = 'Tab__tab_2Ylcg'])[2]")
    private WebElement payForZhkuTab;

    @CacheLookup
    @FindBy(xpath = "//*[@name = 'provider-payerCode']")
    private WebElement payerCodeInputField;

    @CacheLookup
    @FindBy(xpath = "//*[@name = 'provider-period']")
    private WebElement paymentPeriodInputField;

    // поле "Сумма добровольного страхования жилья из квитанции за ЖКУ в Москве, ₽ " не является обязательным

    @CacheLookup
    @FindBy(xpath = "(//*[@type = 'text'])[3]/..")
    private WebElement sumInputField;

    @FindBy(xpath = "(//*[contains(@class, 'field-error-message')])[1]")
    private WebElement errorMessageCodeField;

    @FindBy(xpath = "(//*[contains(@class, 'field-error-message')])[2]")
    private WebElement errorMessagePeriodField;

    @FindBy(xpath = "(//*[contains(@class, 'field-error-message')])[3]")
    private WebElement errorMessageSumField;

    @FindBy(xpath = "(//*[contains(@class, 'field-error-message')])[4]")
    private WebElement errorMessageBigSumField;

    public WebElement getPayForZhkuTab() {
        return payForZhkuTab;
    }

    public WebElement getPayerCodeInputField() {
        return payerCodeInputField;
    }

    public WebElement getPaymentPeriodInputField() {
        return paymentPeriodInputField;
    }

    public WebElement getSumInputField() {
        return sumInputField;
    }

    public WebElement getErrorMessageCodeField() {
        return errorMessageCodeField;
    }

    public WebElement getErrorMessagePayPeriodField() {
        return errorMessagePeriodField;
    }

    public WebElement getErrorMessageSumField() {
        return errorMessageSumField;
    }

    public WebElement getErrorMessageBigSumField() {
        return errorMessageBigSumField;
    }
}
