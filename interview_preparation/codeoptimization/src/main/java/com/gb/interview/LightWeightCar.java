package com.gb.interview;

public class LightWeightCar extends Car {

    public void setDriver(){
        System.out.println("The driver in a " + getName() + " car!");
    }
    public LightWeightCar(){
        setName("LightWeightCar");
    }

}
