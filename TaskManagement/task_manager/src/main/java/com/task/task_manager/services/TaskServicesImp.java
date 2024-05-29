package com.task.task_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.task_manager.module.Task;
import com.task.task_manager.module.dao.TaskRepo;

@Service
public class TaskServicesImp implements TaskServices{

	@Autowired
	private TaskRepo taskRepo;
	
	@Override
	public Task addTask(Task task) {
		
		return taskRepo.save(task);
	}

	@Override
	public List<Task> taskList() {
		List<Task> findAll = taskRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteById(int id) {
		taskRepo.deleteById(id);
		
	}

	@Override
	public Task findById(int id) {
		Optional<Task> findById = taskRepo.findById(id);
		Task task =  findById.get();
		return task;
	}

	@Override
	public Task updateTask(Task task) {
		
		return taskRepo.save(task);
	}

}
