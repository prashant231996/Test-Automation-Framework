package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class LoginTest2 {

    static WebDriver driver;

    public  static void main(String[] args)
    {
        //Accepting Insecure certificates
        ChromeOptions options=new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //Create browser session
        driver=new ChromeDriver(options);
        HomePage homePage=new HomePage(Browser.CHROME);
        LoginPage loginPage=homePage.goToLoginPage();
        MyAccountPage myAccountPage=loginPage.doLoginWith("testpm@gmail.com","testpm");
    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }


}
