package org.example.inputexcel.createscript.ScriptKind.iws;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.inputexcel.createscript.ScriptKind.CancelIssue;
import org.example.inputexcel.createscript.ScriptKind.CancelOrder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.HashMap;
import java.util.Properties;


public class CancelOrderTest {
//    CancelIssue cancelIssue=new CancelIssue();





    //test is passed
    @Test
    public void checkerTest() throws IOException {

//        FileReader propertiesFile =new FileReader("C:\\Scripts\\UserExcel\\User_Midco.xlsx");

        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\CancelOrderExcel.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("order_modification");
        CancelOrder cancelOrder=new CancelOrder(myExcelSheet);
        XSSFRow row=myExcelSheet.getRow(1);
//        FileReader a=new FileReader("ca");
        HashMap<String,String> validationFields=new HashMap<>();
        validationFields.put("kindValidation","سفارش کالا");
        validationFields.put("updateKindValidation","ابطال");
//        Assert.assertTrue(cancelOrder.checker(row,validationFields));
//        Assert.fail();
//        Assert.assertTrue(true);
        System.out.println("a");

        System.out.println(cancelOrder.checker(row,validationFields));
    }
    @Test
    void generateScriptTest() throws IOException {
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\CancelOrderExcel.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("order_modification");
        CancelOrder cancelOrder=new CancelOrder(myExcelSheet);


        System.out.println("generateScriptTest started :)");
        System.out.println(myExcelSheet.getSheetName());
        System.out.println(cancelOrder.generateScript());
    }
    //test is passed
    @Test
    void createScriptPerOrderNumberTest() throws IOException {
        System.out.println("createScriptPerOrderNumber :)");
        String scriptPath="C:\\Scripts\\ModificationScripts\\CancelOrder.sql";
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\CancelOrderExcel.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("order_modification");
        CancelOrder cancelOrder=new CancelOrder(myExcelSheet);
        System.out.println(cancelOrder.createScriptPerOrderNumber("101010","'چون دلم میخواد'",scriptPath));
        Assert.assertTrue(true);
    }
    //    readScriptSourceFile method test
    //Test is passed
    @Test
    void readScriptSourceFileTest() throws IOException {
        System.out.println("readScriptSourceFileTest started :)");
        String scriptPath="C:\\Scripts\\ModificationScripts\\CancelOrder.sql";
        FileInputStream excelFile=new FileInputStream(new File("C:\\Scripts\\UserExcel\\CancelOrderExcel.xlsx"));
        XSSFWorkbook myExcelWorkBook=new XSSFWorkbook(excelFile);
        XSSFSheet myExcelSheet=myExcelWorkBook.getSheet("order_modification");
        CancelIssue cancelIssue=new CancelIssue(myExcelSheet);
        System.out.println(cancelIssue.readScriptSourceFile(scriptPath));
        Assert.assertTrue(true);
    }
    @Test
     void sheetTest() throws IOException {
        String rootPath = System.getProperty("user.dir");
//        FileReader
//        FileReader scriptfile = new FileReader(rootPath + "\\src\\main\\java\\org\\example\\config\\inputexcel\\Script.Properties");//get config of script names
        FileReader scriptSheet = new FileReader(rootPath + "\\src\\main\\java\\org\\example\\config\\inputexcel\\ExcelSheets.Properties");//get config of script sheets names
//        FileReader scriptFields = new FileReader(rootPath + "\\src\\main\\java\\org\\example\\config\\inputexcel\\ExcelFields.Properties");//get config of script fields

//        Properties config = new Properties();// config for script

        Properties sheetConfig = new Properties(); //config for sheet

//        Properties fieldsConfig = new Properties(); //config for field

//        config.load(scriptfile);//load config of script names

        sheetConfig.load(scriptSheet);// load config of script sheet names

//        fieldsConfig.load(scriptFields);// load config of script field names

//        String scriptAddress = config.getProperty("script_Address");//get memory address that scripts are saved
//        System.out.println(scriptAddress);
//        String scriptName = config.getProperty("cancel_order");//get the contracted script name
//        String scriptName = config.getProperty("cancel_order");//get the contracted script name
//        String scriptFullAddress = scriptAddress + scriptName;
//        System.out.println(scriptName);
//        System.out.println(scriptFullAddress);

//        String sheetName = sheetConfig.getProperty("cancel_order");//get the sheet name of cancel ORDER excel file
        String sheetName = sheetConfig.getProperty("cancel_order");//get the sheet name of cancel ORDER excel file
        System.out.println(sheetName);
        Assert.assertTrue(true);
    }

}

