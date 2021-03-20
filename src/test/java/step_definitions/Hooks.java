package step_definitions;

import command_provider.ActOn;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
  private static final Logger LOGGER= LogManager.getLogger(Hooks.class);
  static WebDriver driver;

  @Before
    public void openBrowser(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
  }



  @After
    public void closeBrowser(){
      ActOn.browser(driver).CloseBrowser();
  }









}
