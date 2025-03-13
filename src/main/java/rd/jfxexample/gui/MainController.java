package rd.jfxexample.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import rd.jfxexample.service.Context;

public class MainController {

    private Context context;

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
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @FXML
    public void btAddAction() {
        docList.getItems().add("untitled");
    }

    @FXML
    public void btRemoveAction() {
        docList.getItems().remove(docList.getSelectionModel().getSelectedIndex());
    }

}
