package pages;

import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;

public class PageDashBoard extends BasePage {

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

    @FindBy(how = How.XPATH, using = "//div[@class='v-input noTranform v-text-field v-text-field--single-line v-text-field--solo v-text-field--enclosed v-text-field--placeholder v-select v-autocomplete theme--light']//div[@class='v-input__slot']")
    private WebElement elementConsignSearch;

    @FindBy(how = How.XPATH, using = "//div[@class='v-dialog v-dialog--active v-dialog--persistent']//div[@class='spinner-inner']")
    private WebElement elementSpinner;


    @FindBy(how = How.XPATH, using = "//*[@id=\"inspire\"]/div[43][not(contains(@style,'display: none'))]")
    private WebElement elementApplauncher;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'v-expansion-panel')]/li[5]//u[contains(text(),'RAM CSD Portal ')]")
    private WebElement elementCLickOnRAMCSDPortal;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'RAM - CUSTOMER SERVICE PORTAL')]")
    private WebElement elementCLickOnCustomerServicePortal;


    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'v-expansion-panel')]/li[5]//u[contains(text(),'Ops Monitor')]")
    private WebElement elementCLickOnAppOpsMonitor;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'You do not have any permissions for this system.')]")
    private WebElement elementCLickOnOpsMonitorPage;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'v-expansion-panel')]/li[5]//u[contains(text(),'RMS Portal ')]")
    private WebElement elementCLickOnRMSPortal;


    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Continue')]")
    private WebElement elementCLickOnContinuePopUp;

    @FindBy(how = How.XPATH, using = "//tbody//td[@id='controlLogonDetails']")
    private WebElement elementCLickOnRMSTitle;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'v-expansion-panel')]/li[5]//u[contains(text(),'RAM Rates Manager ')]")
    private WebElement elementCLickOnRAMRatesManager;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'v-expansion-panel')]/li[5]//u[contains(text(),'RAM Billing ')]")
    private WebElement elementCLickOnRAMBilling;

    //    @FindBy(how = How.XPATH, using = "//body/form[@id='aspnetForm']/div[@id='mainwrapper']/div[2]/a[1]")
    @FindBy(how = How.XPATH, using = "//td[text()[normalize-space()='RAM Billing System']]")
    private WebElement elementCLickOnRAMBillingInvoice;


    @FindBy(how = How.XPATH, using = "//textarea[@id='textConsignmentID']")
    private WebElement elementTextConsignmentRMS;

    @FindBy(how = How.XPATH, using = "//input[@id='buttonTrackingSearch']")
    private WebElement elementClickOnSearchButton;


    @FindBy(how = How.XPATH, using = "//input[@id='textConsignmentID']")
    private WebElement elementEnterConsignmentIDRMS;


    @FindBy(how = How.XPATH, using = "//input[@id='btnEdit']")
    private WebElement elementClickOnBtnConsignmentIDRMSEdit;

    @FindBy(how = How.XPATH, using = "//input[@id='txtConsignmentID']")
    private WebElement elementConsignmentIDFieldOnRMSEdit;

    @FindBy(how = How.XPATH, using = "//input[@id='txtSenderID']")
    private WebElement elementSenderIDFieldOnRMSEdit;

    @FindBy(how = How.CSS, using = "input#txtBilledTo")
    private WebElement elementBilledToFieldOnRMSEditProd;

    @FindBy(how = How.XPATH, using = "//input[@id='txtReceiverName']")
    private WebElement elementReceiverNameFieldOnRMSEdit;


    @FindBy(how = How.XPATH, using = "//input[@id='txtShipperRef']")
    private WebElement elementShipperRefFieldOnRMSEdit;


    @FindBy(how = How.XPATH, using = "//textarea[@id='txtGoodsDescription']")
    private WebElement elementGoodsDescriptionFieldOnRMSEdit;


    @FindBy(how = How.XPATH, using = "//input[@id='radioServiceND']")
    private WebElement elementCheckBoxND17h00IsSelectedOnRMSEdit;

    @FindBy(how = How.XPATH, using = "//input[@id='txtNoOfParcels']")
    private WebElement elementVerifyNoOfParcelOnRMSEdit;


    @FindBy(how = How.XPATH, using = "//input[@id='checkSurchargeS']")
    private WebElement elementVerifySaturdayOnRMSEdit;

    @FindBy(how = How.XPATH, using = "//input[@id='buttonOK']")
    private WebElement elementClickONHubSelection;

    @FindBy(how = How.XPATH, using = "//input[@id='textEmployeeID2']")
    private WebElement elementEnterEmployeeID;

    @FindBy(how = How.XPATH, using = "//input[@id='textPassword2']")
    private WebElement elementEnterPassword;

    @FindBy(how = How.XPATH, using = "//input[@id='buttonLogin2']")
    private WebElement elementClickOnLoginBtn;

    @FindBy(how = How.XPATH, using = "//input[@id='textConsignmentID']")
    private WebElement elementEnterConsignmentIDDimParcels;

    @FindBy(how = How.XPATH, using = "//input[@id='textNoOfParcels']")
    private WebElement elementEnterNumOfParcelDimParcels;

    @FindBy(how = How.XPATH, using = "//input[@id='btnDim']")
    private WebElement elementClickOnDimButton;

    @FindBy(how = How.XPATH, using = "//input[@value='Done']")
    private WebElement elementClickOnDoneButtonOnRMS;


    @FindBy(how = How.XPATH, using = "//tr[2]//input[@value='Edit']")
    private WebElement elementClickOnEdit1ButtonOnRMS;


    @FindBy(how = How.XPATH, using = "//tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]")
    private WebElement elementEnterTxtKGOnRMS;

    @FindBy(how = How.XPATH, using = "//tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/input[1]")
    private WebElement elementEnterTxtLengthOnRMS;

    @FindBy(how = How.XPATH, using = "//tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/input[1]")
    private WebElement elementEnterTxtBreadthOnRMS;

    @FindBy(how = How.XPATH, using = "//tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[5]/input[1]")
    private WebElement elementEnterTxtHeightOnRMS;

    @FindBy(how = How.XPATH, using = "//tbody/tr[2]/td[8]/input[@value='Save']")
    private WebElement elementClickSaveBtnOnRMSWeiDim;

    // 2R= second row


    @FindBy(how = How.XPATH, using = "//tbody/tr[3]/td[8]/input[1]")
    private WebElement elementClickEditBtnOnKG2ROnRMSWeiDim;


   @FindBy(how = How.XPATH, using = "//tbody/tr[3]/td[2]/input[1]")
    private WebElement elementEnterTxtOnKG2ROnRMSWeiDim;

    @FindBy(how = How.XPATH, using = "//tbody/tr[3]/td[3]/input[1]")
    private WebElement elementEnterTxtOnLength2ROnRMSWeiDim;

    @FindBy(how = How.XPATH, using = "//tbody/tr[3]/td[4]/input[1]")
    private WebElement elementEnterTxtOnHeight2ROnRMSWeiDim;


    @FindBy(how = How.XPATH, using = "//tbody/tr[3]/td[5]/input[1]")
    private WebElement elementEnterTxtOnBreadth2ROnRMSWeiDim;

    @FindBy(how = How.XPATH, using = "//tbody/tr[3]/td[8]/input[1]")
    private WebElement elementClickOnSaveBtn2ROnRMSWeiDim;


    //    @FindBy(how = How.XPATH, using = "//*[normalize-space(text())='SEARCH/REPORTS']")
    @FindBy(how = How.CSS, using = "span#titleSearchReports")
