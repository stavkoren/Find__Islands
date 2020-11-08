import Constants.UIConstants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(UIConstants.VIEW_FILE));
        primaryStage.setTitle(UIConstants.PRIMARY_STAGE_TITLE);
        primaryStage.setScene(new Scene(root, UIConstants.SCENE_SIZE, UIConstants.SCENE_SIZE));
        primaryStage.show();
        this.primaryStage = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
