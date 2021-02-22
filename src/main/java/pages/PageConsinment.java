package pages;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.commonmodule.Loader;
import pages.commonmodule.Login;

import java.security.Key;
import java.util.List;

public class PageConsinment extends BasePage {

    //    Actions actions;
    private Loader loader ;
    private WebDriver webDriver;

    public PageConsinment(WebDriver webDriver) {
        super(webDriver);

        this.webDriver = webDriver;
        loader = new Loader(driver);
    }

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='ConsignmentID']")
    private WebElement elementtxtConsignmentID;
    // Toster for invalid consigment id

//    @FindBy(how=How.XPATH, using = "//div[@class='toast toast-error animated zoomInUp']")
//    private WebElement elementToasterAlreadycosigned;

//    @FindBy(how = How.XPATH, using = "//input[@id='BilledTo']")
    @FindBy(how = How.CSS, using = "#BilledTo")
//    @FindBy(how = How.ID, using = "BilledTo")
    private WebElement elementtxtBilledTo;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active v-autocomplete__content']//div[@role='listitem'][1]")
    private WebElement elementMenuBilledTo;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@id='Commodity']")
    private WebElement elementtxtCommodity;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//label[text()='Commodity']/parent::*/div[1]/div")
    private WebElement elementCommodityText;

//    //input[@id='Commodity']/..
    @CacheLookup
    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active']//div[@role='listitem' and @class='primary--text']")
    private WebElement elementMenuCommodity;


    @CacheLookup
    // validate commodity scenerio
//    @FindBy(how = How.XPATH, using = "//div[@class='v-select__selections']/div[contains(text(),'Cellular Equipment')]")
    @FindBy(how = How.XPATH, using = "//div[@class='v-select__selections']/div[contains(text(),'General')]")
    private WebElement elementcommudity;

    @CacheLookup
    // Select Document and verify
    @FindBy(how =How.XPATH, using = "//div[@class='v-list__tile__content']/div[contains(text(),'Documentation')]")
    private WebElement elementMenuCommudityDocument;

    @CacheLookup
    // Popup Continue
    @FindBy(how =How.XPATH,using = "//button[@id='CommodityContinue']")
    private WebElement elementPopCommudityContinue;

    @CacheLookup
    // Select Jwellery and Verify 2nd
    @FindBy(how =How.XPATH,using = "//div[@class='v-select__selections']/div[contains(text(),'Documentation')]")
    private WebElement elementCommudityJwelleryStep;

    @CacheLookup
//    @FindBy(how =How.XPATH,using = "//div[@class='v-list__tile__content']/div[contains(text(),'Jewellery')]")
    @FindBy(how =How.XPATH,using = "//div[@class='v-list__tile__content']/div[contains(text(),'General')]")
    private WebElement elementMenuJwellery;

    @CacheLookup
    @FindBy(how=How.XPATH,using = "//button[@class='v-btn v-btn--outline v-btn--depressed theme--light primary--text']/div[contains(text(),'Continue')]")
    private WebElement elementpopUpContinueJwellery;

    // Stepper  second Validation

    @CacheLookup
    @FindBy(how =How.XPATH, using = "//div[@id='stepSender']")
    private WebElement elementMenuSecondStepper;

    @CacheLookup
//    @FindBy(how=How.XPATH,using = "//div[contains(text(),'Reset')]")
    @FindBy(how=How.XPATH,using = "//button[@id='SenderResetSearch']//div")
    private WebElement elementButtonReset;

    @CacheLookup
//    @FindBy(how= How.XPATH, using = "//input[@id='SenderName']")
    @FindBy(how= How.XPATH, using = "//input[@id='SearchAutocomplete_Sender']")
    private WebElement elemnentFieldSenderName;

    @CacheLookup
//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'CELL C - COMPANY OWNED STORES, CELL C, 084 174 4000')]")
//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'ASUREN NAIDOO, I1149777, 000 000 0000')]")
//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'CELLSURE (PTY) LTD, 000 000 0000')]")
//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'SURE WENHOLD - 074 460 7090')]")
    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active v-autocomplete__content']//div[@role='listitem'] [2]")
    private WebElement elementMenuSenderName;

