package com.iiht.taskmanager.controller;

import com.iiht.taskmanager.entity.Task;
import com.iiht.taskmanager.model.ParentTaskDto;
import com.iiht.taskmanager.model.TaskDto;
import com.iiht.taskmanager.service.ParentTaskService;
import com.iiht.taskmanager.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/taskmanager")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskManagerController {

    @Autowired
    private ParentTaskService parentTaskService;

    @Autowired
    private TaskService taskService;


    @PostMapping("/task/add")
    public ResponseEntity<Object> addTask(@RequestBody TaskDto taskDto) {
        if (Optional.ofNullable(taskDto).isPresent()) {
            TaskDto updatedTaskDto = taskService.convertTaskEntityToDto(
                    taskService.addNewTask(
                            taskService.convertTaskDtoToEntity(taskDto)
                    ));
            return new ResponseEntity<>(updatedTaskDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Invalid Task", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/task")
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks().stream().map(task -> taskService.convertTaskEntityToDto(task)).collect(Collectors.toList());
    }

    @GetMapping("/parenttask")
    public List<ParentTaskDto> getAllParentTasks() {
        return parentTaskService.getAllParentTasks().stream().map(parentTask -> parentTaskService.convertParentTaskEntitytoDto(parentTask)).collect(Collectors.toList());
    }

    @PutMapping("/task/update")
    public ResponseEntity<Object> updateTask(@RequestBody TaskDto taskDto) {
        if (Optional.ofNullable(taskDto).isPresent()) {
            Task task = taskService.getTaskById(taskDto.getTaskId());
            task.setTaskId(taskDto.getTaskId());
            task.setTask(taskDto.getTask());
            task.setPriority(taskDto.getPriority());
            task.setParentTask(parentTaskService.getParentTaskByParentId(taskDto.getParentId()));
            task.setStartDate(taskDto.getStartDate());
            task.setEndDate(taskDto.getEndDate());
            TaskDto updatedTaskDto = taskService.convertTaskEntityToDto(taskService.updateTask(task));
            return new ResponseEntity<>(updatedTaskDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Task", HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/task/end")
    public ResponseEntity<Object> endTask(@RequestBody TaskDto taskDto) {
        if (Optional.ofNullable(taskDto).isPresent()) {
            Task task = taskService.getTaskById(taskDto.getTaskId());
            task.setTaskId(taskDto.getTaskId());
            task.setTask(taskDto.getTask());
            task.setPriority(taskDto.getPriority());
            task.setParentTask(parentTaskService.getParentTaskByParentId(taskDto.getParentId()));
            task.setStartDate(taskDto.getStartDate());
            task.setEndDate(taskDto.getEndDate());
            task.setInProgress(false);
            TaskDto updatedTaskDto = taskService.convertTaskEntityToDto(taskService.updateTask(task));
            return new ResponseEntity<>(updatedTaskDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Task", HttpStatus.BAD_REQUEST);
        }
    }

}
