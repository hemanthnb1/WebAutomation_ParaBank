package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SystemAdministrationPage extends BasePage {
    WebDriver driver;
    public SystemAdministrationPage (WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void gotomanageAccountPage(){
        driver.findElement(By.partialLinkText("System Administration")).click();
        driver.findElement(By.partialLinkText("Manage Accounts")).click();
    }
    public void addAccount(String familyName,String givenName,String username,String password, String capbilities){
        driver.findElement(By.partialLinkText("Add New Account")).click();
        driver.findElement(By.id("adminui-familyName-field")).sendKeys(familyName);
        driver.findElement(By.id("adminui-givenName-field")).sendKeys(givenName);
        driver.findElement(By.id("adminui-gender-0-field")).click();
        driver.findElement(By.id("adminui-addUserAccount")).click();
        driver.findElement(By.id("adminui-username-field")).sendKeys(username);
        WebElement privilege= driver.findElement(By.id("adminui-privilegeLevel-field"));
        Select select = new Select(privilege);
        select.selectByVisibleText("High");
        driver.findElement(By.id("adminui-password-field")).sendKeys(password);
        driver.findElement(By.id("adminui-confirmPassword-field")).sendKeys(password);
        WebElement table = driver.findElement(By.className("adminui-display-table")).findElement(By.tagName("tbody"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        List<WebElement> cells = rows.get(0).findElements(By.tagName("td"));
        for (WebElement cell : cells) {
            if(cell.getText().equals("Administers System"))
            {
                System.out.println(cell.getText());
                cell.click();
                break;
            }
        }
        driver.findElement(By.id("adminui-capabilities-Application: Administers System")).click();
        driver.findElement(By.id("save-button")).click();
    }


    public String getUserName(String searchKey){


        WebElement searchBar= driver.findElement(By.cssSelector("#list-accounts_filter > label > input[type=text]"));
        pagewaits.waitForElementToBePresent(searchBar);
        searchBar.sendKeys(searchKey);

        WebElement table = driver.findElement(By.id("list-accounts")).findElement(By.tagName("tbody"));
        WebElement row=table.findElements(By.tagName("tr")).get(0);
        boolean flag=false;
        String actualUserName=null;
        actualUserName=row.findElements(By.tagName("td")).get(0).getText();
        return actualUserName;
        }
    }
