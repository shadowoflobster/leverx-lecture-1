package org.example;


public class Main {
    public static void main(String args[]){
        System.out.println("Hello LeverX");

        Car mercedes = new Car("Mercedes", 250,1800,30);
        mercedes.drive(100);
        mercedes.drive(20);
        mercedes.drive(200);
        mercedes.refuel(30);
        mercedes.drive(200);
    }
}