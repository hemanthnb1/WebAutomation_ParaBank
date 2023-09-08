package parabank_last5;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import parabank_last5.Driver.DriverCreator;
import parabank_last5.Pages.LauncherPage;
import parabank_last5.Pages.LoginPage;

public class launcherTest {

    WebDriver driver=new DriverCreator().create("chrome");
    @Test
    void loginTest() throws InterruptedException {
        LauncherPage launcherPage = new LauncherPage(driver);
        launcherPage.navigateTo("https://demo.openmrs.org/openmrs/login.htm");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("admin","Admin123");
    }

}
