package com.crm.qa.tests;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password") );
    }

    @Test(priority = 1, description = "HomePage verify title test")
    @Severity(SeverityLevel.NORMAL)
    @Description("HomePage verify title test")
    @Story("ST-001: User shall be able to login.")
    public void verifyHomePageTitleTest(){
        String homePageTitle =  homePage.HomePageTitle();
        Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page title not matched!");

    }

    @Test(priority = 2, description ="verify current user title " )
    @Severity(SeverityLevel.NORMAL)
    @Description("verify current user title ")
    @Story("ST-001: User shall be able to login.")
    public void verifyCurrentUser(){
        Assert.assertTrue(homePage.verifyCurrentUser());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