//    @FindBy(how = How.XPATH, using = "//tbody//span[@id='titleSearchReports' and contains(text(),'SEARCH/REPORTS')]")
//    @FindBy(how = How.XPATH, using = "//body[1]/form[1]/div[3]/div[1]/table[5]/tbody[1]/tr[1]/td[2]")

//    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Search')]")
//    private List<WebElement> SelectSEARCHREPORTS;
    private WebElement SelectSEARCHREPORTS;


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


        ((JavascriptExecutor) driver).executeScript("window.open('https://uat.app.ram.co.za/apps/consign')");
        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Sign In To Ram Portal"));

    }

    public void manageMyAccountURL() throws InterruptedException {


        ((JavascriptExecutor) driver).executeScript("window.open('https://uat.app.ram.co.za/apps/mma')");
        System.out.println("Page title is : " + driver.getTitle());
//        assertTrue(driver.getTitle().contains("Title of Page"));
        Assert.assertTrue(driver.getTitle().contains("Sign In To Ram Portal"));

    }

    public void rMSPublicAccessURL() throws InterruptedException {


        ((JavascriptExecutor) driver).executeScript("window.open('https://uat.ram.co.za/RAMTnTv3/')");
        System.out.println("Page title is : " + driver.getTitle());
//        assertTrue(driver.getTitle().contains("Title of Page"));
//        Assert.assertTrue(driver.getTitle().contains("Sign In To Ram Portal"));

    }


    public void selectIsandoFromDropdown() throws InterruptedException {
        driver.switchTo().frame(2);
        WebElement HubDD = driver.findElement(By.xpath("//select[@id='listHubs']"));
        HubDD.click();
        Select Isando = new Select(HubDD);
        Isando.selectByVisibleText("Isando");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickONHubSelection));
        elementClickONHubSelection.click();
        Thread.sleep(3000);
        driver.switchTo().frame(2);
        webDriverWait.until(ExpectedConditions.visibilityOf(elementEnterEmployeeID));
        elementEnterEmployeeID.sendKeys("8507278318189");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterPassword));
        elementEnterPassword.sendKeys("al3s3pog");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnLoginBtn));
        elementClickOnLoginBtn.click();

    }


    public void permissionURL() throws InterruptedException {


        ((JavascriptExecutor) driver).executeScript("window.open('https://uat.app.ram.co.za/apps/permission/rolemanagement')");
        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Sign In To Ram Portal"));
    }


    public void clickOnRamCSDPortal() throws InterruptedException {


        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementAvailableAccordion));

        elementAvailableAccordion.click();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementConsignAccordion);

        scrollToElement(elementCLickOnRAMCSDPortal);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementCLickOnRAMCSDPortal);
        System.out.println("Page title is : " + driver.getTitle());

    }


    public void clickOnCustomerServicePortal() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnCustomerServicePortal));
        elementCLickOnCustomerServicePortal.click();
        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("RAMCSDPortal"));
        Thread.sleep(10000);


    }

    public void clickOnRamOpsMonitor() throws InterruptedException {


//        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementAvailableAccordion));
//
//        elementAvailableAccordion.click();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementConsignAccordion);
        driver.switchTo().activeElement();


        scrollToElement(elementCLickOnAppOpsMonitor);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementCLickOnAppOpsMonitor);
        System.out.println("Page title is : " + driver.getTitle());

    }

    public void clickOnOpsMonitorPage() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnOpsMonitorPage));
        elementCLickOnOpsMonitorPage.click();

        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Signin - RAM Operations Monitor"));
    }

    public void clickOnRMSTitle() {
        driver.switchTo().activeElement();

//        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnRMSTitle));
////        elementCLickOnRMSTitle.click();
//        elementCLickOnRMSTitle.getTagName();

        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("RAM MANAGEMENT SYSTEM"));
    }


    public void clickOnRMSPortal() {
        driver.switchTo().activeElement();


        scrollToElement(elementCLickOnRMSPortal);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementCLickOnRMSPortal);
        System.out.println("Page title is : " + driver.getTitle());

