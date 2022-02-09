package com.company.lesson8.hierarchy.auto;

import com.company.lesson8.hierarchy.Auto;

public class Car extends Auto {
    private int accelerationTime;

    public Car(String name, int fuelConsumption, int fuelCapacity, int maxSpeed, double speed,
               int driverPlaces, String serialNumber, int accelerationTime) {
        super(name, fuelConsumption, fuelCapacity, maxSpeed, speed, driverPlaces, serialNumber);

        this.accelerationTime = accelerationTime;
    }

    public int getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(int accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return accelerationTime == car.accelerationTime;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serialNumber='" + serialNumber + '\'' +
                ", name='" + name + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", fuelCapacity=" + fuelCapacity +
                ", speed=" + speed +
                ", maxSpeed=" + maxSpeed +
                ", driverPlaces=" + driverPlaces +
                ", accelerationTime=" + accelerationTime +
                '}';
    }
}
