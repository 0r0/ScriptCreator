package org.example.inputexcel.createscript;



import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ScriptSupplierFactory {
    private static final Map<String, Supplier<? extends Script>> registeredType=new HashMap<>();

    public static void registerSupplier(String type,Supplier<? extends Script> supplier){
        registeredType.put(type.toLowerCase(),supplier);
    }
    public static Script getScript(String type)
    {
//        String ignoreCaseType=type.toLowerCase() ;
        Supplier<? extends Script> supplier=registeredType.get(type.toLowerCase());
        return supplier !=null ? supplier.get():null;
    }
}
