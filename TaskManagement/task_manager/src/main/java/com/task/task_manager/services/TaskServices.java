package com.task.task_manager.services;

import java.util.List;

import com.task.task_manager.module.Task;

public interface TaskServices {
	
	public Task addTask(Task task);
	
	public List<Task>taskList();
	
	public void deleteById(int id);
	
	public Task findById(int id);
	
	public Task updateTask(Task task);

}
