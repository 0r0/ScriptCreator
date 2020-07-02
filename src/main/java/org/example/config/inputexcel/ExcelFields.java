package org.example.config.inputexcel;

public enum ExcelFields {
    CANCEL("ابطال"),
    ISSUE("حواله"),
    RECEIPT("رسید"),
    EDIT_DATE("ویرایش تاریخ"),
    ORDER("سفارش"),
    REQUEST("درخواست"),
    MOVEMENT_REQUEST("درخواست انتقال");


    private String val;

    ExcelFields(String val) {
        this.val=val;
    }
    public String getValue(){
        return  val;
    }
}
