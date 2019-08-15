package com.iiht.taskmanager.service;

import com.iiht.taskmanager.entity.Task;
import com.iiht.taskmanager.model.TaskDto;

import java.util.List;

public interface TaskService  {
	Task addNewTask(Task task);
	List<Task> getAllTasks();
	Task updateTask(Task task);
	Task getTaskById(Long id);
	Task convertTaskDtoToEntity(TaskDto taskDto);
	TaskDto convertTaskEntityToDto(Task task);
}
