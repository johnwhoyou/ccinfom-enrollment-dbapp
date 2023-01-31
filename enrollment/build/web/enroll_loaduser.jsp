<%@page import="enrollment.coursedegree"%>
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
        <%
            String id = request.getParameter("enroll_studentid");
            enrollBean.Student.studentid = Long.parseLong(id);
            enrollBean.Student.viewRecord();
        %>
        <a href="enroll_selectcourses.jsp">Go to course selection</a>
    </body>
</html> 