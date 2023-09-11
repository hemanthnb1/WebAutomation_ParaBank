package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
     public void Login(String Username, String Password) throws InterruptedException {

        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys(Username);
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys(Password);
        WebElement inpatientWard=driver.findElement(By.id("Inpatient Ward"));
        inpatientWard.click();
        Thread.sleep(2000);
        WebElement loginBtn=driver.findElement(By.id("loginButton"));
        loginBtn.click();
     }


}
