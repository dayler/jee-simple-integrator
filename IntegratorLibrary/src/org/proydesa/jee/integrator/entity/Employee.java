/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proydesa.jee.integrator.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ariel
 */
@Entity(name = "Employee")
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double employeId;
    
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    
    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    @Column(name = "PHONE_NUMBER", nullable = true)
    private String phoneNumber;
    
    @Column(name = "HIRE_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    
    @Column(name = "JOB_ID", nullable = false)
    private String jobId;
    
    @Column(name = "SALARY", nullable = true)
    private double salary;
    
    @Column(name = "COMMISSION_PCT", nullable = true)
    private double commisionPCT;
    
    @Column(name = "MANAGER_ID", nullable = true)
    private double managerId;
    
    @Column(name = "DEPARTMENT_ID", nullable = true)
    private double departmentId;
    
    @OneToMany(mappedBy = "Employe", targetEntity = Job.class, fetch = FetchType.EAGER)
    private List<Job> jobs;

    public double getEmployeId() {
        return employeId;
    }

    public void setEmployeId(double employeId) {
        this.employeId = employeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommisionPCT() {
        return commisionPCT;
    }

    public void setCommisionPCT(double commisionPCT) {
        this.commisionPCT = commisionPCT;
    }

    public double getManagerId() {
        return managerId;
    }

    public void setManagerId(double managerId) {
        this.managerId = managerId;
    }

    public double getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(double departmentId) {
        this.departmentId = departmentId;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
