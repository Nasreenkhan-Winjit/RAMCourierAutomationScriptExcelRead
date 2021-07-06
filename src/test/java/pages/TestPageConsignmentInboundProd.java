package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.commonmodule.Loader;

import java.util.ArrayList;
import java.util.Map;

public class TestPageConsignmentInboundProd extends TestBase{

    PageDashBoard pageDashBoard;
    PageConsinment pageConsignment;
    Loader loader;

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify valid user are allowed to access")

    @Test
    public void clickOnConsignment() throws InterruptedException {
        Thread.sleep(30000);
//     loader.waitForLoaderToDispose();
        pageDashBoard = new PageDashBoard(eventFiringWebDriver);
        pageDashBoard.clickOnNavBar();

//        Thread.sleep(20000);
//        pageDashBoard.clickOnConsignViaAccordion();
//        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
//        eventFiringWebDriver.switchTo().window(tabsCount.get(1));
    }


    @Test
    public void clickOnAccordian() throws InterruptedException {
        Thread.sleep(21000);
////     loader.waitForLoaderToDispose();
//        pageDashBoard = new PageDashBoard(eventFiringWebDriver);
//        pageDashBoard.clickOnNavBar();

//            Thread.sleep(5000);
        pageDashBoard.clickOnConsignViaAccordion();
        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(1));
    }



    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentInbound1Prod")
//    @Test()
    public void consignmentInboundEmailAndSave(Map<String, String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(15000);

        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);

        Thread.sleep(15000);

        pageConsignment.enterTxtBilledTo(testDataSet.get("BilledTo"));
        Thread.sleep(8000);
        pageConsignment.selectMenuBilledTo();

        Thread.sleep(5000);
        if (pageConsignment.clickOnLogisticTypeFieldAndVerify() == 0) {

            pageConsignment.clickOnLogisticTypeAndSelectInbound() ;
            Thread.sleep(4000);

        } else {

            System.out.println("Logistic Type Field value is Present");
        }

        Thread.sleep(8000);
        //<editor-fold desc="Second Stepper">

        pageConsignment.clickOnSecondStepper();
        Thread.sleep(2000);
        pageConsignment.clickOnSenderName(testDataSet.get("NewSenderName"));
        pageConsignment.clickOnAdvancedSearchButton();
        pageConsignment.verifyAdvancedSearchWindow();
        pageConsignment.enterSenderCustomerName(testDataSet.get("InvalidSenderName"), Keys.TAB);
        pageConsignment.enterSenderCustomerName(testDataSet.get("SenderName"), Keys.TAB);

        pageConsignment.clickOnSearchButton();

//        pageConsignment.clickOnSenderName(testDataSet.get("SenderName"));
        Thread.sleep(3000);
        pageConsignment.SelectMenuSenderName();
        Thread.sleep(3000);

        pageConsignment.clickOnResetButton();
        Thread.sleep(3000);


        Thread.sleep(3000);
        pageConsignment.clickOnCreateNewSenderButton("NotTestTest");
        Thread.sleep(3000);
        pageConsignment.clickOnSenderTypeFieldAndSelectIndividual();
        Thread.sleep(3000);
        pageConsignment.clickOnNewSenderStepperInCreateNewSender();

        System.out.println("Validation message displayed" );

        pageConsignment.enterIndividualsFirstName(testDataSet.get("Individual First Name"));
        pageConsignment.enterIndividualsLastName(testDataSet.get("Individual Last Name"));
        pageConsignment.enterIndividualsYourReference(testDataSet.get("Individual Your Name"));

        pageConsignment.clickOnNewSenderStepperInCreateNewSender();

        pageConsignment.selectHomeDestinationGrp();
        Thread.sleep(2000);
        pageConsignment.selectDestinationTypeHome();

        pageConsignment.enterSerachDeliverytxtAndSelectFrmList(testDataSet.get("DeliveryAddress"));

        Thread.sleep(5000);
        pageConsignment.clickOnNewSenderContact();
        pageConsignment.clickOnNewPrimaryNummberType();

        pageConsignment.enterNewPrimaryNumber(testDataSet.get("PrimaryNumber"));
        pageConsignment.enterNewEmailAddress(testDataSet.get("NewEmailAddress"));
        pageConsignment.clickOnNewSubmitButton();
        Thread.sleep(30000);
        pageConsignment.clickOnStepReciever();
                                        //         commented due to issue for default receiver
        pageConsignment.clickOnReceiverResetButton();
        Thread.sleep(2000);
        pageConsignment.entertxtRecieverName(testDataSet.get("NewReceiverName"));
//        pageConsignment.entertxtRecieverNameProd();


