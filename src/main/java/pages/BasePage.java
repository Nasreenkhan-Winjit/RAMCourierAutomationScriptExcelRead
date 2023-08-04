package pages;

import com.google.inject.internal.cglib.proxy.$Dispatcher;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;

    public BasePage() {

    }

    protected BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(webDriver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    @Step("Enter webelement {0} value {0}")
    protected WebElement clearAndInputText(WebElement webElement, String inputTxt) {
        webElement.clear();
        webElement.sendKeys(inputTxt);
        return webElement;
    }

    /**
     * Use this to get shadow root element by passing the shadow host locator.
     * Shadow Host is that element in which #shadow-root resides. Note: #shadow-root must be open
     *
     *  Example :
     *    WebElement shadowContent = getShadowHost("div#app>div>div:nth-of-type(2)>div *:nth-child(1)").findElement(By.cssSelector("form#addressForm input"));
     * @param strCSSShadowHostSelector, pass shadow host, this must be strictly css.
     * @return shadowRoot
     *
     */
    protected SearchContext getShadowHost(final String strCSSShadowHostSelector){
        WebElement shadowHost = driver.findElement(By.cssSelector(strCSSShadowHostSelector));
        return shadowHost.getShadowRoot();
    }

    protected  void staticExplicitWait(final long duration){
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(duration));
    }
    protected By convertWebElementToBy(WebElement webElement) {

        String[] data = webElement.toString().split(" -> ")[1].replaceFirst(".$", "").split(": ");

        String locatorType = data[0];
        System.out.println(locatorType + " locatorType");
        String locatorPath = data[1];
        System.out.println(locatorPath + " locatorPath");

        switch (locatorType.toLowerCase()) {
            case "xpath":
                return By.xpath(locatorPath);
            default:
                System.out.println("Found locator \"" + locatorType + "\" is not handled.");
        }
        return (By) webElement;
    }

    public void scrollToElement( WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(driver -> {
            System.out.println("Current Window State: " + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
            return String.valueOf(((JavascriptExecutor) Objects.requireNonNull(driver)).executeScript("return document.readyState")).equals("complete");
        });
    }
}

