package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest3 {

        /*
           Test Method Good Practices
           1) Test Script small
           2) You can not have conditional statements or loops or try catch in ur test methods
           3) Reduce the use of local variables
           4) Atleast one assertion in test method
         */

    HomePage homePage;

    @BeforeMethod(description = "Load home page of the website")
    public void setUp()
    {
        homePage=new HomePage(EDGE);
    }


    @Test(description = "Verify valid user is able to login", groups = {"e2e","sanity"})
    public  void loginMethod()
    {
        assertEquals(homePage.goToLoginPage().doLoginWith("testpm@gmail.com","testpm").getUsername(),"Prashanttest More");
    }

}
