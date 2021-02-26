package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.commonmodule.Loader;

import java.util.*;

public class TestPageConsinment extends TestBase {

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
//        Thread.sleep(21000);
////     loader.waitForLoaderToDispose();
//        pageDashBoard = new PageDashBoard(eventFiringWebDriver);
//        pageDashBoard.clickOnNavBar();

        Thread.sleep(5000);
        pageDashBoard.clickOnConsignViaAccordion();
        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(1));
    }

    @Test
    public void verifyValueStepperIsNotPresentOnSelectionOfDoc() throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
//        Thread.sleep(8000);
        pageConsignment.clickOnConsignmentDropdown();
        Thread.sleep(9000);
        pageConsignment.enterTxtConsignmentID("UAT00010001", Keys.ENTER);
        Thread.sleep(10000);
        pageConsignment.enterTxtBilledTo("CELW01");
        Thread.sleep(5000);
        pageConsignment.selectMenuBilledTo();
        Thread.sleep(8000);
//
////        pageConsignment.clickOnLogisticTypeAndSelectOutbond();
        pageConsignment.isCommoditySelected();
        pageConsignment.clickoncommudity();
        pageConsignment.clickOnCommudityContinuePopup();
        Thread.sleep(5000);
        pageConsignment.clickOnCommudityJwellery();
        pageConsignment.clickOnCommudityContinuePopup();
        Thread.sleep(7000);
//        waitForLoad();
//        webDriver.navigate().refresh();

    }

    @Test(dataProviderClass = DataProviderList.class, dataProvider = "consignment")
//    @Test()
    public void doStarted(Map<String, String> testDataSet) throws InterruptedException {


//       testDataSet.entrySet().stream().forEach((k)-> System.out.println(k.getKey() + "" + k.getValue()));

//    @Test(priority = 0)
//    public void doStarted() throws InterruptedException {

//        pageConsignment = new PageConsinment(eventFiringWebDriver);
////        Thread.sleep(8000);
//        pageConsignment.clickOnConsignmentDropdown();
//        Thread.sleep(8000);
        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);
//        pageConsignment.enterTxtConsignmentID("UAT92095901", Keys.ENTER);
        Thread.sleep(10000);
//        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"),Keys.ENTER);
//        Thread.sleep(8000);
        pageConsignment.enterTxtBilledTo(testDataSet.get("BilledTo"));
//        pageConsignment.enterTxtBilledTo("CELW01");
        pageConsignment.selectMenuBilledTo();

        Thread.sleep(5000);
        if (pageConsignment.clickOnLogisticTypeFieldAndVerify() == 0) {

            pageConsignment.clickOnLogisticTypeAndSelectOutbond();
            Thread.sleep(4000);
            //<editor-fold desc="Commneted to check">

//            pageConsignment.isCommoditySelected();
//            pageConsignment.clickoncommudity();
//
//
//            pageConsignment.clickOnCommudityContinuePopup();
//            Thread.sleep(5000);
////
//
//            pageConsignment.clickOnCommudityJwellery();
//            Thread.sleep(7000);
        } else {

            System.out.println("Logistic Type Field value is Present");
        }

//        if(pageConsignment.isCommodityDisabled()){
//
//            pageConsignment.clickOnSecondStepper();
//            Thread.sleep(2000);
//        }
//        else{
//            pageConsignment.isCommoditySelected();
//            pageConsignment.clickoncommudity();
//
//
//            pageConsignment.clickOnCommudityContinuePopup();
//            Thread.sleep(5000);
////
//
//            pageConsignment.clickOnCommudityJwellery();
//            Thread.sleep(7000);

//        Thread.sleep(4000);
        //<editor-fold desc="Commneted to check">

//


        //<editor-fold desc="Second Stepper">

        pageConsignment.clickOnSecondStepper();
        Thread.sleep(2000);

//        if(pageConsignment.verifySenderFieldText()){


        if (pageConsignment.verifySenderAddress() != 0) {

//            pageConsignment.clickOnSecondStepper();
//            Thread.sleep(2000);

            pageConsignment.clickOnStepReciever();
        }

        if (pageConsignment.verifySenderFieldRestricted()) {


            pageConsignment.clickOnSenderNameRestricted();

            pageConsignment.SelectMenuSenderName();

        }
//        (pageConsignment.verifySenderFieldNotRestricted())
        if (pageConsignment.verifySenderFieldNotRestricted()) {
            pageConsignment.clickOnSenderName(testDataSet.get("SenderName"));
//        pageConsignment.clickOnSenderName("Cell");
            pageConsignment.SelectMenuSenderName();
            Thread.sleep(3000);
            //Verify the Reset Button
//        pageConsignment.validateResetButton();
//            Thread.sleep(3000);
//        pageConsignment.clickOnSenderName(testDataSet.get("SenderName"));
//
//        pageConsignment.SelectMenuSenderName();
//        Thread.sleep(4000);
            pageConsignment.clickOnButtonNewContact();
            Thread.sleep(3000);
            pageConsignment.clickOnCancelButton();

//            pageConsignment.clickOnbuttonEditContact();
//            Thread.sleep(6000);
        }

        Thread.sleep(6000);

        pageConsignment.clickOnStepReciever();

        if (pageConsignment.verifyReceiverAddress() != 0) {
            //Click on fourth Stepper
            pageConsignment.clickOnStepValue();
        }
        if (pageConsignment.verifyReceiverFieldIsRestricted()) {
//            pageConsignment.clickOnStepReciever();

            pageConsignment.entertxtRecieverNameRestricted();

            pageConsignment.selectMenuRecieverName();
        }

        if (pageConsignment.verifyReceiverFieldNotRestricted()) {
//            pageConsignment.clickOnStepReciever();
            pageConsignment.entertxtRecieverName(testDataSet.get("ReceiverName2"));
//        pageConsignment.entertxtRecieverName("surekha");

            pageConsignment.selectMenuRecieverName();

            pageConsignment.clickOnbuttonNewContactReceiverContact();
            Thread.sleep(4000);

            pageConsignment.clickonSavebuttonNewContact();


        }
        Thread.sleep(4000);
