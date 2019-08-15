package com.iiht.taskmanager.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "parent_task")
public class ParentTask {

    @Id
    @Column(name = "parent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parentId;

    @Column(name = "parent_task")
    private String parentTask;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentTask that = (ParentTask) o;
        return Objects.equals(parentId, that.parentId) &&
                Objects.equals(parentTask, that.parentTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentId, parentTask);
    }

    @Override
    public String toString() {
        return "ParentTask{" +
                "parentId=" + parentId +
                ", parentTask='" + parentTask + '\'' +
                '}';
    }
}
