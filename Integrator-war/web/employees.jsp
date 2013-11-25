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
        <table>
            <tr><imput type="button" value="Add Employee"/></tr>
        </table>
        <br/>
        <br/>
        <table>
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
                    <td><b>emp_getJobId</b></td><!-- Change to get title -->
                    <td><%=emp.getManagerId() %></td><!-- Change by manager name -->
                    <td><%=emp.getDepartmentId() %></td>
                    <td><input type="button" value="Details"/><input type="button" value="Delete"/></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
