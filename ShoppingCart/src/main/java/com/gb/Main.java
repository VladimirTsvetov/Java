package com.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var context = new AnnotationConfigApplicationContext
                (ProjectConfig.class);
        while (true) {
            while(true){
                System.out.println("Введите id продукта (0 - 4)");
                int id = scanner.nextInt();
                Cart shopCart = context.getBean(Cart.class);
                System.out.println("Добавить продукт? (Д/Н)");
                String code = scanner.next();
                if("Д".equals(code) || "д".equals(code)) {
                    shopCart.addById(id);
                 }
                 System.out.println(shopCart);
                System.out.println("Желаете продолжить? Д/Н");
                code = scanner.next();
                if("Д".equals(code) || "д".equals(code)) {
                    break;
                }
            }
            System.out.println("Создать новую корзину? (Д/Н)");
            String code = scanner.next();
            if("Н".equals(code) || "н".equals(code))break;

        }
    }
}