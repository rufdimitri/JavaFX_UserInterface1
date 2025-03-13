package rd.jfxexample.service;

import javafx.application.Application;
import javafx.stage.Stage;
import rd.jfxexample.gui.MainWindow;

public class App extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Context context = new Context();
        context.populate();

        new MainWindow(context).createAndShow(primaryStage);
    }
}
