package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage  extends TestBase {

    @FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]")
    WebElement addNewContact;

    @FindBy(name= "first_name")
    WebElement firstName;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(name ="address")
    WebElement userAddress;

    @FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]")
    WebElement newContactSaveButton;

    public ContactPage(){
        PageFactory.initElements(driver, this);
    }


    public void CreateNewContactLink(){
        addNewContact.click();
    }

    public void createNewContact(String fName, String lName, String address){
//        Select select = new Select(driver.findElement(By.name(status)));
//        select.selectByVisibleText(status);

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        userAddress.sendKeys(address);

        newContactSaveButton.click();


    }



}
