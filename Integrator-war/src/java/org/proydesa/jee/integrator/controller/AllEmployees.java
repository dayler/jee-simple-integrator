/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proydesa.jee.integrator.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.proydesa.jee.integrator.bean.EmployeeManagerRemote;
import org.proydesa.jee.integrator.entity.Employee;
import org.proydesa.jee.integrator.exception.OperationException;

/**
 *
 * @author ariel
 */
public class AllEmployees extends HttpServlet {

    @EJB
    private EmployeeManagerRemote employeeManager;
    
//    public AllEmployees() {
//        super();
//        try {
//            Context ctx = new InitialContext();
//            employeeManager = (EmployeeManagerRemote) ctx.lookup("java:comp/env/EmployeeManager");
//        } catch (NamingException ex) {
//            Logger.getLogger(AllEmployees.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException(ex);
//        }
//    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // Retrieve info
            List<Employee>rawEmployees = employeeManager.retrieveAllEmployees();
            Employee[]emplyees = new Employee[rawEmployees.size()];
            rawEmployees.toArray(emplyees);
            request.setAttribute("employees", emplyees);

            RequestDispatcher dispatcher = request.getRequestDispatcher("employees.jsp");
            dispatcher.forward(request, response);
//        } catch (OperationException ex) {
//            Logger.getLogger(AllEmployees.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(AllEmployees.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // No op
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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

    public EmployeeManagerRemote getEmployeeManagerRemote() {
        return employeeManager;
    }

    public void setEmployeeManagerRemote(EmployeeManagerRemote employeeManager) {
        this.employeeManager = employeeManager;
    }
}
