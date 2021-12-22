package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.commonmodule.Loader;

import java.util.ArrayList;
import java.util.Map;

public class TestPageWeiDimPROD extends TestBase {
    PageDashBoard pageDashBoard;
    PageConsinment pageConsignment;
    PageEditConsignment pageEditConsignment;

    Loader loader;

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify valid user are allowed to access weigh and dimension")
//1
    @Test
    public void clickOnConsignment() throws InterruptedException {
        Thread.sleep(30000);


        pageDashBoard = new PageDashBoard(eventFiringWebDriver);

//        Thread.sleep(5000);
        pageDashBoard.clickOnNavBar();
    }
    //2
    @Test
    public void clickOnAccordian() throws InterruptedException {

        Thread.sleep(10000);
        pageDashBoard.clickOnConsignViaAccordion();
        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(1));

    }
    //3
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentProd")

    public void enterConsignmentIDOutbound(Map<String, String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(20000);
        pageConsignment.selectWeighAndDimTab();
        Thread.sleep(10000);
        pageConsignment.clickOnSettingsIcon();
        Thread.sleep(5000);
        pageConsignment.clickOnPrinterSetupButton();


        pageConsignment.enterTxtOnCompanyName("RAM Solutions");
        Thread.sleep(5000);
        pageConsignment.EnterHubIDAndSelectFromList("ISA");
        Thread.sleep(5000);
        pageConsignment.EnterDepartmentAndSelectFromList("IT");
        Thread.sleep(5000);
        pageConsignment.enterTxtPrinterID("48");
        Thread.sleep(5000);

        pageConsignment.enterTxtConsignmentID(("34343434333"), Keys.ENTER);
        Thread.sleep(5000);
//        pageConsignment.enterTxtConsignmentID(testDataSet.get("             "), Keys.ENTER);
//        Thread.sleep(5000);
        pageConsignment.enterTxtConsignmentID(("UAT12221212"), Keys.ENTER);
        Thread.sleep(5000);
        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);

        Thread.sleep(17000);
        pageConsignment.clickOnDoneButton();
        Thread.sleep(2000);
        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);
        Thread.sleep(9000);
        pageConsignment.entertxtLength(testDataSet.get("Length"));

        pageConsignment.entertxtBreadth(testDataSet.get("Breadth"));

        pageConsignment.entertxtHeight(testDataSet.get("Height"));

        pageConsignment.entertxtweight(testDataSet.get("Weight"));
        Thread.sleep(2000);

        pageConsignment.clickOnPrintButton();
        Thread.sleep(9000);

