package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Констроллер для добавления нового человека
 * @avtor Борисова Екатерина ИВТ-20
 */
public class NewPersonController {

    @FXML
    private Button closeButton;
    public Label textFieldError;
    @FXML
    private TextField textFieldAge;
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldFam;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldOtch;
    @FXML
    private TextField textFieldSeries;
    @FXML
    private TextField textFieldNumber;

    private DataBase dataBase;
    private TableView<Person> objectsTableView;

    /**
     * Закрывает окно с анкетой
     * @param event
     */
    @FXML
    void onCloseButtonClick(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Для получения базы данных с главного окна
     * @param dataBase
     */
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * для получения базы данных с главного окна
     * @param objectsTableView
     */
    public void setTable(TableView<Person> objectsTableView) {
        this.objectsTableView = objectsTableView;
    }
    @FXML
    /**
     * Добавляет все данные в БД
     */
    void onAddPButtonClick(ActionEvent event){
        int count = 0;
        textFieldError.setVisible(false);
        Person newPerson = new Person();
        // Задаем исходный цвет полей
        textFieldID.setStyle("-fx-control-inner-background: white");
        textFieldFam.setStyle("-fx-control-inner-background: white");
        textFieldName.setStyle("-fx-control-inner-background: white");
        textFieldOtch.setStyle("-fx-control-inner-background: white");
        textFieldAge.setStyle("-fx-control-inner-background: white");
        textFieldSeries.setStyle("-fx-control-inner-background: white");
        textFieldNumber.setStyle("-fx-control-inner-background: white");
        // Если вызовется исключение при заполнении какого-то поля
        // его цвет поменяется на КРАСНЫЙ!!!
        //---------------ИСКЛЮЧЕНИЯ------------------------
        try {
            Integer.parseInt(textFieldID.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            textFieldID.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            newPerson.setFam(textFieldFam.getText());
        } catch (IOException e){
            e.printStackTrace();
            textFieldFam.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            newPerson.setName(textFieldName.getText());
        } catch (IOException e){
            e.printStackTrace();
            textFieldName.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            newPerson.setOtch(textFieldOtch.getText());
        } catch (IOException e){
            e.printStackTrace();
            textFieldOtch.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            Integer.parseInt(textFieldAge.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            textFieldAge.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            Integer.parseInt(textFieldSeries.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            textFieldSeries.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            Integer.parseInt(textFieldNumber.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            textFieldNumber.setStyle("-fx-control-inner-background: red");
            count++;
        }

        if (count != 0) {
            textFieldError.setVisible(true);
            if(count == 1) {
                textFieldError.setText("Неправильное значение!");
            }
            else {
                textFieldError.setText("Неправильное значения!");
            }
            return;
        }
        try {
            newPerson.setID(Integer.parseInt(textFieldID.getText()));
        } catch (IOException e) {
            e.printStackTrace();
            textFieldID.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            newPerson.setAge(Integer.parseInt(textFieldAge.getText()));
        } catch (IOException e) {
            e.printStackTrace();
            textFieldAge.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            newPerson.setSeries(Integer.parseInt(textFieldSeries.getText()));
        } catch (IOException e) {
            e.printStackTrace();
            textFieldSeries.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            newPerson.setNumber(Integer.parseInt(textFieldNumber.getText()));
        } catch (IOException e) {
            e.printStackTrace();
            textFieldNumber.setStyle("-fx-control-inner-background: red");
            count++;
        }

        if (count != 0) {
            textFieldError.setVisible(true);
            if(count == 1) {
                textFieldError.setText("Неправильное значение!");
            }
            else {
                textFieldError.setText("Неправильное значение!");
            }
            return;
        }
        //----------------------Конец ИСКЛБЮЧЕНИЙ--------------------------------
        dataBase.objects.add(newPerson);
        Stage stage = (Stage) closeButton.getScene().getWindow();
        objectsTableView.refresh();
        stage.close();
    }
    public void onKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE)
            onCloseButtonClick(new ActionEvent());
        if(event.getCode() == KeyCode.ENTER)
            onAddPButtonClick(new ActionEvent());
    }
}
