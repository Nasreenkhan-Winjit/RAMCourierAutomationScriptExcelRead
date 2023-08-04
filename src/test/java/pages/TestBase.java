package pages;

import browsers.BrowserFactory;
import browsers.DriverManagerWeb;
import browsers.EnumBrowserType;
import common.GenericFunction;
import io.qameta.allure.Step;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.filereading.files.properties.ReadProperties;
import utilities.filereading.files.xml.EnvironmentXml;
import utilities.listener.WebEventListener;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected DriverManagerWeb driverManager;
    protected static WebDriver webDriver;
    protected static EventFiringWebDriver eventFiringWebDriver;
    protected WebEventListener eventListener;
    private boolean IS_BROWSER_OPENED = false;
    protected ReadProperties readProperties = new ReadProperties(System.getProperty("user.dir")+"\\project.properties");

    private void openBrowser(){
        IS_BROWSER_OPENED = true;

        BasicConfigurator.configure();
        System.out.println(".   " + readProperties.getPropertyValue("BROWSER_NAME"));
        driverManager = BrowserFactory.getManager(EnumBrowserType.getBrowserEnum(readProperties.getPropertyValue("BROWSER_NAME").toUpperCase()));
        webDriver = driverManager.getWebDriver();

        // Initializing EventFiringWebDriver using WebDriver instance
        eventFiringWebDriver = new EventFiringWebDriver(webDriver);

        eventListener = new WebEventListener();
        eventFiringWebDriver.register(eventListener);

        eventFiringWebDriver.manage().timeouts().pageLoadTimeout(Integer.parseInt(readProperties.getPropertyValue("DEFAULT_ELEMENT_WAIT_TIMEOUT")), TimeUnit.SECONDS);
        eventFiringWebDriver.get(readProperties.getPropertyValue("BASE_URL"));

        EnvironmentXml createAndWriteEnvironment = new EnvironmentXml();
        Map<String, String> envMap = Map.ofEntries(
                Map.entry("Browser\\u0020Name", driverManager.getBrowserName()),
                Map.entry("Browser\\u0020Version", driverManager.getBrowserVersion()),
                Map.entry("Driver\\u0020Version", driverManager.getWebDriverVersion()),
                Map.entry("Platform", GenericFunction.getOSNameAndArch()),
                Map.entry("Environment", readProperties.getPropertyValue("ENVIRONMENT"))
        );
        createAndWriteEnvironment.createAllureEnvironmentXml(envMap);
        waitForPageLoad();
    }

    public TestBase() {
//        try {
//            if (!IS_BROWSER_OPENED) {
//                openBrowser();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            tearBrowser();
//        }

        //finalize()
    }

    @BeforeSuite
    public void setUp() throws InterruptedException {
        openBrowser();
    }

    @BeforeClass
    public void waitForLoad() {
        String className = this.getClass().getName();
        System.out.println("ClassName: " + className);

    }

    @AfterSuite
    public void tearBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driverManager.quitDriver();
    }

    @Step("Open browser: {0}")
    public void openBaseURL(String BASEURL) {
        eventFiringWebDriver.get(BASEURL);
    }

    public void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(webDriver,Duration.ofSeconds(Integer.parseInt(readProperties.getPropertyValue("DEFAULT_ELEMENT_WAIT_TIMEOUT"))));
//        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(360));
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(360));
        wait.until(driver -> {
            System.out.println("Current Window State: " + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
            return String.valueOf(((JavascriptExecutor) Objects.requireNonNull(driver)).executeScript("return document.readyState")).equals("complete");
        });
    }
}
