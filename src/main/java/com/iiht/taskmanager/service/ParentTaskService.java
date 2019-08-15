package com.iiht.taskmanager.service;

import com.iiht.taskmanager.entity.ParentTask;
import com.iiht.taskmanager.model.ParentTaskDto;

import java.util.List;

public interface ParentTaskService {
    List<ParentTask> getAllParentTasks();
    ParentTask getParentTaskByParentId(Long id);
    ParentTaskDto convertParentTaskEntitytoDto(ParentTask parentTask);
}