//        pageConsignment.entertxtRecieverName(testDataSet.get("ReceiverName"));
////        pageConsignment.entertxtRecieverName("Surekh");
//
//        pageConsignment.clickOnbuttonNewReceiver();
//
//        pageConsignment.clickonCancelbuttonNewCustomer();

//        pageConsignment.entertxtRecieverName(testDataSet.get("ReceiverName2"));
////        pageConsignment.entertxtRecieverName("surekha");
//
//        pageConsignment.selectMenuRecieverName();

//

//        pageConsignment.clickOnbuttonNewContactReceiverContact();
//        Thread.sleep(4000);
//
//        pageConsignment.clickonSavebuttonNewContact();
//        Thread.sleep(3000);
//
        pageConsignment.clickOnStepValue();
        // Thread.sleep(10000);

        pageConsignment.entertxtStepValue(testDataSet.get("ValueForCarrige"));
        //Thread.sleep(5000);
//
//        pageConsignment.clickOnCheckBox();
//        Thread.sleep(10000);
//
        //<editor-fold desc="FifthStepper">
        pageConsignment.clickOnStepRequirement();
//        Thread.sleep(4000);
        pageConsignment.entertxtShipperReference(testDataSet.get("InvalidShipperReference"));
//        Thread.sleep(5000);
//
        pageConsignment.entertxtShipperReference(testDataSet.get("ValidShipperReference"));
//        Thread.sleep(10000);
        pageConsignment.clickOnDropdownProofOfDelivery(Keys.TAB);
//
//        Thread.sleep(9000);
        /*//<editor-fold desc="Not applicable in Fifth stepper">
        pageConsignment.ClickonDropDownStandardInstructionType();
        Thread.sleep(10000);
//
        pageConsignment.clickonDropdownNonDeliverablesDays(Keys.TAB);
       Thread.sleep(11000);
        //</editor-fold>*/
//
//        pageConsignment.clickOnAddAnotherInstruction();
//       // Thread.sleep(8000);
//
        //<editor-fold desc="6th stepper">
        pageConsignment.clickonstepServices();
//        pageConsignment.selectServiceType();

        //For RICA
//        if (pageConsignment.verifyRicaIsNotPresent()) {

            if (!pageConsignment.verifyRICA()) {

                pageConsignment.selectServiceTypeAndSelectNextDay();
                pageConsignment.clickOnSAID();
                pageConsignment.enterTxtInSAIDField("1234567891234");

                pageConsignment.clickonStepParcel();
//        Thread.sleep(6000);

                pageConsignment.entertxtNumberOfParcel(testDataSet.get("NumberOfParcel"));
                Thread.sleep(5000);

                pageConsignment.clickOnPackageType01();

                pageConsignment.clickOnSecurityPack(testDataSet.get("SecurityPack"));

                pageConsignment.entertxtweight("0.1");

                pageConsignment.enterParcelReferenceTxt("NA");

                pageConsignment.clickOnFinaliseConsignment();

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
            //Step Seven and finalize the consignment
//        Thread.sleep(6000);
//        }
//        else {
            pageConsignment.clickonStepParcel();
//        }


        pageConsignment.entertxtNumberOfParcel(testDataSet.get("NumberOfParcel"));
//        Thread.sleep(8000);
        System.out.println("ParcelHeader displayed" + pageConsignment.verifyParcelHeaderIsDisplayed());
//        pageConsignment.clickOnFinaliseConsignment();
//        if(pageConsignment.verifySecurityPack()) {
            pageConsignment.clickOnSecurityPack(testDataSet.get("SecurityPack"));
//        }
//        if(pageConsignment.verifyWeightErrorIsDisplayed()) {
            pageConsignment.entertxtweight("0.1");
//        }



////        pageConsignment.clickOnDeleteIcon();
//        Thread.sleep(10000);
//
//        pageConsignment.clickOnSecurityPack(testDataSet.get("SecurityPack"));
//
//        pageConsignment.entertxtweight("0.1");

    //pageConsinment.clickOnPackageType();
//        Thread.sleep(8000);
//
        pageConsignment.clickOnFinaliseConsignment();








        /*//<editor-fold desc="Stepper Seven">
        Thread.sleep(6000);

        pageConsignment.clickonStepParcel();
//        Thread.sleep(6000);

        pageConsignment.entertxtNumberOfParcel(testDataSet.get("NumberOfParcel"));
        Thread.sleep(8000);
//
////        pageConsignment.clickOnDeleteIcon();
//        Thread.sleep(10000);
//
        pageConsignment.clickOnSecurityPack(testDataSet.get("SecurityPack"));

        pageConsignment.entertxtweight("0.1");

        //pageConsinment.clickOnPackageType();
//        Thread.sleep(8000);
//
        pageConsignment.clickOnFinaliseConsignment();
        //</editor-fold>*/
        //</editor-fold>
        //</editor-fold>
//        Thread.sleep(8000);


        waitForLoad();
        webDriver.navigate().refresh();

//
    }


}

