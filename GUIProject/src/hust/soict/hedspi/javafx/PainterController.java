package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    Circle typeOfCircle = new Circle();

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle circle = new Circle(event.getX(), event.getY(), 4, typeOfCircle.getFill());
    	drawingAreaPane.getChildren().add(circle);
    }

    @FXML
    void chooseEraserTool(ActionEvent event) {
    	typeOfCircle.setFill(Color.WHITE);
    }

    @FXML
    void choosePenTool(ActionEvent event) {
    	typeOfCircle.setFill(Color.BLACK);
    }
}
