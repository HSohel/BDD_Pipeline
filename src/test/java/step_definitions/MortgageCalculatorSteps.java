package step_definitions;

import command_provider.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;
import utilities.GetData;
import utilities.SqlConnector;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MortgageCalculatorSteps {

    private static final Logger LOGGER= LogManager.getLogger(MortgageCalculatorSteps.class);
    WebDriver driver=Hooks.driver;


    @Given("^user is in the mortgage calculator home page$")
    public void navigateToMortgageCalculatorHomePage() throws IOException {
        String url= GetData.getPropertyValue("url");
        //String url= "https://www.mortgagecalculator.org/";
        ActOn.browser(driver).OPenBrowser(url);
        LOGGER.info("User is in Mortgage calculator Home page");
    }

    @And("^user navigates the real apr page$")
    public void userNavigatesToRealAprPage(){
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad();
    }

    @When ("^user clicks on calculate button upon entering \"(.+?)\", \"(.+?)\", \"(.+?)\", and \"(.+?)\"$")
    public void enterRealAprData(String homePrice,String downPayment,String interestRate,String Term){
        new RealApr(driver)
                .typeHomPrice(homePrice)
                .typeDownPayment(downPayment)
                .clickDownPaymentInDollarRadioBtn()
                .typeInterestRate(interestRate)
                .typeLength(Term)
                .clickCalculateButton();
    }

    @When ("^user enters required data and clicks on Calculate button$")
    public void enterMortgageData(){
        ResultSet rs= SqlConnector.readData("Select * FROM monthly_mortgage");
        try {
            while (rs.next()) {
                new Home(driver)
                        .typeHomePrice(rs.getString("homevalue"))
                        .typeDownPayment(rs.getString("downpayment"))
                        .clickDollarRadioButton()
                        .typeLoanAmount(rs.getString("loanamount"))
                        .typeInterestRate(rs.getString("interestrate"))
                        .typeLoanTerm(rs.getString("loanterm"))
                        .selectStartDate(rs.getString("startdatemonth"))
                        .typeStartYear(rs.getString("startdateyear"))
                        .typePropertyTax(rs.getString("propertytax"))
                        .typePMI(rs.getString("pmi"))
                        .typeHOI(rs.getString("homeownerinsurance"))
                        .typeHOA(rs.getString("monthlyhoa"))
                        .selectLoanType(rs.getString("loantype"))
                        .selectBuyOrRefinance(rs.getString("buyorrefi"))
                        .clickOnCalculateButton();
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Then("^validate that Real apr is \"(.+?)\"$")
    public void validateAprRate(String aprRate){
            new RealApr(driver)
                    .validateAPR(aprRate);
    }

    @Then("^validate Total Monthly Payment$")
    public void validateMonthlyPayment(){
        ResultSet rs= SqlConnector.readData("Select * FROM monthly_mortgage");
        try {
            while (rs.next()) {
                new Home(driver)
                        .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