//        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnContinuePopUp));
//        elementCLickOnContinuePopUp.click();

    }

    public void clickOnRAMBilling() {
        driver.switchTo().activeElement();
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementAvailableAccordion));
//
//        elementAvailableAccordion.click();

        scrollToElement(elementCLickOnRAMBilling);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementCLickOnRAMBilling);
        System.out.println("Page title is : " + driver.getTitle());


    }


    public void clickOnRAMBillingPageTitle() {

        driver.switchTo().activeElement();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnRAMBillingInvoice));
        elementCLickOnRAMBillingInvoice.click();

        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("RAM Billing - Default"));
    }

    public void clickOnProdRAMBillingPageTitle() {

        driver.switchTo().activeElement();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnRAMBillingInvoice));
        elementCLickOnRAMBillingInvoice.click();

        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("RAM Billing - Logon"));
    }


    public void clickOnRAMRatesManager() {
        driver.switchTo().activeElement();


        scrollToElement(elementCLickOnRAMRatesManager);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementCLickOnRAMRatesManager);

        System.out.println("Page title is : " + driver.getTitle());


    }

    public void clickOnRAMRatesManagerPageTitle() {
        driver.switchTo().activeElement();

//        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnRMSTitle));
////        elementCLickOnRMSTitle.click();
//        elementCLickOnRMSTitle.getTagName();

        System.out.println("Page title is : " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("RATES EDITING MODULE"));

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


    public void clickOnSearchAndReport() throws InterruptedException {
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(SelectSEARCHREPORTS));

        Thread.sleep(50000);
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));

