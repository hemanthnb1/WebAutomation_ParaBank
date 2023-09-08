package parabank_last5.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverCreator {
    public WebDriver create(String driver){
        switch (driver){
            case "firefox":
                return  new FirefoxDriver();
            case "safari":
                return new SafariDriver();
            default:
                return  new ChromeDriver();
        }
    }
}
