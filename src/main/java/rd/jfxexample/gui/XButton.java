package rd.jfxexample.gui;

import javafx.scene.control.Button;

public class XButton extends Button {
    private final static String STYLE = "-fx-background-color: #AAD";
    private final static String STYLE_HOVER = "-fx-background-color: #CCF";
    public XButton(String text) {
        super(text);
        this.setStyle(STYLE);
        this.setOnMouseEntered(event -> this.setStyle(STYLE_HOVER));
        this.setOnMouseExited(event -> this.setStyle(STYLE));
        this.setOnMousePressed(event -> this.setStyle(STYLE));
        this.setOnMouseReleased(event -> this.setStyle(STYLE_HOVER));
    }


}
