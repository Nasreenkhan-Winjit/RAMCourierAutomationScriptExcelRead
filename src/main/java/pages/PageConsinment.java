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
//    @FindBy(how = How.XPATH, using = "//div[@class='v-select__selections']/div[contains(text(),'General')]")
    @FindBy(how = How.XPATH, using = "//input[@id='Commodity']//..")
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
    @FindBy(how =How.XPATH,using = "//div[@class='v-menu__content theme--light menuable__content__active']//div[@role='listitem'][1]")
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

    @FindBy(how = How.CSS, using = "  #SearchAutocomplete_Sender")
    private WebElement elementCreateNewSenderTxt;

    @CacheLookup
//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'CELL C - COMPANY OWNED STORES, CELL C, 084 174 4000')]")
//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'ASUREN NAIDOO, I1149777, 000 000 0000')]")
//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'CELLSURE (PTY) LTD, 000 000 0000')]")
//    @FindBy(how = How.XPATH, using = "//div[contains(text(),'SURE WENHOLD - 074 460 7090')]")
    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active v-autocomplete__content']//div[@role='listitem'] [1]")
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
    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active v-autocomplete__content']//div[@role='listitem'][1]")
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
//    @FindBy(how= How.XPATH, using = "//div[@id='stepRequirements']")
    @FindBy(how= How.CSS, using = "#stepRequirements")
    private WebElement elementRequirements;

    @CacheLookup
    @FindBy(how= How.XPATH, using = "//input[@id='ShipperReference']")
    private WebElement elementtxtShipperReference;

    @CacheLookup
//    @FindBy(how=How.XPATH, using = "//div[@class='flex xs12 md12']//div[@class='v-select__selections']")
    @FindBy(how=How.XPATH, using = "//input[@id='ProofOfDelivery']//..")
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

    @FindBy(how = How.XPATH, using = "//div[text()='Inbound - Domestic']")
    private  WebElement elementSelectInbondFromLogisticList;

    @FindBy(how= How.XPATH, using = "//button[@id='AdvanceSearch_Sender']//div")
    private WebElement elementClickOnAdvancedSearchButton;


    @FindBy(how= How.XPATH, using = "//input[@id='CustomerName_Sender']")
    private WebElement elementEnterCustomerSenderName;


    @FindBy(how= How.XPATH, using = "//button[@id='Search_Sender']//div")
    private WebElement clickOnSearchButton;


    @FindBy(how= How.XPATH, using = "//button[@id='SenderResetSearch']//div")
    private WebElement clickOnResetButton;

   @FindBy(how= How.XPATH, using = "//button[@id='CreateNew_Sender']//div")
    private WebElement clickOnCreateNewSenderButton;

   @FindBy(how= How.XPATH, using = "//button[@id='CreateNew_Receiver']//div")
    private WebElement clickOnCreateNewSenderButtonRcv;


   @FindBy(how= How.XPATH, using = "//input[@id='NewSenderType']//..")
    private WebElement ClickOnSenderTypeField;

   @FindBy(how= How.XPATH, using = "//div[contains(text(),'Individual')]")
    private WebElement selectSenderTypeIndividual;

   @FindBy(how= How.XPATH, using = "//div[contains(text(),'New Sender Address')]")
    private WebElement clickOnNewSenderAddressStepper;

   @FindBy(how= How.XPATH, using = "//input[@id='Individual_FirstName']")
    private WebElement EnterTxtOnIndividualsFirstName;

   @FindBy(how= How.XPATH, using = "//input[@id='Individual_LastName']")
    private WebElement EnterTxtOnIndividualsLastName;

   @FindBy(how= How.XPATH, using = "//input[@id='CustomerReference']")
    private WebElement EnterTxtOnIndividualsYourReference;

   @FindBy(how= How.XPATH, using = "//input[@id='NewAddressGroup_COA']//..")
    private WebElement elementSelectDestinationGrp;

   @FindBy(how= How.XPATH, using = "//input[@id='NewAddressType_COA']//..")
    private WebElement elementSelectDestinationType;


   @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active']//div[contains(text(),'Home')]")
    private WebElement elementSelectDestinationTypeHome;

   @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active']//div[contains(text(),'Home')]")
    private WebElement elementSelectDestinationGrpHome;

   @FindBy(how= How.XPATH, using = "//input[@id='SearchDeliveryAddress_COA']")
    private WebElement elementEnterDeliveryAddress;


   @FindBy(how= How.XPATH, using = "//span[contains(text(),'27 Wrench Road, Isando, Kempton Park, South Africa')]")
    private WebElement elementSelectDeliveryAddress;

  @FindBy(how= How.XPATH, using = "//div[contains(text(),'New Sender Contact')]")
    private WebElement elementCLickOnNewSenderContact;

  @FindBy(how= How.XPATH, using = "//input[@id='NewPrimaryNumberType']//..")
    private WebElement elementCLickOnNewPrimaryNumberType;

  @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active']//div[contains(text(),'Mobile')]")
    private WebElement elementSelectNewPrimaryNumberType;

  @FindBy(how= How.XPATH, using = "//input[@id='NewPrimaryContact']")
    private WebElement elementEnterPrimaryNumber;

  @FindBy(how= How.XPATH, using = "//input[@id='NewEmailAddress']")
    private WebElement elementEnterEmailAddress;

  @FindBy(how= How.XPATH, using = "//button[@id='NewSubmitCustomer']")
    private WebElement elementClickOnSubmitButton;

  @FindBy(how= How.XPATH, using = "//input[@id='NewReceiverType']//..")
    private WebElement elementCLickOnNewReceiverType;


  @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active']//div[contains(text(),'Corporate - Business')]")
    private WebElement elementSelectCorporateBusinessFromMenu;

  @FindBy(how= How.XPATH, using = "//input[@id='Business_GroupName']")
    private WebElement elementEnterBusinessGroupName;

  @FindBy(how= How.XPATH, using = "//div[contains(text(),'RAM Hand to Hand Couriers')]")
    private WebElement elementSelectBusinessGroupName;

  @FindBy(how= How.XPATH, using = "//input[@id='Business_Name']")
    private WebElement elementEnterBusinessName;

