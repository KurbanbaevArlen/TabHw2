package com.company;

public class Drivers {
    private int id;
    private String name;
    private String bus;

//    public Drivers(int id, String name, String bus) {
//        this.id = id;
//        this.name = name;
//        this.bus = bus;
//    }

        public static Drivers readDrivers(int id,String name,String bus){
        Drivers drivers = new Drivers();
        drivers.id = id;
        drivers.name = name;
        drivers.bus = bus;
        return drivers;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bus='" + bus + '\'' +
                '}';
    }
}
