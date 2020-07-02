package org.example.inputexcel.createscript;

import org.apache.poi.ss.usermodel.Sheet;
import org.example.inputexcel.createscript.ScriptKind.CancelIssue;

import java.lang.reflect.InvocationTargetException;

public class ScriptFactory{
    public Script create(Sheet sheet, String Type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            if(Type==null)
            {
                return null;
            }
            if(Type.equalsIgnoreCase("cancelIssue"))
            {
                return new CancelIssue(sheet);
            }
            return null;
    }
}
