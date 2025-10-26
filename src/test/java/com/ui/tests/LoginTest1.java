package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class LoginTest1 {

    static WebDriver driver;

    public  static void main(String[] args)
    {
        //Accepting Insecure certificates
        ChromeOptions options=new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //Create browser session
        driver=new ChromeDriver(options);
//        BrowserUtility browserUtility=new BrowserUtility(driver);
//        browserUtility.gotToWebSite("http://www.automationpractice.pl/index.php");
//        browserUtility.maximizeBrowserWindow();
//        browserUtility.clickOn(By.xpath("//a[@title='Log in to your customer account']"));
//        browserUtility.type(By.cssSelector("#email"),"testpm@gmail.com");
//        browserUtility.type(By.id("passwd"),"testpm");
//        browserUtility.clickOn(By.id("SubmitLogin"));
//        Assert.assertTrue(browserUtility.isElementDisplayed(By.xpath("//*[text()='Prashanttest More']")));
//        browserUtility.clickOn(By.xpath("//*[contains(@class,'header')]//a[contains(text(),'Sign out')]"));
    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }


}
