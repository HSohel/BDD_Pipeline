package page_objects;

import command_provider.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RealApr extends NavigationBar {

    private static final Logger LOGGER= LogManager.getLogger(RealApr.class);

    private final By calculateTab = By.xpath("//*[@id='CalcForm']//label[text()='Calculator']");
    private final By HomeValue = By.name("HomeValue");
    private final By downPayment = By.name("DownPayment");
    private final By downPaymentInDollar = By.id("DownPaymentSel0");
    private final By interestRate = By.name("Interest");
    private final By Length = By.name("Length");
    private final By Calculate = By.name("calculate");
    private final By ActualAPR = By.xpath("//tr/td/strong[contains(text(),'Actual APR')]/../following-sibling::td/strong");

        public RealApr(WebDriver driver) {
            super(driver);
        }

        public RealApr waitForPageToLoad() {
            ActOn.wait(driver, calculateTab).waitForElementToBeVisible();
            return this;
        }

        public RealApr typeHomPrice(String value) {
            LOGGER.debug("Set Home price :"+value);
            ActOn.element(driver, HomeValue).setValue(value);
            return this;
        }

        public RealApr typeDownPayment(String value) {
            LOGGER.debug("Set DownPayment :"+value);
            ActOn.element(driver, downPayment).setValue(value);
            return this;
        }

        public RealApr clickDownPaymentInDollarRadioBtn() {
            LOGGER.debug("Click on DownPaymentInDollar Radio button");
            ActOn.element(driver, downPaymentInDollar).click();
            return this;
        }

        public RealApr typeInterestRate(String value) {
            LOGGER.debug("Set InterestRate :"+value);
            ActOn.element(driver, interestRate).setValue(value);
            return this;
        }

        public RealApr typeLength(String value) {
            LOGGER.debug("Set Length :"+value);
            ActOn.element(driver, Length).setValue(value);
            return this;
        }

        public RealApr clickCalculateButton() {
            LOGGER.debug("Click on Calculate Button");
            ActOn.element(driver, Calculate).click();
            return this;
        }


        public RealApr validateAPR(String interestRate) {
            //Validate APR
            String aprRate = ActOn.element(driver, ActualAPR).getTextValue();
            LOGGER.debug("Validate Expected APR :"+interestRate+" with Actual APR :"+aprRate);
            Assert.assertEquals(aprRate, interestRate);
            return this;
        }

    }
