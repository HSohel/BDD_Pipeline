package page_objects;


import command_provider.ActOn;
import command_provider.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Home extends NavigationBar {
    private static final Logger LOGGER= LogManager.getLogger(Home.class);

    private final By HomeValue=By.id("homeval");
    private final By DownPayment=By.id("downpayment");
    private final By dollarRadioButton=By.xpath("//input[@name='param[downpayment_type]' and @value='money']");
    private final By loanAmount=By.id("loanamt");
    private final By interestRate=By.id("intrstsrate");
    private final By loanTerm=By.id("loanterm");
    private final By startDate=By.name("param[start_month]");
    private final By startYear=By.id("start_year");
    private final By propertyTax=By.id("pptytax");
    private final By PMI=By.id("pmi");
    private final By Hoi=By.id("hoi");
    private final By Hoa=By.id("hoa");
    private final By loanType=By.name("param[milserve]");
    private final By buyOrRefinance=By.name("param[refiorbuy]");
    private final By Cal=By.name("cal");


    public Home(WebDriver driver) {
        super(driver);
    }

    public Home typeHomePrice(String value){
        LOGGER.debug("Enter Home price :"+value);
        ActOn.element(driver,HomeValue).setValue(value);
        return this;
    }

    public Home typeDownPayment(String value){
        LOGGER.debug("Enter DownPayment :"+value);
        ActOn.element(driver,DownPayment).setValue(value);
        return this;
    }
    public Home clickDollarRadioButton(){
        LOGGER.debug("Click on Dollar Radio button ");
        ActOn.element(driver,dollarRadioButton).click();
        return this;
    }
    public Home typeLoanAmount(String value){
        LOGGER.debug("Enter Loan Amount :"+value);
        ActOn.element(driver,loanAmount).setValue(value);
        return this;
    }
    public Home typeInterestRate(String value){
        LOGGER.debug("Enter interestRate :"+value);
        ActOn.element(driver,interestRate).setValue(value);
        return this;
    }
    public Home typeLoanTerm(String value){
        LOGGER.debug("Enter Loan Term :"+value);
        ActOn.element(driver,loanTerm).setValue(value);
        return this;
    }
    public Home selectStartDate(String value){
        LOGGER.debug("Select Start date :"+value);
        ActOn.element(driver,startDate).selectValue(value);
        return this;
    }
    public Home typeStartYear(String value){
        LOGGER.debug("Enter startYear :"+value);
        ActOn.element(driver,startYear).setValue(value);
        return this;
    }
    public Home typePropertyTax(String value){
        LOGGER.debug("Enter Property Tax :"+value);
        ActOn.element(driver,propertyTax).setValue(value);
        return this;
    }
    public Home typePMI(String value){
        LOGGER.debug("Enter PMI:"+value);
        ActOn.element(driver,PMI).setValue(value);
        return this;
    }
    public Home typeHOI(String value){
        LOGGER.debug("Enter Home Owner Association fee:"+value);
        ActOn.element(driver,Hoi).setValue(value);
        return this;
    }
    public Home typeHOA(String value){
        LOGGER.debug("Enter HOA:"+value);
        ActOn.element(driver,Hoa).setValue(value);
        return this;
    }
    public Home selectLoanType(String value){
        LOGGER.debug("Select Loan Type:"+value);
        ActOn.element(driver,loanType).selectValue(value);
        return this;
    }

    public Home selectBuyOrRefinance(String value){
        LOGGER.debug("Select buy or Refinance:"+value);
        ActOn.element(driver,buyOrRefinance).selectValue(value);
        return this;
    }

    public Home clickOnCalculateButton(){
        LOGGER.debug("Click on Calculate Button");
        ActOn.element(driver,Cal).click();
        return this;
    }

    public Home validateTotalMonthlyPayment(String totalMonthlyPayment){
        By monthlyPaymentLocator=By.xpath("//h3[text()='"+ totalMonthlyPayment +"']");
        String monthlyPayment = ActOn.element(driver, monthlyPaymentLocator).getTextValue();
        LOGGER.debug("Validate Total Monthly Payment with Expected:"+totalMonthlyPayment+" and Actual :"+monthlyPayment);
        AssertThat.elementAssertions(driver, monthlyPaymentLocator).elementExist();
        Assert.assertEquals(monthlyPayment,totalMonthlyPayment);
        return this;
    }



}
