package com.company;

import com.company.sos.Methods;

import java.util.Random;

public class Condition implements Methods {
    private String base;
    private String route;
    private String repair;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }

    @Override
    public void changeDriver(Drivers drivers, Car car) {
        if (car.getState().equals(base)){
            car.setDriver(drivers.getName());
            drivers.setBus(car.getName());
            System.out.println(" Тепер грузовик "+ car.getName()+", его водитель "+ drivers.getName());
        }

        if (car.getState().equals(route)){
            throw new RuntimeException(" Водитель на дороге. Вы не можете сменить этот водитель.");
        }
        if (car.getState().equals(repair)){
            throw  new RuntimeException(" Грузовик в ремонте. Вы не можете сменить водитель.");
        }
    }

    @Override
    public void startDriving(Drivers drivers, Car car) {
      if (car.getState().equals(base)&& car.getDriver() != null){
          car.setState(route);
          car.setDriver(drivers.getName());
          System.out.println("Грузовик на дороге!");
      }else if (car.getState().equals(route)){
          throw new RuntimeException("Грузовик на дороге!");
      } else if (car.getState().equals(repair)) {
          Random random = new Random();
          int a = random.nextInt(1,3);
          if (a == 1){
              car.setState(route);
          }else {
              car.setState(base);
              System.out.println("Состояние грузовика " + car.getState());
          }
      }
    }

    @Override
    public void startRepair(Drivers drivers, Car car) {
      if (car.getState().equals(base)|| car.getState().equals(route)){
          car.setState(repair);
          System.out.println("Грузовик в ремонте");
      }else if (car.getState().equals(repair)){
          throw new RuntimeException("Этот грузовик уже в ремонте");
      }
    }

    @Override
    public String toString() {
        return "Condition{" +
                "base='" + base + '\'' +
                ", route='" + route + '\'' +
                ", repair='" + repair + '\'' +
                '}';
    }
}