//        clickOnReprintReasonDropDown-------------- will use for reprint label

        pageConsignment.clickOnDoneButton();
        Thread.sleep(7000);

    }
    //4
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentProd")
    public void enterTrackingNumber(Map<String, String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(20000);
        pageConsignment.selectWeighAndDimTab();
        Thread.sleep(10000);

        pageConsignment.enterTxtConsignmentID("PROD01121001.001", Keys.ENTER);

        Thread.sleep(15000);
        pageConsignment.selectPackageType01();
        Thread.sleep(2000);
        pageConsignment.selectFromMenuCustom();

        pageConsignment.entertxtLength(testDataSet.get("Length"));

        pageConsignment.entertxtBreadth(testDataSet.get("Breadth"));

        pageConsignment.entertxtHeight(testDataSet.get("Height"));

        pageConsignment.entertxtweight(testDataSet.get("Weight"));
        Thread.sleep(2000);


        pageConsignment.clickOnDoneButton();
        Thread.sleep(2000);
        pageConsignment.clickOnNoButton();
        Thread.sleep(2000);
        pageConsignment.clickOnDoneButton();
        Thread.sleep(2000);
        pageConsignment.clickOnYesButton();
        Thread.sleep(10000);
    }
    //5
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentProd")
    public void clickOnActionIcon(Map<String, String> testDataSet) throws InterruptedException {

        pageConsignment.enterTxtConsignmentID("PROD01121002", Keys.ENTER);

        Thread.sleep(15000);
        pageConsignment.selectPackageType01();
        Thread.sleep(5000);
        pageConsignment.selectFromMenuCustom();
        Thread.sleep(5000);
        pageConsignment.clickOnActionIcon();
        Thread.sleep(5000);
        pageConsignment.clickOnActionIcon();
        Thread.sleep(5000);
        pageConsignment.clickOnDoneButton();
        Thread.sleep(2000);
        pageConsignment.clickOnNoButton();
        Thread.sleep(2000);
        pageConsignment.entertxtLength(testDataSet.get("Length"));

        pageConsignment.entertxtBreadth(testDataSet.get("Breadth"));

        pageConsignment.entertxtHeight(testDataSet.get("Height"));

        pageConsignment.entertxtweight(testDataSet.get("Weight"));
        Thread.sleep(5000);
        pageConsignment.clickOnActionIcon();

        Thread.sleep(5000);
        pageConsignment.clickOnDoneButton();
        Thread.sleep(5000);
        pageConsignment.clickOnYesButton();
        Thread.sleep(5000);
    }

    //    6
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentInbound2Prod")
    public void enterConsignmentIDInbound(Map<String, String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(20000);
        pageConsignment.selectWeighAndDimTab();
        Thread.sleep(10000);

//        Printer configuration---

//        pageConsignment.clickOnSettingsIcon();
//        Thread.sleep(5000);
//        pageConsignment.clickOnPrinterSetupButton();
//
//
//        pageConsignment.enterTxtOnCompanyName("RAM Solutions");
//        Thread.sleep(5000);
//        pageConsignment.EnterHubIDAndSelectFromList("ISA");
//        Thread.sleep(5000);
//        pageConsignment.EnterDepartmentAndSelectFromList("IT");
//        Thread.sleep(5000);
//        pageConsignment.enterTxtPrinterID("230");
//        Thread.sleep(5000);


        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);
        Thread.sleep(20000);
//        pageConsignment.clickOnPrintLabels();
        pageConsignment.selectPackageType01();
        Thread.sleep(2000);
        pageConsignment.selectFromMenuCustom();

//        pageConsignment.enterSecurityPackSmall(testDataSet.get("SecurityPackSmall"));


        pageConsignment.entertxtLength(testDataSet.get("Length"));

        pageConsignment.entertxtBreadth(testDataSet.get("Breadth"));

        pageConsignment.entertxtHeight(testDataSet.get("Height"));

        pageConsignment.entertxtweight(testDataSet.get("Weight"));
        Thread.sleep(2000);

        pageConsignment.clickOnPrintButton();
        Thread.sleep(5000);
        pageConsignment.clickOnDoneButton();
        Thread.sleep(7000);

        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);
        Thread.sleep(15000);

        pageConsignment.selectPackageType01();
        Thread.sleep(5000);
        pageConsignment.selectFromMenuCustom();
        Thread.sleep(5000);
        pageConsignment.clickOnActionIcon();
        Thread.sleep(5000);
        pageConsignment.clickOnSaveBtnOnDPD();
        Thread.sleep(2000);
        pageConsignment.clickOnFromRowDropDown();
        Thread.sleep(2000);
        pageConsignment.clickOnSaveBtnOnDPD();
        Thread.sleep(2000);
        pageConsignment.clickOnToRowDropDown();
        Thread.sleep(2000);
        pageConsignment.clickOnSaveBtnOnDPD();
        Thread.sleep(5000);
        pageConsignment.clickOnDoneButton();
        Thread.sleep(5000);
        pageConsignment.clickOnYesButton();
        Thread.sleep(5000);

    }
    //7
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentInbound2Prod")
    public void enterTrackingNumberInbound(Map<String, String> testDataSet) throws InterruptedException {


        pageConsignment.enterTxtConsignmentID("PROD01121003.001", Keys.ENTER);
        Thread.sleep(25000);
//        pageConsignment.clickOnPrintLabels();
        pageConsignment.selectPackageType01();
        Thread.sleep(2000);
        pageConsignment.selectFromMenuCustom();


//
        pageConsignment.entertxtLength(testDataSet.get("Length"));

        pageConsignment.entertxtBreadth(testDataSet.get("Breadth"));

        pageConsignment.entertxtHeight(testDataSet.get("Height"));

        pageConsignment.entertxtweight(testDataSet.get("Weight"));
        Thread.sleep(2000);


        pageConsignment.clickOnPrintButton();
        Thread.sleep(10000);


        pageConsignment.clickOnDoneButton();
        Thread.sleep(7000);

        pageConsignment.enterTxtConsignmentID("PROD01121003.001", Keys.ENTER);
        Thread.sleep(20000);

        pageConsignment.clickOnPrintButton();
        Thread.sleep(9000);
        pageConsignment.clickOnReprintReasonDropDown();
        Thread.sleep(9000);
        pageConsignment.clickOnDoneButton();
        Thread.sleep(15000);
//        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
//        eventFiringWebDriver.switchTo().window(tabsCount.get(0));

    }
    //8
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentProd")
    public void rMSPortalAndClickOnDimOutbound(Map<String, String> testDataSet) throws InterruptedException {
     pageDashBoard = new PageDashBoard(eventFiringWebDriver);
       //        pageDashBoard.clickOnRMSPortal();

/////  -------------- Testing purpose
//        pageConsignment = new PageConsinment(eventFiringWebDriver);

        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(0));
        Thread.sleep(9000);
        pageDashBoard.clickOnRMSPortal();

        Thread.sleep(5000);