//        driver.switchTo().frame(0);
//        System.out.println("Frame1 "+ driver.getPageSource());
        driver.switchTo().frame(1);
        System.out.println("Frame2 " + driver.getPageSource());
//        driver.switchTo().frame(2);
//        System.out.println("Frame3 "+ driver.getPageSource());

//        List<WebElement> elements = driver.findElements(By.id("tableMain"));
//        if(elements.size()!=0){
//
//        }
//        else{
//            System.out.println("No Such element ");
//        }
////        webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("tableMain"))));

//    driver.findElement(By.id("tableMain"));
//        actions.moveToElement(SelectSEARCHREPORTS).build().perform();
//        System.out.println("element Search is "+ SelectSEARCHREPORTS.isEnabled());

//        ((JavascriptExecutor) driver).executeScript("arguments[0].click()" ,SelectSEARCHREPORTS );

//        SelectSEARCHREPORTS.click();

//        System.out.println("element Search is "+ SelectSEARCHREPORTS.isEnabled());
//        WebElement frame = driver.findElement(By.xpath("//frame[@name= 'frameIndex']"));
//        WebElement frame = driver.findElement(By.xpath("//frameset[1]/frameset/frame"));
//        driver.switchTo().frame("frameIndex");


//        FluentWait fluentWait = new FluentWait(webDriverWait);
//
//        fluentWait.withTimeout(30, TimeUnit.SECONDS);
//        fluentWait.pollingEvery(200, TimeUnit.MILLISECONDS);


        WebElement er = driver.findElement(By.cssSelector("span#titleSearchReports"));
//        WebElement er = driver.findElement(By.cssSelector("div:nth-child(1) table:nth-child(8) tbody:nth-child(1) tr:nth-child(1) > td.nav-title-mid"));
//        WebElement er = driver.findElement(By.xpath("//div[@id='menu-div-inner']/table[5]//td[@class='nav-title-mid']"));
//        WebElement er = driver.findElement(By.xpath("//body[@onload='body_onload();']/form[@id='Form1']/div[@id='menu-div-outer']/div[@id='menu-div-inner']/table[5]/tbody[1]/tr[1]"));

//        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(er));
//        actions.moveToElement(er).build().perform();
        er.click();
        Thread.sleep(5000);

        WebElement search = driver.findElement(By.xpath("//a[contains(text(),'Search')]"));
        search.click();

//        actions.moveToElement(SelectSEARCHREPORTS).build().perform();
//        SelectSEARCHREPORTS.click();
//        System.out.println("the size of row :" + table.getSize());
//         return table.getTagName();

        //        System.out.println("Number of Rows" + table.size());

        driver.switchTo().defaultContent();
    }

    public void enterConsignmentIDTxtRMS(String txt) throws InterruptedException, IOException {
        Thread.sleep(40000);
        driver.switchTo().frame(2);
//        System.out.println("Frame3 "+ driver.getPageSource());

        webDriverWait.until(ExpectedConditions.visibilityOf(elementTextConsignmentRMS));
        elementTextConsignmentRMS.sendKeys(txt);


        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnSearchButton));
        elementClickOnSearchButton.click();
        Thread.sleep(40000);

//        elementClickOnSearchButton.getScreenshotAs(OutputType.BYTES);


//        elementClickOnSearchButton.getScreenshotAs(OutputType.FILE);
//        elementClickOnSearchButton.getScreenshotAs(OutputType.FILE);

//        Allure.addAttachment(filename, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));


    }


    public void clickONConsignmentTab() throws InterruptedException {
//
        Thread.sleep(9000);
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));

//        driver.switchTo().frame(0);
//        System.out.println("Frame1 "+ driver.getPageSource());
        driver.switchTo().frame(1);
        System.out.println("Frame2 " + driver.getPageSource());

        WebElement Consignment = driver.findElement(By.cssSelector("span#titleConsignments"));
        Consignment.click();
        Thread.sleep(5000);

        WebElement search = driver.findElement(By.xpath("//body[1]/form[1]/div[2]/div[1]/table[8]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[2]/a[1]"));
