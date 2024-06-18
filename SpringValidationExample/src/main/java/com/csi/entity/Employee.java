package com.csi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int empId;
    @Size(min = 2,message = "Please Enter Valid Name")
    private String empName;
    private String empAddress;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;
    private double empSalary;
    @Range(min = 1000000000,max = 9999999999l,message = "Contact Number should be valid.")
    private long empConatct;
    @Email(message = "Email should be vallid.")
    private String empEmailId;
    @Size(min = 4,message = "Password should have Atleast 4 Character.")
    private String empPassword;
}
