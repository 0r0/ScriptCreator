package org.example.config.inputexcel;

public enum ExcelFields {
    CANCEL("ابطال"),
    ISSUE("حواله"),
    RECEIPT("رسید"),
    EDIT_DATE("ویرایش تاریخ"),
    ORDER("سفارش"),
    REQUEST("درخواست"),
    MOVEMENT_REQUEST("درخواست انتقال"),
    CANCEL_RUNNING("لغو در جریان"),
    SHIPMENT_ORDER("دستور حمل"),
    SHIPMENT_REQUEST("درخواست حمل"),
    WEIGHING_BILL("توزین"),
    PLAQUE("پلاک"),
    STATION("ایستگاه");





    private final String val;

    ExcelFields(String val) {
        this.val=val;
    }
    public String getValue(){
        return  val;
    }
}
