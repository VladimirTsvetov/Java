package org.gb.genpatterns;

import org.gb.genpatterns.task.TaskItem;
import org.gb.genpatterns.task.TaskItemProxy;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LocalDateTime localDateTime = LocalDateTime.of(2023, Month.MAY, 14, 12, 30);
        TaskItem taskItem = new TaskItem.Builder()
                .withSubtask("Задача 1")
                .withRemark("Примечание к задаче")
                .withDeadLine(localDateTime)
                .build();
        System.out.println(taskItem);

        TaskItemProxy taskItemProxy = new TaskItemProxy(taskItem);
        System.out.println(taskItemProxy.getSubtask() + " вызвана " + taskItemProxy.getTaskCallCounter() + "раз");
    }
}