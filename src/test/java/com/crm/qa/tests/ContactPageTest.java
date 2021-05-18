package com.crm.qa.tests;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ContactPage contactPage;
    TestUtils testUtils;
    String sheetName = "Contacts";

    public ContactPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();

        loginPage = new LoginPage();
        homePage = new HomePage();
        contactPage= new ContactPage();
        testUtils =  new TestUtils();

        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        contactPage = homePage.clickOnContactPage();

    }

    @DataProvider
    public Object[][] getCRMTestDATA(){
        Object data[][] = TestUtils.getTestDATA(sheetName);
        return data;
    }

    @Test(priority = 1, dataProvider = "getCRMTestDATA")
    public void CreateNewContactTest(String firstName, String lastName, String address){
        testUtils.sleep();
        contactPage.CreateNewContactLink();
        contactPage.createNewContact(firstName, lastName,address);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