//  @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active v-autocomplete__content']//div[contains(text(),'RAM Business Office')]")
  @FindBy(how= How.XPATH, using = "//span[contains(text(),'RAM Business Office')]")
    private WebElement elementSelectBusinessName;

  @FindBy(how= How.XPATH, using = "//div[contains(text(),'New Receiver Contact')]")
    private WebElement elementClickOnNewReceiverContact;

 @FindBy(how= How.XPATH, using = "//input[@id='NewContactType']//..")
    private WebElement elementClickOnNewContactDetailsType;


 @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active']//div[contains(text(),'Unknown Contact')]")
    private WebElement elementSelectUnknownContactType;


  @FindBy(how= How.XPATH, using = "//input[@id='NewPrimaryNumberType']//..")
    private WebElement elementClickOnNumberType;


  @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active']//div[contains(text(),'Mobile')]")
    private WebElement elementSelectNumberTypeMobile;

  @FindBy(how= How.XPATH, using = "//button[@id='AddGoodsDescription']//div")
    private WebElement elementClickOnADDGDButton;

//  @FindBy(how= How.XPATH, using = "//input[@id='Field1_D_8c180d28-cfd8-443d-80a3-0ac4ab3c827f']")
  @FindBy(how= How.XPATH, using = "//input[@placeholder='Enter IMEI']")
    private WebElement elementEnterIMEINumber;

