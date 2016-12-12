package sample.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);
        primaryStage.setTitle("lab 3");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../views/mainView.fxml"));

        Parent fxmlMain = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        controller.setMainStage(primaryStage);

        primaryStage.setScene(new Scene(fxmlMain, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
