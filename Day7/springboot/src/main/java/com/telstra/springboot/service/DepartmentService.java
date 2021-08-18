package com.telstra.springboot.service;

import com.telstra.springboot.entity.Department;
import com.telstra.springboot.error.DepartmentNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentID) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentID);


    public Department updateDepartmentById(Long departmentID, Department department);

    public Department fetchDepartmentByName(String departmentName);

    }
