package org.example.outputexcel;

import org.example.inputexcel.createscript.Script;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ExcelCreator {
    //get default excel file then get generated script and update excel file with it
//    public static Script GeneratedScriptClassName;
//    public ExcelCreator(Script GeneratedScriptClassName){
//        ExcelCreator.GeneratedScriptClassName =GeneratedScriptClassName;
//    }

    public static void addTableName(Script generatedClass) throws IOException {
        String rootPath = System.getProperty("user.dir");
        FileReader scriptFieldName = new FileReader(rootPath + "\\src\\main\\java\\org\\example\\config\\outputexcel\\ScriptFieldNames.Properties");//get config of script names
        Properties config = new Properties();// config for scriptField name
        config.load(scriptFieldName);
        String className=generatedClass.getClass().getSimpleName();
        System.out.println(config.getProperty(className));

    }

}
