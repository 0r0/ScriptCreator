package org.example.inputexcel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.config.inputexcel.ExcelSheets;
import org.example.inputexcel.createscript.Script;
import org.example.inputexcel.createscript.ScriptSupplierFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;



public class ExcelFile {
   private static StringBuilder scriptString=new StringBuilder();
    public static void hello(String excelPath){
        System.out.println("I love U");
        System.out.println(excelPath);
    }
//    public void
    public static void read(String fileAddress) throws FileNotFoundException {
        try {
            FileInputStream file=new FileInputStream(new File(fileAddress));
////
        XSSFWorkbook workbook=new XSSFWorkbook(file);//get excel workbook;
        for(int i=0;i<workbook.getNumberOfSheets();i++)
        {
            String sheetName=workbook.getSheetName(i);//get sheet name
            XSSFSheet sheet=workbook.getSheetAt(i);//get sheet
            //get sheet script generator class then send  sheet to class;
                for(ExcelSheets excelsheet:ExcelSheets.values())
                {
                    if(excelsheet.getSheetName().equals(sheetName))
                    {
                        //call Script supplier factory class
                        Script script=ScriptSupplierFactory.getScript2(excelsheet.toString(),sheet);
                        scriptString.append("\n");
                        scriptString.append(script.generateScript());
                        System.out.println(scriptString);
                    }
                }

        }

        }
        catch(FileNotFoundException e)
            {
                System.out.printf("file not Exist");
            } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static StringBuilder getScriptString(){
        return scriptString;
    }
}