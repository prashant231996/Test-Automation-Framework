package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();//Instance Variable==>Heap Memory
    private WebDriverWait wait;
    Logger logger= LoggerUtility.getLogger(this.getClass());

    public BrowserUtility(WebDriver driver)
    {
        super();
        this.driver.set(driver); //Initialize the instance variable driver!!!
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public BrowserUtility(String browserName)
    {
        logger.info("Launching browser name "+browserName);
        if(browserName.equalsIgnoreCase("chrome"))
        {
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
        }
        else {
            logger.error("Invalid Browser name.!! Enter Chrome or Edge only..");
            System.err.println("Invalid Browser name.!! Enter Chrome or Edge only..");
        }
        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30));
    }

    public BrowserUtility(Browser browserName)
    {
        logger.info("Launching browser name "+browserName);
        if(browserName==Browser.CHROME)
        {
            driver.set(new ChromeDriver());
        } else if (browserName==Browser.EDGE) {
            driver.set(new EdgeDriver());
        }else if (browserName==Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
        }
        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30));
    }

    public BrowserUtility(Browser browserName, boolean isHeadless)
    {
        logger.info("Launching browser name "+browserName);
        if(browserName==Browser.CHROME)
        {
            if(isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver.set(new ChromeDriver(options));
            }
            else {
                driver.set(new ChromeDriver());
            }
        } else if (browserName==Browser.EDGE) {
            if(isHeadless)
            {
                EdgeOptions edgeOptions=new EdgeOptions();
                edgeOptions.addArguments("--headless");
                driver.set(new EdgeDriver(edgeOptions));
            }
            else {
                driver.set(new EdgeDriver());
            }
        }else if (browserName==Browser.FIREFOX) {
            if(isHeadless)
            {
                FirefoxOptions options=new FirefoxOptions();
                options.addArguments("--headless");
                driver.set(new FirefoxDriver(options));
            }
            else
            {
                driver.set(new FirefoxDriver());
            }
        }
        wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30));
    }


    public WebDriver getDriver() {
        return driver.get();
    }

    public void gotToWebSite(String url)
    {
        driver.get().get(url);
    }

    public void maximizeBrowserWindow()
    {
        //maximize browser window
        logger.info("Maximize the browser window");
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator)
    {
        logger.info("Waiting for element to be clickable and click on element located by "+locator);
        //Clicking on web element
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void type(By locator, String inputText)
    {
        logger.info("Waiting for element to be visible and enter text into an element located by "+locator);
        //Typing text into the text box
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(inputText);
    }

    public boolean isElementDisplayed(By locator)
    {
        logger.info("Waiting for element to be displayed and element located by "+locator);
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    public String getVisibleText(By ele)
    {
        logger.info("Waiting for the element to be visible "+ele);
       return wait.until(ExpectedConditions.visibilityOfElementLocated(ele)).getText();
    }

    public String takeScreenShot(String fileName)
    {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH-mm-ss");
        String timeStamp=simpleDateFormat.format(date);
        String destFilePath=System.getProperty("user.dir")+"\\snapshots\\"+fileName+" - "+timeStamp+".png";
        File destFile=new File(destFilePath);
        TakesScreenshot ts=(TakesScreenshot) driver.get();
        File srcFile=ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destFilePath;
    }





}
