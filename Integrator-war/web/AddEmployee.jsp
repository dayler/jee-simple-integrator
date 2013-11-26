<%-- 
    Document   : AddEmployee
    Created on : Nov 19, 2013, 5:51:40 PM
    Author     : asalazar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee</title>
    </head>
    <body>
        <form action="EmployeeOperationHandler" method="get">
            <h1>Add Employee</h1>
            <table cellpadding="4" border="1">
                <thead>
                    <tr>
                        <th>Add Employee</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <table cellpadding="4" border="1">
                                <tr>
                                    <td><label>ID: </label></td><td><input type="text" name="employeeId" /></td>
                                </tr>
                                <tr>
                                    <td><label>Last Name:</label></td><td><input type="text" name="lastName" /></td>
                                </tr>
                                <tr>
                                    <td><label>First Name:</label></td><td><input type="text" name="firstName" /></td>
                                </tr>
                                <tr>
                                    <td><label>Email:</label></td><td><input type="text" name="email" /></td>
                                </tr>
                                <tr>
                                    <td><label>Phone Number:</label></td><td><input type="text" name="phoneNumber" /></td>
                                </tr>
                                <tr>
                                    <td><label>Hire Date:</label></td><td><input type="text" name="hireDate" /></td>
                                </tr>
                                <tr>
                                    <td><label>Job ID:</label></td><td><input type="text" name="jobId" /></td>
                                </tr>
                                <tr>
                                    <td><label>Base Salary:</label></td><td><input type="text" name="baseSalary" /></td>
                                </tr>
                                <tr>
                                    <td><label>Commision:</label></td><td><input type="text" name="commision" /></td>
                                </tr>
                                <tr>
                                    <td><label>Manager ID:</label></td><td><input type="text" name="managerId" /></td>
                                </tr>
                                <tr>
                                    <td><label>Department ID:</label></td><td><input type="text" name="depId" /></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </tbody>
                <tfoot align="center" width="100%">
                    <tr>
                        <td>
                            <input type="submit" name="submit" value="AddEmployee"/>
                            <!-- <input type="button" name="submit" value="Cancel" onclick="history.back(-1);"/>-->
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </body>
</html>
