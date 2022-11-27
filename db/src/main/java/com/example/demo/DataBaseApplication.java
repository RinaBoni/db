package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Приложение
 * @avtor Борисова Екатерина ИВТ-20
 */
public class DataBaseApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // запуск главного окна с БД
        FXMLLoader fxmlLoader = new FXMLLoader(DataBaseApplication.class.getResource("DB.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Database");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}