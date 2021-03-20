package command_provider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {

    WebDriver driver;
    By locator;

    public WaitFor(WebDriver driver, By locator){
        this.driver=driver;
        this.locator=locator;

    }

    public WaitFor waitForElementToBeVisible(){
        WebDriverWait Wait=new WebDriverWait(driver, 15);
        Wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }


}
