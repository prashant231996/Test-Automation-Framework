package com.ui.listners;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

    /*
       MyRetryAnalyzer class will be called only if test case is failed.
     */
    //private static final int MAX_NUMBER_OF_ATTEMPT= Integer.parseInt(PropertiesUtil.readProperty(Env.DEV,"MAX_NUMBER_OF_ATTEMPT"));

    private static final int MAX_NUMBER_OF_ATTEMPT= JSONUtility.readJson(Env.DEV).getMAX_NUMBER_OF_ATTEMPT();

    private static int currantAttempt=1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(currantAttempt<=MAX_NUMBER_OF_ATTEMPT)
        {
            currantAttempt++;
            return true;  //Execute Failed test or Rerun failed test case again
        }
        return false;   //Mark test case as Fail
    }
}
