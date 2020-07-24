package org.example;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.ReadExcelFile;
import java.io.File;

public class FileUploader {
        @FXML
    private TextField browseTextField;

        @FXML
        public void browseClicked(Event event){
            FileChooser fileChooser=new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Excel file","*.xlsx")

            );
            File selectedFile=fileChooser.showOpenDialog(new Stage());
            if(selectedFile!=null){
                browseTextField.setText(selectedFile.getAbsolutePath());
            }


        }
        @FXML
        public void generateClicked(Event event){


            ReadExcelFile.readExcel(browseTextField.getText());

        }
}
