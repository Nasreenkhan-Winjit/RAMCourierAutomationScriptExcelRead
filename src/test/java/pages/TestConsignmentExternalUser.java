package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.commonmodule.Loader;

import java.util.ArrayList;
import java.util.Map;

public class TestConsignmentExternalUser extends TestBase {
    PageDashBoard pageDashBoard;
    PageConsinment pageConsignment;
    Loader loader;

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify valid user are allowed to access")

    @Test
    public void clickOnConsignment() throws InterruptedException {
        Thread.sleep(30000);
        pageDashBoard = new PageDashBoard(eventFiringWebDriver);
        pageDashBoard.clickOnNavBar();


    }


    @Test
    public void clickOnAccordianAndSelectExternalUserCompany() throws InterruptedException {
        Thread.sleep(21000);

        pageDashBoard.clickOnConsignViaAccordion();
        Thread.sleep(5000);
        pageDashBoard.clickOnExternalUserCompanyArrowDD();
        pageDashBoard.selectCompanyAssignedMultipleBilledTos();

        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(1));

    }


    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ExternalOutboundConsignment")
//    @Test()
    public void externalUserConsignmentOutbound(Map<String, String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(25000);

        pageConsignment.clickOnBilledToFieldAndSelect();
        Thread.sleep(5000);

        if (pageConsignment.clickOnLogisticTypeFieldAndVerify() == 0) {

            pageConsignment.clickOnLogisticTypeAndSelectOutbond();
            Thread.sleep(10000);

        } else {

            System.out.println("Logistic Type Field value is Present");
        }
        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);

        Thread.sleep(15000);

        pageConsignment.clickOnSecondStepper();
        Thread.sleep(2000);
        pageConsignment.clickOnSenderFieldAndSelectAddress(testDataSet.get("SenderName"));
        Thread.sleep(2000);
        pageConsignment.clickOnSenderMenuAndSelectAddress();
        Thread.sleep(5000);


        pageConsignment.clickOnStepReciever();
        Thread.sleep(4000);
        pageConsignment.entertxtRecieverName(testDataSet.get("ReceiverName"));
        Thread.sleep(2000);
        pageConsignment.selectMenuRecieverName();
        Thread.sleep(5000);

        pageConsignment.clickOnStepValue();
        pageConsignment.entertxtStepValue(testDataSet.get("ValueForCarriage"));

        pageConsignment.clickOnStepRequirement();
        pageConsignment.entertxtShipperReference(testDataSet.get("ValidShipperReference"));
        Thread.sleep(5000);

        pageConsignment.clickOnStandardInstructionTypeAndSelectFD();
        pageConsignment.selectFutureDateFromMenu();
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
        System.out.println("ParcelHeader displayed" + pageConsignment.verifyParcelHeaderIsDisplayed());
        pageConsignment.clickOnFinaliseConsignment1();
        Thread.sleep(2000);
        pageConsignment.clickOnPackageType01();
        Thread.sleep(8000);

        if (pageConsignment.verifySecurityPack()) {
            pageConsignment.clickOnSecurityPack(testDataSet.get("SecurityPack"));
        }
        if (pageConsignment.verifyWeightErrorIsDisplayed()) {
            pageConsignment.entertxtweight("0.9");
        }
        pageConsignment.clickOnPrintLabels();

        pageConsignment.clickOnFinaliseConsignment();
        Thread.sleep(30000);
    }



    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ExternalInboundConsignment")
//    @Test()
    public void externalUserConsignmentInbound(Map<String, String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(15000);

        pageConsignment.clickOnBilledToFieldAndSelect();
        Thread.sleep(5000);

        if (pageConsignment.clickOnLogisticTypeFieldAndVerify() == 0) {

            pageConsignment.clickOnLogisticTypeAndSelectInbound() ;
            Thread.sleep(10000);

        } else {

            System.out.println("Logistic Type Field value is Present");
        }

        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);

        Thread.sleep(15000);

        pageConsignment.clickOnSecondStepper();
        Thread.sleep(4000);
        pageConsignment.clickOnSenderFieldAndSelectAddress(testDataSet.get("SenderName"));
        Thread.sleep(5000);
        pageConsignment.clickOnSenderMenuAndSelectAddress();
        Thread.sleep(5000);


        pageConsignment.clickOnStepReciever();
        Thread.sleep(4000);
        pageConsignment.entertxtRecieverName(testDataSet.get("ReceiverName"));
        Thread.sleep(2000);
        pageConsignment.selectMenuRecieverName();
        Thread.sleep(5000);

        pageConsignment.clickOnStepValue();
        pageConsignment.entertxtStepValue(testDataSet.get("ValueForCarriage"));

        pageConsignment.clickOnStepRequirement();
        pageConsignment.entertxtShipperReference(testDataSet.get("ValidShipperReference"));
        Thread.sleep(5000);

        pageConsignment.clickOnStandardInstructionTypeAndSelectFD();
        pageConsignment.selectFutureDateFromMenu();
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

        pageConsignment.clickOnEmailAndSaveButton();
        Thread.sleep(2000);
        pageConsignment.updateEmailAddress(testDataSet.get("UpdateEmailAddress"));

        Thread.sleep(15000);


    }








}
