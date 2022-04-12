package com.company.person;

import com.company.Car;
import com.company.Condition;
import com.company.Drivers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE = Paths.get("./Car.json");
    public static final Path WRITE_DRIVER = Paths.get("./Drivers.json");

    public static void main(String[] arg) {
/*
        ArrayList<Car> cars = new ArrayList<>();
//        cars.add(Car.readCars(1, "Renault Megan", " ", " base "));
//        cars.add(Car.readCars(2, "Volvo FH12", " ", " base "));
//        cars.add(Car.readCars(3, "Daf XF", " ", " base "));
        cars.add(new Car(1, "Renault Megan", " ", " base "));
        cars.add(new Car(2, "Volvo FH12", " ", " base "));
        cars.add(new Car(3, "Daf XF", " ", " base "));


        ArrayList<Drivers> drivers = new ArrayList<>();
//        drivers.add(Drivers.readDrivers(1,"Sasha",""));
//        drivers.add(Drivers.readDrivers(2,"Petya",""));
//        drivers.add(Drivers.readDrivers(3,"Vasya",""));
        drivers.add(new Drivers(1, "Sasha", ""));
        drivers.add(new Drivers(2, "Petya", ""));
        drivers.add(new Drivers(3, "Vasya", ""));

        String jsonCars = GSON.toJson(cars);
        writeCar(jsonCars);
        System.out.println();
        String jsonDriver = GSON.toJson(drivers);
        System.out.println();
        writeDriver(jsonDriver);
    }
//          while (true){
//              printCar(cars);
//              System.out.println("Выберите машину : ");
//              int number = scanner.nextInt();
//              if (number == 1){
//                  System.out.println(cars.get(0));
//                  System.out.println("Нажмите 1, чтобы изменить водителя ");
//                  System.out.println("Нажмите 2, чтобы отправить на маршруть ");
//                  System.out.println("Нажмите 3, чтобы отправить в ремонт ");
//                  System.out.println("Нажмите 4, чтобы выйти ");
//                  System.out.print("Введите число : ");
//                  int num = scanner.nextInt();
//                  switch (num){
//                      case 1: condition.changeDriver(drivers.get(num -1),cars.get(num - 1));
//                          System.out.println("Вводитель успешно изменен !");
//                          printDriver(drivers);
//                      case 2: condition.startDriving(drivers.get(num -1),cars.get(num - 1));
//                          System.out.println("Вводитель вышел на маршруть ");
//                          printDriver(drivers);
//                      case 3: condition.startRepair(drivers.get(num -1),cars.get(num - 1));
//                          System.out.println("Вводитель на ремонте ");
//                          printDriver(drivers);
//                  }
//
//              }else {
//                  System.exit(0);
//
//              }
//          }


       /*  while (true){
            printCar(cars);
            System.out.print("Выберите машину : ");
            int number = scanner.nextInt();
            if (number == 1){
                try {
                    System.out.println("Выберите водителя ");
                    int numberId = scanner.nextInt();
                    condition.changeDriver(drivers.get(numberId -1),cars.get(numberId -1));
                    printCar(cars);
                    printDriver(drivers);
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }else if (number == 2){
                try {
                    System.out.println("Выберите грузовика ");
                    int numberId = scanner.nextInt();
                    condition.startDriving(drivers.get(numberId -1),cars.get(numberId -1));
                    System.out.println(cars.get(numberId -1));
                    printCar(cars);
                    printDriver(drivers);
                }catch ( RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }else if (number == 3){
                try {
                    System.out.println("Выберите грузовика ");
                    int numberId = scanner.nextInt();
                    condition.startRepair(drivers.get(numberId -1),cars.get(numberId - 1));
                    System.out.println(cars.get(numberId - 1));
                    printCar(cars);
                    printDriver(drivers);
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }else {
                System.out.println("No number");
                break;
            }
        }*/
//    }

    }
    private static void writeCar(String obje) {
        Path write = Paths.get(String.valueOf(GSON));
        try {
            Files.writeString(write, obje, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (IOException e) {
            e.getMessage();
        }
    } private static void writeDriver(String obje) {
        Path write = Paths.get(String.valueOf(GSON));
        try {
            Files.writeString(write, obje, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static String readLine() {
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(GSON));
            int a;
            while ((a = fileReader.read()) != -1) {
                json += (char) a;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;

    }
    public static void printCar(ArrayList<com.company.Car> trucks ){
        System.out.println("------------------------Trucks--------------------------");
        System.out.println("    # | Bus               | Driver            | State        ");
        System.out.println("------+-------------------+-------------------+------------ ");
        int counter = 1, tabsBus = 18, tabsDriver = 18, tabsState = 12;
        for (com.company.Car i: trucks) {
            System.out.print("  "+counter+"   | ");
            System.out.print(i.getName());
            for (int j = 0; j < tabsBus - i.getName().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("| "+i.getDriver());
            for (int j = 0; j < tabsDriver - i.getDriver().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("| "+i.getState());
            for (int j = 0; j < tabsState - i.getState().length(); j++) {
                System.out.print(" ");
            }
            counter++;
            System.out.println();
        }
    }
    public static void printDriver(ArrayList<Drivers> drivers){
        System.out.println("---------------Driver--------------");
        System.out.println("    # | Driver             | Bus         ");
        System.out.println("------+--------------------+------------    ");
        int counter = 1, tabsDriver = 19, tabsBus = 12;
        for (Drivers i:drivers) {
            System.out.print("  "+counter+"   | ");
            System.out.print(i.getName());
            for (int j = 0; j < tabsDriver - i.getName().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("| "+i.getBus()+" ");
            for (int j = 0; j < tabsBus - i.getBus().length(); j++) {
                System.out.print(" ");
            }
            counter++;
            System.out.println();
        }

    }

}