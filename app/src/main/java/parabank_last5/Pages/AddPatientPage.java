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


    public void setDemoGraphics(String... basicdetails){
         WebElement fistname=driver.findElement(By.name("givenName"));
         fistname.clear();
         fistname.sendKeys(basicdetails[0]);
         WebElement familyname=driver.findElement(By.name("familyName"));
         familyname.clear();
         familyname.sendKeys(basicdetails[1]);
         WebElement next= driver.findElement(By.id("next-button"));
         next.click();
         WebElement gender=driver.findElement(By.name("gender"));
         Select select= new Select(gender);
         select.selectByVisibleText("Male");
         next.click();
         WebElement birthdayDate= driver.findElement(By.id("birthdateDay-field"));
         birthdayDate.clear();
         birthdayDate.sendKeys(basicdetails[2]);
         WebElement birthdayMonth= driver.findElement(By.id("birthdateMonth-field"));
         Select selectMonth= new Select(birthdayMonth);
         selectMonth.selectByVisibleText("March");
         WebElement birthdayYear= driver.findElement(By.id("birthdateYear-field"));
         birthdayYear.clear();
         birthdayYear.sendKeys(basicdetails[3]);
         next.click();
    }

    public void setAddress(String... contact){
         WebElement next= driver.findElement(By.id("next-button"));
         WebElement address1=driver.findElement(By.id("address1"));
         address1.clear();
         address1.sendKeys(contact[0]);
         next.click();
         WebElement phonenum=driver.findElement(By.name("phoneNumber"));
         phonenum.clear();
         phonenum.sendKeys(contact[1]);
         next.click();
    }

    public void setRelationShip(String relationShip){
         WebElement relationship= driver.findElement(By.id("relationship_type"));
         Select selectRelationShip= new Select(relationship);
         selectRelationShip.selectByVisibleText(relationShip);
         WebElement next= driver.findElement(By.id("next-button"));
         next.click();
    }


   public void registerPatient(String firstName, String familyName, String date, String year, String addressnum1,String phNo, String relationship) throws InterruptedException {
        driver.findElement(By.partialLinkText("Register a patient")).click();
        Thread.sleep(2000);
        setDemoGraphics(firstName,familyName,date,year);
        setAddress(addressnum1,phNo);
        setRelationShip(relationship);
        WebElement confirmButton= driver.findElement(By.id("submit"));
        confirmButton.click();

    }
}
