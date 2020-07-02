package org.example.inputexcel.createscript;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.inputexcel.createscript.ScriptKind.CancelIssue;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ScriptSupplierFactoryTest {
    @Test
    void supplierFactoryTest() throws IOException {
        System.out.println("supplierFactoryTest");
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        ScriptSupplierFactory.registerSupplier("cancelissue",new CancelIssue(myExcelSheet));
        System.out.println(ScriptSupplierFactory.getScript("cancelIssue"));
        Assert.assertTrue(true);
    }
}
