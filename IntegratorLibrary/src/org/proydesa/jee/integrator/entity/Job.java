/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proydesa.jee.integrator.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ariel
 */
@Entity(name = "Job")
@Table(name = "JOBS")
public class Job implements Serializable {
    
    public static final long serialVersionUID = 11262013L;
    
    @Id
    @Column(name = "JOB_ID", nullable = false)
    private String jobId;
    
    @Column(name = "JOB_TITLE", nullable = false)
    private String title;
    
    @Column(name = "MIN_SALARY", nullable = true)
    private double minSalary;
    
    @Column(name = "MAX_SALARY", nullable = true)
    private double maxSalary;
    
    @OneToMany(mappedBy = "job", fetch = FetchType.EAGER)
    private List<Employee> employees;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
