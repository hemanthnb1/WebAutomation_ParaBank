package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaptureVitalsPage extends BasePage{
    WebDriver driver;
    public CaptureVitalsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void addVitals(String... vitals) throws InterruptedException {

        WebElement captureVitalsButton=driver.findElement(By.cssSelector("#referenceapplication\\.realTime\\.vitals"));
        pagewaits.waitForElementToBePresent(captureVitalsButton);
        captureVitalsButton.click();
        driver.findElement(By.id("w8")).sendKeys(vitals[0]);
        WebElement next= driver.findElement(By.id("next-button"));
        next.click();
        driver.findElement(By.id("w10")).sendKeys(vitals[1]);
        next.click();
        next.click();
        driver.findElement(By.id("w12")).sendKeys(vitals[2]);
        next.click();
        driver.findElement(By.id("w14")).sendKeys(vitals[3]);
        next.click();
        driver.findElement(By.id("w16")).sendKeys(vitals[4]);
        next.click();
        driver.findElement(By.id("w18")).sendKeys(vitals[5]);
        driver.findElement(By.id("w20")).sendKeys(vitals[6]);
        next.click();
        driver.findElement(By.id("w22")).sendKeys(vitals[7]);
        next.click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/form/div[2]/div/p[1]/button")).click();
        Thread.sleep(6000);


        WebElement getVitals = driver.findElement(By.className("viewEncounter"));
        pagewaits.waitForElementToBeVisible(getVitals);
        getVitals.click();
    }

    public String getHeight(){

        WebElement height = driver.findElement(By.xpath("/html/body/div/div[3]/htmlform/section/fieldset[1]/p/span/span[1]"));
       pagewaits.waitForElementToBePresent(height);
        String Height=height.getText();
        return Height;
    }
    public String getWeight(){
        String weight = driver.findElement(By.xpath("/html/body/div/div[3]/htmlform/section/fieldset[2]/p/span/span[1]")).getText();
        return weight;
    }
}
