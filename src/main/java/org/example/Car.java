package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Car {
    private static final float HORSEPOWER_DIVIDER = 2f;
    private static final float WEIGHT_DIVIDER = 2f;
    private static final float DISTANCE_DIVIDER_TO_CALCULATE_FUEL = 2f;



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
        this.fuelConsumption = ((horsePower / HORSEPOWER_DIVIDER) + (weight / WEIGHT_DIVIDER)) / 100;
    }

    //Inner non-static class replaced with anonymous class
    Engine engine = new Engine() {
        @Override
        public void start() {
            if (!engineRunning) {
                engineRunning = true;
                System.out.println("Engine started running");
            } else
                System.out.println("Engine is already running");
        }


        @Override
        public void stop() {
            if (engineRunning) {
                engineRunning = false;
                System.out.println("Engine stopped running");
            } else {
                System.out.println("Engine is already stopped");
            }
        }
    };

    //Inner static class replaced with lambda function
    Manual manual = () -> {
        System.out.print("""
                Welcome to manual
                 \
                To start engine please use Engine.start method
                To stop engine please use Engine.stop method\s
                To drive car use Car.drive(distance(int)) method (Remember! Engine must be on)\s
                To refuel car use Car.refuel(fuel(float)) method (Remember! Engine must be off)\s
                """);
    };


    public void drive(int distance) {
        if (engineRunning) {
            final float requiredFuel = (float) distance / DISTANCE_DIVIDER_TO_CALCULATE_FUEL * fuelConsumption;
            if (requiredFuel < fuelLevel) {
                fuelLevel -= requiredFuel;
                System.out.println("You drove " + distance + "KM, " + fuelLevel + " Liters of fuel remaining.");

                //Local class replaced by Lambda function
                Report driveReport = () -> {
                    //requiredFuel is final so it can be accessed by local class
                    System.out.println("Fuel consumed during trip: " + requiredFuel + "L");
                    //distance method parameter is effectively final
                    System.out.println("Distance driven during trip: " + distance + "km");
                };
                driveReport.print();

            } else {
                System.out.println("You don't have enough fuel. (Required: " + requiredFuel + "L, your fuel level: " + fuelLevel + "L)");
            }
        } else {
            System.out.println("Engine must be running to drive car");
        }


    }

    public void refuel(float fuel) {
        if (!engineRunning) {
            this.fuelLevel += fuel;
            System.out.println("You added " + fuel + "L fuel");

            //Local class replaced by lambda function
            Report refuelReport = () -> {
                System.out.println("Fuel added during refuel: " + fuel + "L");
            };

            refuelReport.print();
        } else {
            System.out.println("Please turn off your engine before refueling");
        }

    }
}