//        pageDashBoard.clickOnSearchAndReport();
        Thread.sleep(9000);
        pageDashBoard.clickONConsignmentTabAndSelectDimProd();
        Thread.sleep(5000);
        pageDashBoard.enterConsignmentIDInDimParcels(testDataSet.get("ConsignmentID"), Keys.TAB);
        Thread.sleep(2000);
        pageDashBoard.enterNumberOfParcelInDimParcels(testDataSet.get("NumberOfParcelDim"));
        Thread.sleep(2000);
        pageDashBoard.clickOnDimButton();
        Thread.sleep(9000);

        pageDashBoard.clickOnEdit1ButtonOnWDRMSPortal();
        Thread.sleep(5000);
        pageDashBoard.enterTxtKGRMSPortalWeiDim(testDataSet.get("KilogramsRMS"));
        Thread.sleep(2000);
        pageDashBoard.enterTxtLengthRMSPortalWeiDim(testDataSet.get("LengthRMS"));
        Thread.sleep(2000);
        pageDashBoard.enterTxtBreadthRMSPortalWeiDim(testDataSet.get("BreadthRMS"));
        Thread.sleep(2000);
        pageDashBoard.enterTxtHeightRMSPortalWeiDim(testDataSet.get("HeightRMS"));

        Thread.sleep(2000);
        pageDashBoard.clickOnSaveBtnOnRMSPortalWeiDim();
        Thread.sleep(10000);

        pageDashBoard.clickOnDoneButtonOnWDRMSPortal();
        Thread.sleep(4000);

    }
