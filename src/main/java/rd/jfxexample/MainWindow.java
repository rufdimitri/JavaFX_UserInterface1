package rd.jfxexample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow extends Application  {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Jo!");
        BorderPane pane = new BorderPane();
        pane.setCenter(label);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
