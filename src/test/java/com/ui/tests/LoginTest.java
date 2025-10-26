package com.ui.tests;

import com.dataproviders.LoginDataProvider;
import com.ui.listners.MyRetryAnalyzer;
import com.ui.listners.TestListner;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.EDGE;
import static org.testng.Assert.assertEquals;

@Listeners({TestListner.class})
public class LoginTest extends TestBase{


    @Test(description = "Verify valid user is able to login", groups = {"e2e","sanity"},dataProviderClass = LoginDataProvider.class,dataProvider = "LoginTestData")
    public  void loginMethod(User user)
    {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAdresss(), user.getPassword()).getUsername(),"Prashanttest More");
    }

    @Test(description = "Verify valid user is able to login", groups = {"e2e","sanity"},dataProviderClass = LoginDataProvider.class,dataProvider = "LoginCsvTestData")
    public  void loginCSVMethod(User user)
    {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAdresss(), user.getPassword()).getUsername(),"Prashanttest More");
    }

    @Test(description = "Verify valid user is able to login", groups = {"e2e","sanity"},dataProviderClass = LoginDataProvider.class,dataProvider = "LoginExcelTestData",
    retryAnalyzer = MyRetryAnalyzer.class)
    public  void loginExcelMethod(User user)
    {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAdresss(), user.getPassword()).getUsername(),"Prashanttest More");
    }



}