//  @FindBy(how= How.XPATH, using = "//input[@id='Field2_D_8c180d28-cfd8-443d-80a3-0ac4ab3c827f']")
  @FindBy(how= How.XPATH, using = "//input[@placeholder='Enter Description']")
    private WebElement elementEnterDescriptionAtGD;


  @FindBy(how= How.XPATH, using = "//input[@id='ContentType_O_2ac9f86e-9499-4d08-b439-b2e8283e1ad2']//..")
    private WebElement elementClickOnContentType;

  @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active']//div[contains(text(),'ICCID')]")
    private WebElement elementSelectContentTypeICCID;


  @FindBy(how= How.XPATH, using = "//input[@id='Field1_O_2ac9f86e-9499-4d08-b439-b2e8283e1ad2']")
    private WebElement elementEnterICCIDNumber;

  @FindBy(how= How.XPATH, using = "//input[@id='Field2_O_2ac9f86e-9499-4d08-b439-b2e8283e1ad2']")
    private WebElement elementEnterDescriptionICCID;


  @FindBy(how= How.XPATH, using = "//button[@id='saveEmailConsignment']//div")
    private WebElement elementClickOnEmailAndSavebutton;


 @FindBy(how= How.XPATH, using = "//input[@placeholder='Email Waybill To']")
    private WebElement elementEnterEmailWaybillTo;


 @FindBy(how= How.XPATH, using = "//button[@id='save_emailcomposer']")
    private WebElement elementClickOnSave;

 @FindBy(how= How.XPATH, using = "//div[contains(text(),'Retail')]")
    private WebElement elementSelectRetailFromSenderType;


  @FindBy(how= How.XPATH, using = "//input[@id='Retail_ChainName']")
    private WebElement elementEnterRetailChainName;



  @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active v-autocomplete__content']//div[@role='listitem'][1]")
    private WebElement elementSelectRetailChainName;

    @FindBy(how= How.XPATH, using = "//input[@id='Retail_StoreName']")
    private WebElement elementEnterRetailStoreName;

  @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active v-autocomplete__content']//div[@role='listitem'][1]")
    private WebElement elementSelectRetailStoreName;

  @FindBy(how= How.XPATH, using = "//div[contains(text(),'New Sender Contact')]")
    private WebElement elementClickOnNewSenderContactStepper;


  @FindBy(how= How.XPATH, using = "//div[contains(text(),'Specific Contact Person')]")
    private WebElement elementSelectSpecificContactPerson;

  @FindBy(how= How.XPATH, using = "//input[@id='CustomerContactFirstName']")
    private WebElement elementContactFirstName;

  @FindBy(how= How.XPATH, using = "//input[@id='CustomerContactLastName']")
    private WebElement elementContactLastName;


  @FindBy(how= How.XPATH, using = "//button[@id='ReceiverResetSearch']//div")
    private WebElement ReceiverResetButton;

  @FindBy(how= How.XPATH, using = "//button[@id='ReceiverNewContact']//div")
    private WebElement elementClickOnReceiversNewContact;


   @FindBy(how= How.XPATH, using = "//input[@id='firstname_receivercontactaddedit']")
    private WebElement elementEnterReceiversNewContactFirstName;

   @FindBy(how= How.XPATH, using = "//input[@id='lastname_receivercontactaddedit']")
    private WebElement elementEnterReceiversNewContactLastName;

   @FindBy(how= How.XPATH, using = "//input[@id='primarytelephonenumber_receivercontactaddedit']")
    private WebElement elementEnterReceiversNewContactPrimaryTelNum;

   @FindBy(how= How.XPATH, using = "//input[@id='emailaddress_receivercontactaddedit']")
    private WebElement elementEnterReceiversNewContactEmailAdd;

  @FindBy(how= How.XPATH, using = "//button[@id='save_receivercontactaddedit']")
    private WebElement elementClickOnSaveButtonOnNewContactPage;

  @FindBy(how= How.XPATH, using = "//input[@placeholder='Select Standard Instruction Type']//..")
    private WebElement elementClickOnSIT;

 @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active']//div[contains(text(),'Future Delivery Date')]")
    private WebElement elementClickOnSITWithFD;

 @FindBy(how= How.XPATH, using = "//input[@id='FutureDate']//..")
    private WebElement elementSelectFutureDate;

 @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active v-autocomplete__content']//div[@role='listitem'][2]")
    private WebElement elementSelectFutureDatefromMenu;


  @FindBy(how= How.XPATH, using = "//button[@id='AddAnotherInstruction']//div")
    private WebElement clickOnAddAnotherInstruction;

  @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active']//div[contains(text(),'Don’t Deliver On')]")
    private WebElement clickOnDontDeleiverOn;


  @FindBy(how= How.XPATH, using = "//input[@placeholder='Select Non-Deliverable Days']//..")
    private WebElement clickOnNonDeliveryDaysField;

  @FindBy(how= How.XPATH, using = "//div[@class='v-menu__content theme--light menuable__content__active']//div[@role='listitem'][3]")
    private WebElement elementSelectNonDeliveryDay;

  @FindBy(how= How.XPATH, using = "//input[@id='SpecialInstruction']")
    private WebElement elementEnterSpecialInstruction;

  @FindBy(how= How.XPATH, using = "//button[@id='FinaliseConsignment']//div")
    private WebElement elementCLickOnSaveButton;


//  @FindBy(how = How.XPATH, using = "//div[@class='v-menu v-menu--inline']//div//button[@id='no-background-hover']")
//  @FindBy(how = How.XPATH, using = "//div[@class='v-menu v-menu--inline']")
    @CacheLookup
