package org.example.inputexcel.createscript;



import org.apache.poi.ss.usermodel.Sheet;
import org.example.config.inputexcel.ClassAddress;
import org.example.config.inputexcel.ExcelSheets;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
        Supplier<? extends Script> supplier=registeredType.get(type.toLowerCase());
        return supplier !=null ? supplier.get():null;
    }
    public static Script getScript2(String type, Sheet sheet) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //at first must check that type is valid (class name exist in enum)

        Class<?> clazz=Class.forName(ClassAddress.CLASS_ADDRESS.getScriptAddress() +type);
        Constructor<?> constructor = clazz.getConstructor(Sheet.class);
        Object instance = constructor.newInstance(sheet);
        return (Script)instance;

    }
}
