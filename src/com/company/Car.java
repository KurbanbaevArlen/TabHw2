package com.company;

public class Car {
    private int id;
    private String name;
    private String driver;
    private String state;

    public Car(){}

//    public Car(int id, String name, String driver, String state) {
//        this.id = id;
//        this.name = name;
//        this.driver = driver;
//        this.state = state;
//    }

    public static Car readCar(int id, String name, String driver, String state){
        Car cars = new Car();
        cars.id = id;
        cars.name= name;
        cars.driver= driver;
        cars.state=state;
        return cars;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public  void infoCar(){
        System.out.println(getId()+"  | "+getName()+"    |  "+getDriver()+"   | "+getState());
    }

    @Override
    public String toString() {
        return
                "\n N      : " + id +
                "\n Bus    :" + name +
                "\n Driver : " + driver +
                "\n State  :" + state ;
    }
}