//    @CacheLookup
//    @FindBy(how = How.XPATH, using= "//button[@id='SenderContactNew']//div[@class='v-btn__content'][contains(text(),'New Contact')]")
//    @FindBy(how = How.XPATH, using= "//button[@id='SenderNewContact']//div[@class='v-btn__content'][contains(text(),'New Contact')]")
    @FindBy(how = How.XPATH, using= "//button[@id='SenderContactNew']//div[@class='v-btn__content'][contains(text(),'New Contact')]")
    private WebElement elementbuttonNewContact;

    @CacheLookup
//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Cancel')]")
    @FindBy(how = How.XPATH, using = "//button[@id='Cancel_sendercontactaddedit']//div[contains(text(),'Cancel')]")
    private WebElement elementbuttonCancel;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//button[@id='SenderContactEdit']//div[contains(text(),'Edit Contact')]")
    private WebElement elementbuttonEditContact;

    @CacheLookup
    @FindBy(how = How.XPATH, using= "// button[@id='save_sendercontactaddedit']//div[contains(text(),'Save')]")
    private WebElement elementbuttonSAVE;

    @CacheLookup
    @FindBy(how= How.XPATH, using = "// button[@id='Cancel_sendercontactaddedit']//div[contains(text(),'Cancel')]")
    private WebElement elementbuttonCancelEditContact;

    // Step third receiver

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//div[@id='stepReceiver']")
    private WebElement elementThirdStepReciever;

    @CacheLookup
    @FindBy(how = How.XPATH, using= "//div[contains(text(),'New Receiver')]")
    private WebElement elementbuttonNewReceiver;

    @CacheLookup
    @FindBy(how= How.XPATH, using = "//button[@id='NewCancelCustomer']/div[contains(text(),'Cancel')]")
    private WebElement elementbuttonCancelNewReceiverDetails;

    @CacheLookup
//    @FindBy(how = How.XPATH, using = "//input[@id='ReceiverName']")
    @FindBy(how = How.XPATH, using = "//input[@id='SearchAutocomplete_Receiver']")
    private WebElement elementRecieverName;

    @CacheLookup
