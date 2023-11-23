package com.exemplo.taskapi.controller;

import com.exemplo.taskapi.model.Task;
import com.exemplo.taskapi.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Task> getAllTask(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable long id){
        return repository.findById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return repository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task updateTask){
        updateTask.setId(id);
        return  repository.save(updateTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id){
        repository.delete(id);
    }
}