package com.csi.repo;

import com.csi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    //Custome Methods
    public List<Employee> findByEmpName(String empName);

    public Employee findByEmpEmailIdAndEmpPassword(String empEmailId,String empPassword);
}
