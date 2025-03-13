package rd.jfxexample.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class MainWindow extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxml = this.getClass().getResource("/fxml/main.fxml");

        Parent parent = FXMLLoader.load(fxml);

        Scene scene = new Scene(parent, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
