package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckInPatient extends BasePage {
    WebDriver driver;
    public CheckInPatient(WebDriver driver){
        super(driver);
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

    public  boolean getActivestatus(){
        String status=driver.findElement(By.cssSelector("#content > div.patient-header.row > div.secondLineFragments.col-12.mt-2.mb-1 > div.active-visit-started-at-message")).getText();
        String[] parts = status.split("-");
        String activeVisitSubstring = parts[0].trim();
        // Extract the first part and trim any leading or trailing whitespace
        if(activeVisitSubstring.compareTo("Active Visit")==0){
            return  true;
        }
        return  false;
    }

    public boolean checkoutPatient(String patient) throws InterruptedException {
        SearchPatient searchPatient = new SearchPatient(driver);
        WebElement patientRecord=searchPatient.searchPatient(patient);
        patientRecord.click();
        driver.findElement(By.partialLinkText("End Visit")).click();
        driver.findElement(By.cssSelector("#end-visit-dialog > div.dialog-content > button.confirm.right")).click();
//        Thread.sleep(3000);
        WebElement startVisitButton=driver.findElement(By.partialLinkText("Start Visit"));
        pagewaits.waitForElementToBeVisible(startVisitButton);
        boolean val=startVisitButton.isDisplayed();
        return val;
    }
}
