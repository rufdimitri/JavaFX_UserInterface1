package rd.jfxexample.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rd.jfxexample.util.StringUtil;

public class MainWindow extends Application  {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        Label label = new Label("Jo! ");
        vBox.getChildren().add(label);

        XButton buttonOk = new XButton("Ok");
        vBox.getChildren().add(buttonOk);
        buttonOk.setOnAction(event -> label.setText(StringUtil.rotateString(label.getText())));

        XButton buttonExit = new XButton("Exit");
        vBox.getChildren().add(buttonExit);
        buttonExit.setOnAction(event -> Platform.exit());

        pane.setCenter(vBox);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
