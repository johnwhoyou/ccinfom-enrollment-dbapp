<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Record</title>
    </head>
    <body>
        <jsp:useBean id="coursesBean" class="enrollment.courses" scope="session" />
        <% String courseid = request.getParameter("courseid");
           String coursename = request.getParameter("coursename");
           String department = request.getParameter("department"); 
            
            coursesBean.courseid  = courseid;
            coursesBean.coursename = coursename;
            coursesBean.department = department;
            
            coursesBean.modRecord(); %>
            
            Success.<br>
            <a href="coursemaintenance.jsp">Click here to add, modify or delete another record.</a><br>
    </body>
</html>