//  @FindBy(how = How.CSS, using = "div.application.theme--light:nth-child(2) div.application--wrap:nth-child(65) div.app-horizontal-layout:nth-child(1) nav.Vuely-toolbar.v-toolbar.v-toolbar--dense.v-toolbar--extended.v-toolbar--fixed.theme--light.light div.v-toolbar__content div.container:nth-child(1) div.layout.row div.flex.xs3.md3:nth-child(4) div.d-custom-flex.align-items-center.navbar-left div.d-custom-flex.align-items-center.navbar-left:nth-child(1) div:nth-child(1) div.v-menu.v-menu--inline div.v-menu__activator button.v-btn.v-btn--icon.theme--light > div.v-btn__content")
  @FindBy(how = How.XPATH, using = "//div[@class='flex xs3 md3']//div[@class='v-menu v-menu--inline']")
    private WebElement elementClickONSettingsICON;

  @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active language-dropdown']//div[@role='listitem']")
    private WebElement elementClickONPrinterSetup;


  @FindBy(how = How.XPATH, using = "//body/div[@id='inspire']/div[@class='v-dialog__content v-dialog__content--active']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/div[1]")
    private WebElement elementClickONPrinterSetupButton;

 @FindBy(how = How.XPATH, using = "//input[@placeholder='Type to search company']")
    private WebElement elementEnterTxtOnCompany;

 @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active v-autocomplete__content']//div[@role='listitem'][1]")
    private WebElement elementSelectFromPrinterMenu;

 @FindBy(how = How.XPATH, using = "//input[@placeholder='Type to search printer']")
    private WebElement elementEnterTxtInSearchPrinter;

 @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active v-autocomplete__content']//div[@role='listitem'][1]")
    private WebElement elementSelectFromPrinterList;

 @FindBy(how = How.XPATH, using = "//div[contains(text(),'Save')]")
    private WebElement elementClickOnSaveButton;