//        WebElement search = driver.findElement(By.xpath("//body[1]/form[1]/div[3]/div[1]/table[8]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[2]/a[1]"));
        search.click();
        Thread.sleep(15000);
        driver.switchTo().defaultContent();
    }

    public void clickONConsignmentTabAndSelectDim() throws InterruptedException {
//
        Thread.sleep(15000);
//        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tab.get(2));

//        driver.switchTo().frame(0);
//        System.out.println("Frame1 "+ driver.getPageSource());

        driver.switchTo().frame(1);
        System.out.println("Frame2 " + driver.getPageSource());

        WebElement Consignment = driver.findElement(By.cssSelector("span#titleConsignments"));
        Consignment.click();
        Thread.sleep(5000);

        WebElement Dim = driver.findElement(By.xpath("//body[1]/form[1]/div[2]/div[1]/table[8]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]/a[1]"));

        Dim.click();
        Thread.sleep(15000);
        driver.switchTo().defaultContent();

    }
    public void clickONConsignmentTabAndSelectDimProd() throws InterruptedException {
//
        Thread.sleep(20000);
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(2));


       driver.switchTo().frame(1);
        System.out.println("Frame2 " + driver.getPageSource());

        WebElement Consignment = driver.findElement(By.cssSelector("span#titleConsignments"));
        Consignment.click();
        Thread.sleep(5000);

//        WebElement Dim = driver.findElement(By.xpath("//body[1]/form[1]/div[2]/div[1]/table[8]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]/a[1]"));
        WebElement Dim = driver.findElement(By.xpath("//body[1]/form[1]/div[3]/div[1]/table[6]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]/a[1]"));
        Dim.click();
        Thread.sleep(15000);
        driver.switchTo().defaultContent();

    }
    public void clickONConsignmentTabAndSelectDimProd1() throws InterruptedException {
//
        Thread.sleep(50000);
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tab.get(2));
        driver.switchTo().window(tab.get(3));


       driver.switchTo().frame(1);
        System.out.println("Frame2 " + driver.getPageSource());

        WebElement Consignment = driver.findElement(By.cssSelector("span#titleConsignments"));
        Consignment.click();
        Thread.sleep(5000);

//        WebElement Dim = driver.findElement(By.xpath("//body[1]/form[1]/div[2]/div[1]/table[8]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]/a[1]"));
        WebElement Dim = driver.findElement(By.xpath("//body[1]/form[1]/div[3]/div[1]/table[6]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]/a[1]"));
        Dim.click();
        Thread.sleep(15000);
        driver.switchTo().defaultContent();

    }

    public void clickONConsignmentTabProd() throws InterruptedException {
//
        Thread.sleep(9000);
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));

//        driver.switchTo().frame(0);
//        System.out.println("Frame1 "+ driver.getPageSource());
        driver.switchTo().frame(1);
        System.out.println("Frame2 " + driver.getPageSource());

        WebElement Consignment = driver.findElement(By.cssSelector("span#titleConsignments"));
        Consignment.click();
        Thread.sleep(5000);

        WebElement search = driver.findElement(By.xpath("//body[1]/form[1]/div[3]/div[1]/table[6]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[5]/td[2]/a[1]"));

        search.click();
        Thread.sleep(15000);
        driver.switchTo().defaultContent();
    }


    public String enterConsignmentIDOnRMSEdit(String txt) throws InterruptedException {

        driver.switchTo().frame(2);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterConsignmentIDRMS));
        elementEnterConsignmentIDRMS.sendKeys(txt);
        Thread.sleep(5000);

        return txt;
    }

    public void enterConsignmentIDOnRMSEditBtn() throws InterruptedException {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnBtnConsignmentIDRMSEdit));
        elementClickOnBtnConsignmentIDRMSEdit.click();

    }

    public String verifyConsignmentIDTextField() {

        SoftAssert softAssert = new SoftAssert();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementConsignmentIDFieldOnRMSEdit));
//        elementConsignmentIDFieldOnRMSEdit.click();
//
        elementConsignmentIDFieldOnRMSEdit.getAttribute("value");
        System.out.println("The Created Consignment ID:  " + elementConsignmentIDFieldOnRMSEdit.getAttribute("value"));

        String ExpectedConsignmentID = "";


