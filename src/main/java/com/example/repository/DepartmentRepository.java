package com.example.repository;

import com.example.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private List<Department> departmentList = new ArrayList<>();

    public Department addDepartment(Department department){
        departmentList.add(department);
        return department;
    }

    public Department findById(Long id){
        Department department =  departmentList.stream().filter(dd -> dd.getId().equals(id)).findFirst().orElseThrow();
        return department;
    }

    public List<Department> findAll(){
        return departmentList;
    }
}
