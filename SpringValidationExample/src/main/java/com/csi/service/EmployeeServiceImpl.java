package com.csi.service;

import com.csi.entity.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeRepo employeeRepoImpl;

    public Employee signup(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public boolean signIn(String empEmail, String empPassword) {
        boolean flag = false;
        Employee employee = employeeRepoImpl.findByEmpEmailIdAndEmpPassword(empEmail, empPassword);
        if (employee != null && employee.getEmpEmailId().equals(empEmail) && employee.getEmpPassword().equals(empPassword)) {
            flag = true;
        }
        return flag;

    }

    public Optional<Employee> findById(int empId) {
        return employeeRepoImpl.findById(empId);
    }

    public List<Employee> findByEmpName(String empName) {
        return employeeRepoImpl.findByEmpName(empName);
    }

    public List<Employee> findAll() {
        return employeeRepoImpl.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public void deleteById(int empId) {
        employeeRepoImpl.findById(empId);
    }

    public void deleteAll() {
        employeeRepoImpl.deleteAll();
    }

}
