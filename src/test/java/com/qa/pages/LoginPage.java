package com.qa.pages;

import com.qa.BaseTest;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {

    @AndroidFindBy(accessibility = "test-Username")
    private WebElement userNameTxtFld;

    @AndroidFindBy(accessibility = "test-Password")
    private WebElement passwordTxtFld;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement loginBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement errTxt;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/preceding-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private WebElement productsTitle;

    public LoginPage enterUserName(String username){
        sendKeys(userNameTxtFld, username);
        // Fluent Page Object Model -
        // In order to keep the same context we return this... but if you'll go toward another page you should to return this new page
        return this;
    }

    public LoginPage enterPassword(String password){
        sendKeys(passwordTxtFld, password);
        return this;
    }

    public ProductsPage pressLoginBtn() {
        click(loginBtn);
        return new ProductsPage();
    }

    public String getErrTxt(){

        return getAttribute(errTxt, "text");
    }

    public String getProductsTitle(){
        return getAttribute(productsTitle, "text");
    }
}
