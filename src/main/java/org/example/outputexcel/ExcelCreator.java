package org.example.outputexcel;

import org.example.inputexcel.createscript.Script;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ExcelCreator {

    //find table name of class
    public static String tableName(Script generatedClass) throws IOException {
        String rootPath = System.getProperty("user.dir");
        FileReader scriptFieldName = new FileReader(rootPath + "\\src\\main\\java\\org\\example\\config\\outputexcel\\ScriptFieldNames.Properties");//get config of script names
        Properties config = new Properties();// config for scriptField name
        config.load(scriptFieldName);
        String className=generatedClass.getClass().getSimpleName();
        System.out.println(config.getProperty(className));
        return config.getProperty(className);
    }
    // update excel file
    public static void updateExcel(String outputExcelPath,String tableName){
//        String rootPath=System.getProperty("user.dir");
//        FileInputStream excelOutputFile=new FileInputStream();
    }


}
