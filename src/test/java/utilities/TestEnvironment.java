package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class TestEnvironment {

    private static WebDriver driver;
    private static URL gridUrl;

    private static final Logger LOGGER= LogManager.getLogger(TestEnvironment.class);

    public static WebDriver selectTestExecutionEnvironment(){
       String environment=System.getProperty("environment")==null?"local":System.getProperty("environment");
       String browser=System.getProperty("browser")==null?"chrome":System.getProperty("browser");

       try{
           gridUrl= new URL("http://localhost:444/wd/hub");
       }catch(Exception e) {
        LOGGER.error("Selenium grid URL exception is :"+e.getMessage());
       }

       if (environment.equals("remote") &&browser.equals("chrome")){
           LOGGER.info("Execute test remote with chrome browser");
           ChromeOptions chromeOptions= new ChromeOptions();
           driver=new RemoteWebDriver(gridUrl,chromeOptions);
       } else if(environment.equals("remote")&& browser.equals("firefox")){
           LOGGER.info("Execute remote with Firefox browser");
           FirefoxOptions firefoxOptions=new FirefoxOptions();
           driver=new RemoteWebDriver(gridUrl,firefoxOptions);
        }else if (environment.equals("remote")&& browser.equals("edge")){
           LOGGER.info("Execute test info with edge browser");
           EdgeOptions edgeOptions=new EdgeOptions();
           driver=new RemoteWebDriver(gridUrl,edgeOptions);

       } else if (environment.equals("local")&& browser.equals("chrome")){
           LOGGER.info("Execute test with chrome browser in local machine");
           WebDriverManager.chromedriver().setup();
           driver=new ChromeDriver();
       } else if(environment.equals("local")&& browser.equals("firefox")){
           LOGGER.info("Execute test in Firefox browser in local machine");
           WebDriverManager.firefoxdriver().setup();
           driver=new FirefoxDriver();
       }else if (environment.equals("local")&& browser.equals("edge")){
           LOGGER.info("Execute test info with edge browser in local machine");
           WebDriverManager.edgedriver().setup();
           driver=new EdgeDriver();
       }
       return driver;
    }

}
