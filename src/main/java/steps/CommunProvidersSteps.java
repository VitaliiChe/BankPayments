package steps;

import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.CommunProvidersPage;
import java.util.Iterator;
import java.util.List;


public class CommunProvidersSteps extends BasePage {

    CommunProvidersPage communProvidersPage = new CommunProvidersPage(driver);
    PaymentsSteps paymentsSteps = new PaymentsSteps();

    public void clickOnTheFirstProvider() {
        WebElement element = communProvidersPage.getFirstProviderCommunServices();
        waitUntilElementClickable(element);
        element.click();
    }

    public void clickOnInfoAboutRegionServices() {
        WebElement element = communProvidersPage.getInfoAboutRegionServices();
        waitUntilElementVisible(element);
        element.click();
    }

    public void clickForChoiceSaintPetersburg() {
        WebElement element = communProvidersPage.getChoiceSaintPetersburg();
        waitUntilElementClickable(element);
        element.click();
    }

    public String getProvidersRegionName() {
        return communProvidersPage.getInfoAboutRegionServices().getText();
    }

    public String getFirstProviderName() {
        return communProvidersPage.getFirstProviderCommunServices().getText();
    }

    public void navigateToProvidersList() {
        paymentsSteps.clickOnPaymentsMenuTab();
        paymentsSteps.clickOnZHKHLink();
    }

    public boolean isProviderPresentInList(String providerName) {
        List<WebElement> providers = communProvidersPage.getProvidersNames();
        Iterator<WebElement> provider = providers.iterator();
        while(provider.hasNext()) {
            String name = provider.next().getText();
            if (name.equals(providerName)) {
                return false;
            }
        }
        return true;
    }
}
