<%-- 
    Document   : index
    Created on : Nov 17, 2013, 9:22:14 PM
    Author     : ariel
--%>

<%@page import="org.proydesa.jee.integrator.entity.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Employees</title>
    </head>
    <body>
        <h1>All Employees</h1>
        <br/>
        <table cellpadding='4' border='1'>
            <tr>
                <td>
                    <a href="AddEmployee.jsp"> Add Employee</a>
                </td>
            </tr>
        </table>
        <br/>
        <br/>
        <table border="1" cellpadding="10" >
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Last Name</th>
                    <th>First Name</th>
                    <th>Email</th>
                    <th>Title</th>
                    <th>Manager</th>
                    <th>Department</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Employee[] employees = (Employee[]) request.getAttribute("employees");

                    for (Employee emp : employees) {
                %>
                <tr>
                    <td><%=emp.getEmployeId() %></td>
                    <td><%=emp.getLastName() %></td>
                    <td><%=emp.getFirstName() %></td>
                    <td><%=emp.getEmail() %></td>
                    <td><%=emp.getJob().getTitle()%></td><!-- Change to get title -->
                    <td><%=emp.getManagerId() %></td><!-- Change by manager name -->
                    <td><%=emp.getDepartmentId() %></td>
                    <td>
                        <% 
                        //String selectLink="deletedefect.do?DefectID="${myCollection.defectId}";
                        String selectedId = Double.toString(emp.getEmployeId());
                        %>
                        <a href='<%= "EmployeeOperationHandler?submit=DeleteEmployee&employeeId=" + selectedId %>'>Delete</a>
                    </td>
                    
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