// @FindBy(how = How.XPATH, using = "//div[@class='v-dialog__content v-dialog__content--active']")
 @FindBy(how = How.XPATH, using = "//body/div[@id='inspire']/div[@class='v-dialog__content v-dialog__content--active']/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/button[1]/div[1]/i[1]")
    private WebElement elementClickOnConsignAppWindow;

 @FindBy(how = How.XPATH, using = "//input[@id='Hub']")
    private WebElement elementEnterHub;



 @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active v-autocomplete__content']//div[@role='listitem'][1]")
    private WebElement elementSelectISAHubFromList;

    @FindBy(how = How.XPATH, using = "//input[@id='Department']")
    private WebElement elementEnterDepartment;

    @FindBy(how = How.XPATH, using = "//div[@class='v-menu__content theme--light v-menu__content--fixed menuable__content__active v-autocomplete__content']//div[@role='listitem'][1]")
    private WebElement elementSelectITDepartmentFrom;










    @Step(" Click on Settings icon and select printer ")
    public void clickOnSettingsIcon() throws InterruptedException {
        System.out.println(elementClickONSettingsICON.isDisplayed());
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickONSettingsICON));
        actions.moveToElement(elementClickONSettingsICON).perform();


        elementClickONSettingsICON.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickONPrinterSetup));
        elementClickONPrinterSetup.click();


    }
    @Step("Click on PrinterSetup button")
     public void clickOnPrinterSetupButton(){


        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickONPrinterSetupButton));
        elementClickONPrinterSetupButton.click();
    }

    @Step("Enter Hub/Office Name and select from list")
     public void EnterHubIDAndSelectFromList(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterHub));
        elementEnterHub.sendKeys(txt);
        Thread.sleep(2000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectISAHubFromList));
        elementSelectISAHubFromList.click();
    }

    @Step("Enter Department Name and select from list")
     public void EnterDepartmentAndSelectFromList(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterDepartment));
        elementEnterDepartment.sendKeys(txt);
        Thread.sleep(2000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectITDepartmentFrom));
        elementSelectITDepartmentFrom.click();

    }


    @Step("Enter txt in Company name")
     public void enterTxtOnCompanyName(String txt){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtOnCompany));
        elementEnterTxtOnCompany.sendKeys(txt);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectFromPrinterMenu));
        elementSelectFromPrinterMenu.click();


    }
    @Step("Enter txt in printer ID in printer search field ")
     public void enterTxtPrinterID(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterTxtInSearchPrinter));
        elementEnterTxtInSearchPrinter.sendKeys(txt);
        Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectFromPrinterList));
        elementSelectFromPrinterList.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnSaveButton));
        elementClickOnSaveButton.click();
        Thread.sleep(2000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnConsignAppWindow));
        elementClickOnConsignAppWindow.click();
        Thread.sleep(3000);

    }




    @Step(" Click on Standard INstruction Type and Select Do not deliver on date ")
    public void clickOnSaveButton() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnSaveButton));
        elementCLickOnSaveButton.click();
    }

    @Step(" Click on Standard INstruction Type and Select Do not deliver on date ")
    public void enterSpecialInstructions(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterSpecialInstruction));
        elementEnterSpecialInstruction.click();
        elementEnterSpecialInstruction.sendKeys(txt);
    }

    @Step(" Select Do nott deliverr days ")
    public void clickOnNonDeliverDaysFieldAndSelectDay() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(clickOnNonDeliveryDaysField));
        clickOnNonDeliveryDaysField.click();

         webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectNonDeliveryDay));
        elementSelectNonDeliveryDay.click();


    }

    @Step(" Click on Standard INstruction Type and Select Do not deliver on date ")
    public void clickOnSITAndSelectDONOTDeliver() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnSIT));
        elementClickOnSIT.click();

         webDriverWait.until(ExpectedConditions.elementToBeClickable(clickOnDontDeleiverOn));
        clickOnDontDeleiverOn.click();


    }


    @Step(" Click on Add Anoother Instruction ")
    public void clickOnAddAnotherInstructionButton() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(clickOnAddAnotherInstruction));
        clickOnAddAnotherInstruction.click();

    }

    @Step(" Click on Standard Instruction type and select Future Delivery")
    public void clickOnStandardInstructionTypeAndSelectFD() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnSIT));
        elementClickOnSIT.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnSITWithFD));
        elementClickOnSITWithFD.click();
    }

    @Step(" Click on Standard Instruction type and select Future Date")
    public void selectFutureDateFromMenu() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectFutureDate));
        elementSelectFutureDate.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectFutureDatefromMenu));
        elementSelectFutureDatefromMenu.click();

    }

    @Step(" Enter Receiver's New Contact Email Address")
    public void enterRcvSaveButtonAtNewContact() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnSaveButtonOnNewContactPage));
        elementClickOnSaveButtonOnNewContactPage.click();
    }

    @Step(" Enter Receiver's New Contact Email Address")
    public void enterRcvNewContactEmailAddress(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterReceiversNewContactEmailAdd));
        elementEnterReceiversNewContactEmailAdd.sendKeys(txt);
    }

    @Step(" Enter Receiver's New Contact Primary telephone number")
    public void enterRcvNewContactPrimaryTelNumber(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterReceiversNewContactPrimaryTelNum));
        elementEnterReceiversNewContactPrimaryTelNum.sendKeys(txt);
    }


    @Step(" Enter Receiver's New Contact Last name")
    public void enterRcvNewContactLastName(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterReceiversNewContactLastName));
        elementEnterReceiversNewContactLastName.sendKeys(txt);

    }
    @Step(" Enter Receiver's New Contact first name")
    public void enterRcvNewContactFirstName(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterReceiversNewContactFirstName));
        elementEnterReceiversNewContactFirstName.sendKeys(txt);

    }

    @Step(" Click on Receiver's New Contact button")
    public void clickOnReceiverNewContactButton() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnReceiversNewContact));
        elementClickOnReceiversNewContact.click();

    }
    @Step(" Click on Receiver reset button")
    public void clickOnReceiverResetButton() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(ReceiverResetButton));
        ReceiverResetButton.click();

    }

    @Step(" Enter First Name in New sender contact ")
    public void enterNewSenderContactFirstName(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementContactFirstName));
        elementContactFirstName.sendKeys(txt);

    }

    @Step(" Enter Last Name in new sender contact ")
    public void enterNewSenderContactLastName(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementContactLastName));
        elementContactLastName.sendKeys(txt);

    }

    @Step(" Enter Retail Store name ")
    public void clickOnNewSenderContactStepper() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnNewSenderContactStepper));
        elementClickOnNewSenderContactStepper.click();


    }
        @Step(" Enter Retail Store name ")
    public void enterRetailStoreName(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterRetailStoreName));
        elementEnterRetailStoreName.sendKeys(txt);
        Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectRetailChainName));
        elementSelectRetailStoreName.click();

    }


    @Step(" Enter Retail chain name ")
    public void enterRetailChainName(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterRetailChainName));
        elementEnterRetailChainName.sendKeys(txt);
        Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectRetailChainName));
        elementSelectRetailChainName.click();

    }

        @Step(" Select New sender type as retail")
    public void clickOnNewSenderTypeAndSelectRetail() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(ClickOnSenderTypeField));
        ClickOnSenderTypeField.click();


        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectRetailFromSenderType));
        elementSelectRetailFromSenderType.click();

    }
    @Step(" Click on Email and save button")
    public void updateEmailAddress(String txt) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterEmailWaybillTo));
        elementEnterEmailWaybillTo.sendKeys(Keys.CONTROL+"a");
        elementEnterEmailWaybillTo.sendKeys(Keys.DELETE);

        elementEnterEmailWaybillTo.sendKeys(txt);


        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnSave));
        elementClickOnSave.click();
    }

    @Step(" Click on Email and save button")
    public void clickOnEmailAndSaveButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnEmailAndSavebutton));
        elementClickOnEmailAndSavebutton.click();

    }

    @Step(" Enter Description ICCID Number")
    public void enterDescriptionICCIDNumber(String txt) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterDescriptionICCID));
        elementEnterDescriptionICCID.sendKeys(txt);

    }

    @Step("Enter ICCID Number")
    public void enterICCIDNumber(String txt) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterICCIDNumber));
        elementEnterICCIDNumber.sendKeys(txt);

    }


