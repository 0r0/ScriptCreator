package org.example.inputexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.inputexcel.createscript.ScriptFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

//import org.apache.poi.xssf.usermodel


public class ReadExcelFile {
//    public void
//    public static void readExcel(String fileAddress)
//    {
//        try {
//            FileInputStream file=new FileInputStream(new File(fileAddress));
//
//        XSSFWorkbook workbook=new XSSFWorkbook(file);
//        for(int i=0;i<workbook.getNumberOfSheets();i++)
//        {
////            String sheetName=workbook.getSheetName(i);
//            XSSFSheet sheet=workbook.getSheetAt(i);
//            ScriptFactory factory=new ScriptFactory();
//            factory.create(sheet);
//        }
//            XSSFSheet sheet=workbook.getSheet("ویرایش رسید و حواله");
//
//
//        XSSFFormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();
////        for(XSSFRow row:sheet)
////        {
////            for(XSSFCell cell:row)
////            {
////                switch (formulaEvaluator.evaluateFormulaCell(cell).getCellType())
////                {
////                    case
////                }
////            }
////        }
//
//            Iterator<Row> iterator=sheet.iterator();
//            while(iterator.hasNext())
//            {
//                Row row=iterator.next();
//                Iterator<Cell> cellIterator=row.cellIterator();
//                while(cellIterator.hasNext())
//                {
//
//                    Cell cell=cellIterator.next();
//                    if(cell!=null && cell.getCellType()!= CellType.BLANK) {
////                        System.out.println(row.getRowNum());
//                        System.out.println(cell.getStringCellValue());
//                    }
////                   for()
//                }
//            }
//
//
//        }catch(FileNotFoundException e)
//        {
//            System.out.printf("file not Exist");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(fileAddress);
//    }
    private String  scriptDetector(Sheet sheet)
    {
        return null;
    }
}