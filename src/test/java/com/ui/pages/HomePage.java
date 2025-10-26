package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtil.*;

import static com.utility.JSONUtility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {

  private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[@title='Log in to your customer account']");

    public HomePage(Browser browserName) {
        super(browserName);//To call parent class constructor from child class constructor
        //gotToWebSite(readProperty(QA,"URL"));
        gotToWebSite(readJson(QA).getUrl());
        maximizeBrowserWindow();
    }

    public HomePage(Browser browserName,boolean isHeadless) {
        super(browserName,isHeadless);//To call parent class constructor from child class constructor
        //gotToWebSite(readProperty(QA,"URL"));
        gotToWebSite(readJson(QA).getUrl());
        maximizeBrowserWindow();
    }

    public HomePage(WebDriver lambdaDriver) {
        super(lambdaDriver);
        gotToWebSite(readJson(QA).getUrl());
        maximizeBrowserWindow();
    }

    public LoginPage goToLoginPage()
  {
     clickOn(SIGN_IN_LINK_LOCATOR);
     return new LoginPage(getDriver());
  }


}
