package org.example.inputexcel.createscript;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.config.inputexcel.ClassAddress;
import org.example.config.inputexcel.ExcelSheets;
import org.example.inputexcel.ExcelFile;
import org.example.inputexcel.SaveScript;
import org.example.inputexcel.createscript.ScriptKind.CancelIssue;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ScriptSupplierFactoryTest {
    @Test
    void supplierFactoryTest() throws IOException {
        System.out.println("supplierFactoryTest");
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        ScriptSupplierFactory.registerSupplier("cancelissue",new CancelIssue(myExcelSheet));
        System.out.println(ScriptSupplierFactory.getScript("cancelIssue"));
        Script s=ScriptSupplierFactory.getScript("cancelIssue");
        System.out.println(s);
        Assert.assertTrue(true);
    }
    @Test
    void enumTest(){
        for(ExcelSheets excelsheet:ExcelSheets.values())
        {

                //call Script supplier factory class
//                Script scr=ScriptSupplierFactory.getScript(sheetName);
//                System.out.println(excelsheet.getSheetName());
                System.out.println(excelsheet);

        }
//        System.out.println(ExcelSheets.);
    }
    @Test
    void instantiateClassByName() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
//        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
//        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
//        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
////        Class<?> clazz=Class.forName("org.example.inputexcel.createscript.ScriptKind.CancelIssue");
//        Class<?> clazz=Class.forName(ClassAddress.CLASS_ADDRESS.getScriptAddress() +ExcelSheets.CancelIssue);
//        Constructor<?> constructor = clazz.getConstructor(Sheet.class);
//        Object instance = constructor.newInstance(myExcelSheet);
//        Script src=(Script)instance;
//        System.out.println(src);
//        ExcelFile2 exf=new ExcelFile2();
//        exf.Rea

        System.out.println(ExcelFile.read("C:\\Scripts\\UserExcel\\User_Midco1.xlsx"));

    }
    @Test
    void saveScriptTest() throws IOException {
        StringBuilder myString= ExcelFile.read("C:\\Scripts\\UserExcel\\User_Midco1.xlsx");
        System.out.println(myString);
        SaveScript.done(myString,"20211","C:\\Scripts\\");

    }
}
