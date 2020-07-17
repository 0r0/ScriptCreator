package org.example.config.inputexcel;

public enum ClassAddress {
    CLASS_ADDRESS(ClassAddress.scriptAddress);
    private static final String scriptAddress="org.example.inputexcel.createscript.ScriptKind.";
    private final String address;

    ClassAddress(String address) {

        this.address = address;
    }
    public  String getScriptAddress()
    {
        return address;
    }
}
