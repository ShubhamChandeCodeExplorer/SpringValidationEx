package com.csi.controller;

import com.csi.entity.Employee;
import com.csi.exception.RecoredNotFoundException;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServiceImpl.signup(employee), HttpStatus.CREATED);
    }

    @GetMapping("/signIn/{empEmail}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmail, @PathVariable String empPassword) {
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmail, empPassword));
    }

    @GetMapping("/findById/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeServiceImpl.findById(empId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeServiceImpl.findAll());
    }

    @GetMapping("/findbyempname/{empName}")
    public ResponseEntity<List<Employee>> findByEmpName(@PathVariable String empName) {
        return ResponseEntity.ok(employeeServiceImpl.findByEmpName(empName));
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee, @PathVariable int empId) {
        Employee employee1 = employeeServiceImpl.findById(empId).orElseThrow(() -> new RecoredNotFoundException("Employee id Doesent Exsist.."));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpConatct(employee.getEmpConatct());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        return ResponseEntity.ok(employeeServiceImpl.update(employee1));
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deletebyid(@PathVariable int empId) {
        employeeServiceImpl.deleteById(empId);
        return ResponseEntity.ok("DATA DELETED SUCESSFULLY...");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteall() {
        employeeServiceImpl.deleteAll();
        return ResponseEntity.ok("All Data Deleted Sucessfully..");
    }
}
