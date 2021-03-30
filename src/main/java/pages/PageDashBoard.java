package pages;

import com.google.inject.internal.cglib.proxy.$LazyLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.commonmodule.Login;
import org.testng.Assert;

public class PageDashBoard extends BasePage{

//    @FindBy(how = How.XPATH, using = "//div[@class='navbar-right']")
//    //div[@class='navbar-right']//img
    @CacheLookup
    @FindBy(how = How.XPATH, using = "//div[@class='flex xs1 md1']")


//    @FindBy(how = How.CSS, using ="div.application.theme--light:nth-child(1) div.application--wrap:nth-child(44) div.app-horizontal-layout:nth-child(1) nav.Vuely-toolbar.v-toolbar.v-toolbar--fixed.theme--light.light div.v-toolbar__content div.container:nth-child(1) div.layout.row div.flex.xs1.md1:nth-child(1) div.layout.d-custom-flex.align-items-center.navbar-left div.navbar-right > img:nth-child(1)")
    private WebElement elementNavBar;

    @CacheLookup
//    @FindBy(how = How.XPATH, using="//ul[contains(@class,'v-expansion-panel')]/li[5]")
//    @FindBy(how = How.XPATH, using="//div[contains(text(),'Available Applications')]")
//    @FindBy(how = How.XPATH, using="//div[contains(text(),'Available Applications')]/parent::*")
//    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[43]/div/div/div[2]/div/ul/li[5]/div[1]/div[1]")
    @FindBy(how = How.CSS, using = ".v-expansion-panel__container:nth-child(5) .panel-header")
    private WebElement elementAvailableAccordion;

    @CacheLookup
    //@FindBy(how = How.XPATH,using = "//ul[contains(@class,'v-expansion-panel')]/li[5]/../..//label[normalize-space(text())='Consign']")
    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'v-expansion-panel')]/li[5]//u[contains(text(),'Consign')]")
    private WebElement elementConsignAccordion;

    @FindBy(how=How.XPATH, using = "//div[@class='v-input noTranform v-text-field v-text-field--single-line v-text-field--solo v-text-field--enclosed v-text-field--placeholder v-select v-autocomplete theme--light']//div[@class='v-input__slot']")
    private WebElement elementConsignSearch;

    @FindBy(how = How.XPATH, using ="//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='spinner-inner']")
    private WebElement elementSpinner;


    @FindBy(how = How.XPATH, using = "//*[@id=\"inspire\"]/div[43][not(contains(@style,'display: none'))]")
    private WebElement elementApplauncher;



    public PageDashBoard(WebDriver webDriver) {
        super(webDriver);
    }



    public void clickOnNavBar() throws InterruptedException {

//        webDriverWait.until(ExpectedConditions.invisibilityOf(elementSpinner));
//        elementSpinner.getAttribute("spinnerVanished");
    webDriverWait.until(ExpectedConditions.elementToBeClickable(elementNavBar));

        System.out.println(elementNavBar);
        actions.moveToElement(elementNavBar).build().perform();
//        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",elementNavBar);
        elementNavBar.click();



    }
    public void consignURL() throws InterruptedException {


        ((JavascriptExecutor)driver).executeScript("window.open('https://uat.app.ram.co.za/apps/consign')");
        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Sign In To Ram Portal"));

    }
    public void manageMyAccountURL() throws InterruptedException {


        ((JavascriptExecutor)driver).executeScript("window.open('https://uat.app.ram.co.za/apps/mma')");
        System.out.println("Page title is : " + driver.getTitle());
//        assertTrue(driver.getTitle().contains("Title of Page"));
        Assert.assertTrue(driver.getTitle().contains("Sign In To Ram Portal"));

    }

    public void permissionURL() throws InterruptedException {


        ((JavascriptExecutor)driver).executeScript("window.open('https://uat.app.ram.co.za/apps/permission/rolemanagement')");
        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Sign In To Ram Portal"));
    }




    public void clickOnConsignViaAccordion() throws InterruptedException {
//        System.out.println("Applauncher before"+ elementApplauncher.isDisplayed());
//        webDriverWait.until(ExpectedConditions.visibilityOf(elementApplauncher));
////        elementApplauncher.isDisplayed();


        // new change Inbound
//        System.out.println("Applauncher displayed"+ elementApplauncher.isDisplayed());

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementAvailableAccordion));

        elementAvailableAccordion.click();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementConsignAccordion);

        scrollToElement(elementConsignAccordion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementConsignAccordion);
    }

    public void clickOnSearchboxTypeConsign() {
        webDriverWait.until(ExpectedConditions.visibilityOf(elementConsignSearch));
        elementConsignSearch.click();


    }
}
