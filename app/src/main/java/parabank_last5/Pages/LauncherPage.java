package parabank_last5.Pages;

import org.openqa.selenium.WebDriver;
import parabank_last5.Driver.DriverCreator;

public class LauncherPage extends BasePage {
    WebDriver driver;
    public LauncherPage(WebDriver driver){
        super(driver);
    this.driver=driver;
    }

    public void navigateTo(String url){
        driver.get(url);
    }

//    public  void  launch(String driver)
//    {
////        WebDriver driver1=new DriverCreator().create(driver);
////        driver1.get("https://demo.openmrs.org/");
//        driver1.quit();
//    }

}
