package org.example;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello LeverX");


        Car mercedes = new Car("Mercedes", 250,1800,30);
        Car.Engine engine = mercedes.new Engine();
        Car.Manual manual = new Car.Manual();
        manual.print();
        engine.start();
        engine.start();
        mercedes.drive(100);
        mercedes.drive(20);
        engine.stop();
        engine.stop();
        mercedes.drive(200);
        mercedes.refuel(30);
        mercedes.drive(200);
        System.out.println("name of this car is: "+mercedes.getName());
    }
}