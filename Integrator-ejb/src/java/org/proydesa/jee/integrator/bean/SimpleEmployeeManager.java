/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proydesa.jee.integrator.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.proydesa.jee.integrator.entity.Employee;
import org.proydesa.jee.integrator.entity.Job;
import org.proydesa.jee.integrator.exception.OperationException;

/**
 *
 * @author asalazar
 */
@Stateless
public class SimpleEmployeeManager implements EmployeeManagerRemote, EmployeeManagerLocal {

    @PersistenceContext
    private EntityManager emanager;

    @Override
    public List<Employee> retrieveAllEmployees() {
        try {
        Query query = emanager.createQuery("select emp from Employee emp", Employee.class);
        List<Employee> employees = query.getResultList();

        return employees;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
//        return new ArrayList<Employee>();
    }

    @Override
    public void addEmployee(Employee employee) throws OperationException{
//        try {
//            if (employee == null) {
//                throw new OperationException("Employee to add is null");
//            } else {
//                emanager.persist(employee);
//            }
//        } catch (EntityExistsException ex) {
//            throw new OperationException("The Employee cannot be addedd", ex);
//        }
    }

    @Override
    public void deleteEmployee(Employee employee) throws OperationException {
//        if (employee == null) {
//            throw new OperationException("Employee to delete is null.");
//        }
//
//        double employeeId = employee.getEmployeId();
//        Employee emp = emanager.find(Employee.class, employeeId);
//
//        if (emp == null) {
//            throw new OperationException("Employee record for " + employeeId + " was not found.");
//        } else {
//            emanager.remove(emp);
//        }
    }

    @Override
    public String getJobTitle(String jobId) throws OperationException {
//        Job simpleJob = emanager.find(Job.class, jobId);
//
//        if (simpleJob == null) {
//            throw new OperationException("Record for " + jobId + " was not foßund");
//        }
//
//        return simpleJob.getTitle();
        return "Job title";
    }

    @Override
    public Employee getEmployee(double employeeId) throws OperationException {
//        Employee emp = emanager.find(Employee.class, employeeId);
//
//        if (emp == null) {
//            throw new OperationException("Record for " + employeeId + " was not found.");
//        }
//
//        return emp;
        return new Employee();
    }

    public EntityManager getEmanager() {
        return emanager;
    }

    public void setEmanager(EntityManager emanager) {
        this.emanager = emanager;
    } 
}