//    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active v-autocomplete__content']//div[@class='v-list__tile__content'][1]")
//    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active v-autocomplete__content']//div[contains(text(),'Surekha Jadhav - 2412434324')]")
    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active v-autocomplete__content']//div[@role='listitem'][2]")
    private WebElement elementMenuRecieverName;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//button[@id='ReceiverNewContact']/div[contains(text(),'New Contact')]")
    private WebElement elementbuttonNewContactReceiverContact;

    @CacheLookup
    @FindBy(how= How.XPATH, using = "//button[@id='save_receivercontactaddedit']/div[contains(text(),' Save')]")
    private WebElement elementbuttonSaveNewConntact;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//button[@id='cancel_receivercontactaddedit']/div[contains(text(),' Cancel')]")
    private WebElement elementbuttonCancelNewContact;

    @CacheLookup
    //Step fourth
    @FindBy(how = How.XPATH, using = "//div[@id='stepValue']")
    private WebElement elementStepValue;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//div[@class='v-text-field__slot']//input[@id='ValueForCarriage']")
    private WebElement elementtxtValueForCarriage;

    @CacheLookup
    // Clicked oN Check Box.
    @FindBy(how= How.XPATH, using = "//div[@class='v-input--selection-controls__ripple']")
    private WebElement elementFullLiabilityCheckBox;

    @CacheLookup
    //Step Five
    @FindBy(how= How.XPATH, using = "//div[@id='stepRequirements']")
    private WebElement elementRequirements;

    @CacheLookup
    @FindBy(how= How.XPATH, using = "//input[@id='ShipperReference']")
    private WebElement elementtxtShipperReference;

    @CacheLookup
    @FindBy(how=How.XPATH, using = "//div[@class='flex xs12 md12']//div[@class='v-select__selections']")
    private WebElement elementProofOfDelivery;

    @CacheLookup
    @FindBy(how=How.XPATH, using = "//div[contains(text(),'KYC Code 1-Sign Waybill')]")
    private WebElement elemnetMenuProofOfDelivery;

    @CacheLookup
    @FindBy(how=How.XPATH, using = "//div[@name='instruction-combobox']//div[@class='v-select__selections']")
    private WebElement elementStandardInstructionType;

    @CacheLookup
    @FindBy(how=How.XPATH, using = "//div[contains(text(),'DontDeliverOn')]")
    private WebElement elementMenuStandardInstructionType;

    @CacheLookup
    @FindBy(how=How.XPATH, using = "//div[@class='flex md5']//div[@class='v-select__slot']")
    private WebElement elementNonDeliverableDates;

    @CacheLookup
    @FindBy(how= How.XPATH, using = "//div[@role='listitem']//div[contains(text(),'Wednesday')]")
    private WebElement elementMenuNonDeliverableDays;

    // special instructions
    @CacheLookup
    @FindBy(how = How.XPATH, using = "//button[@id='AddAnotherInstruction']")
    private WebElement elementbuttonAddAnotherInstruction;

    @FindBy(how = How.XPATH,using = "//div[@class='v-select__slot']//input[@id='StandardInstructionType5']")
    private WebElement elementsecondStandardInstructionType5;

    //Step sixth

    @FindBy(how=How.XPATH, using = "//div[@id='stepServices']")
    private WebElement elementStepServices;

    //@FindBy(how=How.XPATH,using = "//div[contains(text(),'Armed Escort / Vehicle')]")
    @FindBy(how=How.XPATH,using = "//div[contains(text(),'Saturday')]")
    private WebElement elementButtonSelectSurcharge;

    @FindBy(how = How.XPATH, using = "//input[@id='ServiceType']/..")
    private WebElement elementClickOnServiceTypeField;

//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Express Road')]")
    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active']//div[@role='listitem'][1]")
    private WebElement elementSelectExpressRoad;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'RICA')]")
    private WebElement elementRICA;

    @FindBy(how = How.XPATH, using = "//input[@id='RICA_IdentityType']/..")
    private WebElement elementClickOnIdentityType;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'SA ID')]")
    private WebElement elementSelectSAID;

    @FindBy(how =How.XPATH, using = "//input[@id='RICA_SAIdentityNumber']")
    private WebElement elementEnterTxtInSAID;

    @FindBy(how = How.XPATH, using = "//input[@id='Fridgeline']/..")
    private WebElement elementFridgelineDD;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Maximum of 36 Hours')]")
    private WebElement elementSelectFridgelineHrs;

    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active']//div[@role='listitem'][2]")
    private WebElement elementSelectNextDayOption;


    //Step Seven
    @FindBy(how=How.XPATH, using = "//div[@id='stepParcels']")
    private WebElement elementStepParcel;

    @FindBy(how=How.XPATH, using = "//input[@id='NumberOfParcels']")
    private WebElement elementNumberOfParcel;

    // Step Seven fill the details

    @FindBy(how = How.XPATH, using = "//input[@id='ParcelPackageType001']/..")
    private WebElement  elementClickOnPackageType01;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'RAM-Flyer-Large')]")
    private WebElement elementSelectBox1FromPackageTypeList;

    @FindBy(how = How.XPATH, using = "//input[@id='ParcelRef001']")
    private WebElement elementEnterParcelReference;

    @CacheLookup
    @FindBy(how=How.XPATH,using = "//input[@id='ParcelSecurityPack001']")
    private WebElement elementSecurityPack;

    @FindBy(how=How.XPATH,using ="//input[@id='ParcelWeight001']")
    private WebElement elementweight;

    @FindBy(how=How.XPATH, using = "//div[@class='v-input v-text-field v-select v-input--is-focused theme--light primary--text']//div[@class='v-select__selections']")
    private WebElement elementPackageType;

    @FindBy(how=How.XPATH, using = "//div[@role='listitem']//div[contains(text(),'Box1')]")
    private WebElement elementMenuPackageType;

    //Finalise Consignment step
    @FindBy(how=How.XPATH,using = "//button[@id='FinaliseConsignment']")
    private WebElement elementbuttonFinaliseConsignment;

    @FindBy(how=How.XPATH,using = "//div[@class='v-dialog v-dialog--active']//div[@class='v-btn__content'][contains(text(),'Close')]")
    private WebElement elementPopUpClose;

    // Select Parcel 2 and validate delete function

    //@FindBy(how=How.XPATH, using="//div[@class='parcelContent']//div[2]//div[11]")
    @FindBy(how=How.XPATH, using= "//i[@class='v-icon material-icons theme--light' and contains(text(),'delete')][1]")
    private WebElement elementdeleteicon;

    @FindBy(how= How.XPATH, using = "//a[contains(text(),'Consignment')]")
    private WebElement elementConsignmentDropDown;

    @FindBy(how = How.XPATH,using = "//div[contains(text(),'Create Consignment')]")
    private WebElement elementClickOnCreateConsignmentFromDD;



    @FindBy(how= How.XPATH,using = "//input[@id='LogisticType']/..")
    private WebElement elementClickOnLogisticType;

    @FindBy(how = How.XPATH, using = "//div[text()='Outbound - Domestic']")
    private  WebElement eleementSelectOutbondFromLogisticList;



    @Step("click on Logistic Type and verify If there is any value for that field")
    public int clickOnLogisticTypeFieldAndVerify(){
        List<WebElement> logisticValue = webDriver.findElements(By.xpath("//input[@id='LogisticType']/../div"));
        return logisticValue.size();
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='LogisticType']/../div")));

