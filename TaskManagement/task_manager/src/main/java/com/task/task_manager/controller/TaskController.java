package com.task.task_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.task_manager.module.Task;
import com.task.task_manager.services.TaskServices;

import jakarta.validation.Valid;

@Controller
public class TaskController {
	
	@Autowired
	private TaskServices ts;
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
		
	}
	//Create Operation
	@GetMapping("/addtask")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		return "taskform";
	}
	
	@PostMapping("/status")
	public String getStatus(@Valid @ModelAttribute("task") Task task, BindingResult br) {
		
		if(br.hasErrors()) {
			return "taskform";
		}
		ts.addTask(task);
		return "redirect:/home";	
	}

	//Read Operation
	@GetMapping("/tasklist")
	public String getAlltask(Model model) {
		List<Task> taskList= ts.taskList();
		model.addAttribute("tasks", taskList);
		return "displaytask";
		
	}
	
	//Delete Operation
	@PostMapping("/task/delete")
	public String deleteTask(@RequestParam("id") int id) {
		ts.deleteById(id);
		return "redirect:/tasklist";	
	}
	
	//Edit Operation
	@GetMapping("/task/edit")
	public String getEditForm(@RequestParam("id") int id,Model model) {
		Task findTask = ts.findById(id);
		model.addAttribute("task",findTask);
		return "taskupdateform";
		
	}
	@PostMapping("/tasksaveupdate")
	public String getupdate(@Valid @ModelAttribute("task") Task task,BindingResult br) {
		if(br.hasErrors()) {
			return "taskupdateform";
		}

		ts.updateTask(task);
		return "redirect:/tasklist";
	}
}
