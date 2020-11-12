/*
 * This file is generated by jOOQ.
 */
package com.sda.taskmanager.entity.tables.pojos;


import java.io.Serializable;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer taskId;
    private String  taskDescription;
    private Integer taskPriority;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employees) {
        this.employee = employees;
    }

    private Integer taskPerformer;

    public Employee employee;

    public Task() {}

    public Task(Task value) {
        this.taskId = value.taskId;
        this.taskDescription = value.taskDescription;
        this.taskPriority = value.taskPriority;
        this.taskPerformer = value.taskPerformer;
    }

    public Task(
        Integer taskId,
        String  taskDescription,
        Integer taskPriority,
        Integer taskPerformer
    ) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
        this.taskPerformer = taskPerformer;
    }

    /**
     * Getter for <code>tasks.task.task_id</code>.
     */
    public Integer getTaskId() {
        return this.taskId;
    }

    /**
     * Setter for <code>tasks.task.task_id</code>.
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * Getter for <code>tasks.task.task_description</code>.
     */
    public String getTaskDescription() {
        return this.taskDescription;
    }

    /**
     * Setter for <code>tasks.task.task_description</code>.
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * Getter for <code>tasks.task.task_priority</code>.
     */
    public Integer getTaskPriority() {
        return this.taskPriority;
    }

    /**
     * Setter for <code>tasks.task.task_priority</code>.
     */
    public void setTaskPriority(Integer taskPriority) {
        this.taskPriority = taskPriority;
    }

    /**
     * Getter for <code>tasks.task.task_performer</code>.
     */
    public Integer getTaskPerformer() {
        return this.taskPerformer;
    }

    /**
     * Setter for <code>tasks.task.task_performer</code>.
     */
    public void setTaskPerformer(Integer taskPerformer) {
        this.taskPerformer = taskPerformer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Task (");

        sb.append(taskId);
        sb.append(", ").append(taskDescription);
        sb.append(", ").append(taskPriority);
        sb.append(", ").append(taskPerformer);

        sb.append(")");
        return sb.toString();
    }
}