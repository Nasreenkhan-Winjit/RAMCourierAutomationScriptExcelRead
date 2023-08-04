package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.commonmodule.Loader;

import java.util.ArrayList;
import java.util.Map;

public class TestPageFirearmConsignment extends TestBase {
    PageDashBoard pageDashBoard;
    PageConsinment pageConsignment;
    PageEditConsignment pageEditConsignment;

    Loader loader;

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify valid user are allowed to access")






    @Test
    public void clickOnConsignment() throws InterruptedException {
        Thread.sleep(30000);
//     loader.waitForLoaderToDispose();

        pageDashBoard = new PageDashBoard(eventFiringWebDriver);

//        Thread.sleep(5000);
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
        pageDashBoard.clickOnConsignPilotViaAccordion();
        Thread.sleep(5000);
        pageDashBoard.clickOnPopUpInternalUser();

        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(1));
    }

    @Test(dataProviderClass = DataProviderList.class, dataProvider = "firearmConsignment")

    public void firearmConsignment(Map<String, String> testDataSet) throws InterruptedException {

    pageConsignment =new PageConsinment(eventFiringWebDriver);
            Thread.sleep(16000);
            pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"),Keys.ENTER);
            Thread.sleep(15000);
            pageConsignment.enterTxtBilledTo(testDataSet.get("BilledTo"));
            pageConsignment.selectMenuBilledTo();
            Thread.sleep(7000);

        if (pageConsignment.clickOnLogisticTypeFieldAndVerify() == 0) {

            pageConsignment.clickOnLogisticTypeAndSelectInbound() ;
            Thread.sleep(15000);

        } else {

            System.out.println("Logistic Type Field value is Present");
        }




//            pageConsignment.clickOnCommudityContinuePopup();
//        Thread.sleep(2000);
            pageConsignment.clickOnCommodityAndSelectFirearms();

            Thread.sleep(9000);

            pageConsignment.clickOnSecondStepper();
            Thread.sleep(6000);

//        if(pageConsignment.verifySenderFieldText()){


            if(pageConsignment.verifySenderAddress()!=0)

    {

//            pageConsignment.clickOnSecondStepper();
//            Thread.sleep(2000);

        pageConsignment.clickOnStepReciever();
    }

            if(pageConsignment.verifySenderFieldRestricted())

    {


        pageConsignment.clickOnSenderNameRestricted();

        pageConsignment.SelectMenuSenderName();

    }

            if(pageConsignment.verifySenderFieldNotRestricted()) {

                pageConsignment.clickOnSenderName(testDataSet.get("SenderName"));
                Thread.sleep(7000);
                pageConsignment.SelectMenuSenderName();
                Thread.sleep(3000);

                if (pageConsignment.ClickAndVerifyIdentityType() == 0) {

                    pageConsignment.ClickAndSelectSenderIdentityType(testDataSet.get("SenderDealerLicense"));
                    Thread.sleep(8000);
                } else {

                    pageConsignment.enterSenderIdentityType(testDataSet.get("SenderDealerLicense"));
                    Thread.sleep(8000);
                    pageConsignment.clickOnStepReciever();
                }

                Thread.sleep(9000);
                pageConsignment.clickOnStepReciever();

                if (pageConsignment.ClickAndVerifyReceiverIdentityType() ==0){

                }

                pageConsignment.entertxtRecieverName(testDataSet.get("ReceiverName"));
                Thread.sleep(9000);
                pageConsignment.selectMenuRecieverName();
                Thread.sleep(9000);
                if (pageConsignment.ClickAndVerifyReceiverIdentityType() ==0) {


                    pageConsignment.ClickAndSelectReceiverIdentityType(testDataSet.get("ReceiverGunsmithLicense"));
                    Thread.sleep(9000);
                }
                else {
                    pageConsignment.enterReceiverIdentityType(testDataSet.get("ReceiverGunsmithLicense"));
                    Thread.sleep(9000);
                    pageConsignment.clickOnStepValue();
                }
                Thread.sleep(9000);
                pageConsignment.clickOnStepValue();

                pageConsignment.entertxtStepValue(testDataSet.get("ValueForCarrige"));
                Thread.sleep(9000);
                pageConsignment.clickOnStepRequirement();
                pageConsignment.selectFirearmTypeAmmunition();
                pageConsignment.enterTxtTypeofAmmunition(testDataSet.get("TypeOfAmmunition"));
                pageConsignment.enterTxtBatchNumber0(testDataSet.get("BatchNumber0"));
                pageConsignment.enterTxtNumberOfRounds0(testDataSet.get("NumberOfRounds0"));
                pageConsignment.clickOnButtonADDANOTHER();
                Thread.sleep(9000);
                pageConsignment.selectFirearmTypeRifle();
                pageConsignment.enterTxtNMakeOfFirearm1(testDataSet.get("NumberOfRounds0"));

                pageConsignment.elementTxtSerialNumber1(testDataSet.get("SerialNumber1"));

                pageConsignment.elementTxtMagazines1(testDataSet.get("Magazines1"));
                Thread.sleep(9000);

                pageConsignment.enterIMEINumber("987545555555555");
                pageConsignment.enterDescription(testDataSet.get("Description"));
                Thread.sleep(5000);

                pageConsignment.entertxtShipperReference(testDataSet.get("ValidShipperReference"));
                pageConsignment.clickOnSITAndSelectDONOTDeliver();
                Thread.sleep(5000);
                pageConsignment.clickOnNonDeliverDaysFieldAndSelectDay();
                Thread.sleep(9000);

                pageConsignment.clickonStepParcel();
                Thread.sleep(2000);
                pageConsignment.entertxtNumberOfParcel(testDataSet.get("NumberOfParcel"));
                Thread.sleep(8000);
                pageConsignment.clickOnEmailAndSaveButton();
                Thread.sleep(2000);
                pageConsignment.updateEmailAddress(testDataSet.get("UpdateEmailAddress"));
            }
        Thread.sleep(15000);


}



}
