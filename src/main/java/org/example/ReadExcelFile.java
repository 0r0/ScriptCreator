package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel

import javafx.application.HostServices;

import org.apache.poi.xssf.usermodel.*;



public class ReadExcelFile {
//    public void
    public static void readExcel(String fileAddress)
    {
        try {
            FileInputStream file=new FileInputStream(new File(fileAddress));

        XSSFWorkbook workbook=new XSSFWorkbook(file);
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