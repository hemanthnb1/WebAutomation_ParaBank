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

    public void checkinPatient(String Patient) throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/a[1]")).click();
        driver.findElement(By.id("patient-search")).sendKeys(Patient);
        WebElement table = driver.findElement(By.id("patient-search-results-table"));
        WebElement body=table.findElement(By.tagName("tbody"));
        List<WebElement>rows=body.findElements(By.tagName("tr"));
        System.out.println(rows.size());
            List<WebElement> cells = rows.get(0).findElements(By.tagName("td"));
            System.out.println(cells.get(1).getText());
        cells.get(1).click();
        driver.findElement(By.partialLinkText("Start Visit")).click();
        driver.findElement(By.id("start-visit-with-visittype-confirm")).click();
        Thread.sleep(10000);
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[9]/div/div[1]/div[3]/div[1]/div[2]/a[4]")).click();
//        driver.findElement(By.partialLinkText(" Capture Vitals")).click();
//        driver.findElement(By.cssSelector("#referenceapplication\\.realTime\\.vitals")).click();
//        driver.findElement(By.id("w8")).sendKeys("156");
//        WebElement next= driver.findElement(By.id("next-button"));
//        next.click();
//        driver.findElement(By.id("w10")).sendKeys("70");
//        next.click();
//        next.click();
//        driver.findElement(By.id("w12")).sendKeys("40");
//        next.click();
//        driver.findElement(By.id("w14")).sendKeys("72");
//        next.click();
//        driver.findElement(By.id("w16")).sendKeys("14");
//        next.click();
//        driver.findElement(By.id("w18")).sendKeys("80");
//        driver.findElement(By.id("w20")).sendKeys("120");
//        next.click();
//        driver.findElement(By.id("w22")).sendKeys("100");
//        next.click();
//        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[4]/form/div[2]/div/p[1]/button")).click();
    }
}
