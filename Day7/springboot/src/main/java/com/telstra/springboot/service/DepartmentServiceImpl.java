package com.telstra.springboot.service;

import com.telstra.springboot.entity.Department;
import com.telstra.springboot.error.DepartmentNotFoundException;
import com.telstra.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentID) throws DepartmentNotFoundException {
        Optional<Department> department=  departmentRepository.findById(departmentID);
    if(!department.isPresent()){
        throw new DepartmentNotFoundException("Department not available");
    }
    return department.get();

    }

    @Override
    public void deleteDepartmentById(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public Department updateDepartmentById(Long departmentID, Department department) {
        //get dept from db
        Department dept = departmentRepository.findById(departmentID).get();
        //then update
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase((department.getDepartmentName()))){
            dept.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase((department.getDepartmentAddress()))){
            dept.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase((department.getDepartmentCode()))){
            dept.setDepartmentCode(department.getDepartmentCode());
        }
        return  departmentRepository.save(dept);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }



}
