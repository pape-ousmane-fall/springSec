package com.mapsn.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapsn.entities.Task;
import com.mapsn.repository.ITaskRepository;

@RestController
public class TaskRestController {
	
	private ITaskRepository iTaskRepository;
	public TaskRestController(ITaskRepository iTaskRepository) {
		super();
		this.iTaskRepository = iTaskRepository;
	}

	@GetMapping("/tasks")
	public List<Task> listTask(){
		return iTaskRepository.findAll();
	}
	@PostMapping("/task")
	public Task save(@RequestBody Task task) {
		return iTaskRepository.save(task);
	}

}
