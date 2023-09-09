package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaptureVitalsPage {
    WebDriver driver;
    public CaptureVitalsPage(WebDriver driver){
        this.driver=driver;
    }

    public void addVitals()
    {
        driver.findElement(By.cssSelector("#referenceapplication\\.realTime\\.vitals")).click();
        driver.findElement(By.id("w8")).sendKeys("156");
        WebElement next= driver.findElement(By.id("next-button"));
        next.click();
        driver.findElement(By.id("w10")).sendKeys("70");
        next.click();
        next.click();
        driver.findElement(By.id("w12")).sendKeys("40");
        next.click();
        driver.findElement(By.id("w14")).sendKeys("72");
        next.click();
        driver.findElement(By.id("w16")).sendKeys("14");
        next.click();
        driver.findElement(By.id("w18")).sendKeys("80");
        driver.findElement(By.id("w20")).sendKeys("120");
        next.click();
        driver.findElement(By.id("w22")).sendKeys("100");
        next.click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/form/div[2]/div/p[1]/button")).click();

    }
}
