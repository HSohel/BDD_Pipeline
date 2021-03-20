package command_provider;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ElementAssertions {

    private WebDriver driver;
    private By locator;

    public ElementAssertions (WebDriver driver,By locator){
        this.driver=driver;
        this.locator=locator;
    }

    public ElementAssertions elementExist(){
        boolean element=driver.findElement(locator).isDisplayed();
        Assert.assertTrue("The expected element does not exist",element);
        return this;
    }





}
