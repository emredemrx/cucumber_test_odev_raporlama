package org.drivers;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
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
import java.util.Objects;

public class DriverFactory {
    static PropertyManager propertyManager =new PropertyManager();
    public static void setupDriver() {

        String browser = propertyManager.getProperty("BROWSER");

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = false;
        Configuration.headless= Objects.equals(propertyManager.getProperty("HEADLESS"),"Y");
         browser = Objects.equals(propertyManager.getProperty("BROWSER"), null) ? "CHROME" : propertyManager.getProperty("BROWSER");
        switch (browser){
            case "IE":
                Configuration.browser = Browsers.IE;
                break;
            case "CHROME":
                Configuration.browser = Browsers.CHROME;
                break;
            case "EDGE" :
                Configuration.browser = Browsers.EDGE;
                break;
            case "FIREFOX":
                Configuration.browser = Browsers.FIREFOX;
                break;
            case "SAFARI":
                Configuration.browser = Browsers.SAFARI;
                break;
            default:
                Configuration.browser = Browsers.CHROME;
                break;
        }
    }
    public static void open(String url) {
        System.out.println(url);
        Selenide.open(url);
    }
    public static WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();
    }
    public static void maximize() {
        currentDriver().manage().window().maximize();
    }
    public static void close() {
        currentDriver().quit();
    }
}
