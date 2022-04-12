package com.company;

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
    public static final Path WRITE_CAR = Paths.get("./Car.json");
    public static final Path WRITE_DRIVER = Paths.get("./Drivers.json");

    public static void main(int arg) {
        Scanner scanner = new Scanner(System.in);
        Condition condition = new Condition();
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(Car.readCar(1, "Renault Megan", " ", " base "));
        cars.add(Car.readCar(2, "Volvo FH12", " ", " base "));
        cars.add(Car.readCar(3, "Daf XF", " ", " base "));

        ArrayList<Drivers> drivers = new ArrayList<>();
        drivers.add(Drivers.readDrivers(1, "Sasha", ""));
        drivers.add(Drivers.readDrivers(2, "Petya", ""));
        drivers.add(Drivers.readDrivers(3, "Vasya", ""));


        String jsonCars = GSON.toJson(cars);
        writeCar(jsonCars);
        System.out.println();
        String jsonDriver = GSON.toJson(drivers);
        System.out.println();
        writeDriver(jsonDriver);

        while (true) {
            printCar(cars);
            System.out.print("Выберите машину : ");
            int number = scanner.nextInt();
            if (number == 1) {
                try {
                    System.out.println("Выберите водителя ");
                    int numberId = scanner.nextInt();
                    condition.changeDriver(drivers.get(numberId - 1), cars.get(numberId - 1));
                    printCar(cars);
                    printDriver(drivers);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else if (number == 2) {
                try {
                    System.out.println("Выберите грузовика ");
                    int numberId = scanner.nextInt();
                    condition.startDriving(drivers.get(numberId - 1), cars.get(numberId - 1));
                    System.out.println(cars.get(numberId - 1));
                    printCar(cars);
                    printDriver(drivers);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else if (number == 3) {
                try {
                    System.out.println("Выберите грузовика ");
                    int numberId = scanner.nextInt();
                    condition.startRepair(drivers.get(numberId - 1), cars.get(numberId - 1));
                    System.out.println(cars.get(numberId - 1));
                    printCar(cars);
                    printDriver(drivers);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("No number");
                break;
            }

        }
    }

    private static void writeCar(String obje ) {
        Path write = Paths.get(String.valueOf(WRITE_CAR));
        try {
            Files.writeString(write, obje, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void writeDriver(String obje ) {
        Path write = Paths.get(String.valueOf(WRITE_DRIVER));
        try {
            Files.writeString(write, obje, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printCar(List<Car> trucks ){
        System.out.println("------------------------Trucks--------------------------");
        System.out.println("    # | Bus               | Driver            | State        ");
        System.out.println("------+-------------------+-------------------+------------ ");
        int counter = 1, tabsBus = 18, tabsDriver = 18, tabsState = 12;
        for (Car i: trucks) {
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
    public static void printDriver(List<Drivers> drivers){
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
