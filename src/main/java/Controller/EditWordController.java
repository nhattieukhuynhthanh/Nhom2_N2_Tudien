package Controller;

import Dictionary.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditWordController {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    @FXML
    private TextField editWordTargetTextField;
    @FXML
    private TextField editWordMeaningTextField;

    /**
     * init
     */
    public void initialize() {
        dictionaryManagement.importFromFile();
    }

    /**
     * @param event
     */
    @FXML
    public void editWordButtonClick(ActionEvent event) {
        String wordToAdd = editWordTargetTextField.getText();
        String meaningToAdd = editWordMeaningTextField.getText();
        dictionaryManagement.dictionary.editWord(wordToAdd, meaningToAdd);
        dictionaryManagement.ExportToFile();
    }
}
