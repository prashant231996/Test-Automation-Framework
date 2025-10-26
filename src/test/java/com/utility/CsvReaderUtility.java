package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvReaderUtility {

    public static Iterator<User> readCsvFile(String fileName){
        File file=new File(System.getProperty("user.dir")+"\\testData\\"+fileName);
        FileReader fileReader= null;
        CSVReader csvReader=null;
        String[] data=null;
        List<User> userList=null;
        User user;
        try {
            fileReader = new FileReader(file);
            csvReader=new CSVReader(fileReader);
            csvReader.readNext(); //Reading the column headers ---Row 1 skip the header row
            userList=new ArrayList<>();
            while((data=csvReader.readNext())!=null)
            {
                user=new User(data[0],data[1]);
                userList.add(user);
            }
        } catch (CsvValidationException | IOException e  ) {
            throw new RuntimeException(e);
        }
       return userList.iterator();
    }
}
