package com.task.task_manager.module.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.task_manager.module.Task;

public interface TaskRepo extends JpaRepository<Task, Integer>{

}
