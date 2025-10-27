package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.constants.Browser.CHROME;
import static com.constants.Browser.EDGE;

public class TestBase {

    protected HomePage homePage;
    private boolean isLambdaTest;
    Logger logger= LoggerUtility.getLogger(this.getClass());
    @Parameters({"browser","isLambdaTest","isHeadless"})
    @BeforeMethod(description = "Load home page of the website")
    public void setUp( @Optional("chrome") String browser,
                       @Optional("false") boolean isLambdaTest,
                       @Optional("true") boolean isHeadless,ITestResult result)
    {
        logger.info("Inside Before Method implementation");
        WebDriver lambdaDriver=null;
        this.isLambdaTest=isLambdaTest;
        System.out.println("isLambdaTest "+isLambdaTest);
        System.out.println("browser "+browser);
        System.out.println("isHeadless "+isHeadless);
        System.out.println("test case name  "+result.getMethod().getMethodName());
        if(isLambdaTest)
        {
            logger.info("Inside lambda test intialization");
            lambdaDriver=LambdaTestUtility.initializeLamdaTestSession(browser,result.getMethod().getMethodName());
            homePage=new HomePage(lambdaDriver);
        }
        else {
            homePage=new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
        }
    }

    public BrowserUtility getInstance()
    {
        return homePage;
    }

    @AfterMethod(description = "Closing browser instances opened by automation script")
    public void tearDown()
    {
        if(isLambdaTest)
        {
            LambdaTestUtility.quiteSession(); //Quite or close browser sessions on lambda test
        }
        else {
            //drver.quite()=>Closing all the browser instances which are opened by automation script
            //driver.close()==>Close the currant browser which is in focus
            getInstance().getDriver().close();
        }

    }


}
