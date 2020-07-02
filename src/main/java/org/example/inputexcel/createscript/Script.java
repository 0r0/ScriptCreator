package org.example.inputexcel.createscript;

import org.apache.poi.ss.usermodel.Row;
import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;

public interface Script extends Supplier<Script> {
     String generateScript() throws IOException;
     boolean checker(Row row, Map<String,String> validationFields) throws IOException;
//     File createScript();
}
