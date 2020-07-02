package org.example.config.inputexcel;

public enum ExcelSheets {
    CANCEL_ISSUE(ExcelSheets.modifyReceiptIssue),
    CANCEL_RECEIPT(ExcelSheets.modifyReceiptIssue),
    UPDATE_ISSUE_DATE(ExcelSheets.modifyReceiptIssue),
    UPDATE_RECEIPT_DATE(ExcelSheets.modifyReceiptIssue),
    CANCEL_REQUEST(ExcelSheets.request);

    private static final String  modifyReceiptIssue="modify_receipt_issue";
    private static final String request="درخواست";
    private final String sheetName;
    ExcelSheets(String sheetName) {
        this.sheetName=sheetName;
    }
    public String getSheetName(){
        return sheetName;
    }
}
