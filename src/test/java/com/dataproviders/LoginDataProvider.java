package com.dataproviders;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CsvReaderUtility;
import com.utility.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name="LoginTestData")
    public Iterator<Object> loginDataProvider() throws FileNotFoundException {
        Gson gson=new Gson();
        File testDataFile=new File(System.getProperty("user.dir")+"\\testData\\logindata.json");
        FileReader fileReader=new FileReader(testDataFile);
        TestData testData=gson.fromJson(fileReader, TestData.class);
        List<Object> dataToReturn=new ArrayList<>();
        for(User user:testData.getData())
        {
            dataToReturn.add(user);
        }
        return dataToReturn.iterator();
    }

    @DataProvider(name="LoginCsvTestData")
    public Iterator<User> loginCsvDataProvider()
    {
        return CsvReaderUtility.readCsvFile("logindata.csv");
    }

    @DataProvider(name="LoginExcelTestData")
    public Iterator<User> loginExcelDataProvider()
    {
        return ExcelReaderUtility.readExcelFile("logindata.xlsx");
    }
}
