<%@page import="enrollment.coursedegree"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enroll</title>
    </head>
    <body>
        <jsp:useBean id="enrollBean" class="enrollment.enroll" scope="session"/>
        <form name="enrollmentUser" action="enroll_loaduser.jsp" method="POST">
            Enter Student ID: <input type="text" name="enroll_studentid" id="enroll_studentid"><br>
            <input type="submit" value="Submit" name="submitUserInfo"><br><br>
        </form>
    </body>
</html> 