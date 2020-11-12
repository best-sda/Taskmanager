package com.sda.taskmanager.controller;

import com.sda.taskmanager.entity.tables.pojos.Employee;
import com.sda.taskmanager.entity.tables.pojos.Task;
import com.sda.taskmanager.repository.EmployeeRepository;
import com.sda.taskmanager.repository.TaskRepository;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
    final private TaskRepository taskRepository;
    final private EmployeeRepository employeeRepository;

    @Autowired
    public MainController(TaskRepository taskRepository, EmployeeRepository employeeRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/tasks" )
    public List<Task> getTasks(){
        return this.taskRepository.findAll(DSL.noCondition());
    }
    @PostMapping("/tasks/create")
    public Task createTask(@Validated @RequestBody Task task) {
        return (Task) taskRepository.insert(task);
    }
    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable("id") Long id) {
        return taskRepository.find(id);
    }
    @DeleteMapping("/tasks/delete")
    public boolean deleteTask(@PathVariable("id") Long id) {
       return taskRepository.delete(id);
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee() {return employeeRepository.findAll(DSL.noCondition());}
    @PostMapping("/employee/create")
    public Employee createEmployee(@Validated @RequestBody Task task) {
        return (Employee) employeeRepository.insert(task);
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return (Employee) employeeRepository.find(id);
    }
    @DeleteMapping("/employee/delete")
    public boolean deleteEmployee(@PathVariable("id") Long id) {
        return employeeRepository.delete(id);
    }
}
