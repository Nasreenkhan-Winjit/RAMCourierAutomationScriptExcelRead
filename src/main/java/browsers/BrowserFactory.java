package browsers;

import browsers.browserType.ChromeBrowser;
import browsers.browserType.FirefoxBrowser;
import browsers.browserType.IEBrowser;
import org.testng.SkipException;

public class BrowserFactory {

    public static DriverManagerWeb getManager(EnumBrowserType webDriverType)  {

        DriverManagerWeb driverManager;
        switch (webDriverType){
            case IE: {
                driverManager = new IEBrowser();
                break;
            }
            case CHROME:{
                driverManager = new ChromeBrowser();
                break;
            }
            case FIREFOX:{
                driverManager = new FirefoxBrowser();
                break;
            }
            default:  throw new IllegalArgumentException("Invalid web driver : " + webDriverType.toString());
        }
        return driverManager;
    }
}