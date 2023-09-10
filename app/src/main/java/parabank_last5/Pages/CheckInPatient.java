package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckInPatient {
    WebDriver driver;
    public CheckInPatient(WebDriver driver){
        this.driver=driver;
    }

    public void checkinPatient(String patient) throws InterruptedException {
        SearchPatient searchPatient = new SearchPatient(driver);
        WebElement patientRecord=searchPatient.searchPatient(patient);
        patientRecord.click();
        driver.findElement(By.partialLinkText("Start Visit")).click();
        driver.findElement(By.id("start-visit-with-visittype-confirm")).click();
        Thread.sleep(10000);
    }
}
