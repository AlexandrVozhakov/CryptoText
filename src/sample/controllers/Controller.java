package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.models.impls.CoderModel;
import sample.models.interfaces.Coder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    @FXML
    private TextArea textArea;

    @FXML
    private ToggleGroup operationToggle;

    @FXML
    private TextField keyAField;

    @FXML
    private TextField keyBField;

    @FXML
    private ChoiceBox<String> cryptType;

    private Coder coder;
    private Stage stage;


    @FXML
    private void initialize() {

        coder = CoderModel.getInstance();
        //keyBField.setDisable(true);

        keyAField.textProperty().addListener((observableValue, s1, s2) -> {

            String key = keyAField.getText();
            // only numbers in keyAField
            if (!key.matches("[0-9]+"))
                keyAField.setText(key.replaceAll("[^0-9]", ""));
        });
    }


    public void onClick(){

        String operation = operationToggle.getSelectedToggle().getUserData().toString();
        ((CoderModel) coder).changeTypeCrypt(cryptType.getValue());

        int keyA = keyAField.getText().equals("") ? 1 : Integer.parseInt(keyAField.getText());
        int keyB = keyBField.getText().equals("") ? 1 : Integer.parseInt(keyBField.getText());

        List<Integer> keys = new ArrayList<>();
        keys.add(keyA);
        keys.add(keyB);

        if (operation.equals("Crypt")) {
            textArea.setText(coder.encrypt(textArea.getText(), keys));
        } else {
            textArea.setText(coder.decrypt(textArea.getText(), keys));
        }
    }


    public void clearText() {
        textArea.setText("");
    }


    private FileChooser fileChoose() {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        return fileChooser;
    }


    public void openFile(ActionEvent actionEvent) {

        File file = fileChoose().showOpenDialog(stage);

        if (file != null) {
            textArea.setText(readFile(file));
        }
    }


    public void saveFile(ActionEvent actionEvent){

        File file = fileChoose().showSaveDialog(stage);

        if(file != null){
            writeFile(textArea.getText(), file);
        }
    }


    private void writeFile(String content, File file){

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            System.err.format("Exception occurred trying to read '%s'.", file);
            e.printStackTrace();
        }
    }


    private String readFile(File file) {

        StringBuilder records = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                records.append(line).append(" ");
            }
            reader.close();
            return records.toString().trim();
        }
        catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", file);
            e.printStackTrace();
            return null;
        }
    }


    public void setMainStage(Stage stage) {
        this.stage = stage;
    }
}
