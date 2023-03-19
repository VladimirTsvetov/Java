package com.gb.interview;

public class Main {
    public static void main(String[] args) {
        LightWeightCar lightWeightCar = new LightWeightCar();
        Ferrari ferrari = new Ferrari();

        lightWeightCar.setDriver();
        lightWeightCar.start();
        lightWeightCar.move();
        lightWeightCar.stop();

        ferrari.open();
        ferrari.start();
        ferrari.move();
        ferrari.stop();

    }
}