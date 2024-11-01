package com.example.client;

import com.example.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeServiceClient {

    @GetExchange(value = "/employee/departmentId/{departmentId}")
    List<Employee> findByDepartmentId(@PathVariable Long departmentId);

    }
