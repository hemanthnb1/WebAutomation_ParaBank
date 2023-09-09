package parabank_last5.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddPatientPage {
    WebDriver driver;
    public AddPatientPage(WebDriver driver){
        this.driver=driver;
    }

   public void registerPatient(String firstName, String familyName, String date, String year, String addressnum1,String phNo) throws InterruptedException {
        driver.findElement(By.partialLinkText("Register a patient")).click();
        Thread.sleep(2000);
        WebElement fistname=driver.findElement(By.name("givenName"));
        fistname.sendKeys(firstName);
        WebElement familyname=driver.findElement(By.name("familyName"));
        familyname.sendKeys(familyName);
        WebElement next= driver.findElement(By.id("next-button"));
        next.click();
        WebElement gender=driver.findElement(By.id("gender-field"));
        Select select= new Select(gender);
        select.selectByVisibleText("Male");
        next.click();

//        WebElement birthdayIcon=driver.findElement(By.xpath("/html/body/div/div[3]/form/ul/li[1]/ul/li[3]"));
//        birthdayIcon.click();

        WebElement birthdayDate= driver.findElement(By.id("birthdateDay-field"));
        birthdayDate.sendKeys(date);
        WebElement birthdayMonth= driver.findElement(By.id("birthdateMonth-field"));
        Select selectMonth= new Select(birthdayMonth);
        selectMonth.selectByVisibleText("March");
        WebElement birthdayYear= driver.findElement(By.id("birthdateYear-field"));
        birthdayYear.sendKeys(year);
        next.click();

        WebElement address1=driver.findElement(By.id("address1"));
        address1.sendKeys(addressnum1);
        next.click();

        WebElement phonenum=driver.findElement(By.name("phoneNumber"));
        phonenum.sendKeys(phNo);
        next.click();

        WebElement relationship= driver.findElement(By.id("relationship_type"));
        Select selectRelationShip= new Select(relationship);
        selectRelationShip.selectByVisibleText("Parent");
        next.click();
        WebElement confirmButton= driver.findElement(By.id("confirmationQuestion"));
        confirmButton.click();
        driver.navigate().to("https://demo.openmrs.org/openmrs/index.htm");
    }
}
