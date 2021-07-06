package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestPageSingleSignOn extends TestBase{
    PageDashBoard pageDashBoard;


    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify valid user are allowed to access for single sign on")

    @Test
    public void clickOnConsignment() throws InterruptedException {
        Thread.sleep(30000);
//     loader.waitForLoaderToDispose();

        pageDashBoard = new PageDashBoard(eventFiringWebDriver);


        pageDashBoard.clickOnNavBar();

    }

    @Test
    public void clickOnRAMCSDPortalAndVerifyPage() throws InterruptedException {

        Thread.sleep(10000);

        pageDashBoard.clickOnRamCSDPortal();
        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(1));

        Thread.sleep(5000);

        pageDashBoard.clickOnCustomerServicePortal();
        Thread.sleep(10000);
//        webDriver.close();

        eventFiringWebDriver.switchTo().window(tabsCount.get(0));
//        webDriver.switchTo().defaultContent();

        Thread.sleep(5000);
    }

    @Test
    public void clickOnRamOpsMonitorAndVerifyPage() throws InterruptedException {

    pageDashBoard.clickOnRamOpsMonitor();
    ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
    eventFiringWebDriver.switchTo().window(tabsCount.get(2));
    Thread.sleep(5000);

    pageDashBoard.clickOnOpsMonitorPage();
//    webDriver.close();
    Thread.sleep(5000);
        eventFiringWebDriver.switchTo().window(tabsCount.get(0));

    }

    @Test
    public void clickOnRMSPortalAndVerifyPageTitle() throws InterruptedException {
        Thread.sleep(10000);
        pageDashBoard.clickOnRMSPortal();
        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(3));
        Thread.sleep(5000);

        pageDashBoard.clickOnRMSTitle();
        Thread.sleep(5000);
        eventFiringWebDriver.switchTo().window(tabsCount.get(0));

    }

    @Test
    public void clickOnRAMRatesManagerAndVerifyPageTitle() throws InterruptedException {
        Thread.sleep(10000);
        pageDashBoard.clickOnRAMRatesManager();
        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(4));
        Thread.sleep(5000);
        pageDashBoard.clickOnRAMRatesManagerPageTitle();
        Thread.sleep(5000);
        eventFiringWebDriver.switchTo().window(tabsCount.get(0));
    }

    @Test
    public void clickOnRAMBillingAndVerifyPageTitle() throws InterruptedException {
        Thread.sleep(10000);
        pageDashBoard.clickOnRAMBilling();
        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(5));
        Thread.sleep(5000);
        pageDashBoard.clickOnRAMBillingPageTitle();
        Thread.sleep(20000);


    }



}
