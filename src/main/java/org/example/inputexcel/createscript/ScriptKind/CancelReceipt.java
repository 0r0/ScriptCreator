package org.example.inputexcel.createscript.ScriptKind;



import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.example.config.inputexcel.ExcelFields;
import org.example.inputexcel.createscript.Script;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class CancelReceipt implements Script {
    Sheet sheet;

    public  CancelReceipt(Sheet sheet)
    {
        this.sheet=sheet;
    }

    @Override
    public CancelReceipt get() {
        return new CancelReceipt(sheet);
    }

    @Override
    public  String generateScript() throws IOException {
        // get Script file name from config
        String rootPath = System.getProperty("user.dir");
        FileReader scriptfile = new FileReader(rootPath + "\\src\\main\\java\\org\\example\\config\\inputexcel\\Script.Properties");//get config of script names
        FileReader scriptSheet = new FileReader(rootPath + "\\src\\main\\java\\org\\example\\config\\inputexcel\\ExcelSheets.Properties");//get config of script sheets names
        FileReader scriptFields = new FileReader(rootPath + "\\src\\main\\java\\org\\example\\config\\inputexcel\\ExcelFields.Properties");//get config of script fields

        Properties config = new Properties();// config for script

        Properties sheetConfig = new Properties(); //config for sheet

        Properties fieldsConfig = new Properties(); //config for field

        config.load(scriptfile);//load config of script names

        sheetConfig.load(scriptSheet);// load config of script sheet names

        fieldsConfig.load(scriptFields);// load config of script field names

        String scriptAddress = config.getProperty("script_Address");//get memory address that scripts are saved

        String scriptName = config.getProperty("cancel_receipt");//get the contracted script name
        String scriptFullAddress = scriptAddress + scriptName;

        String sheetName = sheetConfig.getProperty("cancel_receipt");//get the sheet name of cancel issue excel file

        if (!sheetNameChecker(sheetName,sheet.getSheetName()))
        {
            throw new RuntimeException("sheet name is not same");
        }

//        String fieldB = fieldsConfig.getProperty("cancel_issue.Field.B.Header");//it is vouchar number

        String kindValidation = ExcelFields.ISSUE.getValue();

        String updateKindValidation =ExcelFields.CANCEL.getValue();

        String issueNumber;

        StringBuilder cancelIssueScript = new StringBuilder();// a string for storing cancel issue script

        HashMap<String, String> validationFields = new HashMap<>();
        validationFields.put("kindValidation", kindValidation);
        validationFields.put("updateKindValidation", updateKindValidation);
        for (Row row : sheet) {

            if (checker(row, validationFields)) {
                issueNumber = row.getCell(1).getStringCellValue();
                cancelIssueScript.append(createScriptPerIssueNumber(issueNumber, scriptFullAddress));
                cancelIssueScript.append("\n");

            }

        }

        return cancelIssueScript.toString();
    }
    @Override
    public boolean checker(Row row, Map<String,String> validationFields) throws IOException {
        String kindValidation =validationFields.get("kindValidation");

        String updateKindValidation=validationFields.get("updateKindValidation");
        String kind=row.getCell(0).getStringCellValue();// get value of kind in cell 0 in excel file and it must be حواله
        String updateKind=row.getCell(4).getStringCellValue();//get value of update kind in cell 4 in excel file and it must be  ابطال

        kind= kind.replaceAll(" ","");//remove redundant space from kind String
        updateKind=updateKind.replaceAll(" ","");// remove redundant space from update kind String

        return kind.equals(kindValidation) && updateKind.equals(updateKindValidation);
    }



    //create script for a issue number
    //  private
    public String createScriptPerIssueNumber(String issueNumber,String scriptAddress) throws FileNotFoundException {


        String fileContent=readScriptSourceFile(scriptAddress);
        fileContent=fileContent.replace("'X'",issueNumber);
        return fileContent;
    }

    // read cancel issue script template
//    private
    public String readScriptSourceFile(String filePath){
        String content = null;
        Charset charset = StandardCharsets.UTF_8;
        try {
            content= Files.readString(Paths.get(filePath), charset);
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        return content;
    }

    //private
    public boolean sheetNameChecker(String contractedSheetName,String sheetName)
    {

        return contractedSheetName.equals(sheetName);
    }



}

