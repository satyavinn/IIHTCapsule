package com.iiht.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.*;

public class TaskDto {

    private Long taskId;

    private String task;

    private int priority;

    private boolean inProgress;

    private Long parentId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "taskId=" + taskId +
                ", task='" + task + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priority=" + priority +
                ", inProgress=" + inProgress +
                ", parentId=" + parentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto taskDto = (TaskDto) o;
        return priority == taskDto.priority &&
                inProgress == taskDto.inProgress &&
                Objects.equals(taskId, taskDto.taskId) &&
                Objects.equals(task, taskDto.task) &&
                Objects.equals(parentId, taskDto.parentId) &&
                Objects.equals(startDate, taskDto.startDate) &&
                Objects.equals(endDate, taskDto.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, task, priority, inProgress, parentId, startDate, endDate);
    }
}
