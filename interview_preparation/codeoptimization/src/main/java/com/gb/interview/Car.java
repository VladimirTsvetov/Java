package com.gb.interview;

import lombok.Getter;
import lombok.Setter;
/*
    все машины заводятся, едут и останавливаются (если не об столб))
    но некоторые не имеют дверей
 */
@Getter
@Setter
abstract class Car implements Movable{
    private Engine engine;
    private String color;
    private String name;

    public void start() {
        System.out.println("Car starting");
    }

    public void stop(){
        System.out.println("Car stopped");
    }

    public void move(){
        System.out.println("Car move");
    }


}
