package rd.jfxexample.gui;

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


            Document newDocument = context.getDocumentService().getDocumentList().get(newValue.intValue());
            docName.setText(newDocument.getName());
            docContent.setText(newDocument.getContent());
        });

        docName.textProperty().addListener((observable, oldValue, newValue) -> {
            Document document = (Document)docList.getItems().get(docList.getSelectionModel().getSelectedIndex());
            document.setName(newValue);
            docList.refresh();
        });

        //TODO save doc on every change
        //docName.textProperty().addListener((observable, oldValue, newValue) -> );

        //TODO save doc on every change
        //docContent.TextProperty().addListener...
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
        vboxRight.setVisible(true);
        Document document = new Document("untitled", "");
        docList.getItems().add(document);
        context.getDocumentService().getDocumentList().add(document);
    }

    @FXML
    public void btRemoveAction() {
        int selectedIndex = docList.getSelectionModel().getSelectedIndex();
        System.out.println(selectedIndex);
        docList.getItems().remove(selectedIndex);
        context.getDocumentService().getDocumentList().remove(selectedIndex);
        System.out.println();
    }

}
