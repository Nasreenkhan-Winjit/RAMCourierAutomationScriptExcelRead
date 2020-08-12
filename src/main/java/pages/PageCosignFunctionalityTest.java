package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.commonmodule.Loader;

public class PageCosignFunctionalityTest extends BasePage {






  @FindBy(how= How.XPATH,using = "//input[@id='firstname_sendercontactaddedit']")
    private WebDriver elementFNSenderAddNewContact;

}
