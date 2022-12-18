package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.nio.file.LinkOption;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    creating a private constructor
    so, we are closing access to the object of this class from outside the class
     */
    private Driver(){}

    /*
    we make it private, because we want to close access from outside the class
    we make it static since we will use it in a static method
     */
    //private static WebDriver driver;//value is null by default

    //for parallel testing
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){
        if (driverPool.get() == null){

            /*
            we read our browserType from configuration.properties
            this way, we can control which browser is opened from outside our code, from configuration.properties
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            depending on the browserType that will be returned from configuration.properties file, if statement will determine the case, and open the matching browser
             */
            if (browserType.equalsIgnoreCase("chrome")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=en-GB");
                WebDriverManager.chromedriver().setup();
                driverPool.set(new ChromeDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browserType.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driverPool.set(new FirefoxDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browserType.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driverPool.set(new EdgeDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browserType.equalsIgnoreCase("safari")) {
                WebDriverManager.safaridriver().setup();
                driverPool.set(new SafariDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else if (browserType.equalsIgnoreCase("opera")) {
                WebDriverManager.operadriver().setup();
                driverPool.set(new OperaDriver());
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }

        return driverPool.get();
    }

    /*
    this method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit(); //this line will terminate the existing session. value will not even be null
            driverPool.remove();
        }
    }

}
