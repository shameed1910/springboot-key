package com.example.keycloak.springbootkeycloacksecurity.controller;

import com.example.keycloak.springbootkeycloacksecurity.model.Employee;
import com.example.keycloak.springbootkeycloacksecurity.repository.EmployeeRepository;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;



    /*List<Employee> employeesList= Arrays.asList(new Employee(1,"hameed","IT"),
            new Employee(1,"shaik","IT"));*/


    @RolesAllowed("app_user")
    @PostMapping("/products")
    public ResponseEntity<Employee> save(@RequestBody Employee employee ){
        return ResponseEntity.ok(repository.save(employee));
    }

    @RolesAllowed("app_user")
    @GetMapping("/products")
    public ResponseEntity<List<Employee>> getAll(){
        return  ResponseEntity.ok(repository.findAll());
    }
}
