package org.drivers;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.utils.PropertyManager;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    static PropertyManager propertyManager =new PropertyManager();
    static WebDriver getDriver() throws MalformedURLException {

        String browser = propertyManager.getProperty("BROWSER");

        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
            // mac kullaniyorsak arch64() eklenmeli  WebDriverManager.chromedriver().arch64().setup();
        }

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = false;


        switch (browser){
            case "IE":
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            case "EDGE" :
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "SAFARI":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case "REMOTE":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions =new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                if ("Y".equalsIgnoreCase(propertyManager.getProperty("HEADLESS"))) {
                    chromeOptions.addArguments("--headless");
                }
                return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            default:
                ChromeOptions chromeOptions1 = new ChromeOptions();
                chromeOptions1.addArguments("--window-size=1920,1080");
                chromeOptions1.addArguments("--disable-extensions");
                chromeOptions1.addArguments("--disable-gpu");
                chromeOptions1.addArguments("--ignore-certificate-errors");
                chromeOptions1.addArguments("--no-sandbox");
                chromeOptions1.addArguments("--disable-dev-shm-usage");
                chromeOptions1.addArguments("--start-maximized");
               if ("Y".equalsIgnoreCase(propertyManager.getProperty("HEADLESS"))){
                   chromeOptions1.addArguments("--headless");
               }
               WebDriverManager.chromedriver().setup();
               return new ChromeDriver(chromeOptions1);
        }
    }
}
