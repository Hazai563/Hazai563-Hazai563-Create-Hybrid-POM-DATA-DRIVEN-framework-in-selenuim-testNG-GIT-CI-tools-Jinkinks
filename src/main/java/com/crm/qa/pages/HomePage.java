package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath = "//span[contains(text(),'Hazari Arshi')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//span[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//span[contains(text(),'Tasks')]")
    WebElement tasksLink;


    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    public String HomePageTitle(){
        return driver.getTitle();
    }



    public boolean verifyCurrentUser(){
        return userNameLabel.isDisplayed();

    }

    public ContactPage clickOnContactPage(){
        contactsLink.click();
        return new ContactPage();
    }


    public DealPage clickOnDealPage(){
        dealsLink.click();
        return new DealPage();
    }

    public TaskPage clickOnTaskPage(){
        tasksLink.click();
        return new TaskPage();
    }




}