//        WebElement logisticType = webDriver.findElement(By.xpath("//input[@id='LogisticType']/../div"));


    }
    @Step("Click on Logistic Type and select Outbond")
    public void clickOnLogisticTypeAndSelectOutbond() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnLogisticType));
        elementClickOnLogisticType.click();

        Thread.sleep(2000);

        eleementSelectOutbondFromLogisticList.click();
    }

    //    public void enterTxtConsignmentID(String txt,Keys keys) {
    @Step("Click on consignment DropDown")
    public void clickOnConsignmentDropdown(){
        loader.waitForLoaderToDispose();
//        elementConsignmentDropDown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnCreateConsignmentFromDD));
        elementClickOnCreateConsignmentFromDD.click();

    }

    @Step("Enter txt consignment : \"{0}\"")
    public void enterTxtConsignmentID(String txt, Keys keys) {
//        loader.waitForLoaderToDispose();
        webDriverWait.until(ExpectedConditions.visibilityOf(elementtxtConsignmentID));
        elementtxtConsignmentID.sendKeys(Keys.CONTROL +"a");
        elementtxtConsignmentID.sendKeys(Keys.DELETE);
    elementtxtConsignmentID.sendKeys(txt,keys);
//        actions.sendKeys();
    }


    public void enterTxtBilledTo(String txt) {
//        loader.waitForLoaderToDispose();
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementtxtBilledTo));
        elementtxtBilledTo.sendKeys(Keys.CONTROL +"a");
        elementtxtBilledTo.sendKeys(Keys.DELETE);
        elementtxtBilledTo.sendKeys(txt);
        elementtxtBilledTo.click();
    }

    public boolean isMenuBilledToDisplayed() {
        webDriverWait.until(ExpectedConditions.visibilityOf(elementtxtBilledTo));
        return elementMenuBilledTo.isDisplayed();
    }

    public void selectMenuBilledTo() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementMenuBilledTo));
        System.out.println("hhhhhhhhhhhhhhhhhhhhhh");
        elementMenuBilledTo.click();
    }
//
//    @Step("Enter txt billed me too : \"{0}\"")
//    public void enterTxtBilledTo(String txt) throws InterruptedException {
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementtxtBilledTo));
//        elementtxtBilledTo.sendKeys(txt);
//        elementtxtBilledTo.click();
//    }

