package Controller;

import API.TranslateWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UseDictionaryController {

    @FXML
    private Label wordDecription;

    @FXML
    private TextField useDictionaryTextField;

    @FXML
    private Label wordMeaningDecription;

    /**
     * @param event
     */
    @FXML
    public void setTranslateWordTextField(ActionEvent event){
        String wordToTranslate= useDictionaryTextField.getText();
        wordDecription.setText(wordToTranslate);
        wordMeaningDecription.setText(new TranslateWord().translateWord(wordToTranslate));
        wordDecription.setVisible(true);
        wordMeaningDecription.setVisible(true);
    }
}
