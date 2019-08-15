package com.iiht.taskmanager.service;

import com.iiht.taskmanager.entity.ParentTask;
import com.iiht.taskmanager.model.ParentTaskDto;
import com.iiht.taskmanager.repository.ParentTaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentTaskServiceImpl implements ParentTaskService {

    @Autowired
    ParentTaskRepository parentTaskRepository;

    @Override
    public List<ParentTask> getAllParentTasks() {
        return parentTaskRepository.findAll();
    }

    @Override
    public ParentTask getParentTaskByParentId(Long id) {
        return parentTaskRepository.findByParentId(id);
    }

    @Override
    public ParentTaskDto convertParentTaskEntitytoDto(ParentTask parentTask)
    {
        ParentTaskDto parentTaskDto = new ParentTaskDto();
        parentTaskDto.setParentId(parentTask.getParentId());
        parentTaskDto.setParentTask(parentTask.getParentTask());
        return parentTaskDto;
    }

}
