package com.utility;

import com.ui.pojo.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelFile(String fileName)
    {
        File file=new File(System.getProperty("user.dir")+"//testData//"+fileName);
        FileInputStream fis=null;
        XSSFWorkbook wb=null;
        XSSFSheet sheet=null;
        Iterator<Row>rowIterator=null;
        List<User> userList=null;
        Row row;
        Cell emailAdressCell;
        Cell passwordCell;
        User user;
        try {
             fis=new FileInputStream(file);
             wb=new XSSFWorkbook(fis);
             sheet=wb.getSheet("LoginTestData");
             rowIterator=sheet.iterator();
             rowIterator.next();//Skippping the column header or 1st row !
             userList=new ArrayList<User>();
            while(rowIterator.hasNext())
            {
                row=rowIterator.next();
                emailAdressCell=row.getCell(0);
                passwordCell=row.getCell(1);
                user=new User(emailAdressCell.toString(),passwordCell.toString());
                userList.add(user);
            }
            return userList.iterator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                wb.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
