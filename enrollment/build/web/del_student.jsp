<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Record</title>
    </head>
    <body>
        <jsp:useBean id="studentsBean" class="enrollment.students" scope="session" />
        <% String studentid = request.getParameter("studentid");
            studentsBean.studentid      = Integer.parseInt(studentid);
            studentsBean.delRecord(); %>
            
            Record deleted.<br>
            <a href="studentmaintenance.jsp">Click here to add, modify or delete records.</a><br>
    </body>
</html>
