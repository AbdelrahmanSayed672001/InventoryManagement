package sample;

import DataBase.products;
import Domain.pro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Products");
        primaryStage.setScene(new Scene(root, 600, 431));
        primaryStage.show();

    }



    /*public static void main(String[] args) {
        launch(args);
    }*/
}