@Step("Click on Content Type and select ICCID")
    public void clickOnContentTypeFieldAndSelectICCID() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnContentType));
        elementClickOnContentType.click();


        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectContentTypeICCID));
        elementSelectContentTypeICCID.click();


    }

    @Step("Enter IMEI Number ")
    public void enterIMEINumber(String txt) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterIMEINumber));
        elementEnterIMEINumber.sendKeys(txt);
    }

    @Step("Enter Goods Description   ")
    public void enterDescription(String txt) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterDescriptionAtGD));
        elementEnterDescriptionAtGD.sendKeys(txt);

    }
    @Step("Click on ADD Goods Description Button  ")
    public void clickOnAddGDButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnADDGDButton));
        elementClickOnADDGDButton.click();

    }



    @Step("Click on Number type and select mobile")
    public void selectNewNumberTypeAsMobile() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnNumberType));
        elementClickOnNumberType.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectNumberTypeMobile));
        elementSelectNumberTypeMobile.click();

    }

    @Step("Click on Contact Details Type")
    public void clickOnContactDetailsType() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnNewContactDetailsType));
        elementClickOnNewContactDetailsType.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectUnknownContactType));
        elementSelectUnknownContactType.click();

    }

    @Step("Click on Contact Details Type And Select Specific contact person")
    public void clickOnContactDetailsTypeAndSPC() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnNewContactDetailsType));
        elementClickOnNewContactDetailsType.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectSpecificContactPerson));
        elementSelectSpecificContactPerson.click();

    }

    @Step("Click on New Receiver Contact  ")
    public void clickOnNewReceiverContactStepper() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnNewReceiverContact));
        elementClickOnNewReceiverContact.click();

    }


        @Step("Enter Existing  Business  Name ")
    public void enterBusinessName(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterBusinessName));
        elementEnterBusinessName.sendKeys(txt);
        Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectBusinessName));
        elementSelectBusinessName.click();

    }

        @Step("Enter Business group name ")
    public void enterNewBusinessGroup(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterBusinessGroupName));
        elementEnterBusinessGroupName.sendKeys(txt);
            Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectBusinessGroupName));
        elementSelectBusinessGroupName.click();
    }

    @Step("Select corporate business from menu ")
    public void selectCorporateBusinessFromMenuAtNewRcv() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectCorporateBusinessFromMenu));
        elementSelectCorporateBusinessFromMenu.click();

    }

    @Step("CLick on New Receiver type field")
    public void clickOnNewReceiverType() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnNewReceiverType));
        elementCLickOnNewReceiverType.click();

    }

    @Step("CLick on New sender number type and enter the number")
    public void clickOnNewSubmitButton() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnSubmitButton));
        elementClickOnSubmitButton.click();

    }
    @Step("CLick on New sender number type and enter the number")
    public void clickOnNewPrimaryNummberType() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnNewPrimaryNumberType));
        elementCLickOnNewPrimaryNumberType.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectNewPrimaryNumberType));
        elementSelectNewPrimaryNumberType.click();

    }


    @Step("Enter new primary number")
    public void enterNewPrimaryNumber(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterPrimaryNumber));
        elementEnterPrimaryNumber.sendKeys(txt);

    }
    @Step("Enter new email address")
    public void enterNewEmailAddress(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterEmailAddress));
        elementEnterEmailAddress.sendKeys(txt);

    }
    @Step("CLick on New sender contact stepper")
    public void clickOnNewSenderContact() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCLickOnNewSenderContact));
        elementCLickOnNewSenderContact.click();

    }
        @Step("Enter Delivery address and select from list")
    public void enterSerachDeliverytxtAndSelectFrmList(String txt) throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterDeliveryAddress));
        elementEnterDeliveryAddress.sendKeys(txt);
        Thread.sleep(10000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectDeliveryAddress));
        elementSelectDeliveryAddress.click();

    }
    @Step("Select Home ass Destination group")
    public void selectHomeDestinationGrp() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectDestinationGrp));
        elementSelectDestinationGrp.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectDestinationGrpHome));
        elementSelectDestinationGrpHome.click();

    }

    @Step("Select Destination type home")
    public void selectDestinationTypeHome() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectDestinationType));
        elementSelectDestinationType.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectDestinationTypeHome));
        elementSelectDestinationTypeHome.click();

    }


    @Step("Enter the the individuals first name and last name")
    public void enterIndividualsFirstName(String txt) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(EnterTxtOnIndividualsFirstName));
        EnterTxtOnIndividualsFirstName.sendKeys(txt);

    }

    @Step("Enter the the individuals last name")
    public void enterIndividualsLastName(String txt) {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(EnterTxtOnIndividualsLastName));
        EnterTxtOnIndividualsLastName.sendKeys(txt);
    }

    @Step("Enter the the individuals your refrence")
    public void enterIndividualsYourReference(String txt) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(EnterTxtOnIndividualsYourReference));
        EnterTxtOnIndividualsYourReference.sendKeys(txt);

    }

 @Step("Click on New Sender Stepper and verify the validation is displayed for Individual's First and Last Name field")
 public void clickOnNewSenderStepperInCreateNewSender(){
     webDriverWait.until(ExpectedConditions.elementToBeClickable(clickOnNewSenderAddressStepper));
     clickOnNewSenderAddressStepper.click();
 }

    @Step("CLick on Sender type field")
    public void clickOnSenderTypeFieldAndSelectIndividual(){
    webDriverWait.until(ExpectedConditions.elementToBeClickable(ClickOnSenderTypeField));
        ClickOnSenderTypeField.click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectSenderTypeIndividual));
        selectSenderTypeIndividual.click();

    }

    @Step("CLick on create new Button")
    public void clickOnCreateNewSenderButton(String txt){

        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementCreateNewSenderTxt));

        elementCreateNewSenderTxt.sendKeys(txt);

    webDriverWait.until(ExpectedConditions.elementToBeClickable(clickOnCreateNewSenderButton));
        clickOnCreateNewSenderButton.click();
    }

    @Step("CLick on create new Button")
    public void clickOnCreateNewSenderButtonInRcvStepper(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(clickOnCreateNewSenderButtonRcv));
        clickOnCreateNewSenderButtonRcv.click();
    }


    @Step("CLick on search button")
    public void clickOnSearchButton(){
    webDriverWait.until(ExpectedConditions.elementToBeClickable(clickOnSearchButton));
        clickOnSearchButton.click();
    }
    @Step("CLick on reset button")
    public void clickOnResetButton(){
    webDriverWait.until(ExpectedConditions.elementToBeClickable(clickOnResetButton));
        clickOnResetButton.click();
    }

    @Step("Enter  characters in customer sender name")
    public void enterSenderCustomerName(String txt, Keys keys){
    webDriverWait.until(ExpectedConditions.elementToBeClickable(elementEnterCustomerSenderName));
        elementEnterCustomerSenderName.sendKeys(txt, keys);
    }

    @Step("Click on Advanced search button")
    public void clickOnAdvancedSearchButton(){
    webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnAdvancedSearchButton));
        elementClickOnAdvancedSearchButton.click();
    }
    @Step("Verify the Advanced Search window is displayed")
    public void verifyAdvancedSearchWindow(){
        WebElement advancedSearch = webDriver.findElement(By.xpath("//div[@id='autocompleteSearchSender']"));
        System.out.println("Advanced Search Window"+ advancedSearch.isDisplayed());

    }


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
    @Step("Click on Logistic Type and select Inbound")
    public void clickOnLogisticTypeAndSelectInbound() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementClickOnLogisticType));
        elementClickOnLogisticType.click();

        Thread.sleep(2000);

        elementSelectInbondFromLogisticList.click();
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
//        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(elemnentFieldSenderName));

            elemnentFieldSenderName.sendKeys(txt);
            webDriverWait.until(ExpectedConditions.visibilityOf(elemnentFieldSenderName));
            elemnentFieldSenderName.click();

