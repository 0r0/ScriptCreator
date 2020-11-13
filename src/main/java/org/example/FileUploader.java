package org.example;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.example.config.database.EngineName;
import org.example.inputexcel.ExcelFile;

import java.io.File;
import java.io.FileNotFoundException;

public class FileUploader {
        @FXML
    private TextField browseTextField;
        @FXML
    private ComboBox selectEngine;
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
        public void generateClicked(Event event) throws FileNotFoundException {


//            ReadExcelFile.readExcel(browseTextField.getText());
            System.out.println(ExcelFile.read(browseTextField.getText()));
            System.out.println(selectEngine.getSelectionModel().selectedItemProperty().getValue());

        }
        @FXML
    public void intializeCombo(Event event){
            selectEngine.getItems().setAll(EngineName.values());
        }
}
