package com.starmadegeek.employeeservice.controller;

import com.starmadegeek.employeeservice.model.Employee;
import com.starmadegeek.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add:{}", employee);
        return employeeRepository.add(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id){
        LOGGER.info("Employee find: id:{} ", id);
        return employeeRepository.findById(id);
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Employee findAll");
        return employeeRepository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId){
        LOGGER.info("Employee find: DepartmentId: {}", departmentId);
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
