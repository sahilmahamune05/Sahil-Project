package com.task.task_manager.module;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE)
	private int id;
	
	private String title;
	
	private String description;
	
	private Date duedate;
	
	private String satus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public String getSatus() {
		return satus;
	}

	public void setSatus(String satus) {
		this.satus = satus;
	}

	public Task(int id, String title, String description, Date duedate, String satus) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.duedate = duedate;
		this.satus = satus;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", duedate=" + duedate
				+ ", satus=" + satus + "]";
	}
	
	
	
	
}
