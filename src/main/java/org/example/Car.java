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

    public Car(String name, int horsePower, int weight, int fuelLevel) {
        this.name = name;
        this.horsePower = horsePower;
        this.weight = weight;
        this.fuelLevel = fuelLevel;
        calculateFuelConsumption();
    }

    public void calculateFuelConsumption() {
        this.fuelConsumption = ((horsePower / 2f) + (weight / 2f)) / 100;
    }

    //Inner non-static class
    public class Engine {
        public void start() {
            if (!engineRunning) {
                engineRunning = true;
                System.out.println("Engine started running");
            } else
                System.out.println("Engine is already running");
        }

        public void stop() {
            if (engineRunning) {
                engineRunning = false;
                System.out.println("Engine stopped running");
            } else
                System.out.println("Engine is already stopped");
        }
    }

    //Inner static class
    public static class Manual {
        public void print() {
            System.out.print("""
                    Welcome to manual
                     \
                    To start engine please use Engine.start method
                    To stop engine please use Engine.stop method\s
                    To drive car use Car.drive(distance(int)) method (Remember! Engine must be on)\s
                    To refuel car use Car.refuel(fuel(float)) method (Remember! Engine must be off)\s
                    """);
        }
    }


    public void drive(int distance) {
        final float requiredFuel = (float) distance / 100f * fuelConsumption;
        if (engineRunning) {
            if (requiredFuel < fuelLevel) {
                fuelLevel -= requiredFuel;
                System.out.println("You drove " + distance + "KM, " + fuelLevel + " Liters of fuel remaining.");
            } else
                System.out.println("You don't have enough fuel. (Required: " + requiredFuel + "L, your fuel level: " + fuelLevel + "L)");
        } else System.out.println("Engine must be running to drive car");

        //Local class
        class DriveReport{
            void print(){
                //requiredFuel is final so it can be accessed by local class
                System.out.println("Fuel consumed during trip: "+requiredFuel+"L" );
                //distance method parameter is effectively final
                System.out.println("Distance driven during trip: "+distance+"km");
            }
        }

    }

    public void refuel(float fuel) {
        if (!engineRunning) {
            this.fuelLevel += fuel;
            System.out.println("You added " + fuel + "L fuel");
        } else System.out.println("Please turn off your engine before refueling");
        class FuelReport{
            void print(){
                System.out.println("Fuel added during refuel: "+fuel+"L" );
            }
        }
    }
}