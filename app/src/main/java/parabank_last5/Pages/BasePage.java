package parabank_last5.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BasePage {
    WebDriver driver;
    BasePage(WebDriver driver){
        this.driver=driver;

    }


}