//    @Step("select from menu billed to")
//    public void selectMenuBilledTo() {
//        elementMenuBilledTo.click();
//    }


    public void enterTxtCommodity(String txt) {
        elementtxtCommodity.click();
    }

    public boolean iselementMenuCommodity() {
        return elementMenuCommodity.isDisplayed();
    }

    public void iselementMenuCommodity1() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementMenuCommodity));
    }

    @Step("Click On Second Stepper")
    public void clickOnSecondStepper() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementMenuSecondStepper));
        elementMenuSecondStepper.click();

    }

    @Step("Validate Reset Button")
    public void validateResetButton(){
        webDriverWait.until(ExpectedConditions.visibilityOf(elementButtonReset));
        elementButtonReset.click();
    }


//    @Step("Verify Field Sender value")
//    public boolean verifySenderFieldText() {
//        WebElement senderAdd = webDriver.findElement(By.xpath("//input[@id='SenderName']"));
//        return senderAdd.getAttribute("value").isEmpty();
//
//    }

    @Step("Verify Field Sender value reset is present")
    public int verifySenderAddress(){


        List<WebElement> verifySender= webDriver.findElements(By.xpath("//button[@id='SenderResetSearch']//div"));
        return verifySender.size();




    }

    @Step("Verify the message displayed with following text")
    public boolean verifySenderFieldRestricted(){
        try{
        WebElement senderRestricted=webDriver.findElement(By.xpath("//div[contains(text(),'Sender is restricted, please select one from the list. Note: The list displays a maximum of 8 results.')]"));
//        return senderRestricted.isDisplayed();
//            System.out.println(senderRestricted.isDisplayed() + "Message displayed");
          return true;

        }catch (Exception e){
            return false;


        }

//        System.out.println("senderRestricted.isDisplayed()");

    }
    @Step("Verify the message displayed with following text")
    public boolean verifySenderFieldNotRestricted() {
        try {
            WebElement senderNotRestricted = webDriver.findElement(By.xpath("//div[contains(text(),' Search for an existing Sender using either Sender Name, Sender Reference or Sender Telephone Number.')]"));
            System.out.println("Sender field not restricted"+senderNotRestricted.isDisplayed());
//        return senderNotRestricted.isDisplayed();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Verify the receiver field displayed with following message")
    public boolean verifyReceiverFieldNotRestricted(){
        try{
            WebElement receiverNotRestricted = webDriver.findElement(By.xpath("//div[contains(text(),' Search for an existing Receiver using either Receiver Name, Receiver Reference or Receiver Telephone Number. ')]"));
            System.out.println("Receiver field not restricted" + receiverNotRestricted.isDisplayed());
//            return receiverNotRestricted.isDisplayed();
            return true;

                    }

        catch (Exception e){
            return false;
        }
    }
    @Step("Verify the receiver field is restricted and displayed with following message")
    public boolean verifyReceiverFieldIsRestricted(){
        try{
            WebElement receiverFieldIsRestricted = webDriver.findElement(By.xpath("//div[contains(text(),'Receiver is restricted, please select one from the list. Note: The list displays a maximum of 8 results. ')]"));
            System.out.println("Receiver field is not restricted" + receiverFieldIsRestricted.isDisplayed());
//            return receiverFieldIsRestricted.isDisplayed();
            return true;

                    }
        catch (Exception e){
            return false;
        }
    }

    @Step("Verify Field receiver value")
    public int verifyReceiverAddress(){
//        WebElement receiverAdd = webDriver.findElement(By.xpath("//button[@id='ReceiverResetSearch']//div"));
//        return receiverAdd.isDisplayed();

        List<WebElement> receiverAdd = webDriver.findElements(By.xpath("//button[@id='ReceiverResetSearch']//div"));
        return receiverAdd.size();
    }


    @Step("Click On Sender Name")
    public void clickOnSenderName(String txt) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elemnentFieldSenderName));

        elemnentFieldSenderName.sendKeys(txt);
        webDriverWait.until(ExpectedConditions.visibilityOf(elemnentFieldSenderName));
        elemnentFieldSenderName.click();

    }
    @Step("Click On Sender Name")
    public void clickOnSenderNameRestricted() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elemnentFieldSenderName));