//        softAssert.assertEquals(elementConsignmentIDFieldOnRMSEdit.getAttribute("value"), );
        return ExpectedConsignmentID;
    }


    public String verifySenderAddressField() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSenderIDFieldOnRMSEdit));
        elementSenderIDFieldOnRMSEdit.getAttribute("value");

        System.out.println("Sender Address is: " + elementSenderIDFieldOnRMSEdit.getAttribute("value"));
        String ExpectedSenderAddress = "";

        return ExpectedSenderAddress;
    }

    public String verifyBilledToProd() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementBilledToFieldOnRMSEditProd));
        elementBilledToFieldOnRMSEditProd.getAttribute("value");

        System.out.println("Sender Address is: " + elementBilledToFieldOnRMSEditProd.getAttribute("value"));
        String ExpectedSenderAddress = "";

        return ExpectedSenderAddress;
    }

    public String verifyReceiverAddress() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementReceiverNameFieldOnRMSEdit));
        elementReceiverNameFieldOnRMSEdit.getAttribute("value");

        System.out.println("Receiver Address is:  " + elementReceiverNameFieldOnRMSEdit.getAttribute("value"));

        String ExpectedReceiverAddress = "";

        return ExpectedReceiverAddress;

    }

    public String verifyShipperRefFieldData() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementShipperRefFieldOnRMSEdit));
        elementShipperRefFieldOnRMSEdit.getAttribute("value");

        System.out.println("Shipper Reference is:  " + elementShipperRefFieldOnRMSEdit.getAttribute("value"));
        String ShipperReference = "";
        return ShipperReference;


    }

    public String verifyGoodsDescriptionFieldData() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementGoodsDescriptionFieldOnRMSEdit));
        elementGoodsDescriptionFieldOnRMSEdit.getAttribute("value");

        System.out.println("Goods Description :   " + elementGoodsDescriptionFieldOnRMSEdit.getAttribute("value"));

        String GoodDescription = "";
        return GoodDescription;

    }

    public boolean verifyServiceND17H00IsSelected() {
        elementCheckBoxND17h00IsSelectedOnRMSEdit.isSelected();
        WebElement RadioBtnND17H00 = driver.findElement(By.xpath("//input[@id='radioServiceND']"));
        System.out.println("Service ND 17H00 is selected:  " + RadioBtnND17H00.isSelected());
        Assert.assertEquals(true, RadioBtnND17H00.isSelected());

        return true;

    }

    public boolean verifySaturdayIsSelected() {
        elementVerifySaturdayOnRMSEdit.isSelected();
        WebElement saturday = driver.findElement(By.xpath("//input[@id='checkSurchargeS']"));
        System.out.println("Saturday is selected:  " + saturday.isSelected());
        Assert.assertEquals(true, saturday.isSelected());

        return true;

    }


    public String verifyNoOfParcelField() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementVerifyNoOfParcelOnRMSEdit));
        elementVerifyNoOfParcelOnRMSEdit.getAttribute("value");

        System.out.println("No of parcel is:  " + elementVerifyNoOfParcelOnRMSEdit.getAttribute("value"));

        String ParcelCount = "";
        return ParcelCount;


    }

    public String enterConsignmentIDInDimParcels(String txt, Keys keys) {
        driver.switchTo().frame(2);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterConsignmentIDDimParcels));
        elementEnterConsignmentIDDimParcels.click();
        elementEnterConsignmentIDDimParcels.sendKeys(txt, keys);

        return txt;

    }

    public String enterConsignmentIDInDimParcelsInbound(String txt, Keys keys) {
//        driver.switchTo().frame(2);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterConsignmentIDDimParcels));
        elementEnterConsignmentIDDimParcels.click();
        elementEnterConsignmentIDDimParcels.sendKeys(txt, keys);

        return txt;

    }


    public void enterNumberOfParcelInDimParcels(String txt) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterNumOfParcelDimParcels));
        elementEnterNumOfParcelDimParcels.sendKeys(txt);

    }

    public void clickOnDimButton() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnDimButton));
        elementClickOnDimButton.click();

    }


    public void clickOnDoneButtonOnWDRMSPortal() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnDoneButtonOnRMS));
        elementClickOnDoneButtonOnRMS.click();

    }


    public void clickOnEdit1ButtonOnWDRMSPortal() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnEdit1ButtonOnRMS));
        elementClickOnEdit1ButtonOnRMS.click();

    }

    public String enterTxtKGRMSPortalWeiDim(String txt) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtKGOnRMS));
        elementEnterTxtKGOnRMS.click();
        elementEnterTxtKGOnRMS.sendKeys(Keys.CONTROL + "a");
        elementEnterTxtKGOnRMS.sendKeys(Keys.DELETE);
        elementEnterTxtKGOnRMS.sendKeys(txt);

        return elementEnterTxtKGOnRMS.getAttribute("value");

    }

    public void enterTxtKG2RONRMSPortalWeiDim(String txt) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtOnKG2ROnRMSWeiDim));
        elementEnterTxtOnKG2ROnRMSWeiDim.click();
        elementEnterTxtOnKG2ROnRMSWeiDim.sendKeys(Keys.CONTROL + "a");
        elementEnterTxtOnKG2ROnRMSWeiDim.sendKeys(Keys.DELETE);
        elementEnterTxtOnKG2ROnRMSWeiDim.sendKeys(txt);
    }

    public String enterTxtLengthRMSPortalWeiDim(String txt) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtLengthOnRMS));
        elementEnterTxtLengthOnRMS.click();
        elementEnterTxtLengthOnRMS.sendKeys(Keys.CONTROL + "a");
        elementEnterTxtLengthOnRMS.sendKeys(Keys.DELETE);
        elementEnterTxtLengthOnRMS.sendKeys(txt);

        return elementEnterTxtLengthOnRMS.getAttribute("value");


    }

    public void enterTxtLength2ROnRMSPortalWeiDim(String txt) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtOnLength2ROnRMSWeiDim));
        elementEnterTxtOnLength2ROnRMSWeiDim.click();
        elementEnterTxtOnLength2ROnRMSWeiDim.sendKeys(Keys.CONTROL + "a");
        elementEnterTxtOnLength2ROnRMSWeiDim.sendKeys(Keys.DELETE);
        elementEnterTxtOnLength2ROnRMSWeiDim.sendKeys(txt);
    }

    public String enterTxtBreadthRMSPortalWeiDim(String txt) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtBreadthOnRMS));
        elementEnterTxtBreadthOnRMS.click();
        elementEnterTxtBreadthOnRMS.sendKeys(Keys.CONTROL + "a");
        elementEnterTxtBreadthOnRMS.sendKeys(Keys.DELETE);
        elementEnterTxtBreadthOnRMS.sendKeys(txt);

        return elementEnterTxtBreadthOnRMS.getAttribute("value");
    }

    public void enterTxtBreadth2ROnRMSPortalWeiDim(String txt) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtOnBreadth2ROnRMSWeiDim));
        elementEnterTxtOnBreadth2ROnRMSWeiDim.click();
        elementEnterTxtOnBreadth2ROnRMSWeiDim.sendKeys(Keys.CONTROL + "a");
        elementEnterTxtOnBreadth2ROnRMSWeiDim.sendKeys(Keys.DELETE);
        elementEnterTxtOnBreadth2ROnRMSWeiDim.sendKeys(txt);

    }

    public void enterTxtHeightRMSPortalWeiDim(String txt) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtHeightOnRMS));
        elementEnterTxtHeightOnRMS.click();
        elementEnterTxtHeightOnRMS.sendKeys(Keys.CONTROL + "a");
        elementEnterTxtHeightOnRMS.sendKeys(Keys.DELETE);
        elementEnterTxtHeightOnRMS.sendKeys(txt);
    }

    public void enterTxtHeight2ROnRMSPortalWeiDim(String txt) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtOnHeight2ROnRMSWeiDim));
        elementEnterTxtOnHeight2ROnRMSWeiDim.click();
        elementEnterTxtOnHeight2ROnRMSWeiDim.sendKeys(Keys.CONTROL + "a");
        elementEnterTxtOnHeight2ROnRMSWeiDim.sendKeys(Keys.DELETE);
        elementEnterTxtOnHeight2ROnRMSWeiDim.sendKeys(txt);

    }

    public void clickOnSaveBtnOnRMSPortalWeiDim() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickSaveBtnOnRMSWeiDim));

        elementClickSaveBtnOnRMSWeiDim.click();

    }

    public void clickOnSaveBtn2ROnRMSPortalWeiDim() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnSaveBtn2ROnRMSWeiDim));

        elementClickOnSaveBtn2ROnRMSWeiDim.click();


    }


    public void clickOnEditBtn2ROnRMSPortalWeiDim() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickEditBtnOnKG2ROnRMSWeiDim));

        elementClickEditBtnOnKG2ROnRMSWeiDim.click();


    }


}

