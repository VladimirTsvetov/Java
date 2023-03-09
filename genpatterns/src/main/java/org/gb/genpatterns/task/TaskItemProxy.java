package org.gb.genpatterns.task;

public class TaskItemProxy implements Solvable{

    private int taskCallCounter;
    private int remarkCallCounter;
    private TaskItem taskItem;

    public TaskItemProxy(TaskItem taskItem) {
        this.taskItem = taskItem;
    }
    @Override
    public String getSubtask() {
        taskCallCounter++;
        return taskItem.getSubtask();


    }

    public int getTaskCallCounter() {
        remarkCallCounter++;
        return taskCallCounter;
    }

    public int getRemarkCallCounter() {
        return remarkCallCounter;
    }

    @Override
    public String getRemark() {
        return taskItem.getRemark();
    }



}