//         commented due to issue for default receiver

        pageConsignment.clickOnCreateNewSenderButtonInRcvStepper();
        Thread.sleep(2000);
        pageConsignment.clickOnNewReceiverType();
        Thread.sleep(3000);
        pageConsignment.selectCorporateBusinessFromMenuAtNewRcv();
        Thread.sleep(3000);
        pageConsignment.enterNewBusinessGroupProd(testDataSet.get("NewBusinessGroupName"));
        Thread.sleep(15000);
        pageConsignment.enterBusinessNameProd(testDataSet.get("NewBusinessName"));
        Thread.sleep(20000);
        pageConsignment.clickOnNewReceiverContactStepper();
        pageConsignment.clickOnContactDetailsType();
        pageConsignment.selectNewNumberTypeAsMobile();
        pageConsignment.enterNewPrimaryNumber(testDataSet.get("PrimaryNumber"));
        pageConsignment.enterNewEmailAddress(testDataSet.get("NewEmailAddress"));
        pageConsignment.clickOnNewSubmitButton();
        Thread.sleep(20000);
        Thread.sleep(5000);

        pageConsignment.clickOnStepValue();
        // Thread.sleep(10000);

        pageConsignment.entertxtStepValue("212");
        pageConsignment.clickOnStepRequirement();

        if(!pageConsignment.verifyIMEIFieldIsPresent()){

            pageConsignment.enterIMEINumber("987545555555555");
            pageConsignment.enterDescription(testDataSet.get("Description"));

        }
        else{
            pageConsignment.clickOnAddGDButton();
            pageConsignment.clickOnContentTypeFieldAndSelectICCID();
            pageConsignment.enterICCIDNumber(testDataSet.get("ICCIDNumber"));
            pageConsignment.enterDescriptionICCIDNumber(testDataSet.get("Description"));
        }


        pageConsignment.entertxtShipperReference(testDataSet.get("InvalidShipperReference"));


        pageConsignment.entertxtShipperReference(testDataSet.get("ValidShipperReference"));
        Thread.sleep(5000);
        pageConsignment.clickOnDropdownProofOfDeliveryInbound(Keys.TAB);
        Thread.sleep(5000);
        pageConsignment.clickonstepServices();


        //For RICA
        if (pageConsignment.verifyRicaIsNotPresent()) {
//

            if (!pageConsignment.verifyRICA()) {

                pageConsignment.selectServiceTypeAndSelectNextDay();
                pageConsignment.clickOnSAID();
                pageConsignment.enterTxtInSAIDField("1234567891234");

                pageConsignment.clickonStepParcel();




            }
//    if(pageConsignment.verifyRICA()){
            else {
                pageConsignment.selectServiceType();
                Thread.sleep(2000);
                pageConsignment.selectRICAOnSurcharge();
                Thread.sleep(2000);
                pageConsignment.clickOnSAID();
                pageConsignment.enterTxtInSAIDField("1234567891234");

                if (!pageConsignment.verifyFridgelineWindow()) {

                    pageConsignment.clickOnFridgeLineAndSelectHrs();
                } else {
                    pageConsignment.clickonStepParcel();
                }

            }


        } else {
            pageConsignment.selectServiceTypeAndSelectNextDay();
            pageConsignment.clickonStepParcel();
        }


        pageConsignment.entertxtNumberOfParcel(testDataSet.get("NumberOfParcel"));

        pageConsignment.clickOnEmailAndSaveButton();
        Thread.sleep(2000);

        //        Save code button is commented  due to in production  save is not allow

        pageConsignment.updateEmailAddress(testDataSet.get("UpdateEmailAddress"));

        Thread.sleep(20000);

        waitForPageLoad();
//        webDriver.navigate().refresh();


    }


    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentInbound2Prod")
//    @Test()
    public void consignmentInboundSave(Map<String, String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(30000);
        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);

        Thread.sleep(20000);

        pageConsignment.enterTxtBilledTo(testDataSet.get("BilledTo"));
        Thread.sleep(8000);
        pageConsignment.selectMenuBilledTo();

        Thread.sleep(8000);
        if (pageConsignment.clickOnLogisticTypeFieldAndVerify() == 0) {

            pageConsignment.clickOnLogisticTypeAndSelectInbound() ;
            Thread.sleep(4000);

        } else {

            System.out.println("Logistic Type Field value is Present");
        }

        Thread.sleep(4000);
        //<editor-fold desc="Second Stepper">

        pageConsignment.clickOnSecondStepper();
        Thread.sleep(2000);
        pageConsignment.clickOnCreateNewSenderButton(testDataSet.get("NewSenderName"));
        pageConsignment.clickOnNewSenderTypeAndSelectRetail();
        pageConsignment.enterRetailChainName(testDataSet.get("RetailChainName"));
        Thread.sleep(4000);
        pageConsignment.enterRetailStoreName(testDataSet.get("RetailStoreName"));
        Thread.sleep(20000);
        pageConsignment.clickOnNewSenderContactStepper();
        Thread.sleep(14000);
        pageConsignment.clickOnContactDetailsTypeAndSPC();
        pageConsignment.enterNewSenderContactFirstName(testDataSet.get("NewSenderContactFirstName"));
        pageConsignment.enterNewSenderContactLastName(testDataSet.get("NewSenderContactLastName"));
        pageConsignment.clickOnNewPrimaryNummberType();

        pageConsignment.enterNewPrimaryNumber(testDataSet.get("PrimaryNumber"));
        pageConsignment.enterNewEmailAddress(testDataSet.get("NewEmailAddress"));
        pageConsignment.clickOnNewSubmitButton();

        Thread.sleep(30000);

        pageConsignment.clickOnStepReciever();
        Thread.sleep(4000);
