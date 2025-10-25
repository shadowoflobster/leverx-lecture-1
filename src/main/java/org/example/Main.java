package org.example;

import java.util.ArrayList;
import java.util.function.Function;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello LeverX");

        Car mercedes = new Car("Mercedes", 250,1800,300);
        Car.Engine mercedesEngine = mercedes.new Engine();
        Car.Manual manual = new Car.Manual();

        manual.print();
        mercedesEngine.start();
        mercedes.drive(100);
        mercedes.drive(20);
        mercedesEngine.stop();
        mercedesEngine.stop();
        mercedes.drive(200);
        mercedes.refuel(30);
        mercedes.drive(200);
        System.out.println("name of this car is: "+mercedes.getName());

        Car bmw = new Car("BMW", 230, 1700,250);
        Car.Engine bmwEngine = bmw.new Engine();

        ArrayList<Car> carList = new ArrayList<>();
        carList.add(mercedes);
        carList.add(bmw);


        /* Anonymous classs implementing function interface
         it will race cars from a list and returns the fastest one */
        Function<ArrayList<Car>,Car> race = cars -> {
            Car fastest = cars.get(0);
            for (Car c : cars) {
                if (c.getHorsePower() > fastest.getHorsePower())
                    fastest = c;
            }

            return fastest;
        };

        System.out.println("Winner of race is: " + race.apply(carList).getName());

    }
}