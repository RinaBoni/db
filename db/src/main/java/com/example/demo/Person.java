package com.example.demo;

import java.io.IOException;

/**
 * @avtor Борисова Екатерина ИВТ-20
 */
public class Person {
    private int ID;         //поле id
    private String fam;     //поле фамилия
    private String name;    //поле имя
    private String otch;    //поле отчество
    private int age;        //поле возраст
    private int series;     //поле серия(паспорта)
    private int number;     //поле номер(паспорта)

    /**
     * Конструктор по умолчанию
     */
    Person(){
        this.ID=0;
        this.fam = "Иванов";
        this.name = "Иван";
        this.otch = "Иванович";
        this.age = 40;
        this.series= 1122;
        this.number = 112233;

    }


    /**
     * конструктор, который сразу задает все значения
     * @param ID
     * @param fam фамилия
     * @param name имя
     * @param otch отчество
     * @param age возраст
     * @param series серия(паспорта)
     * @param number номер(паспорта)
     * @throws IOException
     */
    Person(int ID,String fam,String name,String otch, int age,int series, int number) throws IOException {
        setParams(ID,fam,name,otch,age,series,number);
    }

    public int getID(){
        return ID;
    }

    /**
     * Задаем id. Оно не может быть <= 0
     * @param ID
     * @throws IOException
     */
    public void setID(int ID) throws IOException {
        if(ID > 0)
            this.ID = ID;
        else
            throw new IOException("ID cant be less then 0!");
    }

    public String getFam() {
        return fam;
    }

    /**
     * задаем фамилию. не может быть пустой строкой
     * @param fam
     * @throws IOException
     */
    public void setFam(String fam) throws IOException {
        if(!fam.equals(""))
            this.fam = fam;
        else
            throw new IOException("Fam cant be null!");
    }

    public String getName() {
        return name;
    }

    /**
     * задаем имя. не может быть пустой строкой
     * @param name
     * @throws IOException
     */
    public void setName(String name) throws IOException {
        if(!name.equals(""))
            this.name = name;
        else
            throw new IOException("Name cant be null!");
    }
    public String getOtch() {
        return otch;
    }


    /**
     * задаем отчество. не может быть пустой строкой
     * @param otch
     * @throws IOException
     */
    public void setOtch(String otch) throws IOException {
        if(!otch.equals(""))
            this.otch = otch;
        else
            throw new IOException("Otch cant be null!");
    }


    public int getAge() {
        return age;
    }

    /**
     * задаем возраст. не может быть меньше нуля
     * @param age
     * @throws IOException
     */
    public void setAge(int age) throws IOException {
        if(age > 0)
            this.age = age;
        else
            throw new IOException("Age cant be less then 0!");
    }

    public int getSeries(){
        return series;
    }

    /**
     * задаем серию(паспорта). не может быть меньше нуля
     * @param series
     * @throws IOException
     */
    public void setSeries(int series) throws IOException {
        if(series > 0)
            this.series = series;
        else
            throw new IOException("series cant be less then 0!");
    }

    public int getNumber(){
        return number;
    }

    /**
     * задаем номер(паспорта). не может быть меньше нуля
     * @param number
     * @throws IOException
     */
    public void setNumber(int number) throws IOException {
        if(number > 0)
            this.number = number;
        else
            throw new IOException("Number cant be less then 0!");
    }

    /**
     * задает сразу все поля
     * @param ID
     * @param fam
     * @param name
     * @param otch
     * @param age
     * @param series
     * @param number
     * @throws IOException
     */
    public void setParams(int ID,String fam,String name,String otch, int age,int series, int number) throws IOException {
        setID(ID);
        setFam(fam);
        setName(name);
        setOtch(otch);
        setAge(age);
        setSeries(series);
        setNumber(number);
    }

    /**
     * совмещает все в одну строку
     * @return строка
     */
    public String toString(){
        return getID()+", "+getFam()+", "+getName()+", "+ getOtch() + ", " + getAge() + ", " + getSeries() + ", " + getNumber();
    }

}
