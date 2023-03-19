package com.gb.interview;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle());
        shapeList.add(new Square());
        shapeList.add(new Rectangle());

        shapeList.stream().forEach(shape -> shape.draw());
    }
}