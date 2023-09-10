package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPatient {
    WebDriver driver;
    public SearchPatient(WebDriver driver){
        this.driver=driver;
    }
    public WebElement searchPatient(String patient){
        driver.findElement(By.xpath("/html/body/div/div[3]/div[3]/div/a[1]")).click();
        driver.findElement(By.id("patient-search")).sendKeys(patient);
        WebElement table = driver.findElement(By.id("patient-search-results-table")).findElement(By.tagName("tbody"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        List<WebElement> cells = rows.get(0).findElements(By.tagName("td"));
        System.out.println(cells.get(1).getText());
        return cells.get(1);
    }


}
