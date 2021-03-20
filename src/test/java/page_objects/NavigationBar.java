package page_objects;

import command_provider.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {

    private static final Logger LOGGER= LogManager.getLogger(NavigationBar.class);
    public WebDriver driver;

    private final By RateLink=By.linkText("Rates");
    private final By RealApr=By.xpath("//a[text()='Real APR']");
    private final By MortgageCalculatorLogo=By.xpath("//*[@id='calc']//h2[text()='Mortgage Calculator']");

    public NavigationBar(WebDriver driver){
        this.driver=driver;
    }


   //Navigate to the Home page

    public Home NavigateToHome(){
        LOGGER.debug("Navigate to Mortgage Calculator Home Page");
        ActOn.element(driver,MortgageCalculatorLogo).click();
        return new Home(driver);
    }


    public NavigationBar mouseHoverToRates(){
        LOGGER.debug("Mouse Hover to Rates Link");
        ActOn.element(driver,RateLink).mouseHover();
        return this;
    }

    public RealApr navigateToRealApr(){
        LOGGER.debug("Click on Real Apr Link");
        ActOn.element(driver,RealApr).click();
        return new RealApr(driver);
    }


}
