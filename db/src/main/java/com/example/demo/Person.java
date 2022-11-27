package com.example.demo;

import java.io.IOException;

/**
 * @avtor Борисова Екатерина ИВТ-20
 */
public class Person {
    private int ID;
    private String fam;
    private String name;
    private String otch;
    private int age;
    private int series;
    private int number;

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


    Person(int ID,String fam,String name,String otch, int age,int series, int number) throws IOException {
        setParams(ID,fam,name,otch,age,series,number);
    }

    public int getID(){
        return ID;
    }
    public void setID(int ID) throws IOException {
        if(ID > 0)
            this.ID = ID;
        else
            throw new IOException("ID cant be less then 0!");
    }

    public String getFam() {
        return fam;
    }
    public void setFam(String fam) throws IOException {
        if(!fam.equals(""))
            this.fam = fam;
        else
            throw new IOException("Fam cant be null!");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) throws IOException {
        if(!name.equals(""))
            this.name = name;
        else
            throw new IOException("Name cant be null!");
    }
    public String getOtch() {
        return otch;
    }
    public void setOtch(String otch) throws IOException {
        if(!otch.equals(""))
            this.otch = otch;
        else
            throw new IOException("Otch cant be null!");
    }


    public int getAge() {
        return age;
    }
    public void setAge(int age) throws IOException {
        if(age > 0)
            this.age = age;
        else
            throw new IOException("Age cant be less then 0!");
    }

    public int getSeries(){
        return series;
    }
    public void setSeries(int series) throws IOException {
        if(series > 0)
            this.series = series;
        else
            throw new IOException("series cant be less then 0!");
    }

    public int getNumber(){
        return number;
    }
    public void setNumber(int number) throws IOException {
        if(number > 0)
            this.number = number;
        else
            throw new IOException("Number cant be less then 0!");
    }

    public void setParams(int ID,String fam,String name,String otch, int age,int series, int number) throws IOException {
        setID(ID);
        setFam(fam);
        setName(name);
        setOtch(otch);
        setAge(age);
        setSeries(series);
        setNumber(number);
    }

    public String toString(){
        return getID()+", "+getFam()+", "+getName()+", "+ getOtch() + ", " + getAge() + ", " + getSeries() + ", " + getNumber();
    }

}
