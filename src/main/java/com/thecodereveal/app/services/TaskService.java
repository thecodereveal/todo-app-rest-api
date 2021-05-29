package com.thecodereveal.app.services;

import java.util.List;

import com.thecodereveal.model.Task;

import javassist.NotFoundException;

public interface TaskService {

	public Task createTask(Task task);
	public void deleteTask(Long id) throws NotFoundException;
	public Task getTasks(Long id);
	public Task updateTask(Long id,Task task) throws NotFoundException;
	public List<Task> getAllTasks();
}
