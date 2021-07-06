package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.commonmodule.Loader;
import pages.commonmodule.Login;
import pages.commonmodule.Logout;

import java.util.ArrayList;
import java.util.Map;

public class TestPageLoginSecurity extends TestBase{


    private Login login;
    private Logout logout;
    PageDashBoard pageDashBoard;





    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify valid user are allowed to access")
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ValidLogin")
    public void signIn(Map<String, String> testDataSet) throws InterruptedException {
        login = new Login(eventFiringWebDriver);
        Thread.sleep(20000);
        waitForPageLoad();

        login.enterUserName("Consign.permission@ram.co.za");
//        login.loginClick();
        login.enterPassword("Test@123");
        login.loginClick();
        Thread.sleep(30000);

        pageDashBoard = new PageDashBoard(eventFiringWebDriver);

        Thread.sleep(1000);
        pageDashBoard.consignURL();
        Thread.sleep(20000);

        pageDashBoard.manageMyAccountURL();
        Thread.sleep(20000);
//        Thread.sleep(5000);
        pageDashBoard.permissionURL();


//        webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//
//        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
//        eventFiringWebDriver.switchTo().window(tabsCount.get(1));
//        eventFiringWebDriver.get("https://uat.app.ram.co.za/apps/consign");
        Thread.sleep(10000);

    }
}
