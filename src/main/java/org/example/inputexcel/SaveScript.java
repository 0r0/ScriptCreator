package org.example.inputexcel;

import javafx.scene.control.FocusModel;

import java.io.*;

/**
 * saving generated script file in database or disk in file format ;)
 */
public class SaveScript {
    public static void done(StringBuilder scriptString,String issueName,String fileAddress) throws IOException {
        //save script here
        File scriptFile=new File(fileAddress+""+issueName+".sql");
        FileOutputStream fileStream=new FileOutputStream(scriptFile);


        fileStream.write(scriptString.toString().getBytes());
        fileStream.flush();
        fileStream.close();

    }



}
