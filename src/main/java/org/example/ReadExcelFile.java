package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.*;



public class ReadExcelFile {

    public static void readExcel(String fileAddress)
    {
        try {
//            get excel file  from address
            FileInputStream file=new FileInputStream(new File(fileAddress));
//                create excel workbook with the excel file
                XSSFWorkbook workbook=new XSSFWorkbook(file);
                //print excel file
                System.out.println(workbook);




        }catch(FileNotFoundException e)
        {
            System.out.printf("file not Exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileAddress);
    }
}