<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get User Info For Enrollment</title>
    </head>
    <body>
        <jsp:useBean id="enrollBean" class="enrollment.enroll" scope="session"/>
        Confirmed Enrollment
        <%
            enrollBean.confirmEnrollment();
        %>
        <a href="index.html">Go to main menu</a>
    </body>
</html> 