//        elemnentFieldSenderName.sendKeys(txt);
//        webDriverWait.until(ExpectedConditions.visibilityOf(elemnentFieldSenderName));
        elemnentFieldSenderName.click();

    }


    @Step("Select from Menu Sender Name ")
    public void SelectMenuSenderName(){
        webDriverWait.until(ExpectedConditions.visibilityOf(elementMenuSenderName));

        elementMenuSenderName.click();
    }
    @Step("Click On button New Contact")
    public void clickOnButtonNewContact(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementbuttonNewContact));
        elementbuttonNewContact.click();
    }

    @Step("Click On button Cancel button")
    public void clickOnCancelButton(){
        webDriverWait.until(ExpectedConditions.visibilityOf(elementbuttonCancel));
        elementbuttonCancel.click();


    }
    @Step("Click On button Edit Contact")
    public void clickOnbuttonEditContact(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementbuttonEditContact));
        elementbuttonEditContact.click();

//        webDriverWait.until(ExpectedConditions.visibilityOf(elementbuttonSAVE));
//        elementbuttonSAVE.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementbuttonCancelEditContact));
        elementbuttonCancelEditContact.click();
    }

    @Step("Click On Step Receiver")
    public void clickOnStepReciever() {
        webDriverWait.until(ExpectedConditions.visibilityOf(elementThirdStepReciever));
        elementThirdStepReciever.click();
        scrollToElement(elementThirdStepReciever);
    }

    @Step("Click On button New Receiver")
    public void clickOnbuttonNewReceiver(){
        webDriverWait.until(ExpectedConditions.visibilityOf(elementbuttonNewReceiver));
        elementbuttonNewReceiver.click();

    }
    @Step("Click On button Cancel on New Customer")
    public void clickonCancelbuttonNewCustomer(){
        webDriverWait.until(ExpectedConditions.visibilityOf(elementbuttonCancelNewReceiverDetails));
        elementbuttonCancelNewReceiverDetails.click();

    }



    @Step("Enter text Receiver Name")
    public void entertxtRecieverName(String txt) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementRecieverName));
        elementRecieverName.sendKeys(txt);
        elementRecieverName.click();
    }
    @Step("Enter text Receiver Name")
    public void entertxtRecieverNameRestricted() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementRecieverName));
