package com.example.controller;

import com.example.client.EmployeeServiceClient;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.repository.DepartmentRepository;
import jakarta.ws.rs.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeServiceClient employeeServiceClient;


    @PostMapping(value = "/add")
    public Department addDepartment(@RequestBody Department department){
        log.info("adding department: {}", department);
        return departmentRepository.addDepartment(department);
    }


    @GetMapping(value = "/all")
    public List<Department> findAll(){
        List<Department> departmentList = departmentRepository.findAll();
        log.info("find all departments: {}", departmentList);
        return departmentList;
    }

    @GetMapping(value = "/{id}")
    public Department findById(@PathVariable Long id){
        Department department = departmentRepository.findById(id);
        List<Employee> employeeList = employeeServiceClient.findByDepartmentId(id);
        department.setEmployees(employeeList);
        log.info("find department by id: {}", department);
        return department;
    }
}
