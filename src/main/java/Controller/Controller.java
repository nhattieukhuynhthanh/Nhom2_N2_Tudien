package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Controller {

    @FXML
    private BorderPane mainPane;

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void editWordButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EditWord.fxml"));
        AnchorPane pane = fxmlLoader.load();
        mainPane.setCenter(pane);
    }

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void translateParagraphButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/TranslateParagraph.fxml"));
        AnchorPane pane = fxmlLoader.load();
        mainPane.setCenter(pane);
    }

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void useDictionaryButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/UseDictionary.fxml"));
        AnchorPane pane = fxmlLoader.load();
        mainPane.setCenter(pane);
    }
}


