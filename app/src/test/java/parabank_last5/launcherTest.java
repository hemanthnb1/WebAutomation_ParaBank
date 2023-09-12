package parabank_last5;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parabank_last5.Driver.DriverCreator;
import parabank_last5.Pages.*;

public class launcherTest {

    WebDriver driver;
    @BeforeMethod
    void launcher() throws InterruptedException {
//        String username="admin", password="Admin123";
        this.driver=new DriverCreator().create("chrome");
        LauncherPage launcherPage = new LauncherPage(driver);
        launcherPage.navigateTo("https://demo.openmrs.org/openmrs/login.htm");
    }

    @Test(groups = {"sanity"}, priority = 1)
    void CaptureVitalTest() throws InterruptedException {
        String username="admin", password="Admin123";
        String patientName="Ananth";
        String height="156",weight="70";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(username,password);

        CheckInPatient checkin = new CheckInPatient(driver);
        checkin.checkinPatient(patientName);

        CaptureVitalsPage captureVitalsPage = new CaptureVitalsPage(driver);
        captureVitalsPage.addVitals("156", "70", "40", "72", "14", "80", "120", "100");
        String Height= captureVitalsPage.getHeight();
        String Weight=captureVitalsPage.getWeight();
        Assert.assertEquals(Height, "156", "Height didn't match");
        Assert.assertEquals(Weight, "70", "Weight didn't match");
    }

    @Test(groups = {"sanity"}, priority = 2)
    void manageAccountTest() throws InterruptedException {
        String username="admin", Password="Admin123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(username,Password);
        String familyName="Cooper",givenName="Johnson",userName="johnsoncooper",password="Johnson@123";
        SystemAdministrationPage systemAdministrationPage = new SystemAdministrationPage(driver);
        systemAdministrationPage.gotomanageAccountPage();
        systemAdministrationPage.addAccount(familyName,givenName,userName,password, "Administers System");
//        Thread.sleep(4000);
        String expectedusername= systemAdministrationPage.getUserName(givenName+" "+familyName);
        Assert.assertEquals(expectedusername,givenName+" "+familyName,"Username doesn't match");
    }

    @Test(groups = {"sanity"}, priority = 3)
    void loginToAddedUserWithFalseCredentials() throws InterruptedException {
        String username="johnsoncooper", password="Johnson@12c";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(username,password);
        String message=loginPage.loginError();
        Assert.assertEquals(message,"Invalid username/password. Please try again.");
    }



    @Test(groups = {"sanity"}, priority = 4)
    void startVisitWorkFlowTest() throws InterruptedException {
        String username = "admin", Password = "Admin123";
        String patientName="Hemanth";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(username, Password);
        CheckInPatient checkin = new CheckInPatient(driver);
        checkin.checkinPatient(patientName);
        boolean active=checkin.getActivestatus();
        Assert.assertTrue(active);
    }

    @Test(groups = {"sanity"}, priority = 5)
    void EndVisitWorkFlowTest() throws InterruptedException {
        String username = "admin", Password = "Admin123";
        String patientName="Hemanth";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(username, Password);
        CheckInPatient checkoutPatient = new CheckInPatient(driver);
        boolean checkout=checkoutPatient.checkoutPatient(patientName);
        Assert.assertTrue(checkout);

    }
    @Test(groups = {"sanity"}, priority = 6)
    void changePasswordTest() throws InterruptedException {
        String currentUsername="hemanthnb3",currentPassword="Hemanth@123";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(currentUsername,currentPassword);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.gotoChangePasswordPage();
//        Thread.sleep(2000);
        changePasswordPage.changePassword(currentPassword,"Hemanth@321");
        Thread.sleep(3000);

        String newPassword="Hemanth@321";
        String username=changePasswordPage.loginWithModifiedCredentials(currentUsername,newPassword);
        Assert.assertEquals(username,currentUsername,"Changing password failed");
    }

    @Test(groups = {"sanity"}, priority = 7)
    void loginAfterModifyingPasswordWithFalseCredentials() throws InterruptedException {
        String username="hemanthnb3", password="Hemanth@111";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(username,password);
        String message=loginPage.loginError();
        Assert.assertEquals(message,"Invalid username/password. Please try again.");
    }

    @Test(groups = {"sanity"}, priority = 8)
    void editInformationTest() throws InterruptedException {
        String username="admin", password="Admin123";
        String patientName="Ananth";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(username,password);

        EditInformationPage editInformationPage = new EditInformationPage(driver);
        editInformationPage.editRegitrationInformation(patientName);
        String expectedName=editInformationPage.getName();

        Assert.assertEquals(expectedName,"Ananth Naik","Full name doesn't match");
    }




}
