/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proydesa.jee.integrator.bean;

import java.util.List;
import javax.ejb.Remote;
import org.proydesa.jee.integrator.entity.Employee;
import org.proydesa.jee.integrator.entity.Job;
import org.proydesa.jee.integrator.exception.OperationException;

/**
 *
 * @author asalazar
 */
@Remote
public interface EmployeeManagerRemote {
    List<Employee> retrieveAllEmployees() throws OperationException;
    void addEmployee(Employee employee) throws OperationException;
    void deleteEmployee(double employeeId) throws OperationException;
    String getJobTitle(String jobId) throws OperationException;
    Employee getEmployee(double employeeId) throws OperationException;
    Job getJob(String jobId) throws OperationException;
}
