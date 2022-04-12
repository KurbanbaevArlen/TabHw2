package com.company.sos;

import com.company.Car;
import com.company.Drivers;

public interface Methods {
     void changeDriver(Drivers drivers, Car car);
     void startDriving(Drivers drivers, Car car);
     void startRepair(Drivers drivers, Car car);
}