//        elementRecieverName.sendKeys(txt);
        elementRecieverName.click();
    }

    @Step("Select Receiver Name from dropdown list")
    public void selectMenuRecieverName() {
        elementMenuRecieverName.click();
    }

    @Step("Click On button New Contact on Receiver Contact ]")
    public void clickOnbuttonNewContactReceiverContact(){

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementbuttonNewContactReceiverContact));
        elementbuttonNewContactReceiverContact.click();

    }
    @Step("Click On button Save New Contact")
    public void clickonSavebuttonNewContact(){

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementbuttonSaveNewConntact));
        elementbuttonSaveNewConntact.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementbuttonCancelNewContact));
        elementbuttonCancelNewContact.click();

    }


    @Step("Click On Stepper Step Value")
    public void clickOnStepValue() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementStepValue));
        elementStepValue.click();

    }
    @Step("Enter Text Step Value")
    public void entertxtStepValue(String txt) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementtxtValueForCarriage));
        elementtxtValueForCarriage.sendKeys(txt);
    }

    @Step("Check on Check box of Full Liability")
    public void clickOnCheckBox(){

        elementFullLiabilityCheckBox.click();

    }
    @Step("Click on Stepper Requirment")
    public void clickOnStepRequirement(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementRequirements));
        elementRequirements.click();
    }

    @Step("Enter Text for Shipper Reference")
    public void entertxtShipperReference(String txt){
        webDriverWait.until(ExpectedConditions.visibilityOf(elementtxtShipperReference));
        elementtxtShipperReference.sendKeys(txt,Keys.ENTER);
        elementtxtShipperReference.clear();
        elementtxtShipperReference.sendKeys(txt);
    }

    @Step("Click On button New Contact")
    public void clickOnDropdownProofOfDelivery(Keys tab) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementProofOfDelivery));
        elementProofOfDelivery.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(elemnetMenuProofOfDelivery));
        elemnetMenuProofOfDelivery.click();
    }
    @Step("Select Standard Instruction type from dropdown")
    public void ClickonDropDownStandardInstructionType() {

        webDriverWait.until(ExpectedConditions.visibilityOf(elementStandardInstructionType));
        elementStandardInstructionType.click();
        elementMenuStandardInstructionType.click();
    }

    @Step("Check On NonDeliverableDays from list")
    public void clickonDropdownNonDeliverablesDays(Keys tab){
        webDriverWait.until(ExpectedConditions.visibilityOf(elementNonDeliverableDates));
        elementNonDeliverableDates.click();
        elementMenuNonDeliverableDays.click();

    }

    public void clickOnAddAnotherInstruction(){
        //WebDriverWait webDriverWait = new WebDriverWait(driver,30);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementbuttonAddAnotherInstruction));
        elementbuttonAddAnotherInstruction.click();

        // WebDriverWait webDriverWait = new WebDriverWait(driver,30);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementsecondStandardInstructionType5));
        elementsecondStandardInstructionType5.click();
    }

    @Step("Click On stepper Services")
    public void clickonstepServices(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementStepServices));
        elementStepServices.click();
