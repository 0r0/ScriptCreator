package org.example.config.inputexcel;

import java.util.HashMap;
import java.util.Map;

public enum ExcelSheets {
    //all enum values is equal to class name for example CancelIssue is class name too ;)
    CancelIssue(ExcelSheets.modifyReceiptIssue);
//    CancelReceipt(ExcelSheets.modifyReceiptIssue),
//    UpdateIssueDate(ExcelSheets.modifyReceiptIssue),
//    UpdateReceiptDate(ExcelSheets.modifyReceiptIssue),
//    CancelRequest(ExcelSheets.request);
//    ScriptAddress(ExcelSheets.scriptAddress);
    private static final String  modifyReceiptIssue="modify_receipt_issue";
    private static final String request="درخواست";

    private final String sheetName;
    ExcelSheets(String sheetName) {
        this.sheetName=sheetName;
    }
    public String getSheetName(){
        return sheetName;
    }
//    private static Map<String,ExcelSheets> lookup =new HashMap<>();

//    static {
//        for (ExcelSheets excelSheet:ExcelSheets.values()){
//            lookup.put(excelSheet.getSheetName(),excelSheet);
//        }
//    }
//    public static ExcelSheets get(String url){
//        return null;
//    }
}
