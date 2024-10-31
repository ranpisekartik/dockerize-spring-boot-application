package com.learnwithkartik.dockerizespringbootapplication.controller;

import com.learnwithkartik.dockerizespringbootapplication.dao.EmployeeRepository;
import com.learnwithkartik.dockerizespringbootapplication.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") String employeeId){
        logger.info("Trying to get employee with id {}",employeeId);
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new RuntimeException(String.format("Unable to find employee with id %s",employeeId)));
        logger.info("Found one employee with id {}",employeeId);
        return employee;
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee){
        logger.info("Trying to create employee with id {}",employee.toString());
        employeeRepository.insert(employee);
        logger.info("Employee created with id {}",employee.getId());

    }


}