//        pageConsignment.entertxtRecieverName(testDataSet.get("NewReceiverName"));
//        pageConsignment.entertxtRecieverNameProd();

                                                // commented due to issue of default receiver


        pageConsignment.clickOnReceiverNewContactButton();

        pageConsignment.enterRcvNewContactFirstName(testDataSet.get("RcvNewContactFirstName"));

        pageConsignment.enterRcvNewContactLastName(testDataSet.get("RcvNewContactLastName"));
        pageConsignment.enterRcvNewContactPrimaryTelNumber(testDataSet.get("RcvNewContactPrimaryTelNumber"));
        pageConsignment.enterRcvNewContactEmailAddress(testDataSet.get("RcvNewContactEmailAddress"));

        pageConsignment.enterRcvSaveButtonAtNewContact();
        Thread.sleep(30000);
//        Thread.sleep(20000);
//        loader.waitForLoaderToDispose();
        pageConsignment.clickOnStepValue();
        pageConsignment.entertxtStepValue(testDataSet.get("ValueForCarrige"));

        pageConsignment.clickOnStepRequirement();

        if(!pageConsignment.verifyIMEIFieldIsPresent()){

            pageConsignment.enterIMEINumber("987545555555555");
            pageConsignment.enterDescription("Description test");

        }
        else{
            pageConsignment.clickOnAddGDButton();
            pageConsignment.clickOnContentTypeFieldAndSelectICCID();
            pageConsignment.enterICCIDNumber(testDataSet.get("ICCIDNumber"));
            pageConsignment.enterDescriptionICCIDNumber(testDataSet.get("Description"));
        }


        pageConsignment.entertxtShipperReference(testDataSet.get("InvalidShipperReference"));


        pageConsignment.entertxtShipperReference(testDataSet.get("ValidShipperReference"));
        Thread.sleep(5000);
        pageConsignment.clickOnDropdownProofOfDeliveryInbound(Keys.TAB);
        Thread.sleep(5000);

        pageConsignment.clickOnStandardInstructionTypeAndSelectFD();
        pageConsignment.selectFutureDateFromMenu();

//        pageConsignment.clickOnAddAnotherInstructionButton();
//
//        pageConsignment.clickOnSITAndSelectDONOTDeliver();
//        pageConsignment.clickOnNonDeliverDaysFieldAndSelectDay();
        pageConsignment.enterSpecialInstructions(testDataSet.get("SpecialInstruction"));
        System.out.println("Add Another Instruction button is disabled");
        pageConsignment.clickonstepServices();


        //For RICA
        if (pageConsignment.verifyRicaIsNotPresent()) {
//

            if (!pageConsignment.verifyRICA()) {

                pageConsignment.selectServiceTypeAndSelectNextDay();
                pageConsignment.clickOnSAID();
                pageConsignment.enterTxtInSAIDField("1234567891234");

                pageConsignment.clickonStepParcel();




            }
//    if(pageConsignment.verifyRICA()){
            else {
                pageConsignment.selectServiceType();
                Thread.sleep(2000);
                pageConsignment.selectRICAOnSurcharge();
                Thread.sleep(2000);
                pageConsignment.clickOnSAID();
                pageConsignment.enterTxtInSAIDField("1234567891234");

                if (!pageConsignment.verifyFridgelineWindow()) {

                    pageConsignment.clickOnFridgeLineAndSelectHrs();
                } else {
                    pageConsignment.clickonStepParcel();
                }

            }


        } else {
            pageConsignment.selectServiceTypeAndSelectNextDay();
            pageConsignment.clickonStepParcel();
        }


        pageConsignment.entertxtNumberOfParcel(testDataSet.get("NumberOfParcel"));

                                      //        Save code button is commented  due to for production  save is not allow

        pageConsignment.clickOnSaveButton();


        Thread.sleep(8000);



//            waitForLoad();
//            webDriver.navigate().refresh();

    }
}
