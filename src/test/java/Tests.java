
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import steps.CommunProvidersSteps;
import steps.PaymentsSteps;
import steps.ZhkuPaymentSteps;



public class Tests extends BasePage {

    PaymentsSteps paymentsSteps = new PaymentsSteps();
    ZhkuPaymentSteps zhkuPaymentSteps = new ZhkuPaymentSteps();
    CommunProvidersSteps communProvidersSteps = new CommunProvidersSteps();

    @Test
    @Description("test covers requirement from paragraph 4")
    public void checkRegionOfServices(){
        communProvidersSteps.navigateToProvidersList();
        String regionName = communProvidersSteps.getProvidersRegionName();
        Assert.assertEquals("Москве", regionName);
    }

    @Test
    @Description("test covers requirement from paragraph 7 - regarding error message below 'payer code' field")
    public void checkMessageBelowPayerCodeField()  {
        zhkuPaymentSteps.navigateToZhkuMoskvaPayTab();
        zhkuPaymentSteps.clearAndFillPayerCodeInputField("11111");
        String errorMessage = zhkuPaymentSteps.getTextOfErrorMessageCodeField();
        Assert.assertEquals("Поле неправильно заполнено", errorMessage);
    }

    @Test
    @Description("test covers requirement from paragraph 7 - regarding error message below 'payment period' field")
    public void checkMessageBelowPaymentPeriodField() {
        zhkuPaymentSteps.navigateToZhkuMoskvaPayTab();
        zhkuPaymentSteps.clearAndFillPaymentPeriodInputField("88.8888");
        String errorMessage = zhkuPaymentSteps.getTextErrorMessagePayPeriodField();
        Assert.assertEquals("Поле заполнено некорректно", errorMessage);
    }


    @Test
    @Description("test covers requirement from paragraph 7 - regarding error message below 'sum' field")
    public void checkMessageBelowSumFieldWhenMinValue() {
        zhkuPaymentSteps.navigateToZhkuMoskvaPayTab();
        zhkuPaymentSteps.clearAndFillSumInputField("7");
        String errorMessage =zhkuPaymentSteps.getTextErrorMessageSumField();
        Assert.assertEquals("Минимум — 10 \u20BD", errorMessage);
    }


    @Test
    @Description("test covers requirement from paragraph 7 - regarding error message below 'sum' field")
    public void checkMessageBelowSumFieldWhenBigValue() {
        zhkuPaymentSteps.navigateToZhkuMoskvaPayTab();
        zhkuPaymentSteps.clearAndFillSumInputField("15000000");
        String errorMessage =zhkuPaymentSteps.getTextErrorMessageSumField();
        Assert.assertEquals("Максимум — 15 000 \u20BD", errorMessage);
    }


    @Test
    @Description("test covers requirement from paragraph 7 - regarding error message below 'sum' field")
    public void checkMessageBelowSumFieldWhenTooBigValue()  {
        zhkuPaymentSteps.navigateToZhkuMoskvaPayTab();
        zhkuPaymentSteps.clearAndFillSumInputField("10000000000000000000000000");
        String errorMessage =zhkuPaymentSteps.getTextErrorMessageBigSumField();
        Assert.assertEquals("Поле заполнено неверно", errorMessage);
    }


    @Test
    @Description("test covers requirement from paragraph 10")
    public void checkThatZhkuIsTheFirstProvider() {
        communProvidersSteps.navigateToProvidersList();
        String firstProviderFromList =  communProvidersSteps.getFirstProviderName();
        paymentsSteps.clickOnPaymentsMenuTab();
        paymentsSteps.clearAndFillSearchField(firstProviderFromList);
        String firstProviderNameFromMenu = paymentsSteps.getTextFirstProviderFromMenu();
        Assert.assertEquals(firstProviderFromList, firstProviderNameFromMenu);
    }


    @Test
    @Description("test covers requirement from paragraph 11")
    public void checkThatZhkuMoskvaPageTheSame() {
        zhkuPaymentSteps.navigateToZhkuMoskvaFromSearch();
        String currentUrlPage = getUrl();
        zhkuPaymentSteps.navigateToZhkuMoskvaFromProviders();
        String previousUrlPage = getUrl();
        Assert.assertEquals(currentUrlPage, previousUrlPage);
    }


    @Test
    @Description("test covers requirement from paragraph 14")
    public void checkThatZhkuIsAbsentInProvidersList() {
        communProvidersSteps.navigateToProvidersList();
        communProvidersSteps.clickOnInfoAboutRegionServices();
        communProvidersSteps.clickForChoiceSaintPetersburg();
        Assert.assertTrue(communProvidersSteps.isProviderPresentInList("ЖКУ-Москва"),
                "ЖКУ-Москва не должен быть в списке провайдеров г.Санкт-Петербурга");
    }
}
