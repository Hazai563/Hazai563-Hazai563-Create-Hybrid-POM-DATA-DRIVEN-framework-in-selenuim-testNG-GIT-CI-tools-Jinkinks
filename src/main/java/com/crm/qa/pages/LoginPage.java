package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //page Factory -

    @FindBy(xpath = "//header/div[1]/nav[1]/div[2]/div[1]/a[1]/span[1]")
    WebElement logInPage;


    @FindBy(name = "email")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//*[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]")
    WebElement loginBtn;


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public HomePage login(String usr, String pass){

        logInPage.click();
        username.sendKeys(usr);
        password.sendKeys(pass);
        loginBtn.click();

        return new HomePage();

    }



}
