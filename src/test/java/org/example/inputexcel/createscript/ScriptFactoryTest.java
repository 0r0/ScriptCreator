package org.example.inputexcel.createscript;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ScriptFactoryTest {
    @Test
    void createTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
//        ScriptFactory.create(myExcelSheet,"CancelIssue");
        ScriptFactory a=new ScriptFactory();
        System.out.println(a.create(myExcelSheet,"CancelIssue"));
    }
}
