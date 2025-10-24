package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Car {
    @Setter
    private String name;
    private final int horsePower;
    private final int weight;
    private float fuelLevel;
    private float fuelConsumption;
    private boolean engineRunning = false;

    public Car(String name, int horsePower, int weight, int fuelLevel){
        this.name=name;
        this.horsePower=horsePower;
        this.weight=weight;
        this.fuelLevel=fuelLevel;
        calculateFuelConsumption();
    }

    public void calculateFuelConsumption(){
        this.fuelConsumption = ((horsePower / 2f) + (weight / 2f))/100;
    }

    public void drive(int distance){
        float requiredFuel = (float) distance / 100f * fuelConsumption;
        if(requiredFuel < fuelLevel){
            fuelLevel -= requiredFuel;
            System.out.println("You drove "+distance+"KM, "+fuelLevel+" Liters of fuel remaining.");
        }else System.out.println("You don't have enough fuel. (Required: "+ requiredFuel+"L, your fuel level: "+fuelLevel+"L)");
    }

    public void refuel(float fuel){
        this.fuelLevel+=fuel;
        System.out.println("You added "+fuel+"L fuel");
    }
}