package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

/**
 *
 * @avtor Борисова Екатерина ИВТ-20
 */
public class DataBase {
    public ObservableList<Person> objects;
    DataBase() {
        objects = FXCollections.observableArrayList();
    }

    /**
     * Считывает данные из файла и вставляет в таблицу
     * @param fileName- название файла
     * @throws IOException
     */
    public void readFile(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                Person s = new Person();
                String[] split = line.split(", ");
                s.setParams(Integer.parseInt(split[0]), split[1], split[2], split[3],Integer.parseInt(split[4]),Integer.parseInt(split[5]),Integer.parseInt(split[6]));
                objects.add(s);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Считывает данные с таблицы и записывает в файл
     * @param fileName- название файла
     */
    public void saveFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (Person object : objects) {
                String text = object.toString() + "\n";
                writer.write(text);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