//9

    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentInbound2Prod")
    public void rMSPortalAndClickOnDimInbound(Map<String, String> testDataSet) throws InterruptedException {

        pageDashBoard.enterConsignmentIDInDimParcelsInbound(testDataSet.get("ConsignmentID"), Keys.TAB);
        Thread.sleep(2000);
        pageDashBoard.enterNumberOfParcelInDimParcels(testDataSet.get("NumberOfParcelDim"));
        Thread.sleep(2000);
        pageDashBoard.clickOnDimButton();
        Thread.sleep(4000);
        pageDashBoard.clickOnEditBtn2ROnRMSPortalWeiDim();
        Thread.sleep(2000);
        pageDashBoard.enterTxtKG2RONRMSPortalWeiDim(testDataSet.get("KilogramsRMS"));
        Thread.sleep(2000);
        pageDashBoard.enterTxtLength2ROnRMSPortalWeiDim(testDataSet.get("LengthRMS"));
        Thread.sleep(2000);
        pageDashBoard.enterTxtBreadth2ROnRMSPortalWeiDim(testDataSet.get("BreadthRMS"));
        Thread.sleep(2000);
        pageDashBoard.enterTxtHeight2ROnRMSPortalWeiDim(testDataSet.get("HeightRMS"));
        Thread.sleep(2000);
        pageDashBoard.clickOnSaveBtn2ROnRMSPortalWeiDim();
        Thread.sleep(10000);
        pageDashBoard.clickOnDoneButtonOnWDRMSPortal();
        Thread.sleep(9000);

        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(1));

    }
//10

    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentProd")

    public void verifyConsignmentIDOutboundOnWeiDim(Map<String, String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(20000);
        pageConsignment.selectWeighAndDimTab();
        Thread.sleep(10000);
        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);

        Thread.sleep(15000);
        pageConsignment.clickOnDoneButton();
        Thread.sleep(8000);

    }


    //11
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentInbound2Prod")
    public void verifyConsignmentIDInboundOnWeiDim(Map<String, String> testDataSet) throws InterruptedException {
//        pageConsignment = new PageConsinment(eventFiringWebDriver);
//        Thread.sleep(20000);
//        pageConsignment.selectWeighAndDimTab();
//        Thread.sleep(10000);
        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);
        Thread.sleep(20000);

        pageConsignment.clickOnDoneButton();
        Thread.sleep(6000);

    }
    //12
    @Test(dataProviderClass = DataProviderList.class, dataProvider =  "ConsignmentProd")

    public void verifyParcelsInEditConsignmentOutbound(Map<String,String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(20000);
        pageConsignment.selectEditConsignmentTab();
        Thread.sleep(10000);
        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);

        Thread.sleep(20000);
        pageConsignment.clickonStepParcel();

        pageConsignment.entertxtNumberOfParcel("2");
        Thread.sleep(4000);
        pageConsignment.clickOnProceedBtnPCU();
        Thread.sleep(4000);

        pageConsignment.selectPackageType01();
        Thread.sleep(5000);
        pageConsignment.selectFromMenuCustom();
        Thread.sleep(2000);
        pageConsignment.entertxtLength(testDataSet.get("Length2"));

        pageConsignment.entertxtBreadth(testDataSet.get("Breadth2"));

        pageConsignment.entertxtHeight(testDataSet.get("Height2"));

        pageConsignment.entertxtweight(testDataSet.get("Weight2"));
        pageConsignment.enterTextOnParcelRefField(testDataSet.get("EditParcelRef01"));
        Thread.sleep(4000);

        pageConsignment.selectPackageType02();
        Thread.sleep(4000);
        pageConsignment.selectFromMenuCustom();
        Thread.sleep(2000);
        pageConsignment.entertxtLength2R(testDataSet.get("Length"));

        pageConsignment.entertxtBreadth2R(testDataSet.get("Breadth"));

        pageConsignment.entertxtHeight2R(testDataSet.get("Height"));

        pageConsignment.enterTxtWeight2R(testDataSet.get("Weight"));
        Thread.sleep(2000);


        pageConsignment.clickOnSaveBtnInEditConsign();

        Thread.sleep(10000);

    }

