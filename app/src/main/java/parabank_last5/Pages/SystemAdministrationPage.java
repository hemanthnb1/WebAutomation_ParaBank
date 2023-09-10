package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SystemAdministrationPage {
    WebDriver driver;
    public SystemAdministrationPage(WebDriver driver){
        this.driver=driver;
    }

    public void gotomanageAccountPage(){
        driver.findElement(By.partialLinkText("System Administration")).click();
        driver.findElement(By.partialLinkText("Manage Accounts")).click();
    }
    public void addAccount(){
        driver.findElement(By.partialLinkText("Add New Account")).click();
        driver.findElement(By.id("adminui-familyName-field")).sendKeys("Jones");
        driver.findElement(By.id("adminui-givenName-field")).sendKeys("Davy");
        driver.findElement(By.id("adminui-gender-0-field")).click();
        driver.findElement(By.id("adminui-addUserAccount")).click();
        driver.findElement(By.id("adminui-username-field")).sendKeys("davyjones");
        WebElement privilege= driver.findElement(By.id("adminui-privilegeLevel-field"));
        Select select = new Select(privilege);
        select.selectByVisibleText("High");
        driver.findElement(By.id("adminui-password-field")).sendKeys("Davy@123");
        driver.findElement(By.id("adminui-confirmPassword-field")).sendKeys("Davy@123");
        WebElement table = driver.findElement(By.className("adminui-display-table")).findElement(By.tagName("tbody"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        List<WebElement> cells = rows.get(0).findElements(By.tagName("td"));
        for (WebElement cell : cells) {
            if(cell.getText().equals("Administers System"))
            {
                cell.click();
                break;
            }
        }
        driver.findElement(By.id("save-button")).click();
    }
}
