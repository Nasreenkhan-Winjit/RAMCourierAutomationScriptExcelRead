package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.commonmodule.Loader;

import java.util.ArrayList;
import java.util.Map;

public class TestPageEditConsignmentUAT extends TestBase{

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

        Thread.sleep(10000);
        pageDashBoard.clickOnConsignViaAccordion();
        ArrayList<String> tabsCount = new ArrayList<>(eventFiringWebDriver.getWindowHandles());
        eventFiringWebDriver.switchTo().window(tabsCount.get(1));
    }
    @Test(dataProviderClass = DataProviderList.class, dataProvider =  "EditConsignmentUAT")

    public void compareDataInEditConsignment(Map<String,String> testDataSet) throws InterruptedException {
        pageConsignment = new PageConsinment(eventFiringWebDriver);
        Thread.sleep(20000);
        pageConsignment.selectEditConsignmentTab();
        Thread.sleep(20000);
//


        pageConsignment.enterTxtEditConsignmentID(testDataSet.get("ConsignmentID"), Keys.ENTER);
        Thread.sleep(20000);
        pageConsignment.clickOnSecondStepper();
        Thread.sleep(8000);
        pageConsignment.clickOnStepReciever();
        Thread.sleep(8000);
        pageConsignment.clickOnStepValue();
        pageConsignment.verifyValueInEdit();
        Thread.sleep(8000);
        pageConsignment.clickOnStepRequirement();
        Thread.sleep(8000);
        pageConsignment.verifyShipperReferenceInEditConsignment();
        pageConsignment.verifyValueInPODField();
        Thread.sleep(8000);
        pageConsignment.clickonstepServices();
        if(!pageConsignment.verifyRicaIsPresentInEdit()){

            System.out.println("Rica is selected ");
        }


        Thread.sleep(8000);
        pageConsignment.clickonStepParcel();
        pageConsignment.enterTextOnParcelRefField(" EditParcelRef01");
        Thread.sleep(4000);
        pageConsignment.clickOnSaveBtnInEditConsign();

        Thread.sleep(10000);









    }
}
