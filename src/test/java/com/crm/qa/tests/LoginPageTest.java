package com.crm.qa.tests;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;
import java.io.Console;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
//    Logger log = Logger.getLogger(LoginPageTest.class);

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }
    @Test(priority = 1, description = "Login page Test Verify title")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login page verify title test")
    @Story("ST-001: User shall be able to login.")
    public void loginPageTitleTest(){
//        log.info("****************************** starting test login page title *****************************************");
        String title =  loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"#1 Free CRM customer relationship management software cloud");

    }
    @Test(priority = 2, description = "Login page verify title test")
    @Severity(SeverityLevel.BLOCKER)
    @Description("perform Login")
    @Story("ST-001: User shall be able to login.")
    public void LoginTest(){
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
