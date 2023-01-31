<%-- 
    Document   : mod_student.jsp
    Created on : 02 2, 22, 7:24:22 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Record</title>
    </head>
    <body>
        <jsp:useBean id="studentsBean" class="enrollment.students" scope="session" />
        <% String studentid = request.getParameter("studentid");
           String completename = request.getParameter("completename");
           String degreeid = request.getParameter("degreeid"); 
            
            studentsBean.studentid  = Integer.parseInt(studentid);
            studentsBean.completename        = completename;
            studentsBean.degreeid        = degreeid;
            
            studentsBean.modRecord(); %>
            
            Success.<br>
            <a href="studentmaintenance.jsp">Click here to add, modify, or delete records.</a><br>
    </body>
</html>
