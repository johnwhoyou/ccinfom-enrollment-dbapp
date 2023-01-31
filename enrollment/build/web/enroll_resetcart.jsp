<%@page import="java.sql.*, java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Enrollment Cart</title>
    </head>
    <body>
        <jsp:useBean id="enrollBean" class="enrollment.enroll" scope="session"/>
        <%enrollBean.clearEnrollment();%>
        Enrollment cart has been reset. 
        <a href="enroll_selectcourses.jsp">Return to Select Courses.</a>
    </body>
</html>
