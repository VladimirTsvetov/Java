package org.gb.genpatterns.task;

import org.gb.genpatterns.memento.Memento;
import org.gb.genpatterns.memento.Mementoble;

import java.time.LocalDateTime;

public class TaskItem implements Solvable, Mementoble {
    private  Long id;
    private String subtask;
    private String remark;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deadLine;

    public Long getId() {
        return id;
    }
    @Override
    public String getSubtask() {
        return subtask;
    }
    @Override
    public String getRemark() {
        return remark;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubtask(String subtask) {
        this.subtask = subtask;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }

    public TaskItem() {
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                "id=" + id +
                ", subtask='" + subtask + '\'' +
                ", remark='" + remark + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deadLine=" + deadLine +
                '}';
    }


    public void setMemento(Memento memento) {
        this.id = memento.getState().getId();
        this.subtask = memento.getState().getSubtask();
        this.remark = memento.getState().getRemark();
        this.createdAt = memento.getState().getCreatedAt();
        this.deadLine = memento.getState().getDeadLine();
        this.updatedAt = memento.getState().getUpdatedAt();
    }

    public Memento createMemento(){
        Memento memento = new Memento();
        memento.setState(this);
        return memento;
    }

    public static class Builder{
        private TaskItem taskItem;
        public Builder(){
            taskItem = new TaskItem();
        }
        public Builder withSubtask(String subtask){
            taskItem.setSubtask(subtask);
            return this;
        }

        public Builder withRemark(String remark){
            taskItem.setRemark(remark);
            return this;
        }
        public Builder withCreatedAt(LocalDateTime created){
            taskItem.setCreatedAt(created);
            return this;
        }

        public Builder withUpdatedAt(LocalDateTime updated){
            taskItem.setUpdatedAt(updated);
            return this;
        }

        public Builder withDeadLine(LocalDateTime deadLine){
            taskItem.setDeadLine(deadLine);
            return this;
        }
        public TaskItem build(){
            return taskItem;
        }
    }
}
