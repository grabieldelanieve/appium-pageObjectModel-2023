package com.qa.tests;

import com.qa.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void beforeClass() {

    }

    @AfterClass
    public void AfterClass() {

    }

    @BeforeMethod
    public void beforeMethod(Method m) {
        System.out.println("\n" + "****** starting test:  " + m.getName() + "  ******" + "\n");
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void AfterMethod() {

    }

    @Test
    public void invalidUserName() {

        loginPage.enterUserName("incorrectusername");
        loginPage.enterPassword("secret_sauce");
        loginPage.pressLoginBtn();

        String expectedErrTxt = "Username and password do not match any user in this service.";
        String actualErrTxt = loginPage.getErrTxt();

        Assert.assertEquals(actualErrTxt, expectedErrTxt);
    }

    @Test
    public void invalidPassword() {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("incorrectpassword");
        loginPage.pressLoginBtn();

        String expectedErrTxt = "Username and password do not match any user in this service.";
        String actualErrTxt = loginPage.getErrTxt();

        Assert.assertEquals(actualErrTxt, expectedErrTxt);
    }

    @Test
    public void successlogIn() {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        productsPage = loginPage.pressLoginBtn();

        String actualProductTitle = loginPage.getProductsTitle();
        String expectedProductTitle = "PRODUCTS";
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
    }

}