//        } catch (StaleElementReferenceException e) {
//
//        }
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

    @Step("Click on POD field and select from list ")
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
    @Step("Verify Rica is selected or not")
    public boolean verifyRICA(){
//
//     WebElement Rica = webDriver.findElement(By.xpath("//div[contains(text(),'RICA')]")) ;


            WebElement Rica = webDriver.findElement(By.xpath("//button[@id='RICA']")) ;
            System.out.println("Rica is selected"+ Rica.isEnabled());
            return Rica.isEnabled();
        }

//        List<WebElement> Rica = webDriver.findElement(By.xpath("//button[@id='RICA']")) ;//
//       return Rica.size();
//        List<WebElement> rica = webDriver.findElements(By.xpath("//button[@id='RICA']"));
//        return rica.size();


    @Step("Verify IMEI Field is Present")
    public boolean verifyIMEIFieldIsPresent() {
        try {
            WebElement IMEIField = webDriver.findElement(By.xpath("//input[@id='Field1_D_8c180d28-cfd8-443d-80a3-0ac4ab3c827f']"));
            System.out.println("IMEI field is present" + IMEIField.isEnabled());
            return IMEIField.isEnabled();

        } catch (Exception e) {
            return false;

        }
    }
    @Step("Verify the Rica is not present")
    public boolean verifyRicaIsNotPresent() {
        try {
            WebElement Rica = webDriver.findElement(By.xpath("//button[@id='RICA']"));
            System.out.println("Rica is not present" + Rica.isDisplayed());
            return Rica.isDisplayed();

        } catch (Exception e) {
            return false;
        }
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

    @Step("Verify the parcel header is displayed")
    public int verifyParcelHeaderIsDisplayed(){
//       List<WebElement> parcelHeader = (List<WebElement>) webDriver.findElement(By.xpath("//div[@class='parcelHeader']"));
////        System.out.println("Parcel header is displayed"+ parcelHeader.isDisplayed() );
//        return parcelHeader.Size();


        List<WebElement> parcelHeader = webDriver.findElements(By.xpath("//div[@class='parcelHeader']"));
        return parcelHeader.size();

    }
    @Step("verify the Security pack error is displayed")
    public boolean verifySecurityPack(){
        WebElement SP = webDriver .findElement(By.xpath("//div[contains(text(),'Security pack is required')]"));
        System.out.println("Security pack is required"+  SP.isDisplayed());
        return SP.isDisplayed();

    }
    @Step("verify the Security pack error is displayed")
    public boolean verifyWeightErrorIsDisplayed(){
        WebElement Weight = webDriver .findElement(By.xpath("//div[contains(text(),'Weight must be between 0.01 and 1200')]"));
        System.out.println("Security pack is required"+  Weight.isDisplayed());
        return Weight.isDisplayed();

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

//    @Step("Enter the parcel package type details")
//    public void parcelTypeCondition(String txt){
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementNumberOfParcel));
//        elementNumberOfParcel.sendKeys(txt, Keys.ENTER);
//        switch (entertxtNumberOfParcel){
//
//        }
//    }

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
    public  void clickOnFinaliseConsignment1(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementbuttonFinaliseConsignment));
        elementbuttonFinaliseConsignment.click();
//        webDriverWait.until(ExpectedConditions.visibilityOf(elementPopUpClose));
//        elementPopUpClose.click();
//        driver.navigate().refresh();

    }

    @Step("Click On Finalise Button and close the POPUP")
    public  void clickOnFinaliseConsignment(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementbuttonFinaliseConsignment));
        elementbuttonFinaliseConsignment.click();
//        webDriverWait.until(ExpectedConditions.visibilityOf(elementPopUpClose));
//        elementPopUpClose.click();
//        driver.navigate().refresh();

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




