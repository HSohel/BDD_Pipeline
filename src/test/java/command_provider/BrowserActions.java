package command_provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private static final Logger LOGGER= LogManager.getLogger(BrowserActions.class);

    WebDriver driver;

    public BrowserActions(WebDriver driver){
        this.driver=driver;
    }


    public BrowserActions OPenBrowser(String url){
        driver.manage().deleteAllCookies();
        LOGGER.info("Launch browser :"+url);
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public BrowserActions validateTitle(String expectedTitle){
          String actualTitle=driver.getTitle();
          LOGGER.debug("Validate title Expected:"+expectedTitle+" Actual :"+actualTitle);
          Assert.assertEquals(expectedTitle,actualTitle);
        return this;
    }


    public BrowserActions CloseBrowser(){
        driver.quit();
        return this;
    }
}
