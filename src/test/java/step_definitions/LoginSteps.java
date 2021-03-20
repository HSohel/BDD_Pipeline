package step_definitions;

import command_provider.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginSteps {
    private static final Logger LOGGER= LogManager.getLogger(LoginSteps.class);
    WebDriver driver=Hooks.driver;

    private static final By FullName=By.id("name");
    private static final By Password=By.id("password");
    private static final By Login=By.id("login");
    private static final By LogOut=By.id("logout");
    private static final By InvalidPassword=By.xpath("//div[text()='Password is invalid']");

    //Precondition
    @Given("^User is on the login page$")
    public void navigateToLoginPage(){
        String Url="https://example.testproject.io/web/";
        ActOn.browser(driver).OPenBrowser(Url);
        LOGGER.info("User is in The Login page");
    }

    @When("^User enters Username \"(.+?)\" and Password \"(.+?)\"$")
    public  void enterUserCredentials(String username, String password){
        ActOn.element(driver,FullName).setValue(username);
        ActOn.element(driver,Password).setValue(password);
        LOGGER.info("User entered valid credentials :"+username+" :"+password);
    }


    @And("^Usr click on the login button$")
    public  void clickOnLoginButton(){
        ActOn.element(driver,Login).click();
        LOGGER.info("User entered valid credentials ");
    }

    @Then("^User should be landed to Home page$")
    public void validateUserLoginSuccessful(){
        boolean logOutDisplayed=driver.findElement(LogOut).isDisplayed();
        Assert.assertTrue("LogOut button is not displayed",logOutDisplayed);
        LOGGER.info("User landed to Home page");
    }

    @Then("^User should not be landed to Home page$")
    public void validateUserFailedToLogin(){
        boolean InvalidPasswordDisplayed=driver.findElement(InvalidPassword).isDisplayed();
        Assert.assertTrue("LogOut button is not displayed",InvalidPasswordDisplayed);
        LOGGER.info("User failed to land to Home page");
    }

}