//    13

    @Test(dataProviderClass = DataProviderList.class, dataProvider =  "ConsignmentInbound2Prod")

    public void verifyParcelsInEditConsignmentInbound(Map<String,String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(20000);
        pageConsignment.selectEditConsignmentTab();
        Thread.sleep(10000);
        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);

        Thread.sleep(20000);
        pageConsignment.clickonStepParcel();

        pageConsignment.entertxtNumberOfParcel("2");
        Thread.sleep(4000);
        pageConsignment.clickOnProceedBtnPCU();
        Thread.sleep(4000);

        pageConsignment.selectPackageType01();
        Thread.sleep(5000);
        pageConsignment.selectFromMenuCustom();
        Thread.sleep(2000);
        pageConsignment.entertxtLength(testDataSet.get("Length"));

        pageConsignment.entertxtBreadth(testDataSet.get("Breadth"));

        pageConsignment.entertxtHeight(testDataSet.get("Height"));

        pageConsignment.entertxtweight(testDataSet.get("Weight"));

        pageConsignment.enterTextOnParcelRefField(testDataSet.get("EditParcelRef01"));
        Thread.sleep(4000);

        pageConsignment.selectPackageType02();
        Thread.sleep(4000);
        pageConsignment.selectFromMenuCustom();
        Thread.sleep(2000);
        pageConsignment.entertxtLength2R(testDataSet.get("Length2"));

        pageConsignment.entertxtBreadth2R(testDataSet.get("Breadth2"));

        pageConsignment.entertxtHeight2R(testDataSet.get("Height2"));

        pageConsignment.enterTxtWeight2R(testDataSet.get("Weight2"));
        Thread.sleep(2000);
        pageConsignment.clickOnSaveBtnInEditConsign();
        Thread.sleep(10000);

        webDriver.navigate().refresh();

    }

    //    14
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentProd")

    public void verifyChangesOnWeiDimOutbound(Map<String, String> testDataSet) throws InterruptedException {
        Thread.sleep(20000);
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(20000);
        pageConsignment.selectWeighAndDimTab();
        Thread.sleep(10000);
        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);

        Thread.sleep(15000);
        pageConsignment.clickOnDoneButton();
        Thread.sleep(2000);

    }
//    15

    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentInbound2Prod")
    public void verifyChangesWeiDimInbound(Map<String, String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(20000);
        pageConsignment.selectWeighAndDimTab();
        Thread.sleep(10000);


        pageConsignment.enterTxtConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);
        Thread.sleep(15000);
        pageConsignment.clickOnDoneButton();
        Thread.sleep(8000);



    }
    //16
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentProd")
    public void verifyChangesOnRMSPortalOutbound(Map<String, String> testDataSet) throws InterruptedException {
        webDriver.navigate().refresh();
        Thread.sleep(9000);
        pageDashBoard = new PageDashBoard(eventFiringWebDriver);

//        pageDashBoard.rMSPublicAccessURL();


        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(0));
        Thread.sleep(9000);
        pageDashBoard.clickOnRMSPortal();

        Thread.sleep(5000);

//        pageDashBoard.clickOnSearchAndReport();
        Thread.sleep(9000);
        pageDashBoard.clickONConsignmentTabAndSelectDimProd1();
        Thread.sleep(5000);
        pageDashBoard.enterConsignmentIDInDimParcels(testDataSet.get("ConsignmentID"), Keys.TAB);
        Thread.sleep(2000);
        pageDashBoard.enterNumberOfParcelInDimParcels("2");
        Thread.sleep(2000);
        pageDashBoard.clickOnDimButton();
        Thread.sleep(9000);
        pageDashBoard.clickOnDoneButtonOnWDRMSPortal();
        Thread.sleep(8000);
    }
    //17
    @Test(dataProviderClass = DataProviderList.class, dataProvider = "ConsignmentInbound2Prod")
    public void verifyChangesOnRMSPortalInbound(Map<String, String> testDataSet) throws InterruptedException {

        pageDashBoard.enterConsignmentIDInDimParcelsInbound(testDataSet.get("ConsignmentID"), Keys.TAB);
        Thread.sleep(2000);
        pageDashBoard.enterNumberOfParcelInDimParcels("2");
        Thread.sleep(5000);
        pageDashBoard.clickOnDimButton();
        Thread.sleep(9000);
        pageDashBoard.clickOnDoneButtonOnWDRMSPortal();
        Thread.sleep(7000);

    }


}
