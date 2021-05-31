package com.thecodereveal.app.api;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import com.thecodereveal.api.TaskApi;
import com.thecodereveal.app.services.TaskService;
import com.thecodereveal.model.Task;

@Controller
public class TaskControllerImpl implements TaskApi {

	@Autowired
	private TaskService taskService;
	
	@Override
	public ResponseEntity<Task> createTask(@Valid Task task) {
		try {
			Task taskResponse=taskService.createTask(task);
			return new ResponseEntity<>(taskResponse,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Task> deleteTask(Integer id) {
		try {
			Long taskId=(Long)id.longValue();
			taskService.deleteTask(taskId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}

	@Override
	public ResponseEntity<List<Task>> getAllTasks() {
		return new ResponseEntity<>(taskService.getAllTasks(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Task> getTasks(Integer id) {
		
		try {
			Long taskId=(Long)id.longValue();
			return new ResponseEntity<>(taskService.getTasks(taskId),HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Task> updateTask(Integer id, @Valid Task task) {
		try {
			Long taskId=(Long)id.longValue();
			return new ResponseEntity<>(taskService.updateTask(taskId,task),HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
}
