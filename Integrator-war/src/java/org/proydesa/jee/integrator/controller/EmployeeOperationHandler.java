/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proydesa.jee.integrator.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.proydesa.jee.integrator.bean.EmployeeManagerRemote;
import org.proydesa.jee.integrator.entity.Employee;
import org.proydesa.jee.integrator.entity.Job;
import org.proydesa.jee.integrator.exception.OperationException;
import org.proydesa.jee.integrator.helper.DateFormatter;
import org.proydesa.jee.integrator.helper.DoubleHelper;
import org.proydesa.jee.integrator.helper.IntegerHelper;
import org.proydesa.jee.integrator.helper.StringHelper;

/**
 *
 * @author asalazar
 */
public class EmployeeOperationHandler extends HttpServlet {

    @EJB
    private EmployeeManagerRemote employeeManager;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operation = request.getParameter("submit");
            
            if ("AddEmployee".equalsIgnoreCase(operation)) {
                Employee employee = createEmployee(request);

                employeeManager.addEmployee(employee);
            } else if ("DeleteEmployee".equalsIgnoreCase(operation)) {
                String value;
                if (!StringHelper.isBlank(value = request.getParameter("employeeId"))) {
                    employeeManager.deleteEmployee(DoubleHelper.tryParse(value));
                }
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("SimpleEmployees");
            dispatcher.forward(request, response);

        } catch (OperationException ex) {
            Logger.getLogger(EmployeeOperationHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(EmployeeOperationHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // No op
        }
    }

    public EmployeeManagerRemote getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManagerRemote employeeManager) {
        this.employeeManager = employeeManager;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Employee createEmployee(HttpServletRequest request) throws OperationException {
        // Create new employee
        Employee employee = new Employee();
        String value;
        if (!StringHelper.isBlank(value = request.getParameter("employeeId"))) {
            employee.setEmployeId(DoubleHelper.tryParse(value));
        }
        if (!StringHelper.isBlank(value = request.getParameter("lastName"))) {
            employee.setLastName(value);
        }
        if (!StringHelper.isBlank(value = request.getParameter("firstName"))) {
            employee.setFirstName(value);
        }
        if (!StringHelper.isBlank(value = request.getParameter("email"))) {
            employee.setEmail(value);
        }
        if (!StringHelper.isBlank(value = request.getParameter("phoneNumber"))) {
            employee.setPhoneNumber(value);
        }
        if (!StringHelper.isBlank(value = request.getParameter("hireDate"))) {
            Date hireDate = DateFormatter.SHORT.parse(value);
            employee.setHireDate(hireDate);
        }
        if (!StringHelper.isBlank(value = request.getParameter("jobId"))) {
            Job simpleJob = employeeManager.getJob(value);
            employee.setJob(simpleJob);
        }
        if (!StringHelper.isBlank(value = request.getParameter("baseSalary"))) {
            employee.setSalary(DoubleHelper.tryParse(value));
        }
        if (!StringHelper.isBlank(value = request.getParameter("commision"))) {
            employee.setCommisionPCT(DoubleHelper.tryParse(value));
        }
        if (!StringHelper.isBlank(value = request.getParameter("managerId"))) {
            employee.setManagerId(DoubleHelper.tryParse(value));
        }
        if (!StringHelper.isBlank(value = request.getParameter("depId"))) {
            employee.setDepartmentId(DoubleHelper.tryParse(value));
        }
        return employee;
    }
}
