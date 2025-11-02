package com.ui.tests;

import com.ui.listners.MyRetryAnalyzer;
import com.ui.listners.TestListner;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({TestListner.class})
public class InvalidCredsLoginTest extends TestBase {

    private static final String invalidEmailAdrress="test12345@gmail.com";
    private static final String invalidPassword="test12345";

    @Test(description = "Verify proper errorm mesage is shown when user enters invalid creds", groups = {"e2e","sanity"},retryAnalyzer = MyRetryAnalyzer.class)
    public  void loginWithInvalidCreds()
    {
        logger.info("Test case is started");
        assertEquals(homePage.goToLoginPage().doLoginWithInvalidCreds(invalidEmailAdrress,invalidPassword).getErroMessage(),"Authentication failed.");
        logger.info("Test case is completed");
    }
}
