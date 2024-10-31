package com.learnwithkartik.dockerizespringbootapplication.dao;

import com.learnwithkartik.dockerizespringbootapplication.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    public Optional<Employee> findById(String id);

}
