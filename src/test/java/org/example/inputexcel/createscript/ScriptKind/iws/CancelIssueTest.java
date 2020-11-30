package org.example.inputexcel.createscript.ScriptKind.iws;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.inputexcel.createscript.Script;
import org.example.inputexcel.createscript.ScriptKind.CancelIssue;
import org.example.outputexcel.ExcelCreator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.HashMap;
import java.util.Properties;


public class CancelIssueTest {
    public CancelIssueTest() throws FileNotFoundException {
    }
//    CancelIssue cancelIssue=new CancelIssue();






    @Test
    public void checkerTest() throws IOException {

//        FileReader propertiesFile =new FileReader("C:\\Scripts\\UserExcel\\User_Midco.xlsx");

        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        CancelIssue cancelIssue=new CancelIssue(myExcelSheet);
        XSSFRow row=myExcelSheet.getRow(1);
//        FileReader a=new FileReader("ca");
        HashMap<String,String> validationFields=new HashMap<>();
        validationFields.put("kindValidation","حواله");
        validationFields.put("updateKindValidation","ابطال");
        Assert.assertTrue(cancelIssue.checker(row,validationFields));
//        Assert.fail();
//        Assert.assertTrue(true);
        System.out.println("a");
    }
    @Test
    void generateScriptTest() throws IOException {
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        CancelIssue cancelIssue=new CancelIssue(myExcelSheet);


        System.out.println("generateScriptTest started :)");

        System.out.println(cancelIssue.generateScript());
    }

    @Test
    void createScriptPerIssueNumberTest() throws IOException {
        System.out.println("createScriptPerIssueNumber :)");
        String scriptPath="C:\\Scripts\\ModificationScripts\\CancelIssue.sql";
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        CancelIssue cancelIssue=new CancelIssue(myExcelSheet);
        System.out.println(cancelIssue.createScriptPerIssueNumber("101010",scriptPath));
        Assert.assertTrue(true);
    }
//    readScriptSourceFile method test
    @Test
    void readScriptSourceFileTest() throws IOException {
        System.out.println("readScriptSourceFileTest started :)");
        String scriptPath="C:\\Scripts\\ModificationScripts\\CancelIssue.sql";
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        CancelIssue cancelIssue=new CancelIssue(myExcelSheet);
        System.out.println(cancelIssue.readScriptSourceFile(scriptPath));
        Assert.assertTrue(true);
    }

    @Test
    void classNameTest() throws IOException {
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        Script a=new CancelIssue(myExcelSheet);
        System.out.println(a.getClass().getSimpleName());
    }
    @Test
    void classNameTestConf() throws IOException {
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\User_Midco.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("modify_receipt_issue");
        Script a=new CancelIssue(myExcelSheet);
//        System.out.println(a.getClass().getSimpleName());

        String rootPath = System.getProperty("user.dir");
        FileReader scriptFieldName = new FileReader(rootPath + "\\src\\main\\java\\org\\example\\config\\outputexcel\\ScriptFieldNames.Properties");//get config of script names
        Properties config = new Properties();// config for scriptField name
        config.load(scriptFieldName);
        ExcelCreator.tableName(a);
//        String className= a.getClass().getSimpleName();
//                new ExcelCreator(a).GeneratedScriptClassName.getClass().getSimpleName();
//        System.out.println(className);
//        System.out.println(config.getProperty(className));
    }

}

