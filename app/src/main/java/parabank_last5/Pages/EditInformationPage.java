package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditInformationPage {
    WebDriver driver;

    public EditInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void editRegitrationInformation(String patient){
        SearchPatient searchPatient = new SearchPatient(driver);
        WebElement patientRecord=searchPatient.searchPatient(patient);
        patientRecord.click();
        driver.findElement(By.partialLinkText("Edit Registration Information")).click();
        driver.findElement(By.id("demographics-edit-link")).click();

        AddPatientPage addPatientPage = new AddPatientPage(driver);
        addPatientPage.setDemoGraphics("Ananth","Naik","6","2001");
        WebElement confirmButton= driver.findElement(By.id("registration-submit"));
        confirmButton.click();
        driver.findElement(By.id("relationships-info-edit-link")).click();
        addPatientPage.setRelationShip("Doctor");
        driver.findElement(By.id("registration-submit")).click();
        driver.findElement(By.id("contactInfo-edit-link")).click();
        addPatientPage.setAddress("Chikkaballapur","0987654321");
        driver.findElement(By.id("registration-submit")).click();


    }

}
