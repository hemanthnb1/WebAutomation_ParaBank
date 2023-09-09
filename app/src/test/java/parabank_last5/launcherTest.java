package parabank_last5;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import parabank_last5.Driver.DriverCreator;
import parabank_last5.Pages.*;

public class launcherTest {

    WebDriver driver=new DriverCreator().create("chrome");
    @Test
    void loginTest() throws InterruptedException {
        LauncherPage launcherPage = new LauncherPage(driver);
        launcherPage.navigateTo("https://demo.openmrs.org/openmrs/login.htm");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("admin","Admin123");

        AddPatientPage addPatientPage = new AddPatientPage(driver);
        addPatientPage.registerPatient("Ananth","Kumar","7","2001","Indiranagagar","1234567890");
    }
//
//    @Test
//    void createPatientTest() throws InterruptedException {
//
//    }

    @Test(dependsOnMethods = "loginTest")
    void CheckinPatientTest() throws InterruptedException {
        CheckInPatient checkin = new CheckInPatient(driver);
        checkin.checkinPatient("Ananth");
    }

    @Test(dependsOnMethods ="CheckinPatientTest")
    void CaptureVitalTest(){
        CaptureVitalsPage captureVitalsPage = new CaptureVitalsPage(driver);
        captureVitalsPage.addVitals();
    }




}
