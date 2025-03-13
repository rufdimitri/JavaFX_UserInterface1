package rd.jfxexample.gui;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import rd.jfxexample.model.Document;
import rd.jfxexample.service.Context;

public class MainController {

    private Context context;

    @FXML
    private VBox vboxRight;
    @FXML
    private ListView docList;
    @FXML
    private TextField docName;
    @FXML
    private TextArea docContent;



    public MainController() {
        super();
    }

    @FXML
    public void initialize() {
        //do component initialization here
        docList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        docList.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            updateDocumentUI(newValue.intValue());
        });
        docList.getItems().addListener((ListChangeListener) c -> {
            updateDocumentUI(docList.getSelectionModel().getSelectedIndex());
        });


        docName.textProperty().addListener((observable, oldValue, newValue) -> {
            Document document = (Document)docList.getItems().get(docList.getSelectionModel().getSelectedIndex());
            document.setName(newValue);
            docList.refresh();
        });

        docName.textProperty().addListener((observable, oldValue, newValue) -> {
            int selected = docList.getSelectionModel().getSelectedIndex();
            Document document = context.getDocumentService().getDocumentList().get(selected);
            document.setName(docName.getText());
            docContent.setText(document.getContent());
        });

        docContent.textProperty().addListener((observable, oldValue, newValue) -> {
            int selected = docList.getSelectionModel().getSelectedIndex();
            Document document = context.getDocumentService().getDocumentList().get(selected);
            document.setContent(docContent.getText());
        });
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void saveDocument() {
        int selectedIndex = docList.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            Document document = context.getDocumentService().getDocumentList().get(selectedIndex);
            document.setName(docName.getText());
            document.setContent(docContent.getText());
        }
    }

    @FXML
    public void btAddAction() {
        Document document = new Document("untitled", "");
        docList.getItems().add(document);
        context.getDocumentService().getDocumentList().add(document);
    }

    @FXML
    public void btRemoveAction() {
        int selectedIndex = docList.getSelectionModel().getSelectedIndex();
        context.getDocumentService().getDocumentList().remove(selectedIndex);
        docList.getItems().remove(selectedIndex);
    }

    private void updateDocumentUI(int listSelectedIndex) {
        if (listSelectedIndex == -1) {
            vboxRight.setVisible(false);
            return;
        }
        vboxRight.setVisible(true);

        Document document = context.getDocumentService().getDocumentList().get(listSelectedIndex);
        docName.setText(document.getName());
        docContent.setText(document.getContent());
    }

}
