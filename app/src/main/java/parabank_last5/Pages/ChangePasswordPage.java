package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangePasswordPage extends BasePage{
    WebDriver driver;

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
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

        WebElement inputOldpassword=driver.findElement(By.id("oldPassword-field"));
        pagewaits.waitForElementToBePresent(inputOldpassword);
        inputOldpassword.sendKeys(oldPassword);
        driver.findElement(By.id("newPassword-field")).sendKeys(newPassword);
        driver.findElement(By.id("confirmPassword-field")).sendKeys(newPassword);
        driver.findElement(By.id("save-button")).click();

    }

    public String loginWithModifiedPassword(String userName, String password) throws InterruptedException {
        WebElement logout=driver.findElement(By.partialLinkText("Logout"));
        pagewaits.waitForElementToBeVisible(logout);
        logout.click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(userName,password);
        String temp=driver.findElement(By.cssSelector("#content > div:nth-child(2) > div > h4")).getText();
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(temp);
        String substring=null;
        if (matcher.find()) {
             substring = matcher.group(1);
            System.out.println(substring); // Output: davyjon
        }
        return substring;
}


}
