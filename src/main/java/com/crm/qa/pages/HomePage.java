package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import io.qameta.allure.Step;
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
    @Step("getting Home page Title step... ")
    public String HomePageTitle(){
        return driver.getTitle();
    }


    @Step("getting current user Title step... ")
    public boolean verifyCurrentUser(){
        return userNameLabel.isDisplayed();

    }
    @Step("clicking on contact page link step... ")
    public ContactPage clickOnContactPage(){
        contactsLink.click();
        return new ContactPage();
    }

    @Step("clicking on dealPage page link step... ")
    public DealPage clickOnDealPage(){
        dealsLink.click();
        return new DealPage();
    }
    @Step("clicking on TaskPage link step... ")
    public TaskPage clickOnTaskPage(){
        tasksLink.click();
        return new TaskPage();
    }




}
