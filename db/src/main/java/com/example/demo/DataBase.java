package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

/**
 * работа с файлом
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
        try {                                               //пробуем
            File file = new File(fileName);                 //создаем файл типа File
            FileReader fr = new FileReader(file);           //с помощью FileReader считываются файлы
            BufferedReader reader = new BufferedReader(fr); //BufferedReader читает текст из потока ввода символов, буферизуя прочитанные символы, чтобы обеспечить эффективное считывание символов, массивов и строк
            String line = reader.readLine();                //считываем строку
            while (line != null) {
                Person s = new Person();                    //создаем объект s типа Person
                String[] split = line.split(", ");    //заносим поля Person в массив строк split
                s.setParams(Integer.parseInt(split[0]), split[1], split[2], split[3],Integer.parseInt(split[4]),Integer.parseInt(split[5]),Integer.parseInt(split[6])); //parseInt преобразует строку в число
                objects.add(s);             // добавляем s в конец списка objects
                line = reader.readLine();   //считываем следующую строку
            }
        } catch (IOException e) {           //если не получилось, кидаем исключение
            e.printStackTrace();
        }
    }

    /**
     * Считывает данные с таблицы и записывает в файл
     * @param fileName- название файла
     */
    public void saveFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) { //с помощью FileWriter создаем файлы
            for (Person object : objects) {                 //проходимся по списку
                String text = object.toString() + "\n";     //преобразуем в строку
                writer.write(text);                         //записываем в файл
            }
        } catch (IOException ex) {                          //если не получилось, кидаем исключение
            System.out.println(ex.getMessage());
        }
    }

}
