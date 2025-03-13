package rd.jfxexample.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rd.jfxexample.service.Context;

import java.net.URL;

public class MainWindow {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private Context context;

    public MainWindow(Context context) {
        this.context = context;
    }

    public void createAndShow(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/main.fxml"));
        Parent parent = loader.load();

        MainController controller = loader.getController();
        controller.setContext(this.context);

        Scene scene = new Scene(parent, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
