package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditInformationPage extends BasePage{
    WebDriver driver;

    public EditInformationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void editRegitrationInformation(String patient) throws InterruptedException {
        SearchPatient searchPatient = new SearchPatient(driver);
        WebElement patientRecord=searchPatient.searchPatient(patient);
        patientRecord.click();
        driver.findElement(By.partialLinkText("Edit Registration Information")).click();
        driver.findElement(By.id("demographics-edit-link")).click();

        AddPatientPage addPatientPage = new AddPatientPage(driver);
        addPatientPage.setDemoGraphics("Ananth","Naik","6","2010");
        WebElement confirmButton= driver.findElement(By.id("registration-submit"));
        confirmButton.click();
        driver.findElement(By.id("relationships-info-edit-link")).click();
        addPatientPage.setRelationShip("Parent");
        driver.findElement(By.id("registration-submit")).click();
        driver.findElement(By.id("contactInfo-edit-link")).click();
        addPatientPage.setAddress("hmt","0987654321");
        driver.findElement(By.id("registration-submit")).click();
    }
    public String getName(){
        String fullname=driver.findElement(By.cssSelector("#content > div.dashboard.clear.row > div.col-12.col-lg-9 > div > div:nth-child(1) > div:nth-child(1) > div.info-body.summary-section > div:nth-child(1) > p")).getText();
        fullname+=" "+driver.findElement(By.cssSelector("#content > div.dashboard.clear.row > div.col-12.col-lg-9 > div > div:nth-child(1) > div:nth-child(1) > div.info-body.summary-section > div:nth-child(3) > p")).getText();
    return fullname;
    }



}
