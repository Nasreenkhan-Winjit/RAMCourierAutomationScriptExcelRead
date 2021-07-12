package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.commonmodule.Loader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class TestPageRMSProd extends TestBase{

    PageDashBoard pageDashBoard;
    PageConsinment pageConsignment;
    PageEditConsignment pageEditConsignment;

    Loader loader;

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify valid user are allowed to access")


    @Test
    public void clickOnConsignment() throws InterruptedException {
        Thread.sleep(25000);
//     loader.waitForLoaderToDispose();

        pageDashBoard = new PageDashBoard(eventFiringWebDriver);
//        pageDashBoard.rMSPublicAccessURL();
        Thread.sleep(5000);
        pageDashBoard.clickOnNavBar();
    }

    @Test(dataProviderClass = DataProviderList.class, dataProvider =  "ConsignmentProd")
    public void clickOnRMSPortalAndVerifyConsignmentISCreated(Map<String,String> testDataSet) throws InterruptedException, IOException {
//        pageDashBoard = new PageDashBoard(eventFiringWebDriver);
//        pageDashBoard.rMSPublicAccessURL();


        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(0));
        Thread.sleep(9000);
        pageDashBoard.clickOnRMSPortal();




        Thread.sleep(5000);

        pageDashBoard.clickOnSearchAndReport();
        Thread.sleep(10000);
        pageDashBoard.enterConsignmentIDTxtRMS(testDataSet.get("ConsignmentID"));


        Thread.sleep(15000);

        pageDashBoard.clickONConsignmentTabProd();

        String ExpectedTitle=  pageDashBoard.enterConsignmentIDOnRMSEdit(testDataSet.get("ConsignmentID"));

        pageDashBoard.enterConsignmentIDOnRMSEditBtn();

        Thread.sleep(20000);
        SoftAssert softAssert = new SoftAssert();
        String ActualText =  pageDashBoard.verifyConsignmentIDTextField();
//        Thread.sleep(5000);

//         = pageDashBoard.enterConsignmentIDOnRMSEdit(testDataSet.get("ConsignmentID"));

        softAssert.assertEquals(ActualText,ExpectedTitle);
    }

    @Test
    public void verifyDataOnRMSEditConsignment(){
        SoftAssert softAssert = new SoftAssert();
// SenderID
        String ActualSenderID = pageDashBoard.verifyBilledToProd();
        String ExpectedSenderID = "ITAU01";

        softAssert.assertEquals(ActualSenderID,ExpectedSenderID, "SenderID Verified");
// Receiver Address

        String ActualReceiverAdd = pageDashBoard.verifyReceiverAddress();
        String ExpectedRcv = "RAM ISANDO RAM";

        softAssert.assertEquals(ActualReceiverAdd, ExpectedRcv);
// Shipper Reference data

        String ActualShipperRef = pageDashBoard.verifyShipperRefFieldData();
        String ExpectedShipperRef = "A1w11";




        softAssert.assertEquals(ActualShipperRef, ExpectedShipperRef);
// Goods Description field data

        String ActualGD =pageDashBoard.verifyGoodsDescriptionFieldData();
        String ExpectedGD = "[References:A1w11]";

        softAssert.assertEquals(ActualGD,ExpectedGD);

        pageDashBoard.verifyServiceND17H00IsSelected();
        pageDashBoard.verifySaturdayIsSelected();


        String ActualPC = pageDashBoard.verifyNoOfParcelField();
        String ExpectedPC = "1";

        softAssert.assertEquals(ActualPC, ExpectedPC);




    }



}