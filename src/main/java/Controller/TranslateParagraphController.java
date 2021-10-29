package Controller;

import API.TranslateText;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.net.URLConnection;

public class TranslateParagraphController {
    @FXML
    private TextArea searchTextField;
    @FXML
    private TextArea wordDescription;

    /**
     * @param event
     */
    @FXML
    void translateParagraphButton(ActionEvent event) {
        try {
            String wordToTranslation = searchTextField.getText();
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            TranslateText translate = new TranslateText();
            String WORD_DESCRIPTION = translate.Translate(wordToTranslation);
            wordDescription.setText(WORD_DESCRIPTION);
            wordDescription.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
