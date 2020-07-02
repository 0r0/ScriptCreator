package org.example.config.inputexcel;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ExcelSheetsTest {
    @Test
    void excelSheetEnumTest(){
        System.out.println(ExcelSheets.CANCEL_REQUEST.getSheetName());
        Assert.assertEquals("درخواست",ExcelSheets.CANCEL_REQUEST.getSheetName());
    }
}