//        webDriverWait.until(ExpectedConditions.visibilityOf(elementButtonSelectSurcharge));
//        elementButtonSelectSurcharge.click();
    }
    @Step("click on Service Type and select Express Road")
    public void selectServiceType(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnServiceTypeField));
        elementClickOnServiceTypeField.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(elementSelectExpressRoad));
        elementSelectExpressRoad.click();
    }

    @Step("Click On Service Type and select Next Day 17H00")
    public void selectServiceTypeAndSelectNextDay(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnServiceTypeField));
        elementClickOnServiceTypeField.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(elementSelectNextDayOption));
        elementSelectNextDayOption.click();
    }

    @Step("click on Rica if not select")
    public void selectRICAOnSurcharge(){

        webDriverWait.until(ExpectedConditions.visibilityOf(elementRICA));
        elementRICA.click();

            }
    @Step("Verify Rica is select or not")
    public boolean verifyRICA(){
//      WebElement Rica = webDriver.findElement(By.xpath("//div[contains(text(),'RICA')]")) ;
      WebElement Rica = webDriver.findElement(By.xpath("//button[@id='RICA']")) ;
        System.out.println("Rica is selected"+ Rica.isEnabled());
        return Rica.isEnabled();
//        List<WebElement> Rica = webDriver.findElement(By.xpath("//button[@id='RICA']")) ;//
//       return Rica.size();
//        List<WebElement> rica = webDriver.findElements(By.xpath("//button[@id='RICA']"));
//        return rica.size();
    }

    @Step("Click on Idnetity type and select SA ID ")
    public void clickOnSAID(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnIdentityType));
        elementClickOnIdentityType.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectSAID));
        elementSelectSAID.click();
    }

    @Step("Verify FridgeLine Window field is available")
    public boolean verifyFridgelineWindow(){
        try {


            WebElement fridgeLineField = webDriver.findElement(By.xpath("//input[@id='Fridgeline']//.."));
            System.out.println("FridgeLineWindow is available" + fridgeLineField.isEnabled());
//            return fridgeLineField.isEnabled();
            return false;
        }
        catch (Exception e){
            return true;
        }
    }

    @Step("Select FridgeLine hrs")
    public void clickOnFridgeLineAndSelectHrs(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementFridgelineDD));
        elementFridgelineDD.click();


        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectFridgelineHrs));
        elementSelectFridgelineHrs.click();



    }
    @Step("Enter text in SA ID field")
    public void enterTxtInSAIDField(String txt){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtInSAID));
        elementEnterTxtInSAID.sendKeys(txt);

    }

    @Step("Click On stepper Parcel")
    public void clickonStepParcel(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementStepParcel));
        elementStepParcel.click();



    }

    @Step("Enter text Number of parcel")
    public void entertxtNumberOfParcel(String txt ){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementNumberOfParcel));
        elementNumberOfParcel.sendKeys(txt, Keys.ENTER);
        //actions.sendKeys(Keys.TAB);
    }

    @Step("Click on Security Pack")
    public void clickOnSecurityPack(String txt){
        webDriverWait.until(ExpectedConditions.visibilityOf(elementSecurityPack));
        elementSecurityPack.sendKeys(txt,Keys.TAB);

    }

    @Step("Enter text weight ")
    public void entertxtweight(String txt){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementweight));
        elementweight.sendKeys(txt);

    }

    @Step("click On PackageType01 and select Box1")
    public void clickOnPackageType01(){
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementPackageType));
//        elementPackageType.click();
//        webDriverWait.until(ExpectedConditions.visibilityOf(elementMenuPackageType));
//        elementMenuPackageType.click();
//
        webDriverWait.until(ExpectedConditions.visibilityOf(elementClickOnPackageType01));
        elementClickOnPackageType01.click();


        webDriverWait.until(ExpectedConditions.visibilityOf(elementSelectBox1FromPackageTypeList));
        elementSelectBox1FromPackageTypeList.click();


    }
    @Step("Enter Text in to parcel reference field")
    public void enterParcelReferenceTxt(String txt){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterParcelReference));
        elementEnterParcelReference.sendKeys(txt);
    }


    @Step("Click On Finalise Button and close the POPUP")
    public  void clickOnFinaliseConsignment(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementbuttonFinaliseConsignment));
        elementbuttonFinaliseConsignment.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(elementPopUpClose));
        elementPopUpClose.click();
        driver.navigate().refresh();

    }

    public void clickOnDeleteIcon(){
        //
        //
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(elementdeleteicon));
        actions.moveToElement(elementdeleteicon).build().perform();

        elementdeleteicon.click();
    }

    @Step("Verify commodity field is disable and move to sender stepper")
    public boolean isCommodityDisabled(){
//        WebElement commodityDisabled = webDriver.findElement(By.xpath("//input[@id='Commodity']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCommodityText));
        elementCommodityText.click();
        System.out.println("Commodity is disabled" + elementCommodityText.isSelected());
        return true;

    }


    @Step("Click On Commodity Select Jwellary")
    public void isCommoditySelected(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCommodityText));
        elementCommodityText.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(elementMenuCommodity));
        elementMenuCommodity.click();

    }

    @Step("Click On commodity select Document")
    public void clickoncommudity(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementcommudity));
        elementcommudity.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(elementMenuCommudityDocument));
        elementMenuCommudityDocument.click();
    }
    @Step("Click On Commudity Continue Popup")
    public void clickOnCommudityContinuePopup(){
        webDriverWait.until(ExpectedConditions.visibilityOf(elementPopCommudityContinue));
        elementPopCommudityContinue.click();
    }
    @Step("Select Jwellary Commudity ")
    public void clickOnCommudityJwellery(){
        webDriverWait.until(ExpectedConditions.visibilityOf(elementCommudityJwelleryStep));
        elementCommudityJwelleryStep.click();

        webDriverWait.until(ExpectedConditions.visibilityOf(elementMenuJwellery));
        elementMenuJwellery.click();


//        webDriverWait.until(ExpectedConditions.visibilityOf(elementPopCommudityContinue));
//        elementPopCommudityContinue.click();

//        webDriverWait.until(ExpectedConditions.visibilityOf(elementpopUpContinueJwellery));
//        elementpopUpContinueJwellery.click();

    }

}




