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



public class CancelOrder implements Script {
    Sheet sheet;

    public  CancelOrder(Sheet sheet)
    {
        this.sheet=sheet;
    }

    @Override
    public CancelOrder get() {
        return new CancelOrder(sheet);
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
        System.out.println(scriptAddress);
        String scriptName = config.getProperty("cancel_order");//get the contracted script name
        String scriptFullAddress = scriptAddress + scriptName;
        System.out.println(scriptName);
        System.out.println(scriptFullAddress);

        String sheetName = sheetConfig.getProperty("cancel_order");//get the sheet name of cancel ORDER excel file
        System.out.println(sheetName);
        if (!sheetNameChecker(sheetName,sheet.getSheetName()))
        {
            throw new RuntimeException("sheet name is not same");
        }

//        String fieldB = fieldsConfig.getProperty("cancel_order.Field.B.Header");//it is vouchar number

        String kindValidation = ExcelFields.ORDER.getValue();// equal to "سفارش کالا"

        String updateKindValidation =ExcelFields.CANCEL.getValue(); // equal to "ابطال"

        String orderNumber,cancelationReason;

        StringBuilder CancelOrderScript = new StringBuilder();// a string for storing cancel ORDER script

        HashMap<String, String> validationFields = new HashMap<>();
        validationFields.put("kindValidation", kindValidation);
        validationFields.put("updateKindValidation", updateKindValidation);
        for (Row row : sheet) {

            if (checker(row, validationFields)) {
                orderNumber = row.getCell(1).getStringCellValue();
                cancelationReason=row.getCell(7).getStringCellValue();
                CancelOrderScript.append(createScriptPerOrderNumber(orderNumber,cancelationReason,scriptFullAddress));
                CancelOrderScript.append("\n");

            }

        }

        return CancelOrderScript.toString();
    }
    @Override
    public boolean checker(Row row, Map<String,String> validationFields) throws IOException {
        String kindValidation =validationFields.get("kindValidation");

        String updateKindValidation=validationFields.get("updateKindValidation");
        String kind=row.getCell(0).getStringCellValue();// get value of kind in cell 0 in excel file and it must be سفارش کالا
        String updateKind=row.getCell(4).getStringCellValue();//get value of update kind in cell 4 in excel file and it must be  ابطال


        kind=kind.trim().replaceAll(" +", " ");//remove redundant spaces in kind string
        updateKind=updateKind.replaceAll(" ","");// remove redundant space from update kind String
        System.out.println(updateKind);
        System.out.println(kind);
        return kind.equals(kindValidation) && updateKind.equals(updateKindValidation);
    }



    //create script for a ORDER number
    //  private
    public String createScriptPerOrderNumber(String orderNumber,String cancelationReason,String scriptAddress) throws FileNotFoundException {


        String fileContent=readScriptSourceFile(scriptAddress);
        fileContent=fileContent.replace("'X'",orderNumber).replace("'Y'",cancelationReason);
        return fileContent;
    }

    // read cancel ORDER script template
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
        System.out.printf("%s,%s",contractedSheetName,sheetName);
        return contractedSheetName.equals(sheetName);
    }



}

