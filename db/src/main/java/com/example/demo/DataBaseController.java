package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.IOException;

/**
 * Контроллер для взаимодействия с базой данных
 * @avtor Борисова Екатерина ИВТ-20
 */
public class DataBaseController {

    @FXML
    private TableColumn<Person, Integer> IDColumn;
    @FXML
    private TableColumn<Person, String> FamColumn;
    @FXML
    private TableColumn<Person, String> NameColumn;
    @FXML
    private TableColumn<Person, String> OtchColumn;
    @FXML
    private TableColumn<Person, Integer> AgeColumn;
    @FXML
    private TableColumn<Person, Integer> SeriesColumn;
    @FXML
    private TableColumn<Person, Integer> NumberColumn;
    @FXML
    private Button informationText;
    @FXML
    private Button informationText1;

    @FXML
    private TableView<Person> objectsTableView;
    private final DataBase data = new DataBase();
    private String fileName = "data2.txt";

    /**
     * Срабатывает при запуске
     */
    public void initialize(){
        // ==== Инициализация таблицы
        // связывает колонку и метод из Person, с помощью которого колонка будет получать значения для каждой ячейки данных
        // аргумента PropertyValueFactory должен быть таким, чтобы получить имя геттера и сеттера добавив get и set соответственно
        objectsTableView.setItems(data.objects);// связывает табличку и класс базы данных
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        FamColumn.setCellValueFactory(new PropertyValueFactory<>("Fam"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        OtchColumn.setCellValueFactory(new PropertyValueFactory<>("Otch"));
        AgeColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
        SeriesColumn.setCellValueFactory(new PropertyValueFactory<>("Series"));
        NumberColumn.setCellValueFactory(new PropertyValueFactory<>("Number"));
        objectsTableView.setEditable(true);
        //edit
        IDColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        FamColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        OtchColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        AgeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        SeriesColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        NumberColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

    }

    /**
     * Вызывает окно с анкетой для добавления нового человека в БД
     * @param event
     * @throws IOException
     */
    @FXML
    void clickAddPButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DataBaseApplication.class.getResource("NewPerson.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("New person");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);     //он будет блокировать все другие окна (Stage), открытые этим приложением. Вы не можете получить доступ к ним, пока это окно рабочей области не будет закрыто.
        stage.getUserData();                                //Получает данные указанного пользователя в виде объекта
        stage.setResizable(false);                          //пользователь не право изменять размеры фрейма.
        stage.show();

        NewPersonController newPersonController = fxmlLoader.getController();
        newPersonController.setDataBase(data);
        newPersonController.setTable(objectsTableView);
    }

    /**
     * Удаляет выбранное поле из БД
     * @param actionEvent
     */
    public void clickDeleteButton(ActionEvent actionEvent) {
        data.objects.remove(data.objects.indexOf(objectsTableView.getSelectionModel().getSelectedItem()));
        objectsTableView.refresh();
    }

    /**
     * Очищает всю БД
     * @param actionEvent
     */
    public void clickClearButton(ActionEvent actionEvent) {
        data.objects.clear();
        objectsTableView.refresh();
    }
    @FXML
    /**
     * Сохраняет БД в файл (данные с формы)
     */
    void clickSaveFileButton(ActionEvent event) {
        data.saveFile(fileName);
    }
    @FXML
    /**
     * Заполняет БД на форме данными из файла
     */
    void clickReadFileButton(ActionEvent event) {
        try {
            data.objects.clear();
            data.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        objectsTableView.refresh();
    }

    /**
     * Вызывает окно с информациией о разработчике
     * @throws IOException
     */
    @FXML
    void clickInfoButton() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DataBaseApplication.class.getResource("Z.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Info");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Вызывает диалоговое окно для сохранения файла.
     */
    @FXML
    private void onMenuItemExportClick() {
        Stage stage = (Stage) informationText.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export File");
        File file = fileChooser.showSaveDialog(stage);

        if(file != null) {
            data.saveFile(file.getAbsolutePath());
        }
    }
    @FXML
    private void onMenuItemImportClick() {
        Stage stage = (Stage) informationText1.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import File");
        File file = fileChooser.showOpenDialog(stage);

        if(file != null) {
            data.objects.clear();
            try {
                data.readFile(file.getAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @FXML
    void clickSortAgeItem(ActionEvent event) {
       // SortedList<Person> sortedItems = new SortedList<>(data.objects);
       // objectsTableView.setItems(sortedItems);
       // sortedItems.comparatorProperty().bind(objectsTableView.comparatorProperty());

        AgeColumn.sortTypeProperty();
    }
}