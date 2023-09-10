package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class ChangePasswordPage {
    WebDriver driver;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void gotoChangePasswordPage() throws InterruptedException {
        WebElement hover=driver.findElement(By.xpath("/html/body/header/nav/div[2]/ul/li[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).perform();
        driver.findElement(By.partialLinkText("My Account")).click();
        driver.findElement(By.partialLinkText("Change Password")).click();
    }

    public  void changePassword(String oldPassword, String newPassword){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofMillis(10000));
        driver.findElement(By.id("oldPassword-field")).sendKeys(oldPassword);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("oldPassword-field")));
        driver.findElement(By.id("newPassword-field")).sendKeys(newPassword);
        driver.findElement(By.id("confirmPassword-field")).sendKeys(newPassword);
        driver.findElement(By.id("save-button")).click();

    }
}
