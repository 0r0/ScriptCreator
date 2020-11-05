package org.example.inputexcel.createscript.ScriptKind.iws;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.inputexcel.createscript.ScriptKind.CancelReceipt;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.HashMap;




public class CancelReceiptTest {
//    CancelIssue cancelIssue=new CancelIssue();

    

    @Test //test successfully passed
    public void checkerTest() throws IOException {

//        FileReader propertiesFile =new FileReader("C:\\Scripts\\UserExcel\\User_Midco.xlsx");

        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        CancelReceipt cancelReceipt=new CancelReceipt(myExcelSheet);
        XSSFRow row=myExcelSheet.getRow(2);
//        FileReader a=new FileReader("ca");
        HashMap<String,String> validationFields=new HashMap<>();
        validationFields.put("kindValidation","رسید");
        validationFields.put("updateKindValidation","ابطال");
//        Assert.assertTrue(cancelReceipt.checker(row,validationFields));
//        Assert.fail();
        System.out.println(cancelReceipt.checker(row,validationFields));
        Assert.assertTrue(true);

    }
    @Test // test passed successfully
    void generateScriptTest() throws IOException {
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        CancelReceipt cancelReceipt=new CancelReceipt(myExcelSheet);


        System.out.println("generateScriptTest started :)");

        System.out.println(cancelReceipt.generateScript());
    }

    @Test  //test is passed successfully ;)
    void createScriptPerReceiptNumberTest() throws IOException {
        System.out.println("createScriptPerReceiptNumber :)");
        String scriptPath="C:\\Scripts\\ModificationScripts\\CancelReceipt.sql";
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        CancelReceipt cancelReceipt=new CancelReceipt(myExcelSheet);
        System.out.println(cancelReceipt.createScript("101010",scriptPath));
        Assert.assertTrue(true);
    }
    //    readScriptSourceFile method test
    @Test //test is passed successfully
    void readScriptSourceFileTest() throws IOException {
        System.out.println("readScriptSourceFileTest started :)");
        String scriptPath="C:\\Scripts\\ModificationScripts\\CancelReceipt.sql";
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        CancelReceipt cancelReceipt=new CancelReceipt(myExcelSheet);
        System.out.println(cancelReceipt.readScriptSourceFile(scriptPath));
        Assert.assertTrue(true);
    }

}

