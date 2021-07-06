package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.commonmodule.Loader;

public class PageEditConsignment extends BasePage {

  private Loader loader ;
  private WebDriver webDriver;

  public PageEditConsignment(WebDriver webDriver) {
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

  @FindBy(how = How.XPATH, using= "//div[@class='v-toolbar__items hidden-sm-and-down']/a[3]")
  private WebElement elementSelectEditCOnsignmentTab;





  @Step("Click on Edit consignment tab ")
  public void EditConsignmentTab(){
    webDriverWait.until(ExpectedConditions.elementToBeClickable(elementSelectEditCOnsignmentTab));
    elementSelectEditCOnsignmentTab.click();

  }


  @Step("Enter txt consignment : \"{0}\"")
  public void editConsignmentID(String txt, Keys keys) {
//        loader.waitForLoaderToDispose();
    webDriverWait.until(ExpectedConditions.visibilityOf(elementtxtConsignmentID));
    elementtxtConsignmentID.sendKeys(Keys.CONTROL +"a");
    elementtxtConsignmentID.sendKeys(Keys.DELETE);
    elementtxtConsignmentID.sendKeys(txt,keys);

    System.out.println(elementtxtConsignmentID.getText());

//    Assert.

  }


  public void editBilledTo(String txt) {
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



}
