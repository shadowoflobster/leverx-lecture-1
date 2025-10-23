package org.example;

public class Car {
    private String name;
    private final int horsePower;
    private final int weight;
    private float fuelLevel;
    private float fuelConsumption;

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

    public String getName(){
        return name;
    }
    public int getHorsePower() {
        return horsePower;
    }
    public int getWeight(){
        return weight;
    }
    public float getFuelConsumption(){
        return fuelConsumption;
    }
    public void setName(String  name){
        this.name=name;
    }

}
