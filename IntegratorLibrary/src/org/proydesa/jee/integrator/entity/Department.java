/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proydesa.jee.integrator.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ariel
 */
@Entity(name = "Department")
@Table(name = "DEPARTMENTS")
public class Department implements Serializable {
    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private double departmentId;
    
    @Column(name = "DEPARTMENT_NAME", nullable = false)
    private String name;
    
    @Column(name = "MANAGER_ID", nullable = true)
    private double managerId;
    
    @Column(name = "LOCATION_ID", nullable = true)
    private double locationId;
    
    @OneToMany(mappedBy = "Department", targetEntity = Employee.class, fetch = FetchType.EAGER)
    private List<Employee> employes;

    public double getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(double departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employee> employes) {
        this.employes = employes;
    }

    public double getManagerId() {
        return managerId;
    }

    public void setManagerId(double managerId) {
        this.managerId = managerId;
    }

    public double getLocationId() {
        return locationId;
    }

    public void setLocationId(double locationId) {
        this.locationId = locationId;
    }
}
