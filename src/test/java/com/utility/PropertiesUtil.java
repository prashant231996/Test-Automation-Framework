package com.utility;

import com.constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    //Read properties file

    public static String readProperty(Env env,String propertyName){
        File file = new File(System.getProperty("user.dir") + "\\config\\"+env+".properties");
        FileReader fileReader= null;
        Properties prop=new Properties();
        try {
            fileReader = new FileReader(file);
            prop.load(fileReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
       return prop.getProperty(propertyName.toUpperCase());
    }

}
