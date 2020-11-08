package UIObjects;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AlertBox {

    public static void display(String message){
        AlertBox.display(Constants.UIConstants.ALERTBOX_MES, message);
    }

    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(Constants.UIConstants.MIN_ALERTBX_WIDTH);

        Label label = new Label();
        label.setText(message);

        Button closeButton = new Button(Constants.UIConstants.BUTTON_CLOSE);
        closeButton.setOnAction(e-> window.close());

        VBox layout = new VBox(Constants.UIConstants.VBOX);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }
}
