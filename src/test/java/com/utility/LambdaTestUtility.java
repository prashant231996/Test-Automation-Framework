package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestUtility {
    public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<WebDriver>();
    private static ThreadLocal<DesiredCapabilities> capabilitiesLocal=new ThreadLocal<>();

    public static WebDriver initializeLamdaTestSession(String browser,String testName)
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "prashantmoresdet");
        ltOptions.put("accessKey", "LT_cDVyopFRPL1ZRslPDcdFLbO1ABh2NuaxGHUTaFbD2DjsV5h");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        try {
            driverLocal.set(new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
       return driverLocal.get();
    }

    public static void quiteSession()
    {
        if(driverLocal.get()!=null)
        {
            driverLocal.get().quit();
        }
    }


}
