package org.gb.genpatterns.memento;

import org.gb.genpatterns.task.TaskItem;

import java.time.LocalDateTime;

public class Memento implements Mementoble{
    TaskItem savedTaskItem;

    public void setState(TaskItem taskItem) {
        savedTaskItem = new TaskItem();
        savedTaskItem.setId(taskItem.getId());
        savedTaskItem.setSubtask(taskItem.getSubtask());
        savedTaskItem.setRemark(taskItem.getRemark());
        savedTaskItem.setCreatedAt(taskItem.getCreatedAt());
        savedTaskItem.setUpdatedAt(taskItem.getUpdatedAt());
        savedTaskItem.setDeadLine(taskItem.getDeadLine());
    }

    public TaskItem getState(){
        return savedTaskItem;
    }
}
