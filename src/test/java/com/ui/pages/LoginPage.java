package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    private static final By EMIAL_TEXT_LOCATOR=By.cssSelector("#email");

    private static final By PASSWORD_TEXT_LOCATOR=(By.id("passwd"));

    private static final By SIGN_IN_BUTTON=By.id("SubmitLogin");

    private static final By ERROR_MSG_LOCATOR=By.xpath("//div[contains(@class,'alert-danger')]//li");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String emailAddress,String passwrod)
    {
         type(EMIAL_TEXT_LOCATOR,emailAddress);
         type(PASSWORD_TEXT_LOCATOR,passwrod);
         clickOn(SIGN_IN_BUTTON);
         return new MyAccountPage(getDriver());
    }

    public LoginPage doLoginWithInvalidCreds(String emailAddress,String passwrod)
    {
        type(EMIAL_TEXT_LOCATOR,emailAddress);
        type(PASSWORD_TEXT_LOCATOR,passwrod);
        clickOn(SIGN_IN_BUTTON);
        return new LoginPage(getDriver());
    }

    public String getErroMessage()
    {
        return getVisibleText(ERROR_MSG_LOCATOR);
    }

}

